package com.afundacion.fp.sessions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonRegister;

    // Ejercicio #4: Añadimos requestQueue.
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Los inicializamos a partir de su contraparte en el XML
        editTextName = findViewById(R.id.hint);
        editTextPassword = findViewById(R.id.password);

        // Ejercicio #3: Crear un botón para registrarse.

        buttonRegister = findViewById(R.id.registerButton);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString();
                Toast.makeText(RegisterActivity.this, "Usuario " + userName, Toast.LENGTH_SHORT).show();

                // Ejercicio #4:
                registerNewUser();
            }
        });

        // Ejercicio #4:
        requestQueue = Volley.newRequestQueue(this);
    }

    // Ejercicio #4: Método para añadir un nuevo request al HTTP
    private void registerNewUser() {
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("username", editTextName.getText().toString());
            requestBody.put("password", editTextPassword.getText().toString());
        }catch (JSONException e){
            throw new RuntimeException(e);
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                Server.name + "/users",
                requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(RegisterActivity.this, "Cuenta registrada", Toast.LENGTH_LONG).show();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Ejercicio #5: Completar el onErrorResponse:
                        if (error.networkResponse == null) {
                           Toast.makeText(RegisterActivity.this, "Imposible conectar al servidor", Toast.LENGTH_LONG).show();
                        } else {
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(RegisterActivity.this, "Estado de respuesta "+serverCode, Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        requestQueue.add(request);
    }
}
