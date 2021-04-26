package com.example.indidvidualassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edt_Name;
    private EditText edt_Email;
    private EditText edt_Phone;
    private EditText edt_Hobbies;
    private Spinner spn_Degree;
    private Button btn_gotosecondActivityOnclick;
    private Button btn_Save;
    private Button btn_Load;
    Spinner spinner;

    private ArrayList<PersonalInformatiomModel> PersonalInformationmodelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spn_Degree);
        btn_gotosecondActivityOnclick = findViewById(R.id.btn_gotosecondActivity);

        edt_Name = findViewById(R.id.edt_Name);
        edt_Email = findViewById(R.id.edt_Email);
        edt_Phone = findViewById(R.id.edt_Phone);
        edt_Hobbies = findViewById(R.id.edt_Hobbies);
        btn_Save = findViewById(R.id.btn_Save);
        btn_Load = findViewById(R.id.btn_Load);

        populatetSpinner();
        setupViews();
        loadData();

        btn_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInformationmodelArrayList.add(new PersonalInformatiomModel(edt_Name.getText().toString(), edt_Email.getText().toString(),edt_Phone.getText().toString(),edt_Hobbies.getText().toString()));
               //adapter.notifyItemInserted(PersonalInformationmodelArrayList.size());
            }
        });
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void setupViews() {
        edt_Name = findViewById(R.id.edt_Name);
        edt_Email = findViewById(R.id.edt_Email);
        edt_Phone = findViewById(R.id.edt_Phone);
        edt_Hobbies = findViewById(R.id.edt_Hobbies);
        spn_Degree = findViewById(R.id.spn_Degree);
    }
    
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("personal information", null);
        Type type = new TypeToken<ArrayList<PersonalInformatiomModel>>() {
        }.getType();

        PersonalInformationmodelArrayList = gson.fromJson(json, type);
        if (PersonalInformationmodelArrayList == null) {
            PersonalInformationmodelArrayList = new ArrayList<>();
        }
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(PersonalInformationmodelArrayList);
        editor.putString("personal information", json);
        editor.apply();
        editor.commit();
        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }
    private void populatetSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("deplom");
        data.add("Bachalores");
        data.add("Master");
        data.add("Dactorate");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
        spinner.setAdapter(adapter);
    }

    public void btn_SpinnerOnclick(View view) {
        Spinner spn_Degree= findViewById(R.id.spn_Degree);
        String str = spn_Degree.getSelectedItem().toString();
    }

    public void btn_gotosecondActivityOnclick(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void btn_SaveOnclick(View view) {
        saveData();
    }

    public void btn_LoadOnclick(View view) {
        PersonalInformationmodelArrayList.add(new PersonalInformatiomModel(edt_Name.getText().toString(), edt_Email.getText().toString(),edt_Phone.getText().toString(),edt_Hobbies.getText().toString()));

    }
}