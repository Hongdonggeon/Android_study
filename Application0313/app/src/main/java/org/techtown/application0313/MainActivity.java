package org.techtown.application0313;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.application0313.Adapters.ChattingRoomAdpater;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChattingRoomAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.main_recycler_view);
        adapter = new ChattingRoomAdpater();
    }
}