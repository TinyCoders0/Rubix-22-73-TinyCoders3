package com.example.homeoheals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Appointment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etname,etphone,etemail,etdate;
    Button btn,btnshow;
    DatabaseReference reff;
    int year;
    int month;
    int day;
    Spinner spinner1;
    String item;
    User user;
    String[] spinnername = {"select Mode", "virtual" , "physical"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        reff = FirebaseDatabase.getInstance().getReference("User");

        etname = (EditText) findViewById(R.id.etname);
        etphone = (EditText) findViewById(R.id.etphone);
        etemail = (EditText) findViewById(R.id.etemail);
        etdate = (EditText) findViewById(R.id.etdate);
        btn = (Button) findViewById(R.id.btn);
        spinner1=findViewById(R.id.spinnerid);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnername);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(arrayAdapter);
        // btnshow =(Button) findViewById(R.id.btnshow);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        month = month + 1;
        etdate.setText(day + "/" + month + "/" + year);
        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                        monthofYear = monthofYear + 1;
                        etdate.setText(dayOfMonth + "/" + monthofYear + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SaveValue(item);
                adddata();

            }
        });
    }
/**    Show Appointment Details
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Appointment.this, Bookedappointment.class));
            }
        });*/


    private void adddata(){

        String name= etname.getText().toString().trim();
        String phone = etphone.getText().toString().trim();
        String email = etemail.getText().toString().trim();
        String date = etdate.getText().toString().trim();
        String mode = spinner1.getSelectedItem().toString().trim();
        //String mode = spinner1.getText().toString().trim();

        if (!TextUtils.isEmpty(name)  && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(date) && !TextUtils.isEmpty(mode)){
            String id = reff.push().getKey();
            User user = new User(id, name, email, phone,date, mode);
            reff.child(id).setValue(user);
            Toast.makeText(this,"User data added sucessfully", Toast.LENGTH_LONG).show();
           // startActivity(new Intent(Appointment.this, Bookedappointment.class));

        }else {
            Toast.makeText(this,"You should fill all details", Toast.LENGTH_LONG).show();
        }



        // btnshow.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View v) {
        //   startActivity(new Intent(MainActivity.this, Bookedappointment.class));
        //}
        //});
    }
    public void sendMail(View view){
        try {
            LongOperation l = new LongOperation();
            l.execute();  //sends the email in background
            Toast.makeText(this, l.get(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //void SaveValue(String item) {
      //  if (item == "select mode"){
            //Toast.makeText(this,"please select mode", Toast.LENGTH_SHORT).show();
        //}else {
          //  user.setSpinnername(item);
            //String id= reff.push().getKey();
            //reff.child(id).setValue(user);
            //Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();
        //}
    //}
}


