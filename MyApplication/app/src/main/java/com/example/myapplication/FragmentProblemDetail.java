package com.example.myapplication;

import static android.app.appsearch.AppSearchResult.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.FragmentProblemDetailBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import javax.xml.transform.Result;


public class FragmentProblemDetail extends Fragment {

//    View v;
//    ImageView closeProblem;
//    CardView inputImg;
//    ImageView imageView;
//    ImageView succeful;
//    FragmentProblemDetailBinding binding;
//
//    FirebaseStorage storage;
//    Uri imageUri;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = FragmentProblemDetailBinding.inflate(getLayoutInflater());
//        binding.getRoot();
//        storage = FirebaseStorage.getInstance();
//
//    }
//
//    private void uploadImage() {
//
//        if (imageUri != null)
//        {
//            StorageReference reference = storage.getReference().child("images/" + UUID.randomUUID().toString());
//            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//                    if (task.isSuccessful()){
//                        Toast.makeText(getContext(), "Image Uploaded Successffully!", Toast.LENGTH_LONG).show();
//                    }else {
//                        Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//        }
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_problem_detail, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        this.v = view;
//        init();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mGetContent.launch("image/*");
//            }
//        });
//
//        succeful.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                uploadImage();
//
//            }
//        });
//        closeProblem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(getActivity(), R.id.navHostFragment).navigate(R.id.fragment1);
//            }
//        });
//        inputImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
////        succeful.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(getContext(), "Отправка прошла успешно!", Toast.LENGTH_LONG).show();
////                Navigation.findNavController(getActivity(), R.id.navHostFragment).navigate(R.id.fragment1);
////            }
////        });
//    }
//
//    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
//            new ActivityResultCallback<Uri>() {
//                @Override
//                public void onActivityResult(Uri result) {
//
//                    if (result != null)
//                    {
//                        imageView.setImageURI(result);
//                        imageUri = result;
//                    }
//
//                }
//            });
//
//    public void init(){
//        closeProblem = v.findViewById(R.id.closeProblem);
//        inputImg = v.findViewById(R.id.inputImg);
//        imageView = v.findViewById(R.id.imageView2);
//        succeful = v.findViewById(R.id.succeful);
//    }


}