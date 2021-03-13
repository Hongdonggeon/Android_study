package org.techtown.application0206;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button closeBtn = findViewById(R.id.main_button_close);
        closeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar
                        .make(v, "종료하시겠습니까?", Snackbar.LENGTH_LONG)
                        .setAction("종료",new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                finish();
                            }

                        }).show();

            }
        });
    }
}