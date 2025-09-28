package com.afundacion.fp.library;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import androidx.fragment.app.Fragment;

public class MonstersActivity extends AppCompatActivity {
    // Ejercicio #11:
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);

        // Ejercicio #16:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Fragment1()).commit();

        // Ejercicio #15:
        BottomNavigationView bar = findViewById(R.id.bottomNavigation);
            bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if (item.getItemId() == R.id.item1) {
                        Toast.makeText(MonstersActivity.this, "Este es el primer Digimon", Toast.LENGTH_LONG).show();
                        Fragment myFragment = new Fragment1();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, myFragment).commit();
                    }
                    if (item.getItemId() == R.id.item2) {
                        Toast.makeText(MonstersActivity.this, "Clicaste Digimon 2", Toast.LENGTH_LONG).show();
                        // Ejercicio #17:
                        Fragment myFragment2 = new Fragment2();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, myFragment2).commit();
                    }
                    if (item.getItemId() == R.id.item3) {
                        Toast.makeText(MonstersActivity.this, "Has clicado en Digimon 3", Toast.LENGTH_LONG).show();
                        // Ejercicio #18:
                        Fragment myFragment3 = new Fragment3();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, myFragment3).commit();
                    }

                    return true;
                }
            });
    }

}
