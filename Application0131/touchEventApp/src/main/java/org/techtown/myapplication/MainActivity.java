package org.techtown.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView touchArea, gestureArea, logText;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //onCreate 메서드 내에서 값을 불러오려면
        //null 검사를 해줘야한다.
//        if(savedInstanceState != null)

        touchArea = findViewById(R.id.main_touch_area);
        gestureArea = findViewById(R.id.main_gesture_area);
        logText = findViewById(R.id.main_text_log);

        // 뷰를 터치 했을 때
        touchArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // 이벤트 핸들러 : touchArea 를 터치 했을 때 수행할 메서드

                // 터치 모션
                int action = event.getAction();

                // 터치 좌표
                // 이벤트가 발생한 뷰를 기준으로 좌표 값을 반환
                double x = event.getX();
                double y = event.getY();
                // 화면을 기준으로 좌표 값을 반환
                double rowX = event.getRawX();
                double rowY = event.getRawY();

                String msg = "";
                if (action == MotionEvent.ACTION_DOWN) {
                    //손가락으로 눌렀을 때
                    msg += String.format("ACTION DOWN : x = %.2f, y = %.2f", x, y);
                logText.append(msg + "\n");

            } else if (action == MotionEvent.ACTION_MOVE) {
                // 손가락으로 눌린 상태로 움직일 때
                msg += String.format("ACTION MOVE : x = %.2f, y = %.2f", x, y);
            } else if (action == MotionEvent.ACTION_UP) {
                // 손가락을 뗐을 때
                msg += String.format("ACTION UP : x = %.2f, y = %.2f", x, y);
            }
                logText.append(msg+"\n");
                // 결과 값 : 이후의 터치 이벤트르 ㄹ게쏙 받을 것인지 논리 값으로 반환
                // true : 이후 터치 이벤트를 받는다.
                // false : 이후 터치 이벤트를 받지 않는다.
                return true;
            }
        });


        // 제스쳐 모션 처리
        GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                appendLog("onDown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                appendLog("onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                appendLog("onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                appendLog("onScroll");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                appendLog("onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                appendLog("onFling");
                return false;
            }
        });

        gestureArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // GestureDetetor 객체의 onTouchEvent 메서드의 매개변수를 이벤트 객체를 넘긴다.
                detector.onTouchEvent(event);

                return false;
            }
        });
    }

    private void appendLog(String msg) {
        logText.append(msg + "\n");
    }

    //화면을 터치했을 때 수행하는 메서드
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //화면을 터치했을 때 수행하는 메서드
//
//        // 터치 모션
//        int action = event.getAction();
//
//        // 터치 좌표
//        double x = event.getX();
//        double y = event.getY();
//
//        String msg ="";
//        if(action == MotionEvent.ACTION_DOWN) {
//            //손가락으로 눌렀을 때
//            msg += String.format("ACTION DOWN : x = %.2f, y = %.2f", x, y);
//        }else if(action == MotionEvent.ACTION_MOVE){
//            // 손가락으로 눌린 상태로 움직일 때
//            msg += String.format("ACTION MOVE : x = %.2f, y = %.2f", x, y);
//        }else if(action ==MotionEvent.ACTION_UP){
//            // 손가락을 뗐을 때
//            msg+= String.format("ACTION UP : x = %.2f, y = %.2f", x, y);
//        }
//        logText.append(msg+"\n");
//
//        return super.onTouchEvent(event);
//    }
    // 방향 고정
    // AndriodManifest.xml 에서
    // 고정하고 싶은 activity의 속성에
    // android:screenOrientation ="portrait" 를 추가

    // 방향 전환 시
    // Activity 를 종료하고 다시 실행한다.
    // 그렇기 때문에 기존의 데이터가 날아가게 된다.
    // 그래서 종료되기 전에 기존의 데이터들을 저장하고
    // 새 Activity 에서 기존의 데이터들을 불러온다.


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Activity 내의 데이터를 저장하기 위한 메서드

        // Bundle 클래스의 객체에 데이터를 저장할 때는
        // 배열처럼 인덱스를 사용않고 문자열 형태의 키 값을 사용한다.
        // 즉 데이터에 이름(키)를 붙여서 데이터를 저장/불러온다.
        // 이때 키 값은 중복이 되어서는 안된다.
        outState.putString("log", logText.getText().toString());
    }

    // 번들 객체에 저장된 데이터를 불러오는 메서드
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String log = savedInstanceState.getString("log");
        logText.setText(log);
    }
}