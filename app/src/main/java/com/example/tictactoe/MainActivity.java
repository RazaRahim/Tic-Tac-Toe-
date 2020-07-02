package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // o:yellow , 1:red , 2:empty

    String Winner = "";
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winingpostion = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive =true;
    public void dropIn(View view) {



    ImageView counter = (ImageView) view;
        int tapedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tapedCounter] == 2 && gameActive) {
            gameState[tapedCounter] = activePlayer;
            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPositions : winingpostion) {

                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                    //some one has won!
                    gameActive=false;

                    if (activePlayer == 1) {
                        Winner = "Yellow";
                    } else {
                        Winner = "Red";
                    }


                    TextView textView = (TextView)findViewById(R.id.textView);
                    Button button = (Button)findViewById(R.id.button);
                     textView.setText(Winner+" has Won!");
                      button.setVisibility(View.VISIBLE);
                      textView.setVisibility(View.VISIBLE);


                }

            }

        }
    }

    public  void playAgain(View view)
    {
        TextView textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);



        androidx.gridlayout.widget.GridLayout mygridLayout = findViewById(R.id.gridLayout);

        for(int i=0; i<mygridLayout.getChildCount(); i++){
            ((ImageView) mygridLayout.getChildAt(i)).setImageResource(0);
        }




for(int i=0;i<gameState.length;i++){

    gameState[i]=2;
}
         activePlayer = 0;


         gameActive =true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}