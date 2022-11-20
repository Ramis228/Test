package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import static com.example.myapplication.Fragment2.tema;

public class ActivityProblemdetail extends AppCompatActivity {

    ImageView closeBtn;
    ImageView successfull;
    ImageView imageView;

    private String imgUrl="sada";
    private String razdel = Fragment2.tema;
    private String BOOK_KEY = "Book";


    TextInputEditText prob;
    TextInputEditText adress;

    private DatabaseReference mDataBase;
    private StorageReference storageReference;

    private Uri uploadUri= Uri.parse("http://ru.wikipedia.org/w/index.php?title=URI");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problemdetail);
        init();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityProblemdetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
        successfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadImage();




            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImage();
            }
        });


    }
    public void init(){

        storageReference = FirebaseStorage.getInstance().getReference("ImageDB");

        closeBtn = findViewById(R.id.closeProblem);
        successfull = findViewById(R.id.succeful);
        imageView = findViewById(R.id.foto);

        prob = findViewById(R.id.inputProb);
        adress = findViewById(R.id.inputAdres);

        mDataBase = FirebaseDatabase.getInstance().getReference(BOOK_KEY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Image URI : " + data.getData(), Toast.LENGTH_LONG).show();
        imageView.setImageURI(data.getData());
//        imgUrl = data.getData().toString();
    }

    protected void uploadImage()
    {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        final StorageReference mRef = storageReference.child(System.currentTimeMillis() + "my_image");
        UploadTask up = mRef.putBytes(byteArray);
        Task<Uri> task = up.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                return mRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                uploadUri = task.getResult();
                Toast.makeText(ActivityProblemdetail.this, "Фото успешно загруженно!", Toast.LENGTH_LONG).show();
                imgUrl=uploadUri.toString();
                Book book = new Book(imgUrl,razdel,47.499537,42.974124);
                mDataBase.push().setValue(book);
                Intent intent = new Intent(ActivityProblemdetail.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getImage()
    {
        Intent intentChooser = new Intent();
        intentChooser.setType("image/*");
        intentChooser.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentChooser, 100);
    }

}