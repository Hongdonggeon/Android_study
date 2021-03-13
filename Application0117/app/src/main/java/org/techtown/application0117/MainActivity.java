package org.techtown.application0117;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Activity 에서 뷰들을 사용하기 위해선 참조변수를 선언해야한다.
    TextView orangeText, blueText, greenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_frame);
//setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_verticalscroll);
        //setContentView 메서드 다음에 레이아웃에서 정의된 뷰들을 참조한다.
        //findViewById 메서드 : 레이아웃에 정의되어있는 뷰들을 뷰의 id 속성을 통해서 참조한다.
        orangeText = findViewById(R.id.textView_orange);
        blueText= findViewById(R.id.textView_blue);
        greenText = findViewById(R.id.textView_green);
    }

    public void onClickColorButton(View v){
        orangeText.setVisibility(View.INVISIBLE);
        greenText.setVisibility(View.INVISIBLE);
        blueText.setVisibility(View.INVISIBLE);

        if(v.getId() == R.id.button_orange)
            orangeText.setVisibility(View.VISIBLE);
        else if(v.getId() == R.id.button_green)
            greenText.setVisibility(View.VISIBLE);
        else
            blueText.setVisibility(View.VISIBLE);
    }

//    public void onClickOrangeButton(View v){
//        orangeText.setVisibility(View.VISIBLE);
//        blueText.setVisibility(View.INVISIBLE);
//        greenText.setVisibility(View.INVISIBLE);
//    }
//
//    public void onClickBlueButton(View v){
//        orangeText.setVisibility(View.INVISIBLE);
//        blueText.setVisibility(View.VISIBLE);
//        greenText.setVisibility(View.INVISIBLE);
//    }
//
//    public void onClickGreenButton(View v){
//        orangeText.setVisibility(View.INVISIBLE);
//        blueText.setVisibility(View.INVISIBLE);
//        greenText.setVisibility(View.VISIBLE);
//    }

}