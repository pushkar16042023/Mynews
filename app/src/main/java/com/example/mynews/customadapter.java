package com.example.mynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.models.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class customadapter extends RecyclerView.Adapter<customviewholder> {
    private Context context;
    private List<Articles> headlines;
    private selectlistener listener;

    public customadapter(Context context, List<Articles> headlines,selectlistener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public customviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new customviewholder(LayoutInflater.from(context).inflate(R.layout.headline_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull customviewholder holder, int position) {
        holder.textitle.setText(headlines.get(position).getTitle());
        holder.textsource.setText(headlines.get(position).getSource().getName());
        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imageheadline);
        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onnewclicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
