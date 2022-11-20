package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class Parse_Adapter_Fragment extends Fragment {

    private ArrayList<ParseItem> parseItems;
    private Context context;

    public static String image;
    Book book;

    public Parse_Adapter_Fragment(ArrayList<ParseItem> parseItems, Context context){
        this.parseItems = parseItems;
        this.context = context;
    }



    View v;


    @NonNull

    public Parse_Adapter_Fragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_parse__item_, parent, false);
        this.v = view;
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParseItem parseItem = parseItems.get(position);
        Picasso.get().load(book.imgUrl).into(holder.imageView);
    }


    public int getItemCount() {
        return parseItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View view) {
            super(view);
            imageView = itemView.findViewById(R.id.imageView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            int position = getBindingAdapterPosition();
//            ParseItem parseItem = parseItems.get(position);

//            MAIN.navController.navigate((R.id.action_educationEventFragment_to_detailEducationEventFragment));

            image = book.imgUrl;


        }
    }
}