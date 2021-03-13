package org.techtown.eventapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 액티비티 내에서 사용할 뷰들의 참조 변수
    Button button;
    TextView textView;

    Button button2;
    TextView textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이벤트(Event)
        // 뷰에서 발생한 특정 사건/수행

        // 액티비티 내에서 뷰를 사용하기 위해서는 참조 변수가 필수
        // 참조 변수를 대부분 필드 영역에 선언한다.
        // 선언된 필드를 onCreate 메서드 내에서 객체를 참조한다.

        // layout.xml 에서 정의한 뷰들을 참조가 위해선 메모리에서 찾아야 한다.
        // 메모리에서 뷰들을 찾기 위해선 findViewById() 메서드를 이용한다.
        // 뷰의 ID 속성을 통해서 메모리에서 찾는다.
        button = findViewById(R.id.main_button_ok);
        textView = findViewById(R.id.main_textview_text);
        
        button2 = findViewById(R.id.main_button_check);
        textview2 = findViewById(R.id.main_button_text2);

        // button 을 클릭했을 때 → onClickListener 인터페이스를 통해서 구현/등록
//        MyButtonListenerImpl listener = new MyButtonListenerImpl(textView);
//        button.setOnClickListener(listener);
        // textView의 텍스트를 ' 버튼을 클릭했습니다.' 로 바꿔도록 한다.

        // Listener  인터페이스를 상속받아 구현하지 않고 바로 등록하는 방법
        // → '익명 클래스'를 이용
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 액티비티 내에서 만들어진 이벤트 핸들러이기 때문에
                // 액티비티에 선언된 필드에 접근할 수 있다.
                textView.setText("버튼을 클릭했습니다.");
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textview2.setText("Button Clicked!!");
            }
        });
    }
}

// View.OnClickListener  인터페이스를 통해서
// 이벤트가 발생했을 때 수행할 이벤트 핸들러의 클래스를 만든다.
class MyButtonListenerImpl implements View.OnClickListener {
    TextView text;

    MyButtonListenerImpl(TextView text) {
        this.text = text;

    }

    @Override
    public void onClick(View view) {
        // 이벤트 핸들러 : 뷰가 클릭됐을 때 수행할 메서드
        if (text == null) return;
        text.setText("버튼을 클릭했습니다.");
    }
}