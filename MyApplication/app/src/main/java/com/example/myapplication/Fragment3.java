package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    View v;
    public String Url;
    public static DatabaseReference firebaseDatabase;
    List<Book> listBook;
    Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        getFromDB();

        this.v = view;


        listBook = new ArrayList<>();


    }

    public void getFromDB() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (listBook.size() > 0) listBook.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    book = ds.getValue(Book.class);
                    book = ds.getValue(Book.class);
                    listBook.add(book);
                    Url = book.imgUrl.toString();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    }}