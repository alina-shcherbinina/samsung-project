package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        list = new ArrayList<>();

        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] desc = res.getStringArray(R.array.desc);
        for (int i=0; i<12; i++) {
            list.add(new ItemClass(getResources().getIdentifier("const_"+i+".jpg", "drawable", "samsungproject"),
                    titles[i],
                    desc[i]));
        }

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Adapter adapter = new Adapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}