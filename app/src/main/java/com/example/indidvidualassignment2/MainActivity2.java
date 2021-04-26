package com.example.indidvidualassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    public static final String EducationalInformation = "EducationalInformation";
    public static final String WorkExperience = "WorkExperience";
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    
    private EditText edt_Educationalinformation;
    private EditText edt_Workexperience;
    private CheckBox Chk_Save;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        setupViews();
        setupSharedPrefs();
        checkPrefs();
    }

    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG,false);
        if(flag){
            String educationalinformation = prefs.getString(EducationalInformation,"");
            String workexperience = prefs.getString(WorkExperience,"");
            edt_Educationalinformation.setText(educationalinformation);
            edt_Workexperience.setText(workexperience);
            Chk_Save.setChecked(true);

        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupViews() {
        edt_Educationalinformation = findViewById(R.id.edt_Educationalinfo);
        edt_Workexperience = findViewById(R.id.edt_Workexperience);
        Chk_Save = findViewById(R.id.Chk_Save);
    }

    public void btn_Save2Onclick(View view) {
        String educationalinformation = edt_Educationalinformation.getText().toString();
        String workexperience = edt_Workexperience.getText().toString();

        if(Chk_Save.isChecked()){
            if(!flag){
                editor.putString(EducationalInformation,educationalinformation);
                editor.putString(WorkExperience,workexperience);
                editor.putBoolean(FLAG,true);
                editor.commit();

            }
        }
    }
}