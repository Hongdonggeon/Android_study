package org.techtown.androidflag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void onClickButton(View view) {
        int viewId = view.getId();
        Intent intent = null;
        if(viewId == R.id.a_from_to_a) {
            intent = new Intent(this, AActivity.class);
            //SINGLE_TOP : 이전 액티비티와 동일한 액티비티를 띄울 때
            //           : 새 액티비티룰 띄우지 않고 기존 액태비티를 그대로 사용한다.
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }else if (viewId == R.id.a_from_to_b){
            intent = new Intent(this, BActivity.class);
        }else if (viewId == R.id.a_from_to_c){
            intent = new Intent(this, CActivity.class);
            // NO_HISTROY : 안드로이드 스택에 저장하지 않도록 한다.
            //          : 광고와 같이 한 번만 보여주고 말 액티비티에 사용된다.
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        }

        if(intent == null)
            return;

        startActivity(intent);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "중복으로 호출된 액티비티입니다.", Toast.LENGTH_SHORT);
    }
}