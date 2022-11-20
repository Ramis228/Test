package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment2 extends Fragment {

    ImageView closeBtn;
    ConstraintLayout vod;
    ConstraintLayout dor;
    ConstraintLayout mus;
    ConstraintLayout osv;
    public static String tema;
    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;
        init();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.navHostFragment).navigate(R.id.fragment1);
            }
        });
        vod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema = "Водоканал";
                Intent intent = new Intent(getContext(),ActivityProblemdetail.class);
                startActivity(intent);
            }
        });
        dor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema = "Дорога";
                Intent intent = new Intent(getContext(),ActivityProblemdetail.class);
                startActivity(intent);
            }
        });
        mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema = "Мусорные баки";
                Intent intent = new Intent(getContext(),ActivityProblemdetail.class);
                startActivity(intent);
            }
        });
        osv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tema = "Освещение";
                Intent intent = new Intent(getContext(),ActivityProblemdetail.class);
                startActivity(intent);
            }
        });
    }

    public void init(){
        closeBtn = v.findViewById(R.id.closeBtn);
        vod = v.findViewById(R.id.vod);
        dor = v.findViewById(R.id.dor);
        mus = v.findViewById(R.id.mus);
        osv = v.findViewById(R.id.osv);
    }
}