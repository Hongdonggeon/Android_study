package org.techtown.app02;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    Sub01Fragment sub01Fragment;
    Sub02Fragment sub02Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 액티비티 내에서 프래그먼트를 관리하기 위해 매니저 객체가 필요하다.
        manager = getSupportFragmentManager();

        // 2. 프래그먼트를 추가/제거/교체 하기 위해 명령어를  내리기 위한 수단 : 트랜젝션
        //    트랜젝션을 이용하기 위해서 FragmentTransition 객체를 생성
        FragmentTransaction transaction = manager.beginTransaction();

        // 3. 프래그먼트는 컴포넌트가 아니기 때문에 실행하기 위해선 객체를 생성해야 한다.
        sub01Fragment = new Sub01Fragment();

        // 4. 트랜젝션에 명령어를 추가
        //    트랜젝션에서 수행할 명령어를 추가를 했을 뿐이고 아직 수행되지는 않는다.
        transaction.add(R.id.main_container, sub01Fragment);

        // 5. 트랜젝션에 추가된 명령어를 수행.
        transaction.commit();

//        manager.beginTransaction()
//                .add(R.id.main_container, sub01Fragment)
//                .commit();
    }

    public void onClickFragmentButton(View view) {
        Fragment fragment = null;
        if (view.getId() == R.id.main_button_sub01) {
            fragment = sub01Fragment;
        } else if (view.getId() == R.id.main_button_sub02) {
            fragment =sub02Fragment;
        }
        manager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}