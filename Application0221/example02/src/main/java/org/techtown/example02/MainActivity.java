package org.techtown.example02;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.techtown.example02.ColorFragment.BlueFragment;
import org.techtown.example02.ColorFragment.GreenFragment;
import org.techtown.example02.ColorFragment.RedFragment;

public class MainActivity extends AppCompatActivity {
    Fragment redFragment, blueFragment, greenFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redFragment = new RedFragment();
        blueFragment = new BlueFragment();
        greenFragment = new GreenFragment();

        fragmentManager = getSupportFragmentManager();
    }

    public void onClickFragmentButton(View view){
        Fragment fragment = null;
        int viewId = view.getId();

        if(viewId == R.id.main_button_red){
            fragment = redFragment;
        } else if (viewId == R.id.main_button_green) {
            fragment = greenFragment;
        }
        else if (viewId == R.id.main_button_blue){
            fragment = blueFragment;
        }
    fragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit();
    }
}