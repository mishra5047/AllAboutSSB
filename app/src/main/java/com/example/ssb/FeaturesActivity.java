package com.example.ssb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class FeaturesActivity extends Activity {

    FloatingActionButton fab;
    SliderView sliderView;
    ArrayList<SliderItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        fab = findViewById(R.id.fab);
        sliderView = findViewById(R.id.imageSlider);

        list = new ArrayList<>();
        String imgLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9H--XGm8TAnyY-MP6RBbUJzsx1XZoNuOK1A&usqp=CAU";
        ArrayList<String> strings = new ArrayList<>();
                strings.add("First");
                strings.add("Second");
                strings.add("Third");
                strings.add("Fourth");
        String data = getResources().getString(R.string.lorem_ipsum);

        list.add(new SliderItem(imgLink, strings.get(0), data));
        list.add(new SliderItem(imgLink,strings.get(1), data));
        list.add(new SliderItem(imgLink,strings.get(2), data));
        list.add(new SliderItem(imgLink,strings.get(3), data));
        setViews();
    }

    private ArrayList<SliderItem> fetchFromDB() {

        ArrayList<SliderItem> fetchList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Features/");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    SliderItem item = snapshot.getValue(SliderItem.class);
                    fetchList.add(item);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Toast.makeText(getApplicationContext(), "list size is " + fetchList.size(), Toast.LENGTH_SHORT).show();
        return fetchList;
    }

    private void setViews() {


        sliderView.setSliderAdapter(new SliderAdapter(getApplicationContext(), list));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            }
        });
    }
}