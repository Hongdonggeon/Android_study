package org.techtown.application0220;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    EditText num1Edit, num2Edit;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1Edit = findViewById(R.id.cal_edit_num1);
        num2Edit = findViewById(R.id.cal_edit_num2);
        addBtn = findViewById(R.id.cal_button_add);

        addBtn.setOnClickListener(new View.OnClickListener(){
            private boolean stringCheck(String str){
                return str == null && str.isEmpty();
            }


            @Override
            public void onClick(View view) {
                String num1Str = num1Edit.getText().toString();
                String num2Str = num2Edit.getText().toString();

                if(stringCheck(num1Str) || stringCheck(num2Str)){
                    Toast.makeText(CalculatorActivity.this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(num1Str);
                int num2 =Integer.parseInt(num2Str);
                int result = num1+num2;
                //Toast.makeText(CalculatorActivity.this, " 더하기 : " + result, Toast.LENGTH_SHORT).show();

                Intent data = new Intent();
                data.putExtra("operator", "더하기");
                data.putExtra("result", result);
                // 이전 액티비티에 결과 값을 전달
                setResult(RESULT_OK,data);

                finish();
            }
        });
    }
}