package com.example.rss_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Channels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channels);
        Button vnexpress = (Button) findViewById(R.id.btnVNexpress) ;
        vnexpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentA1A2 = new Intent (Channels.this, MainActivity.class);
                Bundle myBundle1 = new Bundle();
                myBundle1.putInt ("val1", 1);
                myIntentA1A2.putExtras(myBundle1);
                startActivityForResult(myIntentA1A2, 1122);
            }
        });
        Button tuoitre = (Button) findViewById(R.id.btnTuoiTre) ;
        tuoitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentA1A2 = new Intent (Channels.this, MainActivity.class);
                Bundle myBundle1 = new Bundle();
                myBundle1.putInt ("val1", 2);
                myIntentA1A2.putExtras(myBundle1);
                startActivityForResult(myIntentA1A2, 1122);
            }
        });
        Button thanhnien = (Button) findViewById(R.id.btnThanhNien) ;
        thanhnien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentA1A2 = new Intent (Channels.this, MainActivity.class);
                Bundle myBundle1 = new Bundle();
                myBundle1.putInt ("val1", 3);
                myIntentA1A2.putExtras(myBundle1);
                startActivityForResult(myIntentA1A2, 1122);
            }
        });
        Button vietnamnet = (Button) findViewById(R.id.btnVNnet) ;
        vietnamnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentA1A2 = new Intent (Channels.this, MainActivity.class);
                Bundle myBundle1 = new Bundle();
                myBundle1.putInt ("val1", 4);
                myIntentA1A2.putExtras(myBundle1);
                startActivityForResult(myIntentA1A2, 1122);
            }
        });
    }
}