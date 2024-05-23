package com.mirea.kt.practical2_10;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlantAdapter plantAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DBHelper(this);
        ArrayList<Plant> plantList = dbHelper.getAllPlants();

        plantAdapter = new PlantAdapter(plantList);
        recyclerView.setAdapter(plantAdapter);
    }
}
