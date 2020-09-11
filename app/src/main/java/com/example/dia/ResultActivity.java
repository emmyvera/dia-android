package com.example.dia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String result;
    private String likelihood;
    private String bpResult;
    private String bmiResult;
    private int bpNo;
    private int bmiNo;

    ImageView resultImage, diabetesImage, likelihoodImage, bpImage, bmiImage;
    TextView resultText, likelihoodText, bpText, bmiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultImage = findViewById(R.id.resultImage);
        diabetesImage = findViewById(R.id.diabetesImage);
        likelihoodImage = findViewById(R.id.likelihoodImage);
        bpImage = findViewById(R.id.bpImage);
        bmiImage = findViewById(R.id.bmiImage);

        resultText = findViewById(R.id.diagnoseResult);
        likelihoodText = findViewById(R.id.diagnoseLikelihood);
        bpText = findViewById(R.id.bpResult);
        bmiText = findViewById(R.id.bmiResult);

        result = getIntent().getExtras().getString(getResources().getString(R.string.diabetes_result), "");
        likelihood = getIntent().getExtras().getString(getResources().getString(R.string.likelihood), "");
        bpResult = getIntent().getExtras().getString(getResources().getString(R.string.bp_result), "");
        bmiResult = getIntent().getExtras().getString(getResources().getString(R.string.bmi_result), "");
        bpNo = getIntent().getExtras().getInt(getResources().getString(R.string.bp_no), 0);
        bmiNo = getIntent().getExtras().getInt(getResources().getString(R.string.bmi_no), 0);

        populateView();
    }

    public void populateView(){
        resultText.setText(result);
        likelihoodText.setText(likelihood);
        bpText.setText(bpResult);
        bmiText.setText(bmiResult);
    }

}