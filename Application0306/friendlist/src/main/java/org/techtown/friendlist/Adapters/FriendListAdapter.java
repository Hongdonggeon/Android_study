package org.techtown.friendlist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.techtown.friendlist.R;
import org.techtown.friendlist.VO.User;

import java.util.ArrayList;

public class FriendListAdapter extends BaseAdapter {
    ArrayList<User> userList;
    Context context;

    public FriendListAdapter(@NonNull Context context) {
        this(context, null);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) { // null 검사 중요
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_friend_profile, parent, false);

            FriendViewHolder holder = new FriendViewHolder(convertView); // 별도의 클래스를 저장을 한다.
            convertView.setTag(holder);
        }

        FriendViewHolder holder = (FriendViewHolder) convertView.getTag();

        User friend = userList.get(position);

        holder.nameText.setText(friend.getName());
        holder.emailText.setText(friend.getEmail());
        holder.profileText.setText(friend.getPro_msg());

        return convertView;
    }
    class FriendViewHolder {
        TextView nameText;
        TextView emailText;
        TextView profileText;

        FriendViewHolder(View root) {
            nameText = root.findViewById(R.id.item_friend_name);
            emailText = root.findViewById(R.id.item_friend_email);
            profileText = root.findViewById(R.id.item_friend_profile_msg);
        }
    }
}
