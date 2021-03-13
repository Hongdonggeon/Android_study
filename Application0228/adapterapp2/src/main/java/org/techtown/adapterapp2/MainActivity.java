package org.techtown.adapterapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_item_list);
        String items[] = getResources().getStringArray(R.array.items);

        arrayList = new ArrayList<>(Arrays.asList(items));

       adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                R.id.item_name,
                items
        );

        listView.setAdapter(adapter);
        arrayList.add("NEW Item");

    }
    int count =1;
    public void onClickAddItemButton(View v){
        Toast.makeText(this, "new Item : "+count, Toast.LENGTH_SHORT).show();
        arrayList.add("NEW Item"+count);
        adapter.notifyDataSetChanged();
                count++;
    }
}