package org.techtown.viewpageapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/*
    veiwPager2
        프래그먼트 또는 뷰 간의 전환을 위한 뷰ddddddddddd
         뷰 전화        : RecyclerView.Adapter 를 이용
         프래그먼트 전환 : FragmentStateAdapter를 이용

        추가된 기능
         -RTL(Right to Left) Layout support
         -Vertical orientation support
         -Reliable Fragmemnt support
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}