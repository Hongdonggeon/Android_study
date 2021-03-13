package org.techtown.application0228;

import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //res 폴더 내의 menu 폴더에 정의된 actionbar_menu.xml 를 인플레이션
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);

        // actionbar_menu.xml 에 정의된 SearchView를 참조
        searchView = (SearchView)menu.findItem(R.id.search_view).getActionView();

        searchView.setQueryHint("입력하세요. ");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 검색 버튼을 눌렀을 때
                // → 즉 텍스트를 전송했을 때
                Toast.makeText(MainActivity.this, query+"검색 완료", Toast.LENGTH_SHORT).show();
                searchView.onActionViewCollapsed(); // searchView 축소 ↔ onActionViewExtended() :
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 텍스트가 문자단위로 바뀔 때마다 호출
                Toast.makeText(MainActivity.this, "입력 중 : " + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        CheckBox ch1 = menu.findItem(R.id.check_box).getActionView().findViewById(R.id.check_box);
        //OnCheckedChangeListener : 체크박스 또는 라디오버튼과 같은 뷰들이 사용하는 리스너
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}