package com.example.jsu.lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.util.*;

public class Lab2 extends AppCompatActivity {

    private Weapon playerWeapon;
    private Weapon computerWeapon;
    private int playerScore;
    private int computerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        TextView w = (TextView) findViewById(R.id.welcomeView);
      //  TextView s = (TextView) findViewById(R.id.scoreView);

        w.setText("Welcome to Rock-Paper-Scissors!\n Please choose your weapon: ");
      //  s.setText("Player: " + playerScore + ", Computer Score: " + computerScore);

    }

   public void setScoreText() {

        TextView s = (TextView) findViewById(R.id.scoreView);
       s.setText("Player: " + playerScore + ", Computer Score: " + computerScore);
    }

   public void computerGenerateWeapon() {

        Random rand = new Random();
        int randomWeaponNumber = rand.nextInt(3);

        if (randomWeaponNumber == 0)
            computerWeapon = Weapon.ROCK;

        else if (randomWeaponNumber == 1)
            computerWeapon = Weapon.PAPER;

        else if (randomWeaponNumber == 2)
            computerWeapon = Weapon.SCISSORS;
    }

    public void rockButtonClicked(View v) {

        playerWeapon = Weapon.ROCK;

        computerGenerateWeapon();

        compareTo(playerWeapon, computerWeapon);


    }

    public void paperButtonClicked(View v) {

        playerWeapon = Weapon.PAPER;

        computerGenerateWeapon();

        compareTo(playerWeapon, computerWeapon);

    }

    public void scissorsButtonClicked(View v) {

        playerWeapon = Weapon.SCISSORS;

        computerGenerateWeapon();

        compareTo(playerWeapon, computerWeapon);

    }

    public void compareTo(Weapon pWeapon, Weapon cWeapon) {

        TextView p = (TextView) findViewById(R.id.playerWeaponView);
        TextView c = (TextView) findViewById(R.id.computerWeaponView);
        TextView r = (TextView) findViewById(R.id.resultLabel);

        if (pWeapon == cWeapon) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("It's a tie!");
        }

        else if (pWeapon == Weapon.ROCK && cWeapon == Weapon.PAPER ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Computer Wins... Paper covers Rock!");

            computerScore++;

            setScoreText();
        }

        else if (pWeapon == Weapon.ROCK && cWeapon == Weapon.SCISSORS ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Player Wins... Rock crushes Scissors!");

            playerScore++;

            setScoreText();
        }

        else if (pWeapon == Weapon.PAPER && cWeapon == Weapon.SCISSORS ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Computer Wins... Scissors cuts Paper!");

            computerScore++;

            setScoreText();
        }

        else if (pWeapon == Weapon.PAPER && cWeapon == Weapon.ROCK ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Player Wins... Paper covers Rock!");

            playerScore++;

            setScoreText();
        }

        else if (pWeapon == Weapon.SCISSORS && cWeapon == Weapon.ROCK ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Computer Wins... Rock crushes Scissors!");

            computerScore++;

            setScoreText();
        }

        else if (pWeapon == Weapon.SCISSORS && cWeapon == Weapon.PAPER ) {

            p.setText("Player's Weapon: " + playerWeapon.toString());

            c.setText("Computer's Weapon: " + computerWeapon.toString());

            r.setText("Player Wins... Scissors cuts Paper!");

            playerScore++;

            setScoreText();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    }
}
