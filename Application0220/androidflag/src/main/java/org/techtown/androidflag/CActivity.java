package org.techtown.androidflag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }
    public void onClickButton(View view) {
        int viewId = view.getId();
        Intent intent = null;
        if(viewId == R.id.c_from_to_a) {
            intent = new Intent(this, AActivity.class);
        }else if (viewId == R.id.c_from_to_b){
            intent = new Intent(this, BActivity.class);
        }else if (viewId == R.id.c_from_to_c){
            intent = new Intent(this, CActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }

        if(intent == null)
            return;

        startActivity(intent);
    }
}