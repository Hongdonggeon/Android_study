package org.techtown.friendlistapp.Adpaters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.friendlistapp.VO.User;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter> {
    @NonNull
    @Override
    public FriendListAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendListAdapter holder, int position) {
        User friend = userList.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
