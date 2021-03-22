package org.techtown.tablayoutapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

class ItemViewPagerAdapter {
    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView itemText;
        int[] colors = {R.color.item_color1, R.color.item_color2, R.color.item_color3, R.color.item_color4};

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
        }

        void bindItem(int position) {
            itemText.setText("Item : " + position);

        }
    }
}


public class MainActivity extends AppCompatActivity{
    ViewPager2 viewPager;
    ItemViewPagerAdapter adapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ItemViewPagerAdapter();
        tabLayout = findViewById(R.id.main_tablayout);
        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // 탭 레이아웃의 항목을 만들기 위한 메서드
                tab.setText("Item" +position+")");
            }
        }).attach();
    }
}