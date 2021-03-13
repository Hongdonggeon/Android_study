package org.techtown.application0306;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class SimpleAdapter extends BaseAdapter{
    ArrayList<String> list;
    Context context;
    SimpleAdapter(@NonNull Context context){
        this(context, null);
    }

    SimpleAdapter(@NonNull Context context, ArrayList<String> list){
        if(list == null) list = new ArrayList<>();

        this.context=context;
        this.list = list;
    }

    @Override
    public int getCount() {

        //어뎁터 뷰에 출력될 갯수
        // 모든 데이터를 출력할 경우 데이터의 수만큼 반환
        // 특정 개수만큼 출력할 경우 특정 값을 반환
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 문제점
        //  - 레이아웃 초기화의 성능 문제
        //      convertView 는 한 번 객체로 생성되면, 그 이후에는 재사용된다.
        //      → 해결 방법 : null 검사를 한다.
        //  - findViewById 의 성능 문제
        //      convertView 에 정의된 뷰들을 매번 참조한다.
        //      → 뷰들을 별도의 클래스(Holder Class)에 참조된 객체를 저장하고 재사용한다.


        // convertView 가 없는 경우에만 인플레이션을 한다.
        if(convertView == null) {
            Log.i("Item Layout Init", position+ "[NULL]");
            // 하나의 항목을 어댑터 뷰에 추가하기 위해 인플레이션이 필요하다.
            // 먼저 인플레이션을 하기 위한 객체를 참조
            // 인플레이션을 한 뷰를 convertView에 반환
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_string, parent, false);

            // convertView를 초기화할 때 Holder 클래스의 객체도 같이 생성한다.
            ItemHolder holder = new ItemHolder(convertView);
            // holder 객체를 convertView 에 저장해놓는다.
            convertView.setTag(holder);
        }else {
            Log.i("Item Layout Init", position + "[NotNULL]");
        }


        // 인플레이션이 이뤄졌으면 R.layout.item_string 에 정의된 뷰가 객체화가 이뤄졌다.
        // 객체로 만들어진 뷰들을 참조
        // final TextView itemText = convertView.findViewById(R.id.dataList);

        ItemHolder holder = (ItemHolder)convertView.getTag();

        // 참조한 뷰에 항목을 출력하기 위한 데이터를 반환
//        final String data = list.get(position);
        holder.setItem(list.get(position));
        // 참조한 뷰에 반환받은 항목 데이터를 설정
//        itemText.setText(data);

//        // 그외 추가적인 이벤트 설정 또는 그의 로직을 작성
//        itemText.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Item : "+ data, Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

    public void sort() {
        Collections.sort(list);
        Collections.reverse(list);

        // 어댑터가 가진 데이터 셋이 변경/수정/삭제 되었을 때
        // 재 적용을 하기 위한 메서드
        notifyDataSetChanged();
    }

    class ItemHolder {
        /// 어뎁터를 통해서 항목에 출력할 뷰들을 참조하는 클래스
        TextView itemText;

        ItemHolder(View root) {
            // 매개변수로 받은 뷰를 통해서 뷰 객체를 참조한다.
            itemText = root.findViewById(R.id.item_text);
        }


        void setItem(String data) {
            // getView 메서드에서 반환된 항목 데이터를 뷰에 설정한다.
            
            itemText.setText(data);
        }
    }
}


public class MainActivity extends AppCompatActivity {
    /*
        어뎁터 뷰(Adapter View)
            다수의 데이터를 화면에 보여주기 위한 뷰
                [ DATA ] --- [Adapter] --→ [ Adapter View ]


            다수의 데이터를 화면에 보여주기 위한 간단한 방법
                1. 리니어 레이아웃을 통한 리스트
                    → 한 항목씩 인플레이션을 해야한다.
                    → 관리가 되어지지 않기 때문에 자원을 많이 차지하게 된다.
                2. 리스트 뷰, 그리드 뷰를 이용
                    → 자원을 관리해야하는 코드를 직접 작성해야한다.
                3. 리사이클러 뷰를 이용
                    →
     */

    ListView list;
    SimpleAdapter simpleAdapter;
    ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.dataList);
        dataList = new ArrayList<>();

        Random r = new Random();

        for (int i =0; i<30 ; i++){
            int n = r.nextInt(100);
            dataList.add("ITEM" + n);
        }
        simpleAdapter = new SimpleAdapter(this, dataList);
        simpleAdapter.sort();
        list.setAdapter(simpleAdapter);
    }
}