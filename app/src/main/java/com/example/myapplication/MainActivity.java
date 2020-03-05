package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monSwitch = (Switch)findViewById(R.id.genderSwitch);
        monSwitch.setOnCheckedChangeListener(this);
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
}
