package com.oim.recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    //private List<MyObject> cities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // évite les doublons car quand on change d'orientation onCreate est appellé
        if(MyObject.getCapitalsList() == null){
            //remplir la ville
            ajouterVilles();
        }else{
            Toast.makeText(MainActivity.this, "Nothing to do", Toast.LENGTH_SHORT).show();
        }

        recyclerView = findViewById(R.id.recyclerView);

        // On récupère l'orientation du device
        int displayMode = getResources().getConfiguration().orientation;

        if (displayMode == 1) {
            //définit l'agencement des cellules, ici de façon verticale, comme une ListView
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new MyAdapter(MyObject.getCapitalsList()));

    }

    @Override
    protected void onResume(){
        super.onResume();
        recyclerView.setAdapter(new MyAdapter(MyObject.getCapitalsList()));
    }

    // test ajout object
    private void ajouterVilles() {
        MyObject.addCities(new MyObject("Paris", "France", "5M", "https://www.telegraph.co.uk/travel/destination/article130148.ece/ALTERNATES/w620/parisguidetower.jpg"));
        MyObject.addCities(new MyObject("Londres", "Angleterre", "10M", "https://cdn.londonandpartners.com/visit/london-organisations/tower-bridge/86830-640x360-tower-bridge-640.jpg"));
        MyObject.addCities(new MyObject("Berlin", "Allemagne", "4M", "http://tanned-allemagne.com/wp-content/uploads/2012/10/pano_rathaus_1280.jpg"));
        MyObject.addCities(new MyObject("Madrid", "Espagne", "7M", "https://www.quizz.biz/uploads/quizz/1029758/8_cueYr.jpg"));
        MyObject.addCities(new MyObject("Rome", "Italie", "3M", "http://retouralinnocence.com/wp-content/uploads/2013/05/Hotel-en-Italie-pour-les-Vacances2.jpg"));
        MyObject.addCities(new MyObject("Moscou", "Russie", "6M", "http://www.choisir-ma-destination.com/uploads/_large_russie-moscou2.jpg"));
    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // item du menu sélectionné
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClicked = item.getItemId();
        // click icon Alert
        if (itemThatWasClicked == R.id.action_alert) {
            Context context = MainActivity.this;
            String textToShow = "Alert clicked";
            Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();

            // AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            // vue personnaliser de l'alerte dialoque
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog_layout, null);

            TextView title = (TextView) view.findViewById(R.id.title);
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

            title.setText("Sorry");

            imageButton.setImageResource(R.drawable.smile);

            // button Yes de l'alert
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
                }
            });
            // button No de l'alert
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Never Mind!", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setView(view);
            builder.show();
             return true;
        }
        // click icon +
        if(itemThatWasClicked == R.id.action_add){
            Context context = MainActivity.this;
            String textToShow = "Add clicked";
            Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
            // démarre l'activity qui représente le formulaire
            startActivity(new Intent(context, FormulaireAdd.class));
        }
        return super.onOptionsItemSelected(item);
    }
}