package com.example.sam01.a4_buresh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder>{
    private ArrayList<Album> albumList;
    private final int[] coverList;
    static int albumPosition;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, artist;
        public ImageView cover;

        public MyViewHolder(View view) {
            super(view);
            cover = view.findViewById(R.id.cover);
            title = view.findViewById(R.id.title);
            artist = view.findViewById(R.id.artist);
            year = view.findViewById(R.id.year);
            mContext = itemView.getContext();
        }
    }

    public AlbumAdapter(int[] coverList, ArrayList<Album> albumList) {
        this.coverList = coverList;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.albumlist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.cover.setImageResource(coverList[position]);
        holder.title.setText(album.getTitle());
        holder.artist.setText(album.getArtist());
        holder.year.setText(album.getYear());

        //Gathers information of the selected album and sends it to Main2Activity.java
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                albumPosition = position;
                Album album = albumList.get(position);
                Toast.makeText(mContext, album.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, Main2Activity.class);
                intent.putExtra("Album", albumPosition);
                intent.putExtra("Album_Title", album.getTitle());
                intent.putExtra("Album_Artist", album.getArtist());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
