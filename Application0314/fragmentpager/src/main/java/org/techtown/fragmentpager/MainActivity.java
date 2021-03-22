package org.techtown.fragmentpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.techtown.fragmentpager.Fragments.Sub01Fragment;
import org.techtown.fragmentpager.Fragments.Sub02Fragment;
import org.techtown.fragmentpager.Fragments.Sub03Fragment;

import java.util.ArrayList;

//viewpager2
// ViewPager2 는 뷰 뿐만 아니라 프래그먼트
//프래그먼트를 전환하기 위한 어댑터 : FragmentStateAdapter
//FragmentStatePagerAdpater는 ViewPager에서 사용하는 어댑터
// → 현재 잘 사용하지 않는 어댑터

class MyFragmentPagerAdapter extends FragmentStateAdapter{
    // 모든 프래그먼트를 저장하기 위한 컬렉션
    ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
        fragments = new ArrayList<>();
        fragments.add(new Sub01Fragment());
        fragments.add(new Sub02Fragment());
        fragments.add(new Sub03Fragment());

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 화면에 표시할 프래그먼트를 생성/반환하는 메서드
        return fragments.get(position%3);
    }

    @Override
    public int getItemCount() {
        // 뷰 페이저에 출력할 프래그먼트의 수를 반환하는 메서드
        return fragments.size();
    }
}

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    MyFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.main_viewpager);
        adapter = new MyFragmentPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }
}