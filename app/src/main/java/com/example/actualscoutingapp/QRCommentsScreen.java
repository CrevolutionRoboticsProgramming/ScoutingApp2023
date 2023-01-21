package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class QRCommentsScreen extends AppCompatActivity {

    //creating variables for everything on the .xml file
    ImageButton autonBtn4, teleopBtn4, endgameBtn4, qrcodeBtn4;
    TextView autonTitleTxt4, teleopTitleTxt4, endgameTitleTxt4, qrcodeTitleTxt4, qrcodeTitleTxt, qrCommentsTitle;
    ImageView qrcodeScreenBackground, qrcodeHomeBtnPic, qrcodePic, qrcodeTitleUnderline, qrcodeGenerateBack, matchNextBack, qrCommentsTitleUnderline;
    Button generateQrcodeBtn, nextMatchBtn;
    EditText commentsBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcomments_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn4 = findViewById(R.id.autonUnclicked4);
        teleopBtn4 = findViewById(R.id.teleopUnclicked4);
        endgameBtn4 = findViewById(R.id.endgameUnclicked4);
        qrcodeBtn4 = findViewById(R.id.qrcodeClicked4);

        autonTitleTxt4 = findViewById(R.id.autonTitleText4);
        teleopTitleTxt4 = findViewById(R.id.teleopTitleText4);
        endgameTitleTxt4 = findViewById(R.id.endgameTitleText4);
        qrcodeTitleTxt4 = findViewById(R.id.qrcodeTitleText4);
        qrcodeTitleTxt = findViewById(R.id.qrcodeScreenTitle);
        qrCommentsTitle = findViewById(R.id.commentsTitle);

        qrcodeScreenBackground = findViewById(R.id.qrcodeBackground);
        qrcodeHomeBtnPic = findViewById(R.id.qrcodeHome);
        qrcodePic = findViewById(R.id.qrcode);
        qrcodeTitleUnderline = findViewById(R.id.qrcodeScreenTitleUnderline);
        qrcodeGenerateBack = findViewById(R.id.generateQrcodeBack);
        matchNextBack = findViewById(R.id.nextMatchBack);
        qrCommentsTitleUnderline = findViewById(R.id.commentsUnderline);

        generateQrcodeBtn = findViewById(R.id.generateQrcode);
        nextMatchBtn = findViewById(R.id.nextMatch);

        commentsBox = findViewById(R.id.comments);


        //creating on click events

        //screen changing buttons
        qrcodeHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeScreen = new Intent(QRCommentsScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAutonScreen = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        teleopBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTeleopScreen = new Intent(QRCommentsScreen.this, EndScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        endgameBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEndgameScreen = new Intent(QRCommentsScreen.this, EndScreen.class);
                startActivity(goToEndgameScreen);
            }
        });
        nextMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewMatch = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(startNewMatch);
            }
        });
    }
}