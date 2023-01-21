package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //creating variables for everything on the .xml file
    Button startBtn;
    ImageView crevolutionLogoPic, startScreenBackground, startBtnUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        startBtn = findViewById(R.id.start);

        crevolutionLogoPic = findViewById(R.id.crevLogo);
        startScreenBackground = findViewById(R.id.autonBackground);
        startBtnUnderline = findViewById(R.id.startUnderline);


        //click the startBtn to come to the auton screen
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeScreens = new Intent(MainActivity.this, AutonScreen.class);
                startActivity(changeScreens);
            }
        });

    }
}