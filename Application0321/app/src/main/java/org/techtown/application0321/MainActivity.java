package org.techtown.application0321;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

/*
    NavigationView 전체화면
     - ActionBar 대신 Toolbar 로 대체



 */


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ActionBar actionBar;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.main_drawerLayout);
        navigationView = findViewById(R.id.main_navigationView);
        toolbar = findViewById(R.id.main_toolbar);

        // ActionBar 재 설정
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.OPEN, R.string.CLOSE);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        // NavigationView 내의 항목에 이벤트 리스너를 설정
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.drawer_menu_account) {
                    Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                }else if(itemId == R.id.drawer_menu_password) {
                    Toast.makeText(MainActivity.this, "Password", Toast.LENGTH_SHORT).show();
                }else if(itemId == R.id.drawer_menu_setting) {
                    Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                }else if(itemId == R.id.drawer_menu_qna) {
                    Toast.makeText(MainActivity.this, "QnA", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        // DrawerLayout이 현재 NavigationView 가 보여지고 있는가
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }



        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}