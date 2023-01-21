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
import android.widget.TextView;

public class TeleopScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //test push to github test
    //satchit was here
    //creating variables for everything on the .xml file
    ImageButton autonBtn2, teleopBtn2, endgameBtn2, qrcodeBtn2;
    TextView autonTitleTxt2, teleopTitleTxt2, endgameTitleTxt2, qrcodeTitleTxt2, teleopTitleTxt, matchNumTitle2, teamNumTitle2, teleopMatchInfoBack, scoringTitleTxt2, upperTitleTxt2, middleTitleTxt2, lowerTitleTxt2, loadsTitleTxt2;
    ImageView teleopScreenBackground, teleopHomeBtnPic, teleopTitleUnderline, matchNumBack2, teamNumBack2, upperPlus2, upperMinus2, middlePlus2, middleMinus2, lowerPlus2, lowerMinus2;
    EditText matchNumInput2, teamNumInput2, upperInput2, middleInput2, lowerInput2;
    CheckBox groundCheck2, humanCheck2;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString, teleopUpperInputScoreString, teleopMiddleInputScoreString, teleopLowerInputScoreString;
    Boolean teleopGroundLoadsBoolean, teleopHumanLoadsBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_screen);


        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        autonBtn2 = findViewById(R.id.autonUnclicked2);
        teleopBtn2 = findViewById(R.id.teleopClicked2);
        endgameBtn2 = findViewById(R.id.endgameUnclicked2);
        qrcodeBtn2 = findViewById(R.id.qrcodeUnclicked2);

        autonTitleTxt2 = findViewById(R.id.autonTitleText2);
        teleopTitleTxt2 = findViewById(R.id.teleopTitleText2);
        endgameTitleTxt2 = findViewById(R.id.endgameTitleText2);
        qrcodeTitleTxt2 = findViewById(R.id.qrcodeTitleText2);
        teleopTitleTxt = findViewById(R.id.teleopScreenTitle);
        matchNumTitle2 = findViewById(R.id.teleopMatchNumberTitle);
        teamNumTitle2 = findViewById(R.id.teleopTeamNumberTitle);
        teleopMatchInfoBack = findViewById(R.id.teleopInputBack);
        scoringTitleTxt2 = findViewById(R.id.teleopScoringTitle);
        upperTitleTxt2 = findViewById(R.id.teleopUpperTitle);
        middleTitleTxt2 = findViewById(R.id.teleopMiddleTitle);
        lowerTitleTxt2 = findViewById(R.id.teleopLowerTitle);
        loadsTitleTxt2 = findViewById(R.id.teleopLoadsTitle);


        teleopScreenBackground = findViewById(R.id.teleopBackground);
        teleopHomeBtnPic = findViewById(R.id.teleopHome);
        teleopTitleUnderline = findViewById(R.id.teleopScreenTitleUnderline);
        matchNumBack2 = findViewById(R.id.teleopMatchNumBack);
        teamNumBack2 = findViewById(R.id.teleopTeamNumBack);
        upperPlus2 = findViewById(R.id.teleopUpperPlus);
        upperMinus2 = findViewById(R.id.teleopUpperMinus);
        middlePlus2 = findViewById(R.id.teleopMiddlePlus);
        middleMinus2 = findViewById(R.id.teleopMiddleMinus);
        lowerPlus2 = findViewById(R.id.teleopLowerPlus);
        lowerMinus2 = findViewById(R.id.teleopLowerMinus);


        matchNumInput2 = findViewById(R.id.teleopMatchNumInput);
        teamNumInput2 = findViewById(R.id.teleopTeamNumInput);
        upperInput2 = findViewById(R.id.teleopUpperInput);
        middleInput2 = findViewById(R.id.teleopMiddleInput);
        lowerInput2 = findViewById(R.id.teleopLowerInput);

        groundCheck2 = findViewById(R.id.teleopGroundCheck);
        humanCheck2 = findViewById(R.id.teleopHumanCheck);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput2.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput2.setText(new_sp.getString("MatchNumber", ""));
        upperInput2.setText(new_sp.getString("TeleopUpperScore", ""));
        middleInput2.setText(new_sp.getString("TeleopMiddleScore", ""));
        lowerInput2.setText(new_sp.getString("TeleopLowerScore", ""));
        groundCheck2.setChecked(new_sp.getBoolean("TeleopGroundCheck", false));
        humanCheck2.setChecked(new_sp.getBoolean("TeleopHumanCheck", false));

        ///creating on click events

        //screen changing buttons
        teleopHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput2.getText().toString();
                matchNumberInputString = matchNumInput2.getText().toString();
                teleopUpperInputScoreString = upperInput2.getText().toString();
                teleopMiddleInputScoreString = middleInput2.getText().toString();
                teleopLowerInputScoreString = lowerInput2.getText().toString();
                if (groundCheck2.isChecked()) {
                    teleopGroundLoadsBoolean = true;
                }
                else {
                    teleopGroundLoadsBoolean = false;
                }
                if (humanCheck2.isChecked()) {
                    teleopHumanLoadsBoolean  = true;
                }
                else {
                    teleopHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopUpperScore", teleopUpperInputScoreString);
                editor.putString("TeleopMiddleScore", teleopMiddleInputScoreString);
                editor.putString("TeleopLowerScore", teleopLowerInputScoreString);
                editor.putBoolean("TeleopGroundCheck", teleopGroundLoadsBoolean);
                editor.putBoolean("TeleopHumanCheck", teleopHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to the home screen
                Intent goToHomeScreen = new Intent(TeleopScreen.this, MainActivity.class);
                startActivity(goToHomeScreen);
            }
        });
        autonBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput2.getText().toString();
                matchNumberInputString = matchNumInput2.getText().toString();
                teleopUpperInputScoreString = upperInput2.getText().toString();
                teleopMiddleInputScoreString = middleInput2.getText().toString();
                teleopLowerInputScoreString = lowerInput2.getText().toString();
                if (groundCheck2.isChecked()) {
                    teleopGroundLoadsBoolean = true;
                }
                else {
                    teleopGroundLoadsBoolean = false;
                }
                if (humanCheck2.isChecked()) {
                    teleopHumanLoadsBoolean  = true;
                }
                else {
                    teleopHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopUpperScore", teleopUpperInputScoreString);
                editor.putString("TeleopMiddleScore", teleopMiddleInputScoreString);
                editor.putString("TeleopLowerScore", teleopLowerInputScoreString);
                editor.putBoolean("TeleopGroundCheck", teleopGroundLoadsBoolean);
                editor.putBoolean("TeleopHumanCheck", teleopHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to the auton screen
                Intent goToAutonScreen = new Intent(TeleopScreen.this, AutonScreen.class);
                startActivity(goToAutonScreen);
            }
        });
        endgameBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput2.getText().toString();
                matchNumberInputString = matchNumInput2.getText().toString();
                teleopUpperInputScoreString = upperInput2.getText().toString();
                teleopMiddleInputScoreString = middleInput2.getText().toString();
                teleopLowerInputScoreString = lowerInput2.getText().toString();
                if (groundCheck2.isChecked()) {
                    teleopGroundLoadsBoolean = true;
                }
                else {
                    teleopGroundLoadsBoolean = false;
                }
                if (humanCheck2.isChecked()) {
                    teleopHumanLoadsBoolean  = true;
                }
                else {
                    teleopHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopUpperScore", teleopUpperInputScoreString);
                editor.putString("TeleopMiddleScore", teleopMiddleInputScoreString);
                editor.putString("TeleopLowerScore", teleopLowerInputScoreString);
                editor.putBoolean("TeleopGroundCheck", teleopGroundLoadsBoolean);
                editor.putBoolean("TeleopHumanCheck", teleopHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to the endgame screen
                Intent goToEndgameScreen = new Intent(TeleopScreen.this, EndScreen.class);
                startActivity(goToEndgameScreen);
            }
        });
        qrcodeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput2.getText().toString();
                matchNumberInputString = matchNumInput2.getText().toString();
                teleopUpperInputScoreString = upperInput2.getText().toString();
                teleopMiddleInputScoreString = middleInput2.getText().toString();
                teleopLowerInputScoreString = lowerInput2.getText().toString();
                if (groundCheck2.isChecked()) {
                    teleopGroundLoadsBoolean = true;
                }
                else {
                    teleopGroundLoadsBoolean = false;
                }
                if (humanCheck2.isChecked()) {
                    teleopHumanLoadsBoolean  = true;
                }
                else {
                    teleopHumanLoadsBoolean = false;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopUpperScore", teleopUpperInputScoreString);
                editor.putString("TeleopMiddleScore", teleopMiddleInputScoreString);
                editor.putString("TeleopLowerScore", teleopLowerInputScoreString);
                editor.putBoolean("TeleopGroundCheck", teleopGroundLoadsBoolean);
                editor.putBoolean("TeleopHumanCheck", teleopHumanLoadsBoolean);
                editor.commit();

                //screen will be changed to qrcode screen
                Intent goToQrcodeScreen = new Intent(TeleopScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });


        //score changing button on click methods
        upperPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopUpperPiecesScored;

                if(upperInput2.getText().toString().equals("")) {
                    teleopUpperPiecesScored = 0;
                } else {
                    teleopUpperPiecesScored = Integer.parseInt(upperInput2.getText().toString());
                }
                if(teleopUpperPiecesScored >= 0) {
                    teleopUpperPiecesScored++;
                }
                String teleopUpperPiecesString = "" + teleopUpperPiecesScored;
                upperInput2.setText(teleopUpperPiecesString);
            }
        });

        upperMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopUpperPiecesScored;
                if(upperInput2.getText().toString().equals("")) {
                    teleopUpperPiecesScored = 0;
                } else {
                    teleopUpperPiecesScored = Integer.parseInt(upperInput2.getText().toString());
                }
                if(teleopUpperPiecesScored > 0) {
                    teleopUpperPiecesScored--;
                }
                String teleopUpperPiecesString = "" + teleopUpperPiecesScored;
                upperInput2.setText(teleopUpperPiecesString);
            }
        });

        middlePlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddlePiecesScored;

                if(middleInput2.getText().toString().equals("")) {
                    teleopMiddlePiecesScored = 0;
                } else {
                    teleopMiddlePiecesScored = Integer.parseInt(middleInput2.getText().toString());
                }
                if(teleopMiddlePiecesScored >= 0) {
                    teleopMiddlePiecesScored++;
                }
                String teleopMiddlePiecesString = "" + teleopMiddlePiecesScored;
                middleInput2.setText(teleopMiddlePiecesString);
            }
        });

        middleMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddlePiecesScored;
                if(middleInput2.getText().toString().equals("")) {
                    teleopMiddlePiecesScored = 0;
                } else {
                    teleopMiddlePiecesScored = Integer.parseInt(middleInput2.getText().toString());
                }
                if(teleopMiddlePiecesScored > 0) {
                    teleopMiddlePiecesScored--;
                }
                String teleopMiddlePiecesString = "" + teleopMiddlePiecesScored;
                middleInput2.setText(teleopMiddlePiecesString);
            }
        });

        lowerPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerPiecesScored;

                if(lowerInput2.getText().toString().equals("")) {
                    teleopLowerPiecesScored = 0;
                } else {
                    teleopLowerPiecesScored = Integer.parseInt(lowerInput2.getText().toString());
                }
                if(teleopLowerPiecesScored >= 0) {
                    teleopLowerPiecesScored++;
                }
                String teleopLowerPiecesString = "" + teleopLowerPiecesScored;
                lowerInput2.setText(teleopLowerPiecesString);
            }
        });

        lowerMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerPiecesScored;
                if(upperInput2.getText().toString().equals("")) {
                    teleopLowerPiecesScored = 0;
                } else {
                    teleopLowerPiecesScored = Integer.parseInt(lowerInput2.getText().toString());
                }
                if(teleopLowerPiecesScored > 0) {
                    teleopLowerPiecesScored--;
                }
                String teleopLowerPiecesString = "" + teleopLowerPiecesScored;
                lowerInput2.setText(teleopLowerPiecesString);
            }
        });
    }
}