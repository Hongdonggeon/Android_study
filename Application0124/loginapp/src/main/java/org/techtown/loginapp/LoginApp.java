package org.techtown.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginApp extends AppCompatActivity {
    // 레이아웃에 정의된 뷰들을 참조하기 위한 참조변수
    TextView id;
    TextView id_check;
    TextView pw;
    TextView pw_check;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);

        // 레이아웃에 정의된 뷰들을 참조하기 위한 코드
        id =findViewById(R.id.main_id_text);
        id_check = findViewById(R.id.main_id_textCheck);
        pw=findViewById(R.id.main_password_text);
        pw_check=findViewById(R.id.main_password_textCheck);
        login =findViewById(R.id.main_login_btn);

        // 버튼을 클릭했을 때
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            // id에 아무것도 입력되지 않았다면
            public void onClick(View view) {
                id_check.setVisibility(view.INVISIBLE);
                pw_check.setVisibility(view.INVISIBLE);
                // id에 아무것도 입력되지 않았다면
                if(id == null || id.getText().toString().isEmpty()){
                    // id_check를 화면에 보여지게 하고
                    id_check.setVisibility(View.VISIBLE);
                    return;
                }
                else if(pw == null || pw.getText().toString().isEmpty()){
                    // pw에 아무것도 입력되지 않았다면
                    // pw_check를 화면에 보여지게 한다.
                    pw_check.setVisibility(View.VISIBLE);
                    return;
                }
              //로그인 정보를 검정하는 단계
                Toast.makeText(LoginApp.this, "로그인 검사중...", Toast.LENGTH_SHORT).show();
            }
        });



    }
}