package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myFunction(View v)
    {
        EditText editPrenom = findViewById(R.id.edtxtNom);
        TextView prenom = findViewById(R.id.txtPrenomCitoyen);

        prenom.setText(editPrenom.getText());

    }
}
