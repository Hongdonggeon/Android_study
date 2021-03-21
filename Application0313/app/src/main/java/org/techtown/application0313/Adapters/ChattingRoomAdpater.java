package org.techtown.application0313.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.application0313.R;
import org.techtown.application0313.VO.ChattingRoom;

import java.util.ArrayList;
import java.util.Collections;

public class ChattingRoomAdpater extends RecyclerView.Adapter<ChattingRoomAdpater.ItemViewHolder> {
    ArrayList<ChattingRoom> roomList;

    public ChattingRoomAdpater(ArrayList<ChattingRoom> roomList) {
        if(roomList == null) roomList = new ArrayList<>();

        this.roomList = roomList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chatting_room, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ChattingRoom room = roomList.get(position);

        holder.nameText.setText(room.getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void addItem(ChattingRoom item) {
        if(item ==null) return;
        roomList.add(item);
        Collections.sort(roomList);
        notifyDataSetChanged();
    }


}
