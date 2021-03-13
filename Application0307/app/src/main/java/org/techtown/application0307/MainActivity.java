package org.techtown.application0307;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.techtown.application0307.Adapters.DataAdapter2;
import org.techtown.application0307.VO.SimpleData;

import java.util.ArrayList;
import java.util.Random;

/*
    RecyclerView
     어뎁터 뷰 중 하나이며, 가장 최근에 나온 뷰

     기본의 리스트 뷰, 그리드 뷰의 성능이유를 해결하고
     더 다양한 기능을 지원하는 뷰이다.
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DataAdapter2 adapter;
    ArrayList<SimpleData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        Random r = new Random();
        for(int i =0; i<30; i++){
            list.add(new SimpleData(r.nextInt(101)));


            recyclerView = findViewById(R.id.main_data_list);
            adapter = new DataAdapter2(list);
            // 리사이클러뷰에 어뎁터를 설정
            recyclerView.setAdapter(adapter);

            // 항목이 구성되는 방식을 설정

            //LinearLayoutManager : 한 방향으로 배치하는 클래스
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));
            // → 세로 방향, 정방향
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));
            //→ 세로방향, 역방향
             recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            // → 가로 방향, 정방향
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));
            // → 가로 방향, 역방향

            // 한 방향으로 다수의 줄을 배치하는 클래스
            recyclerView.setLayoutManager( new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));
            //→ 세로 방향으로 4개씩 정방향
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false));
            // → 세로 방향으로 4개씩 정방향

            // StarggeredGridLayoutManager : 크기가 불규칙한 그리드 레이아웃
            recyclerView.setLayoutManager(( new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)));

            recyclerView.setLayoutManager(( new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL)));
        }


    }
}