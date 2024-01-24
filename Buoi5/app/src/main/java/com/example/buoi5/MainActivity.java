package com.example.buoi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragment.HomeFragment;
import fragment.InfoFragment;
import fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botNav;
    Button btnLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("main");
    }

    void loadFrag(Fragment frmNew){

        FragmentTransaction Fmtran = getSupportFragmentManager().beginTransaction();
        Fmtran.replace(R.id.main_frame,frmNew);
        Fmtran.addToBackStack(null);
        Fmtran.commit();

    }
    private void addEvent() {
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //load fragment
                //khi chon menu tren nav load fragment
                Fragment fmnew;
                if(item.getItemId()== R.id.home){
                    fmnew = new HomeFragment();
                    loadFrag(fmnew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                if(item.getItemId()== R.id.set){
                    fmnew = new SettingFragment();
                    loadFrag(fmnew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                if(item.getItemId()== R.id.info){
                    fmnew = new InfoFragment();
                    loadFrag(fmnew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                return true;
            }
        });
    }

    private void addControl() {
        botNav = findViewById(R.id.botNav);
        btnLog = findViewById(R.id.btnLog);
    }
}