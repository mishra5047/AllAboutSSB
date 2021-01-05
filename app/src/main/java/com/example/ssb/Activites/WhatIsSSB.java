package com.example.ssb.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ssb.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class WhatIsSSB extends Activity {

    LinearLayout knowMoreLay;
    ImageView imageBanner;
    TextView txtBottom;
    WhatIsSSBItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is_s_s_b);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            item = snapshot.getValue(WhatIsSSBItem.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        knowMoreLay = findViewById(R.id.layKnowMore);
        imageBanner = findViewById(R.id.imgBanner);
        txtBottom = findViewById(R.id.txtInfo);

//        Picasso.get().load(item.getImgUrl()).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                imageBanner.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bitmap));
//            }
//
//            @Override
//            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//            }
//        });
//
//        txtBottom.setText(item.getTextInfo());

        knowMoreLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), OLQDetails.class);
            startActivity(intent);
            }
        });
    }

    //Class to fetch Data from Firebase
    static class WhatIsSSBItem{
        String imgUrl, textInfo;

        public WhatIsSSBItem() {
        }

        public WhatIsSSBItem(String imgUrl, String textInfo) {
            this.imgUrl = imgUrl;
            this.textInfo = textInfo;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public String getTextInfo() {
            return textInfo;
        }
    }
}
