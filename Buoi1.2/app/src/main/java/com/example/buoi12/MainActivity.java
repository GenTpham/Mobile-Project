package com.example.buoi12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    TextView txtKQ;
    Button Cong, Tru, Nhan, Chia;
    double a, b, tinh =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Control();
        Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValue();
                tinh = a-b;
                txtKQ.setText(String.valueOf(tinh));
            }
        });
        Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValue();
                tinh = a*b;
                txtKQ.setText(String.valueOf(tinh));
            }
        });
        Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValue();
                tinh = a/b;
                txtKQ.setText(String.valueOf(tinh));
            }
        });

    }
    public void Control(){
         edtA = findViewById(R.id.edtA);
         edtB = findViewById(R.id.edtB);
         txtKQ = findViewById(R.id.txtKQ);
         Tru = findViewById(R.id.btnTru);
        Nhan = findViewById(R.id.btnNhan);
        Chia = findViewById(R.id.btnChia);
    }
    public void GetValue(){
        a = Double.parseDouble(edtA.getText().toString());
        b = Double.parseDouble(edtB.getText().toString());
    }
    public void Cong(View view) {
       GetValue();
        tinh = a+b;
        txtKQ.setText(String.valueOf(tinh));
    }
}