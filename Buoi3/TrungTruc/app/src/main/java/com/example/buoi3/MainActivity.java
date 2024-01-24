package com.example.buoi3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLog, btnCan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUser.getText().toString().trim();
                String password = edtPass.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, Infor.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
        btnCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUser.setText("");
                edtPass.setText("");
            }
        });
    }
    public void addControl(){
         btnCan = findViewById(R.id.btnCan);
         btnLog = findViewById(R.id.btnLog);
         edtUser = findViewById(R.id.edtUser);
         edtPass = findViewById(R.id.edtPass);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.home:{
                intent= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.dbuser:{
                intent= new Intent(MainActivity.this, Infor.class);
                startActivity(intent);
                return true;
            }
            case R.id.more:{
                intent= new Intent(MainActivity.this, Infor.class);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}