package com.oim.recyclerview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FormulaireAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_add);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ajouter Capitales");
    }
}
