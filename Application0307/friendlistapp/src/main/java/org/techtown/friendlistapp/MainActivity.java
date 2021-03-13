package org.techtown.friendlistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/*
    RecyclerView 를 이용하여 작성하는 방법
     1. 준비
      a.RecyclerView 출력할 데이터를 VO 클래스로 작성
      b. 하나의 항목을 표시할 XML 레이아웃을 작성
      C. Activity 에  Recycler VIEW 배치

     2. Adapter 작성
      a. Adapter 클래스 작성
      b. Adapter 클래스에서 사용할 ViewHolder 클래스를 작성
       i. RecyclerView.ViewHolder 를 상속
       ii. 1.b 에서 작성한 레이아웃에서 정의된 뷰들을 참조
       iii. 참조된 뷰에 데이터 항목을 설정하는 메서드를 작성
      c. Adapter 를 완성하기 위한 RecyclerView.Adapter<ViewHolder> 를 상속
      d. 오버라이딩된 메서드를 구현
        i. onCreateViewHolder 구현 → ViewHolder를 생성하여 반환하는 메서드
        ii. onBindViewHolder 구현 → 생성된 ViewHolder에 데이터 항목을 설정하기 위한 메ㅓㅅ드
        iii. getItemCount 구현

     3. RecyclerView 설정
      a. RecyclerView 에 LayoutManager 를 통해서 레이아웃 구성을 설정
      b. RecyclerView 에 Adapter를 설정

     4. ItemDecoration, ItemAnimation 등을 통해 다양한 효과를 설정 (선택)


 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}