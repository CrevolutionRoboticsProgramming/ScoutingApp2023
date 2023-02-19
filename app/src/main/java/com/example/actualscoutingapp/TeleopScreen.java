package com.example.actualscoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TeleopScreen extends AppCompatActivity {

// MORE IN DEPTH COMMENTS FOR REPEATED CODE IS ON AUTON SCREEN

    //test push to github test
    //satchit was here pt 2, pushed saturday morning
    //creating variables for everything on the .xml file
    ImageButton autonBtn2, teleopBtn2, endgameBtn2, qrcodeBtn2;
    TextView autonTitleTxt2, teleopTitleTxt2, endgameTitleTxt2, qrcodeTitleTxt2, teleopTitleTxt, matchNumTitle2, teamNumTitle2, teleopMatchInfoBack, scoringCubesTitleTxt2, upperCubesTitleTxt2, middleCubesTitleTxt2, lowerCubesTitleTxt2, scoringConesTitleTxt2, upperConesTitleTxt2, middleConesTitleTxt2, lowerConesTitleTxt2, droppedPiecesTitleTxt2, fieldDropsTitleTxt2, communityDropsTitleTxt2, loadingDropsTitleTxt2;
    ImageView teleopScreenBackground, teleopHomeBtnPic, teleopTitleUnderline, matchNumBack2, teamNumBack2, upperCubesPlus2, upperCubesMinus2, middleCubesPlus2, middleCubesMinus2, lowerCubesPlus2, lowerCubesMinus2, upperConesPlus2, upperConesMinus2, middleConesPlus2, middleConesMinus2, lowerConesPlus2, lowerConesMinus2, fieldDropsPlus2, fieldDropsMinus2, communityDropsPlus2, communityDropsMinus2, loadingDropsPlus2, loadingDropsMinus2;
    EditText matchNumInput2, teamNumInput2, upperCubesInput2, middleCubesInput2, lowerCubesInput2, upperConesInput2, middleConesInput2, lowerConesInput2, fieldDropsInput2, communityDropsInput2, loadingDropsInput2;
    SharedPreferences sp;
    String teamNumberInputString, matchNumberInputString, teleopUpperCubesInputScoreString, teleopMiddleCubesInputScoreString, teleopLowerCubesInputScoreString, teleopUpperConesInputScoreString, teleopMiddleConesInputScoreString, teleopLowerConesInputScoreString, teleopFieldDropsInputScoreString, teleopCommunityDropsInputScoreString, teleopLoadingDropsInputScoreString;

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
        scoringCubesTitleTxt2 = findViewById(R.id.teleopCubesScoringTitle);
        upperCubesTitleTxt2 = findViewById(R.id.teleopCubesUpperTitle);
        middleCubesTitleTxt2 = findViewById(R.id.teleopCubesMiddleTitle);
        lowerCubesTitleTxt2 = findViewById(R.id.teleopCubesLowerTitle);
        scoringConesTitleTxt2 = findViewById(R.id.teleopConesScoringTitle);
        upperConesTitleTxt2 = findViewById(R.id.teleopConesUpperTitle);
        middleConesTitleTxt2 = findViewById(R.id.teleopConesMiddleTitle);
        lowerConesTitleTxt2 = findViewById(R.id.teleopConesLowerTitle);
        droppedPiecesTitleTxt2 = findViewById(R.id.teleopDropsTitle);
        fieldDropsTitleTxt2 = findViewById(R.id.teleopFieldDropsTitle);
        communityDropsTitleTxt2 = findViewById(R.id.teleopCommunityDropsTitle);
        loadingDropsTitleTxt2 = findViewById(R.id.teleopLoadingDropsTitle);

        teleopScreenBackground = findViewById(R.id.teleopBackground);
        teleopHomeBtnPic = findViewById(R.id.teleopHome);
        teleopTitleUnderline = findViewById(R.id.teleopScreenTitleUnderline);
        matchNumBack2 = findViewById(R.id.teleopMatchNumBack);
        teamNumBack2 = findViewById(R.id.teleopTeamNumBack);
        upperCubesPlus2 = findViewById(R.id.teleopCubesUpperPlus);
        upperCubesMinus2 = findViewById(R.id.teleopCubesUpperMinus);
        middleCubesPlus2 = findViewById(R.id.teleopCubesMiddlePlus);
        middleCubesMinus2 = findViewById(R.id.teleopCubesMiddleMinus);
        lowerCubesPlus2 = findViewById(R.id.teleopCubesLowerPlus);
        lowerCubesMinus2 = findViewById(R.id.teleopCubesLowerMinus);
        upperConesPlus2 = findViewById(R.id.teleopConesUpperPlus);
        upperConesMinus2 = findViewById(R.id.teleopConesUpperMinus);
        middleConesPlus2 = findViewById(R.id.teleopConesMiddlePlus);
        middleConesMinus2 = findViewById(R.id.teleopConesMiddleMinus);
        lowerConesPlus2 = findViewById(R.id.teleopConesLowerPlus);
        lowerConesMinus2 = findViewById(R.id.teleopConesLowerMinus);
        fieldDropsPlus2 = findViewById(R.id.teleopFieldDropsPlus);
        fieldDropsMinus2 = findViewById(R.id.teleopFieldDropsMinus);
        communityDropsPlus2 = findViewById(R.id.teleopCommunityDropsPlus);
        communityDropsMinus2 = findViewById(R.id.teleopCommunityDropsMinus);
        loadingDropsPlus2 = findViewById(R.id.teleopLoadingDropsPlus);
        loadingDropsMinus2 = findViewById(R.id.teleopLoadingDropsMinus);


        matchNumInput2 = findViewById(R.id.teleopMatchNumInput);
        teamNumInput2 = findViewById(R.id.teleopTeamNumInput);
        upperCubesInput2 = findViewById(R.id.teleopCubesUpperInput);
        middleCubesInput2 = findViewById(R.id.teleopCubesMiddleInput);
        lowerCubesInput2 = findViewById(R.id.teleopCubesLowerInput);
        upperConesInput2 = findViewById(R.id.teleopConesUpperInput);
        middleConesInput2 = findViewById(R.id.teleopConesMiddleInput);
        lowerConesInput2 = findViewById(R.id.teleopConesLowerInput);
        fieldDropsInput2 = findViewById(R.id.teleopFieldDropsInput);
        communityDropsInput2 = findViewById(R.id.teleopCommunityDropsInput);
        loadingDropsInput2 = findViewById(R.id.teleopLoadingDropsInput);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumInput2.setText(new_sp.getString("TeamNumber", ""));
        matchNumInput2.setText(new_sp.getString("MatchNumber", ""));
        upperCubesInput2.setText(new_sp.getString("TeleopCubesUpperScore", ""));
        middleCubesInput2.setText(new_sp.getString("TeleopCubesMiddleScore", ""));
        lowerCubesInput2.setText(new_sp.getString("TeleopCubesLowerScore", ""));
        upperConesInput2.setText(new_sp.getString("TeleopConesUpperScore", ""));
        middleConesInput2.setText(new_sp.getString("TeleopConesMiddleScore", ""));
        lowerConesInput2.setText(new_sp.getString("TeleopConesLowerScore", ""));
        fieldDropsInput2.setText(new_sp.getString("TeleopFieldDropsScore", ""));
        communityDropsInput2.setText(new_sp.getString("TeleopCommunityDropsScore", ""));
        loadingDropsInput2.setText(new_sp.getString("TeleopLoadingDropsScore", ""));

        ///creating on click events

        //screen changing buttons
        teleopHomeBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences
                teamNumberInputString = teamNumInput2.getText().toString();
                matchNumberInputString = matchNumInput2.getText().toString();
                teleopUpperCubesInputScoreString = upperCubesInput2.getText().toString();
                teleopMiddleCubesInputScoreString = middleCubesInput2.getText().toString();
                teleopLowerCubesInputScoreString = lowerCubesInput2.getText().toString();
                teleopUpperConesInputScoreString = upperConesInput2.getText().toString();
                teleopMiddleConesInputScoreString = middleConesInput2.getText().toString();
                teleopLowerConesInputScoreString = lowerConesInput2.getText().toString();
                teleopFieldDropsInputScoreString = fieldDropsInput2.getText().toString();
                teleopCommunityDropsInputScoreString = communityDropsInput2.getText().toString();
                teleopLoadingDropsInputScoreString = loadingDropsInput2.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopCubesUpperScore", teleopUpperCubesInputScoreString);
                editor.putString("TeleopCubesMiddleScore", teleopMiddleCubesInputScoreString);
                editor.putString("TeleopCubesLowerScore", teleopLowerCubesInputScoreString);
                editor.putString("TeleopConesUpperScore", teleopUpperConesInputScoreString);
                editor.putString("TeleopConesMiddleScore", teleopMiddleConesInputScoreString);
                editor.putString("TeleopConesLowerScore", teleopLowerConesInputScoreString);
                editor.putString("TeleopFieldDropsScore", teleopFieldDropsInputScoreString);
                editor.putString("TeleopCommunityDropsScore", teleopCommunityDropsInputScoreString);
                editor.putString("TeleopLoadingDropsScore", teleopLoadingDropsInputScoreString);
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
                teleopUpperCubesInputScoreString = upperCubesInput2.getText().toString();
                teleopMiddleCubesInputScoreString = middleCubesInput2.getText().toString();
                teleopLowerCubesInputScoreString = lowerCubesInput2.getText().toString();
                teleopUpperConesInputScoreString = upperConesInput2.getText().toString();
                teleopMiddleConesInputScoreString = middleConesInput2.getText().toString();
                teleopLowerConesInputScoreString = lowerConesInput2.getText().toString();
                teleopFieldDropsInputScoreString = fieldDropsInput2.getText().toString();
                teleopCommunityDropsInputScoreString = communityDropsInput2.getText().toString();
                teleopLoadingDropsInputScoreString = loadingDropsInput2.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopCubesUpperScore", teleopUpperCubesInputScoreString);
                editor.putString("TeleopCubesMiddleScore", teleopMiddleCubesInputScoreString);
                editor.putString("TeleopCubesLowerScore", teleopLowerCubesInputScoreString);
                editor.putString("TeleopConesUpperScore", teleopUpperConesInputScoreString);
                editor.putString("TeleopConesMiddleScore", teleopMiddleConesInputScoreString);
                editor.putString("TeleopConesLowerScore", teleopLowerConesInputScoreString);
                editor.putString("TeleopFieldDropsScore", teleopFieldDropsInputScoreString);
                editor.putString("TeleopCommunityDropsScore", teleopCommunityDropsInputScoreString);
                editor.putString("TeleopLoadingDropsScore", teleopLoadingDropsInputScoreString);
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
                teleopUpperCubesInputScoreString = upperCubesInput2.getText().toString();
                teleopMiddleCubesInputScoreString = middleCubesInput2.getText().toString();
                teleopLowerCubesInputScoreString = lowerCubesInput2.getText().toString();
                teleopUpperConesInputScoreString = upperConesInput2.getText().toString();
                teleopMiddleConesInputScoreString = middleConesInput2.getText().toString();
                teleopLowerConesInputScoreString = lowerConesInput2.getText().toString();
                teleopFieldDropsInputScoreString = fieldDropsInput2.getText().toString();
                teleopCommunityDropsInputScoreString = communityDropsInput2.getText().toString();
                teleopLoadingDropsInputScoreString = loadingDropsInput2.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopCubesUpperScore", teleopUpperCubesInputScoreString);
                editor.putString("TeleopCubesMiddleScore", teleopMiddleCubesInputScoreString);
                editor.putString("TeleopCubesLowerScore", teleopLowerCubesInputScoreString);
                editor.putString("TeleopConesUpperScore", teleopUpperConesInputScoreString);
                editor.putString("TeleopConesMiddleScore", teleopMiddleConesInputScoreString);
                editor.putString("TeleopConesLowerScore", teleopLowerConesInputScoreString);
                editor.putString("TeleopFieldDropsScore", teleopFieldDropsInputScoreString);
                editor.putString("TeleopCommunityDropsScore", teleopCommunityDropsInputScoreString);
                editor.putString("TeleopLoadingDropsScore", teleopLoadingDropsInputScoreString);
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
                teleopUpperCubesInputScoreString = upperCubesInput2.getText().toString();
                teleopMiddleCubesInputScoreString = middleCubesInput2.getText().toString();
                teleopLowerCubesInputScoreString = lowerCubesInput2.getText().toString();
                teleopUpperConesInputScoreString = upperConesInput2.getText().toString();
                teleopMiddleConesInputScoreString = middleConesInput2.getText().toString();
                teleopLowerConesInputScoreString = lowerConesInput2.getText().toString();
                teleopFieldDropsInputScoreString = fieldDropsInput2.getText().toString();
                teleopCommunityDropsInputScoreString = communityDropsInput2.getText().toString();
                teleopLoadingDropsInputScoreString = loadingDropsInput2.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putString("MatchNumber", matchNumberInputString);
                editor.putString("TeleopCubesUpperScore", teleopUpperCubesInputScoreString);
                editor.putString("TeleopCubesMiddleScore", teleopMiddleCubesInputScoreString);
                editor.putString("TeleopCubesLowerScore", teleopLowerCubesInputScoreString);
                editor.putString("TeleopConesUpperScore", teleopUpperConesInputScoreString);
                editor.putString("TeleopConesMiddleScore", teleopMiddleConesInputScoreString);
                editor.putString("TeleopConesLowerScore", teleopLowerConesInputScoreString);
                editor.putString("TeleopFieldDropsScore", teleopFieldDropsInputScoreString);
                editor.putString("TeleopCommunityDropsScore", teleopCommunityDropsInputScoreString);
                editor.putString("TeleopLoadingDropsScore", teleopLoadingDropsInputScoreString);
                editor.commit();


                //screen will be changed to qrcode screen
                Intent goToQrcodeScreen = new Intent(TeleopScreen.this, QRCommentsScreen.class);
                startActivity(goToQrcodeScreen);
            }
        });


        //score changing button on click methods
        upperCubesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a variable for the pieces scored
                int teleopUpperCubesScored;

                //if there is noting inputed yet the variable will be set to 0
                if(upperCubesInput2.getText().toString().equals("")) {
                    teleopUpperCubesScored = 0;
                } else {
                    //if there is something inputed it will get the number and set the variable to it
                    teleopUpperCubesScored = Integer.parseInt(upperCubesInput2.getText().toString());
                }
                if(teleopUpperCubesScored >= 0) {
                    //if the number is above or = to 0 then the variable will increase by 1
                    teleopUpperCubesScored++;
                }
                //string created that stores the pieces scored variable (empty string needed since cant directly set a string to a variable)
                String teleopUpperCubesString = "" + teleopUpperCubesScored;
                //setting the input to the string storing the pieces scored so it shows up on the screen
                upperCubesInput2.setText(teleopUpperCubesString);
            }
        });

        upperCubesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopUpperCubesScored;
                if(upperCubesInput2.getText().toString().equals("")) {
                    teleopUpperCubesScored = 0;
                } else {
                    teleopUpperCubesScored = Integer.parseInt(upperCubesInput2.getText().toString());
                }
                if(teleopUpperCubesScored > 0) {
                    //if the number is above 0 the number can go one lower but otherwise nothing will happen if it is already at 0 since you don't want negative numbers
                    teleopUpperCubesScored--;
                }
                String teleopUpperCubesString = "" + teleopUpperCubesScored;
                upperCubesInput2.setText(teleopUpperCubesString);
            }
        });

        middleCubesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddleCubesScored;

                if(middleCubesInput2.getText().toString().equals("")) {
                    teleopMiddleCubesScored = 0;
                } else {
                    teleopMiddleCubesScored = Integer.parseInt(middleCubesInput2.getText().toString());
                }
                if(teleopMiddleCubesScored >= 0) {
                    teleopMiddleCubesScored++;
                }
                String teleopMiddleCubesString = "" + teleopMiddleCubesScored;
                middleCubesInput2.setText(teleopMiddleCubesString);
            }
        });

        middleCubesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddleCubesScored;
                if(middleCubesInput2.getText().toString().equals("")) {
                    teleopMiddleCubesScored = 0;
                } else {
                    teleopMiddleCubesScored = Integer.parseInt(middleCubesInput2.getText().toString());
                }
                if(teleopMiddleCubesScored > 0) {
                    teleopMiddleCubesScored--;
                }
                String teleopMiddleCubesString = "" + teleopMiddleCubesScored;
                middleCubesInput2.setText(teleopMiddleCubesString);
            }
        });

        lowerCubesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerCubesScored;

                if(lowerCubesInput2.getText().toString().equals("")) {
                    teleopLowerCubesScored = 0;
                } else {
                    teleopLowerCubesScored = Integer.parseInt(lowerCubesInput2.getText().toString());
                }
                if(teleopLowerCubesScored >= 0) {
                    teleopLowerCubesScored++;
                }
                String teleopLowerCubesString = "" + teleopLowerCubesScored;
                lowerCubesInput2.setText(teleopLowerCubesString);
            }
        });

        lowerCubesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerCubesScored;
                if(upperCubesInput2.getText().toString().equals("")) {
                    teleopLowerCubesScored = 0;
                } else {
                    teleopLowerCubesScored = Integer.parseInt(lowerCubesInput2.getText().toString());
                }
                if(teleopLowerCubesScored > 0) {
                    teleopLowerCubesScored--;
                }
                String teleopLowerCubesString = "" + teleopLowerCubesScored;
                lowerCubesInput2.setText(teleopLowerCubesString);
            }
        });

        upperConesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a variable for the pieces scored
                int teleopUpperConesScored;

                //if there is noting inputed yet the variable will be set to 0
                if(upperConesInput2.getText().toString().equals("")) {
                    teleopUpperConesScored = 0;
                } else {
                    //if there is something inputed it will get the number and set the variable to it
                    teleopUpperConesScored = Integer.parseInt(upperConesInput2.getText().toString());
                }
                if(teleopUpperConesScored >= 0) {
                    //if the number is above or = to 0 then the variable will increase by 1
                    teleopUpperConesScored++;
                }
                //string created that stores the pieces scored variable (empty string needed since cant directly set a string to a variable)
                String teleopUpperConesString = "" + teleopUpperConesScored;
                //setting the input to the string storing the pieces scored so it shows up on the screen
                upperConesInput2.setText(teleopUpperConesString);
            }
        });

        upperConesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopUpperConesScored;
                if(upperConesInput2.getText().toString().equals("")) {
                    teleopUpperConesScored = 0;
                } else {
                    teleopUpperConesScored = Integer.parseInt(upperConesInput2.getText().toString());
                }
                if(teleopUpperConesScored > 0) {
                    //if the number is above 0 the number can go one lower but otherwise nothing will happen if it is already at 0 since you don't want negative numbers
                    teleopUpperConesScored--;
                }
                String teleopUpperConesString = "" + teleopUpperConesScored;
                upperConesInput2.setText(teleopUpperConesString);
            }
        });

        middleConesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddleConesScored;

                if(middleConesInput2.getText().toString().equals("")) {
                    teleopMiddleConesScored = 0;
                } else {
                    teleopMiddleConesScored = Integer.parseInt(middleConesInput2.getText().toString());
                }
                if(teleopMiddleConesScored >= 0) {
                    teleopMiddleConesScored++;
                }
                String teleopMiddleConesString = "" + teleopMiddleConesScored;
                middleConesInput2.setText(teleopMiddleConesString);
            }
        });

        middleConesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopMiddleConesScored;
                if(middleConesInput2.getText().toString().equals("")) {
                    teleopMiddleConesScored = 0;
                } else {
                    teleopMiddleConesScored = Integer.parseInt(middleConesInput2.getText().toString());
                }
                if(teleopMiddleConesScored > 0) {
                    teleopMiddleConesScored--;
                }
                String teleopMiddleConesString = "" + teleopMiddleConesScored;
                middleConesInput2.setText(teleopMiddleConesString);
            }
        });

        lowerConesPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerConesScored;

                if(lowerConesInput2.getText().toString().equals("")) {
                    teleopLowerConesScored = 0;
                } else {
                    teleopLowerConesScored = Integer.parseInt(lowerConesInput2.getText().toString());
                }
                if(teleopLowerConesScored >= 0) {
                    teleopLowerConesScored++;
                }
                String teleopLowerConesString = "" + teleopLowerConesScored;
                lowerConesInput2.setText(teleopLowerConesString);
            }
        });

        lowerConesMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLowerConesScored;
                if(upperConesInput2.getText().toString().equals("")) {
                    teleopLowerConesScored = 0;
                } else {
                    teleopLowerConesScored = Integer.parseInt(lowerConesInput2.getText().toString());
                }
                if(teleopLowerConesScored > 0) {
                    teleopLowerConesScored--;
                }
                String teleopLowerConesString = "" + teleopLowerConesScored;
                lowerConesInput2.setText(teleopLowerConesString);
            }
        });

        fieldDropsPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopFieldDropsScore;

                if(fieldDropsInput2.getText().toString().equals("")) {
                    teleopFieldDropsScore = 0;
                } else {
                    teleopFieldDropsScore = Integer.parseInt(fieldDropsInput2.getText().toString());
                }
                if(teleopFieldDropsScore >= 0) {
                    teleopFieldDropsScore++;
                }
                String teleopFieldDropsString = "" + teleopFieldDropsScore;
                fieldDropsInput2.setText(teleopFieldDropsString);
            }
        });

        fieldDropsMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopFieldDropsScore;
                if(fieldDropsInput2.getText().toString().equals("")) {
                    teleopFieldDropsScore = 0;
                } else {
                    teleopFieldDropsScore = Integer.parseInt(fieldDropsInput2.getText().toString());
                }
                if(teleopFieldDropsScore > 0) {
                    teleopFieldDropsScore--;
                }
                String teleopFieldDropsString = "" + teleopFieldDropsScore;
                fieldDropsInput2.setText(teleopFieldDropsString);
            }
        });

        communityDropsPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopCommunityDropsScore;

                if(communityDropsInput2.getText().toString().equals("")) {
                    teleopCommunityDropsScore = 0;
                } else {
                    teleopCommunityDropsScore = Integer.parseInt(communityDropsInput2.getText().toString());
                }
                if(teleopCommunityDropsScore >= 0) {
                    teleopCommunityDropsScore++;
                }
                String teleopCommunityDropsString = "" + teleopCommunityDropsScore;
                communityDropsInput2.setText(teleopCommunityDropsString);
            }
        });

        communityDropsMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopCommunityDropsScore;
                if(communityDropsInput2.getText().toString().equals("")) {
                    teleopCommunityDropsScore = 0;
                } else {
                    teleopCommunityDropsScore = Integer.parseInt(communityDropsInput2.getText().toString());
                }
                if(teleopCommunityDropsScore > 0) {
                    teleopCommunityDropsScore--;
                }
                String teleopCommunityDropsString = "" + teleopCommunityDropsScore;
                communityDropsInput2.setText(teleopCommunityDropsString);
            }
        });

        loadingDropsPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLoadingDropsScore;

                if(loadingDropsInput2.getText().toString().equals("")) {
                    teleopLoadingDropsScore = 0;
                } else {
                    teleopLoadingDropsScore = Integer.parseInt(loadingDropsInput2.getText().toString());
                }
                if(teleopLoadingDropsScore >= 0) {
                    teleopLoadingDropsScore++;
                }
                String teleopLoadingDropsString = "" + teleopLoadingDropsScore;
                loadingDropsInput2.setText(teleopLoadingDropsString);
            }
        });

        loadingDropsMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleopLoadingDropsScore;
                if(loadingDropsInput2.getText().toString().equals("")) {
                    teleopLoadingDropsScore = 0;
                } else {
                    teleopLoadingDropsScore = Integer.parseInt(loadingDropsInput2.getText().toString());
                }
                if(teleopLoadingDropsScore > 0) {
                    teleopLoadingDropsScore--;
                }
                String teleopLoadingDropsString = "" + teleopLoadingDropsScore;
                loadingDropsInput2.setText(teleopLoadingDropsString);
            }
        });
    }
}