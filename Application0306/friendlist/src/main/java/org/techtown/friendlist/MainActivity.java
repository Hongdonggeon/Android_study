package org.techtown.friendlist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.friendlist.Adapters.FriendListAdapter;
import org.techtown.friendlist.VO.User;

import java.util.ArrayList;

/*
    친구 목록을 만들기 위한 앱

    user 클래스
     필드
      이름
      이메일
      프로필 메세지
     생성자
      기본 생성자
      모든 필드를 초기화하는 생성자


    위의 User 클래스를 작성하고
    User 클래스의 객체를 리스트 뷰에 보여지도록 프로그램을 작성

    순서
     1. User 클래스를 작성
     2. 친구(유저)의 정보를 하나의 항목으로 출력할 레이아웃 작성
     3. 메인 화면에서 친구 목록을 보여줄 어뎁터 뷰(리스트 뷰)를 정의
     4. 어뎁터 클래스를 작성
     4-1. 어뎁터 클래스의 생성자
     4-2. 오버라이딩 메서드 구현
     4-2-1. getView() 구현
     4-2-2. convertView의 null 검사
     4-2-3. convertView 내의 뷰 객체들을 별도로 저장하기 위한 Holder 클래스를 작성
     4-2-4. Holder 객체 생성 후 convertView에 저장
     5. convertView 의 뷰들에 항목 데이터 설정을 구현
     6. 어뎁터 뷰에 어뎁터를 설정
 */
public class MainActivity extends AppCompatActivity {
    ListView friendListView;
    FriendListAdapter adapter;
    ArrayList<User> friendList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendList = new ArrayList<>();
        friendListView = findViewById(R.id.main_friend_list);
        adapter = new FriendListAdapter(this, friendList);

        User u1 = new User("User1", "u1@sbs.com", "안녕하세요");
        User u2 = new User("User2", "u1@sbs.com", "반가워요");
        friendList.add(u1);
        friendList.add(u2);

    }
}