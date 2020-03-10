package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannedString;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Switch monSwitch;
    private boolean layoutsDifferents = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView prenom = findViewById(R.id.txtPrenomCitoyen);
        TextView nomFamille = findViewById(R.id.txtNomCitoyen);
        TextView genre = findViewById(R.id.txtSexe);
        ImageView signature = findViewById(R.id.signature);

        monSwitch = (Switch)findViewById(R.id.genderSwitch);
        monSwitch.setOnCheckedChangeListener(this);

        if (savedInstanceState != null)
        {
            prenom.setText(savedInstanceState.getString("Prenom"));
            nomFamille.setText(savedInstanceState.getString("NomFamille"));
            genre.setText(savedInstanceState.getString("Genre"));
            signature.setVisibility(savedInstanceState.getInt("SignatureVisible"));
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton ms, boolean isChecked) {
        TextView genre = findViewById(R.id.txtSexe);
        Log.i("DICJ", "ETAT : " + isChecked);
        if (isChecked)
            genre.setText("M");
        else
            genre.setText("F");
    }

    public void myFunction(View v)
    {
        EditText editPrenom = findViewById(R.id.edTxtPrenom);
        TextView prenom = findViewById(R.id.txtPrenomCitoyen);

        EditText editNomFamille = findViewById(R.id.edtxtNom);
        TextView nomFamille = findViewById(R.id.txtNomCitoyen);


        nomFamille.setText(editNomFamille.getText());
        prenom.setText(editPrenom.getText());


    }

    public void hideSignature (View v)
    {
        ImageView signature = findViewById(R.id.signature);

        if (((CheckBox)v).isChecked())
        {
            signature.setVisibility(View.VISIBLE);
        }

        else{
            signature.setVisibility(View.INVISIBLE);

        }


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView prenom = findViewById(R.id.txtPrenomCitoyen);
        TextView nomFamille = findViewById(R.id.txtNomCitoyen);
        TextView genre = findViewById(R.id.txtSexe);
        ImageView signature = findViewById(R.id.signature);



        outState.putString("Prenom", (String)prenom.getText().toString());
        outState.putString("NomFamille", (String)nomFamille.getText().toString());
        outState.putString("Genre", (String)genre.getText().toString());
        outState.putInt("SignatureVisible", signature.getVisibility());

    }
}
