package org.techtown.application0207;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.application0207.Server.Database;
import org.techtown.application0207.VO.User;

public class SignupActivity extends AppCompatActivity {
    EditText idEdit;
    EditText pwEdit;
    EditText nameEdit;
    EditText ageEdit;
    EditText nicknameEdit;
    EditText emailEdit;
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        idEdit = findViewById(R.id.signup_edit_id);
        pwEdit = findViewById(R.id.signup_edit_pw);
        nameEdit = findViewById(R.id.signup_edit_name);
        ageEdit = findViewById(R.id.signup_edit_age);
        nicknameEdit = findViewById(R.id.signup_edit_nickname);
        emailEdit = findViewById(R.id.signup_edit_email);

        submitBtn = findViewById(R.id.signup_button_submit);
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String id = idEdit.getText().toString();
                if(checkEmpty(id)){
                    printToast("아이디를 입력하세요");
                    return;
                }
                String pw = pwEdit.getText().toString();
                if(checkEmpty(pw)){
                    printToast("비밀번호를 입력하세요");
                    return;
                }
                String name = nameEdit.getText().toString();
                if(checkEmpty(name)){
                    printToast("이름을 입력하세요");
                    return;
                }
                String ageStr = ageEdit.getText().toString();
                String nickname = nicknameEdit.getText().toString();

                //아이디 중복 체크
                if(!Database.checkID(id)){
                    printToast("ID가 중복입니다.");
                    return;
                }

                String nicknam = nicknameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                int age = Integer.parseInt(ageStr);
                User newUser= new User(id,name,pw,nickname,age,email);
                Database.add(newUser);

                finish();

            }
        });
    }

    // 제대로 입력이 되어져있는지 검사
    public boolean checkEmpty(String str){
        return str==null || str.isEmpty();
    }

    public void printToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}