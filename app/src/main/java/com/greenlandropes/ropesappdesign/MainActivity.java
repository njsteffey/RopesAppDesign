package com.greenlandropes.ropesappdesign;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.*;


public class MainActivity extends AppCompatActivity {


    static int fl;
    static int fr;
    static int bl;
    public int br;
    public int roundNumber = 0;
    List<Score> scores = new ArrayList<>();
    /*
    public Score(int startfl, int startfr, int startbl, int startbr) {
        fl = startfl;
        fr = startfr;
        bl = startbl;
        br = startbr;}
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to do: instantiate score class 4 times based on current round

       /*
        Score score = new Score("fl" + roundNumber, 1);
        Score score = new Score("fr" + roundNumber, 1);
        Score score = new Score("bl" + roundNumber, 1);
        Score score = new Score("br" + roundNumber, 1);
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /*
     * Displays the given score.
     */
    public void displayScore() {
        int score = fl + fr + bl + br;
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team A by 1 point.
     */

    public void addForwardLeft(View v) {
        boolean on = ((ToggleButton) findViewById(R.id.forwardLeftButton)).isChecked();

        if (on) {
            fl = 3;

        } else {
            fl = 0;
        }
        displayScore();
    }

    public void addForwardRight(View v) {
        boolean on = ((ToggleButton) findViewById(R.id.forwardRightButton)).isChecked();

        if (on) {
            fr = 3;
        } else {
            fr = 0;
        }
        displayScore();
    }

    public void addBackLeft(View v) {
        boolean on = ((ToggleButton) findViewById(R.id.backLeftButton)).isChecked();

        if (on) {
            bl = 3;

        } else {
            bl = 0;
        }
        displayScore();
    }

    public void addBackRight(View v) {
        boolean on = ((ToggleButton) findViewById(R.id.backRightButton)).isChecked();

        if (on) {
            br = 3;
        } else {
            br = 0;
        }
        displayScore();
    }

    public void reset(View v) {
        fl = 0;
        fr = 0;
        bl = 0;
        br = 0;
        displayScore();
    }

    public void backMove(View view) {
    }

    public void nextMove(View view) {


    }

    public class CountDown extends Activity implements OnClickListener {

        Button btn;
        int i = 0, second = 30;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btn = (Button) findViewById(R.id.textTimer);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                Handler handle = new Handler() {
                    public void handleMessage(Message msg) {
                        btn.setText("Time Left" + second);
                        second--;
                    }
                };

                public void run() {
                    while (i != second) {
                        try {
                            handle.sendMessage(handle.obtainMessage());
                            Thread.sleep(1000);
                        } catch (Throwable t) {

                        }
                    }
                }
            }).start();

        }
    }
}