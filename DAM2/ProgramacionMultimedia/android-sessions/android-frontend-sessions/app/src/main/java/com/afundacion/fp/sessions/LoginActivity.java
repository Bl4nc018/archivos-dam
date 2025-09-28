package com.afundacion.fp.sessions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

// Ejercicio #6: Creada la clase java correspondiente al xml de los layouts
public class LoginActivity extends AppCompatActivity {

    private Button myButton;

    // Ejercicio #7: Empezamos con las requests

    private RequestQueue requestQueue;
    private Button myOtherButton;
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.hint2);
        editTextPassword = findViewById(R.id.password2);

        myButton = findViewById(R.id.noAccount);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        requestQueue = Volley.newRequestQueue(this);

        myOtherButton = findViewById(R.id.logIn);
        myOtherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPostRequest();
            }
        });
        requestQueue = Volley.newRequestQueue(this);

    }

    private void sendPostRequest() {
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("username", editTextName.getText().toString());
            requestBody.put("password", editTextPassword.getText().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                Server.name + "/sessions",
                requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String receivedToken;
                        try {
                            receivedToken = response.getString("sessionToken");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        Toast.makeText(LoginActivity.this, "Token: " + receivedToken, Toast.LENGTH_SHORT).show();

                        // Ejercicio #9: Tiene lugar la pantalla de carga.

                        Intent intent2 = new Intent(LoginActivity.this, StatusActivity.class);
                        startActivity(intent2);

                        // Ejercicio #10:

                        SharedPreferences preferences = LoginActivity.this.getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("VALID_USERNAME", editTextName.getText().toString());
                        editor.putString("VALID_TOKEN", receivedToken); 
                        editor.commit();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int serverCode = error.networkResponse.statusCode;

                        // Ejercicio #8: Lo que pasa si hay un error:

                        Toast.makeText(LoginActivity.this, "Estado de respuesta "+serverCode, Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(request);
    }


}
