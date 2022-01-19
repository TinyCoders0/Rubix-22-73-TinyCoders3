package com.example.homeoheals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selectpanel extends AppCompatActivity {
    CardView admin;
    CardView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectpanel);
        admin = findViewById(R.id.admin);
        user = findViewById(R.id.user);
        // add admin panel Listner
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(selectpanel.this, Admin.class));

            }
        });
        //adding patient panel Listner
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(selectpanel.this, Login.class));

            }
        });
    }
}