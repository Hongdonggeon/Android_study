package org.techtown.application0307.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.application0307.R;
import org.techtown.application0307.VO.SimpleData;

import java.util.ArrayList;

//
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<SimpleData> datalist;

    public DataAdapter() {
        this(null);
    }

    public DataAdapter(ArrayList<SimpleData> datalist) {
        if(datalist == null) new ArrayList<>();


        this.datalist = datalist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //ViewHolder 를 만드는 메서드
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // 생성된 holder 객체를 통해서 어뎁터 뷰에 보여주는 메서드


        // holder에 참조된 뷰에 특정 위치의 데이터를 설정한다.
        ((DataViewHolder)holder).itemText.setText( datalist.get(position).getNumber() );
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    // 하나의 항목을 리사이클러 뷰
    // 레이아웃 내에 정의된 뷰들을 참조하고 관리한다.
    class DataViewHolder extends RecyclerView.ViewHolder{
        TextView itemText;

        public DataViewHolder(@NonNull View itemView){
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
        }
    }
}
