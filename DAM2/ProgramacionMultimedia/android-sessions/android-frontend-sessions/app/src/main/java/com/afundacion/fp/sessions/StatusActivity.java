package com.afundacion.fp.sessions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class StatusActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private TextView textViewStatus;

    // Ejercicio #12: Añadimos a la clase el botón flotante.
    private FloatingActionButton buttonChangeStatus;

    // Ejercicio #13:
    private EditText editTextPutStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        // Ejercicio #10: Iniciamos la cola de las peticiones.

        requestQueue = Volley.newRequestQueue(this);
        retrieveStatus();

        // Ejercicio #12: Encontramos el botón en el layout y creamos la clase en java.
        buttonChangeStatus = findViewById(R.id.button_open_dialog);
        buttonChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(StatusActivity.this);
                myBuilder.setView(inflateDialogView());
                myBuilder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(StatusActivity.this, "Modificar a: " + editTextPutStatus.getText().toString(), Toast.LENGTH_LONG).show();

                        // Ejercicio #14:

                        sendUpdateStatusRequest();
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }

    private void retrieveStatus() {
        SharedPreferences preferences = getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
        String username = preferences.getString("VALID_USERNAME", null);
        textViewStatus = findViewById(R.id.Loading);

        // Ejercicio #11:
        JsonObjectRequestWithAuthentication request = new JsonObjectRequestWithAuthentication(
                Request.Method.GET,
                Server.name + "/users/" + username + "/status",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(StatusActivity.this, "Estado obtenido", Toast.LENGTH_LONG).show();
                                // Ejercicio #11:
                        try { textViewStatus.setText(response.getString("status"));
                        } catch (JSONException e) { throw new RuntimeException(e); }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StatusActivity.this, "Problema recibiendo el estado", Toast.LENGTH_LONG).show();
                    }
                },
                StatusActivity.this
        );
        requestQueue.add(request);
    }

    // Ejercicio #13: Implementamos el view hecho en el .xml

    private View inflateDialogView() {
        LayoutInflater inflater = getLayoutInflater();
        View inflatedView = inflater.inflate(R.layout.change_status_dialog, null);
        editTextPutStatus = inflatedView.findViewById(R.id.edit_text_change_status);
        return inflatedView;
    }


    // Ejercicio #14:
    private void sendUpdateStatusRequest() {
        SharedPreferences preferences = getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
        String username = preferences.getString("VALID_USERNAME", null);
        JSONObject requestBody = new JSONObject();
        try { requestBody.put("status", editTextPutStatus.getText().toString());
        } catch (JSONException e) { throw new RuntimeException(e); }

        JsonObjectRequestWithAuthentication request = new JsonObjectRequestWithAuthentication(
                Request.Method.PUT,
                Server.name + "/users/" + username + "/status",
                requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textViewStatus.setText("Cargando");
                        retrieveStatus();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) { // Su contenido fue añadido por mí, para mostrar el error por pantalla.
                        int serverCode = error.networkResponse.statusCode;
                        Toast.makeText(StatusActivity.this, "Estado de respuesta "+serverCode, Toast.LENGTH_LONG).show();
                    }
                },
                StatusActivity.this
        );
        requestQueue.add(request);

    }



}