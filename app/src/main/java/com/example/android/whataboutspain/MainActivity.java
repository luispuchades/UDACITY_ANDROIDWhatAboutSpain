package com.example.android.whataboutspain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.right;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //1. Declaration of public variables (if exist)
    //Score
    int score;
    int scoreBonus;
    int answeredQuestions;
    int answeredBonusQuestions;



    //Question1 (Q1)
    boolean questionSelected11;
    boolean questionSelected12;
    boolean questionSelected13;
    String answerQ1;
    EditText textQuestion1;

    //Question2 (Q2)
    boolean questionSelected21;
    boolean questionSelected22;
    boolean questionSelected23;
    String answerQ2;
    EditText textQuestion2;

    //Question3 (Q3)
    boolean questionSelected31;
    boolean questionSelected32;
    boolean questionSelected33;
    String answerQ3;
    EditText textQuestion3;

    //Question4 (Q4)
    boolean questionSelected41;
    boolean questionSelected42;
    boolean questionSelected43;
    String answerQ4;
    EditText textQuestion4;

    //Question5 (Q5)
    CheckBox buttonRadio51;
    CheckBox buttonRadio52;
    CheckBox buttonRadio53;
    boolean questionSelected51;
    boolean questionSelected52;
    boolean questionSelected53;
    String answerQ5;
    EditText textQuestion5;


    //2. Definition of methods and functions

    //Check answer given and score question
    private void checkAnswer(boolean questionSelected1, boolean questionSelected2, boolean questionSelected3) {
        if(questionSelected3) {
            score += 1;
            answeredQuestions += 1;
        }
        if(questionSelected1) {
            answeredQuestions += 1;
        }
        if(questionSelected2) {
            answeredQuestions += 1;
        }
    }

    //Check bonus answer giben and score question
    private void checkAnswerBonus(String checkAnswer, String rightAnswer) {
        if(checkAnswer.matches("")){
            return;
        } else if(checkAnswer.toLowerCase().contains(rightAnswer.toLowerCase())){
            scoreBonus += 1;
            answeredBonusQuestions += 1;
        } else {
            answeredBonusQuestions += 1;
        }
    }

    private void checkAnswerBox(boolean questionSelected1, boolean questionSelected2, boolean questionSelected3) {
        if(questionSelected1 && questionSelected3) {
            score += 1;
            answeredQuestions += 1;
            return;
        }
        if(questionSelected1) {
            answeredQuestions += 1;
            return;
        }
        if(questionSelected2) {
            answeredQuestions += 1;
            return;
        }
        if(questionSelected3) {
            answeredQuestions += 1;
        }
    }

    private void updateAnsweredQuestions(int number) {
        TextView answeredQuestionsBanner = (TextView) findViewById(R.id.quiz_answered_questions_number);
        answeredQuestionsBanner.setText("" + number);
    }


    private String createFinalMessage(int score, int scoreBonus, int answeredQuestions, int answeredBonusQuestions) {
        String finalMessage;
        int finalScore;

        finalScore = (answeredQuestions + score * 3 + answeredBonusQuestions * 2 + scoreBonus * 5);

        finalMessage = "WHAT ABOUT SPAIN QUIZ EVALUATION";
        finalMessage += "\n";
        finalMessage += "\n";
        finalMessage += "\n" + "Thank you for taking this Quizz about Spain.";
        finalMessage += "\n";
        finalMessage += "\n";
        finalMessage += "\n" + "Questions answered: "+ answeredQuestions;
        finalMessage += "\n" + "Questions correct: "+ score;
        finalMessage += "\n";
        finalMessage += "\n";
        finalMessage += "\n" + "EXTRA BONUS QUESTIONS";
        finalMessage += "\n";
        finalMessage += "\n" + "Bonus questions answered: " + answeredBonusQuestions;
        finalMessage += "\n" + "Bonus questions correct: " + scoreBonus;
        finalMessage += "\n";
        finalMessage += "\n" + "TOTAL SCORE: " + finalScore;
        finalMessage += "\n";
        finalMessage += "\n" + "Answered Questions: 1 points.";
        finalMessage += "\n" + "Correct Questions: 3 points.";
        finalMessage += "\n" + "Answered Bonus Questions: 2 points.";
        finalMessage += "\n" + "Correct Bonus Questions: 5 points.";


        return finalMessage;
    }

    //Private method for extending time to the toast message
    //As LENGHT_LONG is defined as 3.5 seconds, then i=2 means 7 seconds
    private void showScore(String message) {
        for (int i=0; i < 2; i++) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    //Private method for unchecking checkboxes
    private void uncheckCheckboxes(CheckBox nameCheckbox) {
        if (nameCheckbox.isChecked()) {
            nameCheckbox.toggle();
        }
    }


    //3. Event Asignment
    // submitQuiz is the method called when "SUBMIT QUIZ" button is pushed
    // submitQuiz method must identify which radiobutons were selected by the user
    public void submitQuiz(View view) {

        //Score reset
        score = 0;
        scoreBonus = 0;
        answeredQuestions = 0;
        answeredBonusQuestions = 0;


        //Question1(Q1): Detection of Radio Button pushed
        RadioButton buttonRadio11 = (RadioButton) findViewById(R.id.radio11);
        questionSelected11 = buttonRadio11.isChecked();

        RadioButton buttonRadio12 = (RadioButton) findViewById(R.id.radio12);
        questionSelected12 = buttonRadio12.isChecked();

        RadioButton buttonRadio13 = (RadioButton) findViewById(R.id.radio13);
        questionSelected13 = buttonRadio13.isChecked();

        //Question1: Check Bonus Question
        textQuestion1 = (EditText) findViewById(R.id.bonus1);
        answerQ1 = textQuestion1.getText().toString();

        //Question1: Check right answer
        checkAnswer(questionSelected11, questionSelected12, questionSelected13);
        checkAnswerBonus(answerQ1, "Calatrava");


        //Question2(Q2): Detection of Radio Button pushed
        RadioButton buttonRadio21 = (RadioButton) findViewById(R.id.radio21);
        questionSelected21 = buttonRadio21.isChecked();

        RadioButton buttonRadio22 = (RadioButton) findViewById(R.id.radio22);
        questionSelected22 = buttonRadio22.isChecked();

        RadioButton buttonRadio23 = (RadioButton) findViewById(R.id.radio23);
        questionSelected23 = buttonRadio23.isChecked();

        //Question1: Check Bonus Question
        textQuestion2 = (EditText) findViewById(R.id.bonus2);
        answerQ2 = textQuestion2.getText().toString();

        //Question1: Check right answer
        checkAnswer(questionSelected21, questionSelected22, questionSelected23);
        checkAnswerBonus(answerQ2, "Albufera");


        //Question3(Q3): Detection of Radio Button pushed
        RadioButton buttonRadio31 = (RadioButton) findViewById(R.id.radio31);
        questionSelected31 = buttonRadio31.isChecked();

        RadioButton buttonRadio32 = (RadioButton) findViewById(R.id.radio32);
        questionSelected32 = buttonRadio32.isChecked();

        RadioButton buttonRadio33 = (RadioButton) findViewById(R.id.radio33);
        questionSelected33 = buttonRadio33.isChecked();

        //Question3: Check Bonus Question
        textQuestion3 = (EditText) findViewById(R.id.bonus3);
        answerQ3 = textQuestion3.getText().toString();

        //Question3: Check right answer
        checkAnswer(questionSelected31, questionSelected32, questionSelected33);
        checkAnswerBonus(answerQ3, "Turia");


        //Question4(Q4): Detection of Radio Button pushed
        RadioButton buttonRadio41 = (RadioButton) findViewById(R.id.radio41);
        questionSelected41 = buttonRadio41.isChecked();

        RadioButton buttonRadio42 = (RadioButton) findViewById(R.id.radio42);
        questionSelected42 = buttonRadio42.isChecked();

        RadioButton buttonRadio43 = (RadioButton) findViewById(R.id.radio43);
        questionSelected43 = buttonRadio43.isChecked();

        //Question4: Check Bonus Question
        textQuestion4 = (EditText) findViewById(R.id.bonus4);
        answerQ4 = textQuestion4.getText().toString();

        //Question4: Check right answer
        checkAnswer(questionSelected41, questionSelected42, questionSelected43);
        checkAnswerBonus(answerQ4, "Paella");


        //Question5(Q5): Detection of Radio Button pushed
        buttonRadio51 = (CheckBox) findViewById(R.id.radio51);
        questionSelected51 = buttonRadio51.isChecked();

        buttonRadio52 = (CheckBox) findViewById(R.id.radio52);
        questionSelected52 = buttonRadio52.isChecked();

        buttonRadio53 = (CheckBox) findViewById(R.id.radio53);
        questionSelected53 = buttonRadio53.isChecked();

        //Question4: Check Bonus Question
        textQuestion5 = (EditText) findViewById(R.id.bonus5);
        answerQ5 = textQuestion5.getText().toString();

        //Question1: Check right answer
        checkAnswerBox(questionSelected51, questionSelected52, questionSelected53);
        checkAnswerBonus(answerQ5, "Mediterr");

        //Update answered questions
        updateAnsweredQuestions(answeredQuestions);


        //String creation for showing score of quiz results
        String finalMessage = createFinalMessage(score, scoreBonus, answeredQuestions, answeredBonusQuestions);


        //Convert Button "SUBMIT QUIZ" to "RETAKE QUIZ"
        Button finalSubmitQuiz = (Button) findViewById(R.id.submit_quiz);
        finalSubmitQuiz.setVisibility(View.GONE);

        Button finalRetakeQuiz = (Button) findViewById(R.id.retake_quiz);
        finalRetakeQuiz.setVisibility(View.VISIBLE);

        //Show results in a toast message
        showScore(finalMessage);
    }


    //Retake Quiz is the event to restart the quizz
    public void retakeQuiz(View view) {
        //Score reset
        score = 0;
        scoreBonus = 0;
        answeredQuestions = 0;
        answeredBonusQuestions = 0;

        //Update answered questions to "0"
        updateAnsweredQuestions(0);

        //UNCHECK RADIOBUTTONS
        //Question 1 (Q1)
        RadioGroup radioButtonQ1 = (RadioGroup) findViewById(R.id.radio_button_Q1);
        radioButtonQ1.clearCheck();

        //Question 2 (Q2)
        RadioGroup radioButtonQ2 = (RadioGroup) findViewById(R.id.radio_button_Q2);
        radioButtonQ2.clearCheck();

        //Question 3 (Q3)
        RadioGroup radioButtonQ3 = (RadioGroup) findViewById(R.id.radio_button_Q3);
        radioButtonQ3.clearCheck();

        //Question 4 (Q4)
        RadioGroup radioButtonQ4 = (RadioGroup) findViewById(R.id.radio_button_Q4);
        radioButtonQ4.clearCheck();


        //UNCHECK CHECKBOXES
        uncheckCheckboxes(buttonRadio51);
        uncheckCheckboxes(buttonRadio52);
        uncheckCheckboxes(buttonRadio53);


        //UNCHECK EDITEXTS
        textQuestion1.getText().clear();
        textQuestion2.getText().clear();
        textQuestion3.getText().clear();
        textQuestion4.getText().clear();
        textQuestion5.getText().clear();


        //Convert Button "RETAKE QUIZ" to "SUBMIT QUIZ"
        Button finalRetakeQuiz = (Button) findViewById(R.id.retake_quiz);
        finalRetakeQuiz.setVisibility(View.GONE);

        Button finalSubmitQuiz = (Button) findViewById(R.id.submit_quiz);
        finalSubmitQuiz.setVisibility(View.VISIBLE);
    }
}
