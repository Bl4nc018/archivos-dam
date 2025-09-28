package com.afundacion.fp.sessions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("SESSIONS_APP_PREFS", MODE_PRIVATE);
        String username = preferences.getString("VALID_USERNAME", null); // null será el valor por defecto

        if (username == null) {
            Intent loginActivity = new Intent(LauncherActivity.this, LoginActivity.class);
            startActivity(loginActivity);
        } else {
            Intent statusActivity = new Intent(LauncherActivity.this, StatusActivity.class);
            startActivity(statusActivity);
        }
    }

}
