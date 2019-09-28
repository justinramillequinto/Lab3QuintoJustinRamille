package com.quinto.lab3quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    CheckBox[] c = new CheckBox[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("SUBJECTS TAKEN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FileInputStream reader = null;
        String courses[] = new String[c.length];
        String str = " ";

        c[0] = findViewById(R.id.checkBox);
        c[1] = findViewById(R.id.checkBox2);
        c[2] = findViewById(R.id.checkBox3);
        c[3] = findViewById(R.id.checkBox4);
        c[4] = findViewById(R.id.checkBox5);
        c[5] = findViewById(R.id.checkBox6);
        c[6] = findViewById(R.id.checkBox7);
        c[7] = findViewById(R.id.checkBox8);

        try {
            reader = openFileInput("data1.txt");
            int token;

            while((token = reader.read()) != -1) {
                str += (char)token;
            }
            courses = str.split(",");

        } catch(FileNotFoundException ex) {
            Log.d("error", "file not found...");
        } catch(IOException ex) {
            Log.d("error", "IO error...");
        }
        for(int i = 0; i < c.length; i++) {
            c[i].setText(courses[i]);
        }
    }

    public void showCourses(View v) {
        String message = "";
        for(int i = 0; i < c.length; i++) {
            if(c[i].isChecked()) {
                message += c[i].getText().toString() + ", ";
            }
        }
        Toast.makeText(this, message + "are taken", Toast.LENGTH_LONG).show();
    }
}
