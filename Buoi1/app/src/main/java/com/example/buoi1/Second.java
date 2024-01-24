package com.example.buoi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    Button btnTinh;
    TextView txtN;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addControl();
        addEvent();
    }
    public void addControl(){
        btnTinh = findViewById(R.id.btnTinh);
        txtN = findViewById(R.id.txtN);
        intent = getIntent();
        int n = intent.getIntExtra("n",1);
        txtN.setText(n+"");
    }
    public void addEvent(){
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhUSC();
            }
        });
    }
    public void TinhUSC(){
        int n = Integer.parseInt(txtN.getText().toString());
        ArrayList<Integer> listDS = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if( n%i ==0 ){
                listDS.add(i);
            }
        }
        intent.putExtra("DSUS", listDS);
        setResult(11,intent);
        finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.mnhome){
            Intent intent = new Intent(Second.this, home.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()== R.id.mnTinh){
            Intent intent = new Intent(Second.this, Second.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}