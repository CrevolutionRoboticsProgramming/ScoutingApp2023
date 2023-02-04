package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //creating variables for everything on the .xml file
    ImageButton autonBtn3, teleopBtn3, endgameBtn3, qrcodeBtn3;
    TextView autonTitleTxt3, teleopTitleTxt3, endgameTitleTxt3, qrcodeTitleTxt3, endgameTitleTxt, matchNumTitle3, teamNumTitle3, endgameMatchInfoBack, dockingTitleTxt3;
    ImageView endgameScreenBackground, endgameHomeBtnPic, endgameTitleUnderline, matchNumBack3, teamNumBack3;
    EditText matchNumInput3, teamNumInput3;
    RadioGroup docking3;
    RadioButton noAttemptOption3, attemptNoEngageOption3, engagedOption3;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString;
    Boolean endgameNoDockingBoolean, endgameDockingNotEngagedBoolean, endgameDockingEngagedBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn3 = findViewById(R.id.autonUnclicked3);
        teleopBtn3 = findViewById(R.id.teleopUnclicked3);
        endgameBtn3 = findViewById(R.id.endgameClicked3);
        qrcodeBtn3 = findViewById(R.id.qrcodeUnclicked3);

        autonTitleTxt3 = findViewById(R.id.autonTitleText3);
        teleopTitleTxt3 = findViewById(R.id.teleopTitleText3);
        endgameTitleTxt3 = findViewById(R.id.endgameTitleText3);
        qrcodeTitleTxt3 = findViewById(R.id.qrcodeTitleText3);
        endgameTitleTxt = findViewById(R.id.endgameScreenTitle);
        matchNumTitle3 = findViewById(R.id.endgameMatchNumberTitle);
        teamNumTitle3 = findViewById(R.id.endgameTeamNumberTitle);
        endgameMatchInfoBack = findViewById(R.id.endgameInputBack);
        dockingTitleTxt3 = findViewById(R.id.endgameDockingTitle);

        endgameScreenBackground = findViewById(R.id.endgameBackground);
        endgameHomeBtnPic = findViewById(R.id.endgameHome);
        endgameTitleUnderline = findViewById(R.id.endgameScreenTitleUnderline);
        matchNumBack3 = findViewById(R.id.endgameMatchNumBack);
        teamNumBack3 = findViewById(R.id.endgameTeamNumBack);

        matchNumInput3 = findViewById(R.id.endgameMatchNumInput);
        teamNumInput3 = findViewById(R.id.endgameTeamNumInput);

        docking3 = findViewById(R.id.endgameDockingOptions);

        noAttemptOption3 = findViewById(R.id.endgameNoAttempt);
        attemptNoEngageOption3 = findViewById(R.id.endgameDockedNotEngagedOption);
        engagedOption3 = findViewById(R.id.endgameDockedEngagedOption);


        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput3.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput3.setText(new_sp.getString("MatchNumber", ""));
        noAttemptOption3.setChecked(new_sp.getBoolean("EndgameNoClimbAttempted", false));
        attemptNoEngageOption3.setChecked(new_sp.getBoolean("EndgameClimbAttemptedNotEngaged", false));
        engagedOption3.setChecked(new_sp.getBoolean("EndgameClimbAttemptedEngaged", false));



        //creating on click events

        //screen changing buttons
        endgameHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();

                if (noAttemptOption3.isChecked()){
                    endgameNoDockingBoolean = true;
                }
                else {
                    endgameNoDockingBoolean = false;
                }
                if (attemptNoEngageOption3.isChecked()){
                    endgameDockingNotEngagedBoolean = true;
                }
                else {
                    endgameDockingNotEngagedBoolean = false;
                }
                if (engagedOption3.isChecked()){
                    endgameDockingEngagedBoolean = true;
                }
                else {
                    endgameDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putBoolean("EndgameNoClimbAttempted", endgameNoDockingBoolean);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", endgameDockingNotEngagedBoolean);
                editor.putBoolean("EndgameClimbAttemptedEngaged", endgameDockingEngagedBoolean);
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(EndScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();

                if (noAttemptOption3.isChecked()){
                    endgameNoDockingBoolean = true;
                }
                else {
                    endgameNoDockingBoolean = false;
                }
                if (attemptNoEngageOption3.isChecked()){
                    endgameDockingNotEngagedBoolean = true;
                }
                else {
                    endgameDockingNotEngagedBoolean = false;
                }
                if (engagedOption3.isChecked()){
                    endgameDockingEngagedBoolean = true;
                }
                else {
                    endgameDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putBoolean("EndgameNoClimbAttempted", endgameNoDockingBoolean);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", endgameDockingNotEngagedBoolean);
                editor.putBoolean("EndgameClimbAttemptedEngaged", endgameDockingEngagedBoolean);
                editor.commit();

                //screen will be changed to auton screen
                Intent goToAutonScreen = new Intent(EndScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        teleopBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();

                if (noAttemptOption3.isChecked()){
                    endgameNoDockingBoolean = true;
                }
                else {
                    endgameNoDockingBoolean = false;
                }
                if (attemptNoEngageOption3.isChecked()){
                    endgameDockingNotEngagedBoolean = true;
                }
                else {
                    endgameDockingNotEngagedBoolean = false;
                }
                if (engagedOption3.isChecked()){
                    endgameDockingEngagedBoolean = true;
                }
                else {
                    endgameDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putBoolean("EndgameNoClimbAttempted", endgameNoDockingBoolean);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", endgameDockingNotEngagedBoolean);
                editor.putBoolean("EndgameClimbAttemptedEngaged", endgameDockingEngagedBoolean);
                editor.commit();

                //screen will be changed to teleop screen
                Intent goToTeleopScreen = new Intent(EndScreen.this, TeleopScreen.class);
                startActivity(goToTeleopScreen);
            }
        });
        qrcodeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput3.getText().toString();
                matchNumberInputString = matchNumInput3.getText().toString();

                if (noAttemptOption3.isChecked()){
                    endgameNoDockingBoolean = true;
                }
                else {
                    endgameNoDockingBoolean = false;
                }
                if (attemptNoEngageOption3.isChecked()){
                    endgameDockingNotEngagedBoolean = true;
                }
                else {
                    endgameDockingNotEngagedBoolean = false;
                }
                if (engagedOption3.isChecked()){
                    endgameDockingEngagedBoolean = true;
                }
                else {
                    endgameDockingEngagedBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putBoolean("EndgameNoClimbAttempted", endgameNoDockingBoolean);
                editor.putBoolean("EndgameClimbAttemptedNotEngaged", endgameDockingNotEngagedBoolean);
                editor.putBoolean("EndgameClimbAttemptedEngaged", endgameDockingEngagedBoolean);
                editor.commit();

                //screen will be changed to qrcode screen
                Intent goToQrcodeScreen = new Intent(EndScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });
    }
}