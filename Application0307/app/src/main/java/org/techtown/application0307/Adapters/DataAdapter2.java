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

// 어뎁터를 만들 때 RecyclerView.Adapter 클래스의 타입변수를
// RecyclerView.ViewHolder 를 상속받은 클래스로 지정하게되면
// onCreateViewHolder 의 반환 타입과 onBindViewHolder 의 매개변수 타입이
// 우리가 작성한 클래스의 타입으로 바뀌기 때문에 타입변환에 대한 부분을 신경을 덜 써도 된다.
public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.DataViewHolder2> {
    ArrayList<SimpleData> dataList;

    public DataAdapter2() {
        this(null);
    }

    @NonNull
    @Override
    public DataViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ViewHolder 를 만드는 메서드
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent,false);

        return new DataViewHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder2 holder, int position) {
        holder.itemText.setText( dataList.get(position)+"" );
    }

    public DataAdapter2(ArrayList<SimpleData> dataList) {
        if(dataList == null) dataList = new ArrayList<>();

        this.dataList = dataList;
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    // 하나의 항목을 리사이클러 뷰에 출력하기 위해
    // 레이아웃 내에 정의된 뷰들을 참조하고 관리한다.
    class DataViewHolder2 extends RecyclerView.ViewHolder{
        TextView itemText;

        public DataViewHolder2(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
        }



    }

}
