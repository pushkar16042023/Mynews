package com.example.mynews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class customviewholder extends RecyclerView.ViewHolder {
    //here we will have 2 textview and one imageview
    TextView textitle;
    TextView textsource;
    ImageView imageheadline;
    CardView container;
    public customviewholder(@NonNull View itemView) {
        super(itemView);
        textitle = itemView.findViewById(R.id.textitle);
        textsource = itemView.findViewById(R.id.textsource);
        imageheadline = itemView.findViewById(R.id.imageheadline);
        container = itemView.findViewById(R.id.container);
    }
}
