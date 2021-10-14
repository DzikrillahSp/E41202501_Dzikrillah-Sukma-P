package com.example.myfragment;
//memasukkan komponen yang diperlukan
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //pemanggilan tampilan awal
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container, new ChatsFragment()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selecedFragment = null;

                //membuat swict case
                switch (item.getItemId()){
                    case R.id.nav_chats:
                        selecedFragment = new ChatsFragment();
                        break;
                    case R.id.nav_calls:
                        selecedFragment = new CallsFragment();
                        break;
                    case R.id.nav_status:
                        selecedFragment = new StatusFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmen_container, selecedFragment).commit();

                return false;
            }
        });

    }
}