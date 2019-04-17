package com.oim.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FormulaireAdd extends AppCompatActivity {

    private Button register;
    private EditText nameCity;
    private EditText namePays;
    private EditText numberLiving;
    private EditText imgCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_add);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ajouter Capitales");

        register = findViewById(R.id.register);
        nameCity = findViewById(R.id.namecity);
        namePays = findViewById(R.id.namepays);
        numberLiving = findViewById(R.id.numberliving);
        imgCity = findViewById(R.id.imgcity);

    }

    protected void registerCity(View view){
        // récup entré clavier
        String entercity = nameCity.getText().toString();
        String enterpays = namePays.getText().toString();
        String enterliving = numberLiving.getText().toString();
        String enterimg = imgCity.getText().toString();

        // vérification si champs vide
        if(entercity.matches("") && enterpays.matches("") && enterliving.matches("") && enterimg.matches("")){
            // alertdialog si champs vide
            SimpleDialog simpleDialog = new SimpleDialog();
            simpleDialog.show(getSupportFragmentManager(),"example simple dialog" );
        }else {
            MyObject.addCities(new MyObject(entercity,enterpays,enterliving,enterimg));
            entercity = null;
            enterpays = null;
            enterliving = null;
            enterimg = null;
            Toast.makeText(this, "Successful insertion", Toast.LENGTH_SHORT).show();
            // démarre l'activity qui représente le formulaire
            finish();
        }
    }
}
