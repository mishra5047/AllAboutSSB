package com.example.ssb.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ssb.Adapters.CardStack.CardStackAdapter;
import com.example.ssb.Adapters.HomeSlider.SliderItem;
import com.example.ssb.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;

public class OLQDetails extends Activity {
    static CardStackView stackView;
   static ArrayList<SliderItem> list;
    FloatingActionButton refresh;
   static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_l_q_details);
        stackView = findViewById(R.id.stackView);
        context = getApplicationContext();
        refresh = findViewById(R.id.refreshFab);
        setList();
        setStackView();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setList();
                setStackView();
            }
        });
    }
    static void setList(){
        list = new ArrayList<>();
        String imgLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9H--XGm8TAnyY-MP6RBbUJzsx1XZoNuOK1A&usqp=CAU";
        ArrayList<String> strings = new ArrayList<>();
        strings.add("First");
        strings.add("Second");
        strings.add("Third");
        strings.add("Fourth");

        String data = context.getResources().getString(R.string.lorem_ipsum);

        list.add(new SliderItem(imgLink, strings.get(0), data));
        list.add(new SliderItem(imgLink,strings.get(1), data));
        list.add(new SliderItem(imgLink,strings.get(2), data));
        list.add(new SliderItem(imgLink,strings.get(3), data));

    }
    static void setStackView(){
        CardStackLayoutManager manager = new CardStackLayoutManager(context);
        stackView.setLayoutManager(manager);
        stackView.setAdapter(new CardStackAdapter(list, context));
        stackView.rewind();
        manager.setStackFrom(StackFrom.Top);
        manager.setVisibleCount(3);
        manager.setDirections(Direction.FREEDOM);
    }
}