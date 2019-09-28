package com.quinto.lab3quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText[] courses = new EditText[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses[0] = findViewById(R.id.editText5);
        courses[1] = findViewById(R.id.editText6);
        courses[2] = findViewById(R.id.editText2);
        courses[3] = findViewById(R.id.editText8);
        courses[4] = findViewById(R.id.editText7);
        courses[5] = findViewById(R.id.editText3);
        courses[6] = findViewById(R.id.editText);
        courses[7] = findViewById(R.id.editText4);
    }

    public void writeData(View v) {
        String data = "";
        for(int i = 0; i < courses.length; i++) {
            data += courses[i].getText().toString() + ",";
        }
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());

            //Files.write(Paths.get("myfile.txt"), "the text".getBytes(), StandardOpenOption.APPEND);

        } catch(FileNotFoundException ex) {
            Log.d("error", "File not found...");
        } catch(IOException ex) {
            Log.d("error", "IO error...");
        } finally {
            try {
                writer.close();
            } catch(IOException ex) {
                Log.d("error", "file not found...");
            }
        }

        Toast.makeText(this, "Courses saved...", Toast.LENGTH_LONG).show();

    }

    public void nextPage(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
