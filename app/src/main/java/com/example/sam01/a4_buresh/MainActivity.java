package com.example.sam01.a4_buresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

//Author: Zachary Buresh
//Date: 10/18/2018
//Description: This program shows multiple music albums in a recycler view. The user can click
//             one of the albums to start a new activity that contains information about the album
//             including the album cover, title, artist, and track list.

public class MainActivity extends AppCompatActivity {

    static ArrayList<Album> albumList = new ArrayList<>();
    private AlbumAdapter aAdapter;

    static int[] coverList = new int[]{
            R.drawable.underpressure,
            R.drawable.astroworld,
            R.drawable.becausetheinternet,
            R.drawable.darkrose,
            R.drawable.goodbye,
            R.drawable.syre,
            R.drawable.views,
            R.drawable.topimp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        aAdapter = new AlbumAdapter(coverList, albumList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);
        prepareMovieData();
    }

    private void prepareMovieData(){
        Album album = new Album("Under Pressure", "Logic", "2014");
        albumList.add(album);

        Album album2 = new Album("Astroworld", "Travis Scott", "2018");
        albumList.add(album2);

        Album album3 = new Album("Because The Internet", "Childish Gambino", "2013");
        albumList.add(album3);

        Album album4 = new Album("Life of a Dark Rose", "Lil Skies", "2018");
        albumList.add(album4);

        Album album5 = new Album("Goodbye & Good Riddance", "Juice WRLD", "2018");
        albumList.add(album5);

        Album album6 = new Album("SYRE", "Jaden Smith", "2017");
        albumList.add(album6);

        Album album7 = new Album("Views", "Drake", "2016");
        albumList.add(album7);

        Album album8 = new Album("To Pimp a Butterfly", "Kendrick Lamar", "2015");
        albumList.add(album8);

        aAdapter.notifyDataSetChanged();
    }
}
