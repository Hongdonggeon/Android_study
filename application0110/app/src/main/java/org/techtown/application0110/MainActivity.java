package org.techtown.application0110;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// 프로젝트의 구성
//  다수의 모듈로 구성할 수 있다.
//  하나의 앱을 하나의 모듈로 개발을 할 수 있다.
//  모듈 내의 구성
//   manifests 폴더
//      - 앱의 정보를 설정하는 파일
//   java 폴더
//      - 어플리케이션의 동작을 구현하기 위한 코드를 작성하는 공간
//   res 폴더
//      - 어플리케이션에서 사용할 정적 데이터를 정의하는 공간
//      - 정의된 데이터들은 R.java 파일에 등록된다.
//      - java 코드에서 R.java 를 통해서 사용할 수 있다.

// 안드로이드는 '컴포넌트 기반'으로 개발을 한다.
//  컴포넌트 : 앱을 구성하는 하나의 단위
//  컴포넌트의 종류
//    1. 액티비티   : 어플리케이션의 UI를 구성하는 컴포넌트
//    2. 서비스
//    3. 컨텐츠 제공자
//    4. 브로드캐스트 수신자

// Activity 컴포넌트의 역할
//  정의되어있거나 메모리에 만들어진 UI를 화면에 출력한다.
//   보통 XML 로 정의된 UI 화면을 출력한다.
//     → layout xml 파일
//  UI에 정의된 버튼, 텍스트, 이미지 등을 동적으로 제어/조작한다.

// activity_sub02.xml 파일을 생성하고
//  root element : LinearLayout 로 지정
// 배경색이 파란색인 텍스트뷰를 추가하고
// 너비는 화면을 꽉 채우고
// 높이는 컨텐츠에 맞춰서 지정
// 글자의 색상 : 하얀색
// 글자의 크기 : 24sp
// 내부의 위, 아래 여백 : 20dp
// 외부의 모든 여백 : 10dp
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/activity_main.xml을 화면에 보여준다.
        setContentView(R.layout.activity_sub03);
    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼을 눌렀을 때 수행되는 메서드

        // 토스트 메세지(Toast 메세지)
//        Toast.makeText(this, "종료합니다.", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, R.string.app_finish_msg, Toast.LENGTH_SHORT).show();

        super.onBackPressed();
    }
}