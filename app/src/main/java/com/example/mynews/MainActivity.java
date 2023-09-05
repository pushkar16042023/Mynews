package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mynews.models.Articles;
import com.example.mynews.models.newsapiresponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements selectlistener, View.OnClickListener{

    //fcef1388277c4e498d4e58b02b31e024
    RecyclerView recyclerView;
    customadapter adapter;
    ProgressDialog dialog;
    Button B1,B2,B3,B4,B5,B6,B7;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles...");
        dialog.show();
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of "+ query);
                dialog.show();
                requestmanager manager = new requestmanager(MainActivity.this);
                manager.getnewheadlines(listener,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        B1 = findViewById(R.id.btn1);
        B1.setOnClickListener(this);
        B2 = findViewById(R.id.btn2);
        B2.setOnClickListener(this);
        B3 = findViewById(R.id.btn3);
        B3.setOnClickListener(this);
        B4 = findViewById(R.id.btn4);
        B4.setOnClickListener(this);
        B5 = findViewById(R.id.btn5);
        B5.setOnClickListener(this);
        B6 = findViewById(R.id.btn6);
        B6.setOnClickListener(this);
        B7 = findViewById(R.id.btn7);
        B7.setOnClickListener(this);
        requestmanager manager = new requestmanager(this);
        manager.getnewheadlines(listener,"general",null);
    }
    private final onfetchdatalistener<newsapiresponse> listener = new onfetchdatalistener<newsapiresponse>() {
        @Override
        public void onfetchdata(List<Articles> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this,"No data found!",Toast.LENGTH_SHORT).show();
            }
            else{
                dialog.dismiss();
                showNews(list);
            }


        }

        @Override
        public void onerror(String manager) {
            Toast.makeText(MainActivity.this,"An error occured!!",Toast.LENGTH_SHORT).show();

        }
    };
    private void showNews(List<Articles> list){
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new customadapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onnewclicked(Articles headlines) {
        startActivity(new Intent(MainActivity.this, detailsactivity.class).putExtra("data",headlines));

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Fetching news articles of" + category);
        dialog.show();
        requestmanager manager = new requestmanager(this);
        manager.getnewheadlines(listener,category,null);

    }
}