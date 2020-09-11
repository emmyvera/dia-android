package com.example.dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText pregEdit, glucoseEdit, bpEdit, stEdit, insulinEdit, bmiEdit, dpfEdit, ageEdit;
    Button diagnoseBtn;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        pregEdit = findViewById(R.id.pregEdit);
        glucoseEdit = findViewById(R.id.glucoseEdit);
        bpEdit = findViewById(R.id.bpEdit);
        stEdit = findViewById(R.id.stEdit);
        insulinEdit = findViewById(R.id.insulinEdit);
        bmiEdit = findViewById(R.id.bmiEdit);
        dpfEdit = findViewById(R.id.dpfEdit);
        ageEdit = findViewById(R.id.ageEdit);
        diagnoseBtn = findViewById(R.id.diagnoseBtn);

        diagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Diagnose();
            }
        });

    }

    public void Diagnose(){
        String pregnancies = pregEdit.getText().toString();
        String glucose = glucoseEdit.getText().toString();
        String bp = bpEdit.getText().toString();
        String st = stEdit.getText().toString();
        String insulin = insulinEdit.getText().toString();
        String bmi = bmiEdit.getText().toString();
        String dpf = dpfEdit.getText().toString();
        String age = ageEdit.getText().toString();

        Call<User> call = apiInterface.performDiagnoses("4", "138", "82", "30",
                "170", "24", "0.255", "38");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null){

                    String result = response.body().getResult();
                    String likelihood = response.body().getLikelihood();
                    String bpResult = response.body().getBp();
                    String bmiResult = response.body().getBmi();
                    int bpNo = response.body().getBpNo();
                    int bmiNo = response.body().getBmiNo();

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra(getResources().getString(R.string.diabetes_result), result);
                    intent.putExtra(getResources().getString(R.string.likelihood), likelihood);
                    intent.putExtra(getResources().getString(R.string.bp_result), bpResult);
                    intent.putExtra(getResources().getString(R.string.bmi_result), bmiResult);
                    intent.putExtra(getResources().getString(R.string.bp_no), bpNo);
                    intent.putExtra(getResources().getString(R.string.bmi_no), bmiNo);

                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(), NoResultActivity.class);
                startActivity(intent);
            }
        });


    }
}