package org.techtown.example01_solve;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

class ItemViewPagerAdapter<T> extends RecyclerView.Adapter<ItemViewPagerAdapter.ItemViewHolder> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
    }

    @NonNull
    @Override
    public ItemViewPagerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewPagerAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        final int colors [] = {R.color.item_color1,R.color.item_color2,R.color.item_color3,R.color.item_color4};

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
        }
    }
}

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intList = new ArrayList<>();
        for(int i=0; i<10; i++){
            intList.add(i);
        }

        integerAdapter = new ItemViewPagerAdapter<>(intList);

        stRlIST = new ArrayList<>();
        for (int i =0; i< 10;i ++){

        }
        ViewPager = findViewById(R.id.main_viewpager);
        ViewPager.setAdapter(integerAdpater);
        ViewPager.setOffscreenPageLimit(2);

        viewPager.setPageTransformer(new ViewPager.PageTransformer()){
            @Override
                    transformp=
        }
    }
}