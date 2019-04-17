package com.oim.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView city;
    private TextView pays;
    private TextView numberOfLiving;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        city = (TextView) itemView.findViewById(R.id.city);
        pays = (TextView) itemView.findViewById(R.id.pays);
        numberOfLiving = (TextView) itemView.findViewById(R.id.pop);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject myObject){
        city.setText(myObject.getCity());
        pays.setText(myObject.getPays());
        numberOfLiving.setText(myObject.getNumberOfLiving());

        // Ici nous utilisons Picasso binder l'image depuis une URL à notre imageView.
        Picasso.with(imageView.getContext())
                .load(myObject.getImageUrl())
                .centerCrop()
                .fit()
                .into(imageView);
    }
}
