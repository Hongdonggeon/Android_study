package org.techtown.customadapterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.techtown.customadapterapp.VO.ChattingRoom;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<ChattingRoom> list;
    Context context;
    public MyAdapter(@NonNull Context context, ArrayList<ChattingRoom> list){
        this.context = context;
        if(list == null) list= new ArrayList<>();
        this.list =list;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 데이터 관리와 같은 효율이 굉장히 안좋다.
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_chatting_room, parent, false);


        TextView nameText = convertView.findViewById(R.id.item_room_name);
        TextView dateText = convertView.findViewById(R.id.item_room_last_date);
        TextView msgText = convertView.findViewById(R.id.item_room_last_msg);

        ChattingRoom room = list.get(position);

        nameText.setText(room.getRoomName());
        dateText.setText(room.getLastChatDate());
        msgText.setText(room.getLastChatMsg());

        return convertView;
    }
}
