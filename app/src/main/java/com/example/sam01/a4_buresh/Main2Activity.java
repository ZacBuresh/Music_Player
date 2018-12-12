package com.example.sam01.a4_buresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.sam01.a4_buresh.AlbumAdapter.albumPosition;
import static com.example.sam01.a4_buresh.MainActivity.albumList;
import static com.example.sam01.a4_buresh.MainActivity.coverList;

//Description: This activity shows the cover, title, artist, and track list of the selected album.

public class Main2Activity extends AppCompatActivity {

    ArrayList<ArrayList> albums = new ArrayList<ArrayList>();

    ArrayList underPressureList = new ArrayList<String>();
    ArrayList astroworldList = new ArrayList<String>();
    ArrayList internetList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        underPressureList.add("1.  Intro                                                              3:03");
        underPressureList.add("2.  Sould Food                                                  4:53");
        underPressureList.add("3.  I'm Gone                                                       4:42");
        underPressureList.add("4.  Gang Related                                               2:47");
        underPressureList.add("5.  Buried Alive                                                 5:38");
        underPressureList.add("6.  Bounce                                                         4:05");
        underPressureList.add("7.  Growing Pains III                                        4:07");
        underPressureList.add("8.  Never Enough                                             4:23");
        underPressureList.add("9.  Metropolis                                                   4:55");
        underPressureList.add("10. Nikki                                                            3:24");
        underPressureList.add("11. Under Pressure                                          9:20");
        underPressureList.add("12. Till the End                                                 5:12");
        underPressureList.add("13. Driving Ms. Daisy                                      4:01");
        underPressureList.add("14. Now                                                            3:33");
        underPressureList.add("15. Alright                                                        3:38");

        astroworldList.add("1.  Stargrazing                                                  4:31");
        astroworldList.add("2.  Carousel                                                       3:00");
        astroworldList.add("3.  Sicko Mode                                                  5:12");
        astroworldList.add("4.  R.I.P. Screw                                                  3:05");
        astroworldList.add("5.  Stop Trying to Be God                                5:38");
        astroworldList.add("6.  No Bystanders                                             3:38");
        astroworldList.add("7.  Skeletons                                                     2:25");
        astroworldList.add("8.  Wake Up                                                       3:52");
        astroworldList.add("9.  5% Tint                                                          3:16");
        astroworldList.add("10. NC-17                                                           2:37");
        astroworldList.add("11. Astrothunder                                              2:23");
        astroworldList.add("12. Yosemite                                                     2:30");
        astroworldList.add("13. Can't Say                                                     3:18");
        astroworldList.add("14. Who? What!                                                2:56");
        astroworldList.add("15. Butterfly Effect                                           3:11");
        astroworldList.add("16. Houstonfornication                                   3:38");
        astroworldList.add("17. Coffee Bean                                                3:29");

        internetList.add("1.  The Library (Intro)                                        0:04");
        internetList.add("2.  I. Crawl                                                           3:29");
        internetList.add("3.  II. Worldstar                                                  4:04");
        internetList.add("4.  Dial Up                                                           0:44");
        internetList.add("5.  I. The Worst Guys                                        3:39");
        internetList.add("6.  II. Shadows                                                   3:51");
        internetList.add("7.  III. Telegraph Ave.                                        3:30");
        internetList.add("8.  IV. Sweatpants                                             3:00");
        internetList.add("9.  V. 3005                                                          3:54");
        internetList.add("10. Playing Around Before the Party Starts  0:54");
        internetList.add("11. I. The Party                                                  1:31");
        internetList.add("12. II. No Exit                                                     2:51");
        internetList.add("13. Death by Number                                       0:43");
        internetList.add("14. I. Flight of the Navigator                           5:44");
        internetList.add("15. II. Zealots of Stockholm                           4:50");
        internetList.add("16. III. Urn                                                          1:13");
        internetList.add("17. I. Pink Toes                                                 3:27");
        internetList.add("18. II. Earth: The Oldest Computer                4:42");
        internetList.add("19. III. Life: The Biggest Troll                          5:42");

        albums.add(underPressureList);
        albums.add(astroworldList);
        albums.add(internetList);

        getAlbum();
    }

    private void getAlbum(){
        //Get information from the selected album
        Integer album = getIntent().getIntExtra("Album", albumPosition);
        String title = getIntent().getStringExtra("Album_Title");
        String artist = getIntent().getStringExtra("Album_Artist");

        ImageView albumCover = findViewById(R.id.imageView);

        TextView albumTitle = findViewById(R.id.albumTitle);
        albumTitle.setText(title);
        TextView artistName = findViewById(R.id.artistName);
        artistName.setText(artist);

        ListView songList = findViewById(R.id.songList);

        if("Under Pressure" == albumList.get(album).getTitle()) {
            albumCover.setImageResource(coverList[album]);
            ArrayAdapter songAdapter =
                    new ArrayAdapter(this, R.layout.song_label, underPressureList);
            songList.setAdapter(songAdapter);
        }
        else if("Astroworld"== albumList.get(album).getTitle()) {
            albumCover.setImageResource(coverList[album]);
            ArrayAdapter songAdapter =
                    new ArrayAdapter(this, R.layout.song_label, astroworldList);
            songList.setAdapter(songAdapter);
        }
        else if("Because The Internet"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
            ArrayAdapter songAdapter =
                    new ArrayAdapter(this, R.layout.song_label, internetList);
            songList.setAdapter(songAdapter);
        }
        else if("Life of a Dark Rose"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
        }
        else if("Goodbye & Good Riddance"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
        }
        else if("SYRE"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
        }
        else if("Views"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
        }
        else if("To Pimp a Butterfly"== albumList.get(album).getTitle()){
            albumCover.setImageResource(coverList[album]);
        }
        else{
            Toast.makeText(this, title + " Doesn't Exist", Toast.LENGTH_SHORT).show();
        }

    }

}
