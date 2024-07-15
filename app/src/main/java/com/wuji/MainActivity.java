package com.wuji;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private BottomNavigationView NavView;
    private Toolbar toolbar;
    private Button passer;
    private ImageButton mine;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(HomeFragment.newInstance(null,null));
        NavView = (BottomNavigationView)findViewById(R.id.nav_view);
        
        NavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.note:
                        replaceFragment(HomeFragment.newInstance(null,null));
                        return true;
                    case R.id.passer:
                        replaceFragment(PasserFragment.newInstance(null,null));
                        return true;
                    case R.id.mine:
                        replaceFragment(new SettingsActivity.SettingsFragment());
                        return true;
                }
                return false;

            }
        });
    }




    // 切换内容区的fragment组件
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        String fragmentName = ((BaseFragment) fragment).getName();
//        if (fragmentName.equals(NavHosts.HOST_WELCOME)){
//            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        }

        //fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        // fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);

        fragmentTransaction.replace(R.id.contentContainer, fragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
