package org.techtown.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toSubButton = findViewById(R.id.main_button_sub);
        toSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 클릭 시 SubActivity를 실행

                // 다른 컴포넌트를 실행하기 위해선
                //안드로이드 시스템에 요청을 보내야하낟.


                // 요청을 보내기 위한 데이터 =Intent 객체
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-3052-6298"));

                // 부가 데이터
                // 인텐트 객체에 추가적으로 저장될 데이터
                // 인텐트 객체 내의 Bundle 객체에 저장한다.
                intent.putExtra("date","2021-02-06");


                //Intent 객체 전달
                startActivity(intent);
            }
        });


    }
}