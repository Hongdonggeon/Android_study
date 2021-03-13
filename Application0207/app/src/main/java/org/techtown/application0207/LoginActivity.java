package org.techtown.application0207;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.application0207.Server.Database;
import org.techtown.application0207.VO.User;

public class LoginActivity extends AppCompatActivity {
    EditText idEdit, pwEdit;
    Button submitBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        idEdit = findViewById(R.id.login_edit_id);
        pwEdit = findViewById(R.id.login_edit_pw);
        submitBtn =findViewById(R.id.login_button_submit);
        signupBtn =findViewById(R.id.login_button_signup);

        for(int i =1 ; i<=10; i++){
            User user = new User("user"+i, "user"+i,"user"+i,"user"+i,20+i,"user"+i+"@n.com");
            Database.add(user);
        }

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String id = idEdit.getText().toString();
                if(checkEmpty(id)){
                    Toast.makeText(LoginActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pw = pwEdit.getText().toString();
                if(checkEmpty(pw)){
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                User user = Database.checkLogin(id, pw);
                if(user == null) {
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //signupActivity를 실행하려면
                //Android System에 Intent를 전달하여 실행해야 한다.
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);

            }

        });
    }

    private boolean checkEmpty(String id) {
        return idEdit.getTextSize()==0;
    }
}
