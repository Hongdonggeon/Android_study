package org.techtown.simpleadapterapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.simpleadapterapp.VO.ChattingRoom;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    SimpleAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.list_chatting_room);

        ChattingRoom [] rooms = new ChattingRoom[10];

        for (int i=0; i<rooms.length; i++){
            String name = "room" +i;
            String date = "02.28 14:" +i;
            String message = "Hello " +i;

            rooms[i]=new ChattingRoom(name, date, message);
        }

        // 다수의 문자열 데이터들을 리스트 뷰에 출력하기 위해선
        // SimpleAdapter 를 만들어야 한다.
        // ChattingRoom 객체의 정보는 SimpleAdapter 가 알 수 없다.
        // → HashMap
        String roomInforItem[] = getResources().getStringArray(R.array.room_infor);
        for (int i =0; i<rooms.length; i++){
            map = new HashMap<>();
            map.put(roomInforItem[0], rooms[i].getRoomName());
            map.put(roomInforItem[1], rooms[i].getLastChatDate());
            map.put(roomInforItem[2], rooms[i].getLastChatMsg());
            list.add(map);
        }

        adapter = new SimpleAdapter(
                this,
                list,
                R.layout.item_chatting_room,
                roomInforItem,
                new int[] {R.id.item_room_name, R.id.item_room_last_date, R.id.item_room_last_msg }
        );
        listView.setAdapter(adapter);

    }
}