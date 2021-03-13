package org.techtown.application0131;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 뷰들을 사용하기 위해선
    // 뷰 객체들을 참조해야한다.
    EditText userIdEdit, userPwEdit;
    Button loginBtn, signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 참조 변수를 선언한 다음 뷰 객체들을 뷰의 id 속성을 통해 참조
        userIdEdit = findViewById(R.id.main_edit_user_id);
        userPwEdit = findViewById(R.id.main_edit_user_pw);
        loginBtn = findViewById(R.id.main_button_login);
        signupBtn = findViewById(R.id.main_button_signup);

        // 회원 가입버튼 클릭시 "회원가입 버튼을 눌렀습니다."를 토스트 메세지로 출력
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이벤트 핸들러 : signupBtn 이 클릭됐을 때 수행할 메서드
                Toast
                        .makeText(
                                MainActivity.this,
                                "회원가입 버튼을 눌렀습니다.",
                                Toast.LENGTH_SHORT)
                        .show();

            }
        });

        // 로그인 버튼을 클릭시 입력값이 제대로 입력되었는지 검사 후
        // 제대로 입력 되었으면 "로그인 버튼을 눌렀습니다."를 토스트 메세지로 출력하고
        // 제대로 입력되지 않았으면 "ID가 입력되지않았습니다." 또는 "비밀번호가 입력되지 않았습니다."를
        // 토스트메세지로 출력
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText 에 입력이 제대로 되었는지 검사
                if(userIdEdit == null || userIdEdit.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "ID가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(userPwEdit == null || userPwEdit.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "비밀번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, "로그인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();

            }
        });


    }
}