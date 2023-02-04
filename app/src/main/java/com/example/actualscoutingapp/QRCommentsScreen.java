package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class QRCommentsScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //creating variables for everything on the .xml file
    ImageButton autonBtn4, teleopBtn4, endgameBtn4, qrcodeBtn4;
    TextView autonTitleTxt4, teleopTitleTxt4, endgameTitleTxt4, qrcodeTitleTxt4, qrcodeTitleTxt, qrCommentsTitle;
    ImageView qrcodeScreenBackground, qrcodeHomeBtnPic, qrcodePic, qrcodeTitleUnderline, qrcodeGenerateBack, matchNextBack, qrCommentsTitleUnderline;
    Button generateQrcodeBtn, nextMatchBtn;
    EditText commentsBox;
    SharedPreferences sp;
    String commentInputString;

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

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        commentsBox.setText(new_sp.getString("Comments",""));


        //creating on click events

        //screen changing buttons
        qrcodeHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(QRCommentsScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the auton screen
                Intent goToAutonScreen = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        teleopBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the teleop screen
                Intent goToTeleopScreen = new Intent(QRCommentsScreen.this, TeleopScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        endgameBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                commentInputString = commentsBox.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Comments", commentInputString);
                editor.commit();

                //screen will be changed to the endgame screen
                Intent goToEndgameScreen = new Intent(QRCommentsScreen.this, EndScreen.class);
                startActivity(goToEndgameScreen);
            }
        });
        nextMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", "");
                editor.putString("MatchNumber", "");
                editor.putString("AutonCubesUpperScore", "");
                editor.putString("AutonCubesMiddleScore", "");
                editor.putString("AutonCubesLowerScore", "");
                editor.putString("AutonConesUpperScore", "");
                editor.putString("AutonConesMiddleScore", "");
                editor.putString("AutonConesLowerScore", "");
                editor.putString("AutonFieldDropsScore", "");
                editor.putString("AutonCommunityDropsScore", "");
                editor.putBoolean("AutonMobilityCheck", false);
                editor.putString("TeleopCubesUpperScore", "");
                editor.putString("TeleopCubesMiddleScore", "");
                editor.putString("TeleopCubesLowerScore", "");
                editor.putString("TeleopConesUpperScore", "");
                editor.putString("TeleopConesMiddleScore", "");
                editor.putString("TeleopConesLowerScore", "");
                editor.putString("TeleopFieldDropsScore", "");
                editor.putString("TeleopCommunityDropsScore", "");
                editor.putString("TeleopLoadingDropsScore", "");
                editor.putString("Comments", "");
                editor.putBoolean("AutonNoClimbAttempted", false);
                editor.putBoolean("AutonClimbAttemptedNotEngaged", false);
                editor.putBoolean("AutonClimbAttemptedEngaged", false);
                editor.putBoolean("EndgameNoClimbAttempted", false);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", false);
                editor.putBoolean("EndgameClimbAttemptedEngaged", false);
                editor.commit();


                Intent startNewMatch = new Intent(QRCommentsScreen.this, AutonScreen.class);
                startActivity(startNewMatch);
            }
        });
    }
}