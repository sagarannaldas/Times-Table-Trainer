package com.sagarannaldas.timestabletrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    String quizId;
    Button startButton, playAgainButton;
    TextView mulitpleTextView, resultTextView, scoreTextView, timerTextView;
    ArrayList<Integer> answer;
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0, button1, button2, button3;
    ConstraintLayout gameLayout;
    GridLayout gridLayout;
    ConstraintLayout constraintLayout;

    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);

        constraintLayout.setBackgroundResource(R.drawable.background_quiz);

        setMultiples(quizId);
        playAgain(findViewById(R.id.timerTextView));
    }


    public void clickableButtons(Boolean click) {

        button0.setClickable(click);
        button1.setClickable(click);
        button2.setClickable(click);
        button3.setClickable(click);
    }

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");

        setMultiples(quizId);
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");

        scoreTextView.setText(Integer.toString(score) + "/" +  Integer.toString(numberOfQuestions));

        clickableButtons(true);

        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Your Score is " + score + " out of " + numberOfQuestions);
               clickableButtons(false);
            }
        }.start();

    }

    public void chooseAnswer(View view){

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

            resultTextView.setText("You Got It.");
            resultTextView.setVisibility(View.VISIBLE);
            score ++;
            setMultiples(quizId);

        } else {

            resultTextView.setText("WRONG :(");
            resultTextView.setVisibility(View.VISIBLE);
            setMultiples(quizId);

        }

        numberOfQuestions ++;

        scoreTextView.setText(Integer.toString(score) + "/" +  Integer.toString(numberOfQuestions));

//        Toast.makeText(this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
    }


    public void options(int a, int b, String id) {

        Random random = new Random();

        answer = new ArrayList<Integer>();

        locationOfCorrectAnswer = random.nextInt(4);

        for(int i = 0; i < 4; i++) {

            if(i == locationOfCorrectAnswer) {

                answer.add(a * b);

            } else if (id.equals("1")) {

                int wrongAnswer = random.nextInt(101);

                while (wrongAnswer == (a * b)) {

                     wrongAnswer = random.nextInt(101);
                }
                answer.add(wrongAnswer);

            } else if (id.equals("2")) {

                int wrongAnswer = random.nextInt(401);

                while (wrongAnswer == (a * b)) {
                    wrongAnswer = random.nextInt(401);
                }

                answer.add(wrongAnswer);

            }

        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }

    public void setMultiples(String id) {

        Random random = new Random();

        if (id.equals("1")) {

            int a = random.nextInt(11);
            int b = random.nextInt(11);

            mulitpleTextView.setText(Integer.toString(a) + " x " + Integer.toString(b));

            options(a, b, id);

        } else if(id.equals("2")) {

            int a = random.nextInt(21);
            int b = random.nextInt(21);

            mulitpleTextView.setText(Integer.toString(a) + " x " + Integer.toString(b));

            options(a, b, id);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        startButton = findViewById(R.id.startQuizButton);
        playAgainButton = findViewById(R.id.playAgainButton);
        mulitpleTextView = findViewById(R.id.multipleTextView);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);

        gameLayout = findViewById(R.id.gameLayout);
        gridLayout = findViewById(R.id.gridLayout);

        constraintLayout = findViewById(R.id.constraintLayout);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            quizId = extras.getString("QUIZ_ID");
            //The key argument here must match that used in the other activity
        }

//        Toast.makeText(this, quiz, Toast.LENGTH_SHORT).show();

        startButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);

    }
}
