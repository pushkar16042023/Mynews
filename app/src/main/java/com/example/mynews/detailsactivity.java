package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mynews.models.Articles;
import com.squareup.picasso.Picasso;

public class detailsactivity extends AppCompatActivity {
    Articles headlines;
    TextView textitle,textdetailauthor,textdetailtime,textdetailcontent,textdetail;
    ImageView imagedetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);
        textitle = findViewById(R.id.textdetailtitle);

        textdetailauthor = findViewById(R.id.textdetailauthor);
        textdetailtime = findViewById(R.id.textdetailtime);
        textdetail = findViewById(R.id.textdetail);
        textdetailcontent = findViewById(R.id.textdetailcontent);
        imagedetail = findViewById(R.id.imagedetail);

        headlines = (Articles)getIntent().getSerializableExtra("data");

        textitle.setText(headlines.getTitle());
        textdetailauthor.setText(headlines.getAuthor());
        textdetailtime.setText(headlines.getPublishedat());
        textdetail.setText(headlines.getDescription());
        textdetailcontent.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(imagedetail);


    }
}