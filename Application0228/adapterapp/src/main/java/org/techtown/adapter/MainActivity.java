package org.techtown.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_item_list);

        // 리스트 뷰에 출력할 데이터
        String[] items= getResources().getStringArray(R.array.items);
        // items를 출력하기 위한 어댑터 객체
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                items
        );
    }

    listView.setAdapter(arrayAdapter);
    listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

    listView.setOnItemListener(new AdapterView.OnItemClickListener){

        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String message = String.format("%d번째 항목 : %s", position+1, items[position])
        }
    }
}