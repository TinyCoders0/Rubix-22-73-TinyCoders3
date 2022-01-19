package com.example.homeoheals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private FirebaseAuth firebaseAuth;
    ImageView youtube;
    ImageView insta;
    ImageView facebook;
    //private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //auto slider code
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.c1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c5, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c6, ScaleTypes.FIT));
        imageSlider.setImageList(imageList,ScaleTypes.FIT);

        //Marquee tag code
        TextView textView = findViewById(R.id.tv);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

        //URL code
        youtube = findViewById(R.id.youtube);
        insta = findViewById(R.id.instagram);
        facebook = findViewById(R.id.facebook);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.youtube.com/c/HomeoHeals/featured");
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/homeoheals/");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/DrTanviHomeoHeals/");
            }
        });
        //logout button
        firebaseAuth = FirebaseAuth.getInstance();
        //btnlogout =(Button)findViewById(R.id.btnlogout);

       // btnlogout.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   firebaseAuth.signOut();
               // finish();
                //startActivity(new Intent(Home.this, Login.class));

            //}
        //});
        //NavigationDrawer code

        Toolbar toolbar = findViewById(R.id.tb1);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new location());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_about:
                Intent about_intent=new Intent(Home.this,aboutUs.class);
                startActivity(about_intent);
                break;

            case R.id.nav_location:
                Intent location_intent=new Intent(Home.this,location.class);
                startActivity(location_intent);
                break;

            case R.id.nav_feedback:
                Intent feedback_intent=new Intent(Home.this,feedback.class);
                startActivity(feedback_intent);
                break;

            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                onStart();
                Toast.makeText(getBaseContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();
                Intent Logout_intent=new Intent(Home.this,Login.class);
                startActivity(Logout_intent);
                break;

            case R.id.nav_appointment:
                Intent Appointment_intent=new Intent(Home.this,Appointment.class);
                startActivity(Appointment_intent);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);


        return true;
    }


    public void logout(){

        Toast.makeText(this,"Logout!!",Toast.LENGTH_SHORT).show();
        firebaseAuth.signOut();
         finish();
        startActivity(new Intent(Home.this, Login.class));
        }



    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}