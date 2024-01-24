package com.example.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Infor extends AppCompatActivity {

    TextView txtUser, txtPass;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        addControl();
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        txtUser.setText(username);
        txtPass.setText(password);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void addControl(){
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnBack = findViewById(R.id.btnBack);
    }
}