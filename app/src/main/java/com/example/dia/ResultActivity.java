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

        ResultImageAndText(result);
        LikelihoodText(likelihood);
        BPResult(bpNo);
        BMIResult(bmiNo);

        //resultText.setText(result);
        //likelihoodText.setText(likelihood);
        bpText.setText(bpResult);
        bmiText.setText(bmiResult);
    }

    public void ResultImageAndText(String result){
        if (result.equals("0")){
            resultImage.setImageDrawable(getDrawable(R.drawable.ic_round_check_24));
            resultImage.setColorFilter(getColor(R.color.good_green));
            resultText.setText(getResources().getString(R.string.no_diabetes));
            diabetesImage.setImageDrawable(getDrawable(R.drawable.ic_round_check_24));
            diabetesImage.setColorFilter(getColor(R.color.good_green));
        }else if (result.equals("1")){
            resultImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            resultImage.setColorFilter(getColor(R.color.bad_red));
            resultText.setText(getResources().getString(R.string.yes_diabetes));
            diabetesImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            diabetesImage.setColorFilter(getColor(R.color.bad_red));
        }else {
            resultImage.setImageDrawable(getDrawable(R.drawable.ic_round_remove_24));
        }
    }

    public void LikelihoodText(String likelihood){
        float result = Float.parseFloat(likelihood);
        String resultInStr = String.format("%.2f, ", result);

        if (result <= 0.33){
            likelihoodText.setText(resultInStr + getResources().getString(R.string.no_likelihood));
            likelihoodImage.setImageDrawable(getDrawable(R.drawable.ic_round_check_24));
            likelihoodImage.setColorFilter(getColor(R.color.good_green));
        }else if (result <= 0.67){
            likelihoodText.setText(resultInStr + getResources().getString(R.string.maybe_likelihood));
            likelihoodImage.setImageDrawable(getDrawable(R.drawable.ic_round_remove_24));
            likelihoodImage.setColorFilter(getColor(R.color.warning_yellow));
        }else{
            likelihoodText.setText(resultInStr + getResources().getString(R.string.yes_likelihood));
            likelihoodImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            likelihoodImage.setColorFilter(getColor(R.color.bad_red));
        }
    }

    public void BPResult(int bpNo){
        if (bpNo < 60){
            bpImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            bpImage.setColorFilter(getColor(R.color.bad_red));
        }
        else if (bpNo < 80) {
            bpImage.setImageDrawable(getDrawable(R.drawable.ic_round_check_24));
            bpImage.setColorFilter(getColor(R.color.good_green));
        }
        else if (bpNo < 90){
            bpImage.setImageDrawable(getDrawable(R.drawable.ic_round_remove_24));
            bpImage.setColorFilter(getColor(R.color.warning_yellow));
        }
        else {
            bpImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            bpImage.setColorFilter(getColor(R.color.bad_red));
        }

    }

    public void BMIResult(int bmiNo){

        if (bmiNo < 16){
            bmiImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            bmiImage.setColorFilter(getColor(R.color.bad_red));
        }
        else if (bmiNo < 18.5) {
            bmiImage.setImageDrawable(getDrawable(R.drawable.ic_round_remove_24));
            bmiImage.setColorFilter(getColor(R.color.warning_yellow));
        }
        else if (bmiNo < 25) {
            bmiImage.setImageDrawable(getDrawable(R.drawable.ic_round_check_24));
            bmiImage.setColorFilter(getColor(R.color.good_green));
        }
        else if (bmiNo < 35) {
            bmiImage.setImageDrawable(getDrawable(R.drawable.ic_round_remove_24));
            bmiImage.setColorFilter(getColor(R.color.warning_yellow));
        }
        else {
            bmiImage.setImageDrawable(getDrawable(R.drawable.ic_round_clear_24));
            bmiImage.setColorFilter(getColor(R.color.bad_red));
        }

    }

}