package com.afundacion.fp.clips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    private ConstraintLayout mainLayout; // Añadimos un nuevo atributo
    private ProgressBar progressBar;
    private ClipsList clips;
    private RecyclerView recyclerView;

        // Ejercicio 1:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.queue = Volley.newRequestQueue(MainActivity.this); // Define la queue
        this.mainLayout = findViewById(R.id.main_layout); // Lo asignamos con findViewById
        this.recyclerView = findViewById(R.id.recView);

        // Ejercicio 5:

        this.progressBar = findViewById(R.id.progbar);

        // Ejercicio 4:

        // Solicitamos una lista de clips
        JsonArrayRequest requestClipList = new JsonArrayRequest(
            Request.Method.GET,
            Server.name + "/clips", // Si ponemos /health2 podríamos observar como la respuesta a dar sería Server KO: 404.
            null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Snackbar.make(mainLayout, "Clips obtained", Snackbar.LENGTH_SHORT).show();
                    // Parseamos la respuesta y la asignamos a nuestro atributo
                    setClips(new ClipsList(response));
                }
            }, new Response.ErrorListener() {

                // Ejercicio 5:
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (error.networkResponse == null) {
                        // Error: No se ha establecido la conexión
                        Snackbar.make(mainLayout, "Server could not be reached", Snackbar.LENGTH_SHORT).show();

                    } else {
                        // Error: El servidor ha dado una respuesta de error
                        int serverCode = error.networkResponse.statusCode;
                        Snackbar.make(mainLayout, "Server status is "+serverCode, Snackbar.LENGTH_SHORT).show();

                    }
                }
            }
        ); // Fin del JSON requestClips

        this.queue.add(requestClipList);

        // Petición HTTP:
        JsonObjectRequest request = new JsonObjectRequest(
            Request.Method.GET,
            Server.name + "/health", // Si ponemos /health2 podríamos observar como la respuesta a dar sería Server KO: 404.
            null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    // Toast: + // Ejercicio 2: Respuesta del servidor:
                    try {
                        Toast.makeText(MainActivity.this, "GET OK: "+response.getString("status"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, new Response.ErrorListener() {

            // Ejercicio 3:
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error.networkResponse == null) {
                        // Error: No se ha establecido la conexión
                        Toast.makeText(MainActivity.this, "Server could not be reached", Toast.LENGTH_SHORT).show();

                    } else {
                        // Error: El servidor ha dado una respuesta de error
                        int serverCode = error.networkResponse.statusCode;
                        Toast.makeText(MainActivity.this, "Server KO: "+serverCode, Toast.LENGTH_SHORT).show();

                    }
                }
            }
        ); // Fin del JSON request

        this.queue.add(request);
    }

    private void requestClipList() {
        progressBar.setVisibility(View.VISIBLE);
    }

    // Ejercicio 6:

    public void setClips(ClipsList clips) {
        this.clips = clips;
        ClipsAdapter myAdapter = new ClipsAdapter(this.clips);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public ClipsList getClipsForTest() {
        return clips;
    }

}

