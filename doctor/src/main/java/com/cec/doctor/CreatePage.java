package com.cec.doctor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cec.doctor.Scribbles.Exams;
import com.cec.doctor.Scribbles.Prescription;

public class CreatePage extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);

        textView = findViewById(R.id.text_newprescription);
        textView = findViewById(R.id.text_newexams);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void CReatePage (View view){



                Intent intent  = new Intent(CreatePage.this, Prescription.class);
                startActivity(intent);
                Toast.makeText(CreatePage.this, "users page ", Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(CreatePage.this, Exams.class);
                startActivity(intent1);
                Toast.makeText(CreatePage.this, "users page ", Toast.LENGTH_SHORT).show();

            }
    public void  Saved (View view) {
        Intent intent  = new Intent(CreatePage.this, User.class);
        startActivity(intent);
        Toast.makeText(this, "back to user", Toast.LENGTH_SHORT).show();

    }


}
