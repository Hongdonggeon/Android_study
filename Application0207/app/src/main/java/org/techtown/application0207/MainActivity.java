package org.techtown.application0207;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.application0207.VO.User;

public class MainActivity extends AppCompatActivity {
TextView helloText;
User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = findViewById(R.id.main_welcome);

        Intent data = getIntent();
        if(data!=null){
            Toast.makeText(this, "잘못된 접근입니다.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        user=data.getParcelableExtra("user");
        helloText.setText(user.getNickname() + "님 안녕하세요.");
    }
}