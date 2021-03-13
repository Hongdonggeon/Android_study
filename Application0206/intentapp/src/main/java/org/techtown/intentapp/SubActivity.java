package org.techtown.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 안드로이드 시스템에 Intent 객체를 반환
        Intent data = getIntent();
        if(data!= null) {
            String date = data.getStringExtra("today");
            Toast.makeText(this, "Today is " + date, Toast.LENGTH_SHORT).show();

            String item = data.getStringExtra("item");
            Toast.makeText(this, "Item is" + item, Toast.LENGTH_SHORT).show();
        }

        Button toMainButton = findViewById(R.id.sub_buttin_main);
        toMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                //부가 데이터
                // 인텐트 객체에 추가적으로 저장될 데이터
                // 인텐ㅌ 객체 내의 Bundle 객체에 저장한다.
                intent.putExtra("today", "2021-02-06");
                startActivity(intent);
            }
        });
    }
}