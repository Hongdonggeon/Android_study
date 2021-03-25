package org.techtown.application0320;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.main_drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.OPEN, R.string.CLOSE);

        getSupportActionBar().setDisplayOptions(true);
        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
    }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(toggle.onOptionsItemSelected(item)){
                Toast.makeText(this, "Clicked Toggle", Toast.LENGTH_SHORT).show();
                return true;
        }
            if(item.getItemId() == R.id.drawer_home){
                Toast.makeText(this, "Clicked Home!", Toast.LENGTH_SHORT).show();
            }
    };


