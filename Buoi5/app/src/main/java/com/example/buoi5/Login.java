package com.example.buoi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView txtHello;
    Button btnCont, btnPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControl();
        XuLyPop();
    }

    private void XuLyPop() {
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Login.this, btnPop);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.popmenu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.Blue){
                            txtHello.setTextColor(Color.BLUE);
                            return true;
                        }
                        if(item.getItemId() == R.id.Gray){
                            txtHello.setTextColor(Color.GRAY);
                            return true;
                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contextmenu, menu);
    }
    public void addControl(){
        txtHello = findViewById(R.id.txtHello);
        btnCont = findViewById(R.id.btnXuly);
        registerForContextMenu(btnCont);
        btnPop = findViewById(R.id.btnpop);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Blue){
            txtHello.setBackgroundColor(Color.BLUE);
            return true;
        }
        if(item.getItemId() == R.id.Gray){
            txtHello.setBackgroundColor(Color.GRAY);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void xulyPopupmenu(){

    }
}