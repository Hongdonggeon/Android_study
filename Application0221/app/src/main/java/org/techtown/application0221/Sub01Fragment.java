package org.techtown.application0221;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Sub01Fragment extends Fragment {
    TextView titleText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프래그먼트의 뷰들을 인플레이션하는 단계
        // inflater : 레이아웃 인플레이션을 하기 위한 객체
        // container : 프래그먼트가 출력될 뷰

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sub01, container, false);
        // inflater 객체를 통해서 인플레이션 과정을 거친 다음에
        // 프래그먼트 내의 뷰들을 참조할 수 있다.
        titleText = root.findViewById(R.id.sub01_text_title);
        titleText.append("@Hello");
        return root;
    }
}