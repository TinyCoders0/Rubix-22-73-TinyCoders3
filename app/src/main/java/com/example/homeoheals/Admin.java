package com.example.homeoheals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    private EditText etusername, etpassword;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        etusername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        submit = (Button) findViewById(R.id.btn_login);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etusername.getText().toString().equals("HomeoHeals") &&
                        (etpassword.getText().toString().equals("Dr_tanvi"))){
                    Toast.makeText(getApplicationContext(),"Login Sucessfully ",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Admin.this, AdminPanel.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Try Again ",Toast.LENGTH_SHORT).show();

                }
                //validate();
                // startActivity(new Intent(Admin.this, Adminpanel.class));
            }
        });
    }

}