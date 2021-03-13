package org.techtown.application0116;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// id, pw - hint 속성
//ImageView - scaleType
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main2);
//        setContentView(R.layout.activity_sub01);
//        setContentView(R.layout.activity_constraint);
//        setContentView(R.layout.activity_login);
//        setContentView(R.layout.activity_login2);
        setContentView(R.layout.activity_sub02);
    }


    // 메서드 이름이 노란색이어야 사용하고 있다는것, 회색은 사용x
    //버튼을 눌렀을 때 수행할 메서드
    public void onClickOkButton(View v){
        Toast.makeText(this, "버튼을 클릭했습니다.", Toast.LENGTH_SHORT).show();
    }
}