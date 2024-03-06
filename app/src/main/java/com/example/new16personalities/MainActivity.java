package com.example.new16personalities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    ArrayList<Personality> personalityArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personalityArrayList=Personality.getPersonalities("personalities.json",this);
        mRecyclerview=findViewById(R.id.recyclerView);
        PersonalityAdapter adapter=new PersonalityAdapter(personalityArrayList);
        mRecyclerview.setAdapter(adapter);
        //mRecyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));


    }
}