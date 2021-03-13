package org.techtown.application0220;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int CODE_CALCULATOR =101;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText=findViewById(R.id.main_text_result);

        // 계산기 버튼을 클릭하면 CalculatorActivity를 띄운다.
        Button calButton = findViewById(R.id.main_button_toCal);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // 버튼을 클릭했을 때 수행할 메서드
            // → 수행할 기능 : CalculatorActivity를 띄운다.

                // 컴포넌트를 실행하기 ㅜ이한 인텐트 객체를 새엇ㅇ한다.
                Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);

                // 생성한 인텐트객체를 안드로이드 시스템에 전달
                // 컴포넌트 중에 액티비티 컴포넌트를 실행하기 위한 메서드
                // -startActivity(...)
                // -startActivityForResult(...)
                //startActivity(intent);// 띄우는 액티비티로부터 결과 못받음

                startActivityForResult(intent, CODE_CALCULATOR);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_CALCULATOR){
            if(resultCode == RESULT_OK){
                String opr = data.getStringExtra("operator");
                int result = data.getIntExtra("result", 0);

            }
        }
    }
}