package com.example.ssb.Activites;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ssb.Adapters.HomeOptions.HomeOptionAdapter;
import com.example.ssb.Adapters.HomeOptions.homeItem;
import com.example.ssb.R;

import java.util.ArrayList;

public class HomeActivity extends Activity {
    //Header Layout Element's
    TextView infoTop;
    LinearLayout infoLayout;

    //Options Recycler View
    RecyclerView recOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        //header layout
        infoTop = findViewById(R.id.txtTop);
        infoLayout = findViewById(R.id.layKnowMore);
        
        infoTop.setText(getResources().getString(R.string.text_info));
        infoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODo                
            }
        });

        //options recycler
        recOptions = findViewById(R.id.recyclerHome);
        recOptions.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        ArrayList<homeItem> list = new ArrayList<>();
        list.add(new homeItem(R.drawable.question, "What's SSB"));
        list.add(new homeItem(R.drawable.event, "The Schedule"));
        list.add(new homeItem(R.drawable.base, "About Centres"));
        list.add(new homeItem(R.drawable.ic_info, "Coming Soon"));

        HomeOptionAdapter adapter = new HomeOptionAdapter(getApplicationContext(), list);
        recOptions.setAdapter(adapter);
    }
}