package com.example.buoi1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtN;
    TextView txtKQ;
    Button btnXyly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Control();
        addEvent();
    }

    public void Control(){
        edtN = findViewById(R.id.edtN);
        txtKQ = findViewById(R.id.txtKQ);
        btnXyly = findViewById(R.id.btnXuLy);
    }
    public void addEvent(){
        btnXyly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xuly();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12 && resultCode==11){
            ArrayList<Integer> listDS = data.getIntegerArrayListExtra("DSUS");
            txtKQ.setText("");
            for (int i:listDS){
                txtKQ.append(i+"\n");
            }
        }
    }
    public void Xuly(){
        Intent intent = new Intent(MainActivity.this, Second.class);
        intent.putExtra("n", Integer.parseInt(edtN.getText().toString()));
        startActivityForResult(intent,12);
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
            Intent intent = new Intent(MainActivity.this, home.class);
            startActivity(intent);
        }
        if(item.getItemId()== R.id.mnTinh){
            Intent intent = new Intent(MainActivity.this, Second.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}