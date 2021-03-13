package org.techtown.application0109;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 화면을 구성하고 보여주기 위한 클래스
// → Activity 컴포넌트
// → Activity : UI를 구성/ 제어하기 위한 컴포넌트
//            : 화면을 구성같은 경우는 XML 파일로 작성한다.
//  Activity의 구성 : Activity 컴포넌트 + Layout.xml
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView() : 안드로이드 앱 화면을 출력
        //R.layout.activity_main : Layout객체의 Resource ID
        // setContentView(R.layout.activity_main);I
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_Hello);
//        textView.setText("Hello, Android!"); // 정적 데이터 이부분을 resource로 다시 만들겟다
        textView.setText(R.string.hello_eng);
    }
}