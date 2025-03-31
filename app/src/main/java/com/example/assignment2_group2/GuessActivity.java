package com.example.assignment2_group2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class GuessActivity extends AppCompatActivity {

    private QuestionManager questionManager;
    private TextView tvQuestionNumber;
    private TextView codeSnippet;
    private LinearLayout optionsContainer;
    private MaterialButton btnPrev;
    private MaterialButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guess);

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        codeSnippet = findViewById(R.id.codeSnippet);
        optionsContainer = findViewById(R.id.optionsContainer);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);

        // Initialize the question manager (loads, randomizes, and limits questions)
        questionManager = new QuestionManager();

        // Display the first question
        displayQuestion();

        // Previous button navigation
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionManager.goToPrevious();
                displayQuestion();
            }
        });

        // Next button navigation
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionManager.goToNext();
                displayQuestion();
            }
        });
    }

    /**
     * Displays the current question and its options. If all questions are answered,
     * it shows the score layout.
     */
    private void displayQuestion() {
        // If every question is answered, show the score layout.
        if (allQuestionsAnswered()) {
            showScore();
            return;
        }

        Question question = questionManager.getCurrentQuestion();
        if (question == null) return;

        int currentIndex = questionManager.getCurrentIndex();
        tvQuestionNumber.setText("Question #" + (currentIndex + 1));
        codeSnippet.setText(question.getCodeSnippet());
        optionsContainer.removeAllViews();

        // Create option buttons dynamically
        for (int i = 0; i < question.getOptions().size(); i++) {
            final int optionIndex = i;
            Button optionButton = new Button(this);
            optionButton.setText(question.getOptions().get(i));
            optionButton.setAllCaps(false);
            optionButton.setTextColor(Color.WHITE);
            optionButton.setBackgroundColor(Color.parseColor("#333333"));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 8, 0, 8);
            optionButton.setLayoutParams(params);

            if (question.isAnswered()) {
                if (question.getSelectedAnswerIndex() == optionIndex) {
                    if (optionIndex == question.getCorrectAnswerIndex()) {
                        optionButton.setBackgroundColor(Color.parseColor("#4CAF50")); // Correct: Green
                    } else {
                        optionButton.setBackgroundColor(Color.parseColor("#F44336")); // Incorrect: Red
                    }
                } else if (optionIndex == question.getCorrectAnswerIndex()) {
                    optionButton.setBackgroundColor(Color.parseColor("#4CAF50"));
                }
                optionButton.setEnabled(false);
            } else {
                optionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (optionIndex == question.getCorrectAnswerIndex()) {
                            // Correct guess: mark as answered and update UI
                            question.setAnswered(true);
                            question.setSelectedAnswerIndex(optionIndex);
                            displayQuestion();
                        } else {
                            // Incorrect guess: increment attempts and animate shake
                            question.incrementAttempts();
                            Animation shake = AnimationUtils.loadAnimation(GuessActivity.this, R.anim.shake);
                            shake.setRepeatCount(question.getAttempts() - 1);
                            optionButton.startAnimation(shake);
                            // After 5 attempts, mark the question as answered (incorrectly)
                            if (question.getAttempts() >= 5) {
                                question.setAnswered(true);
                                question.setSelectedAnswerIndex(optionIndex);
                                displayQuestion();
                            }
                        }
                    }
                });
            }
            optionsContainer.addView(optionButton);
        }
    }

    /**
     * Checks if all questions have been answered.
     */
    private boolean allQuestionsAnswered() {
        for (Question q : questionManager.getQuestions()) {
            if (!q.isAnswered()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the score and shows the score layout.
     */
    private void showScore() {
        int score = 0;
        for (Question q : questionManager.getQuestions()) {
            if (q.isAnswered() && q.getSelectedAnswerIndex() == q.getCorrectAnswerIndex()) {
                score++;
            }
        }
        setContentView(R.layout.activity_score);
        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Your Score: " + score + " / " + questionManager.getTotalQuestions());
        MaterialButton btnMainMenu = findViewById(R.id.btnMainMenu);
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuessActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
