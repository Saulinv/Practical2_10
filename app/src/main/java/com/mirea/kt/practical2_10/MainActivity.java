package com.mirea.kt.practical2_10;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextSpecies;
    private Switch switchGreenhouse;
    private DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSpecies = findViewById(R.id.editTextSpecies);
        switchGreenhouse = findViewById(R.id.switchGreenhouse);

        dbHelper = new DBHelper(this);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v -> savePlant());
        Log.d("MY_LOG","Saulin Ivan RIBO-01-22 VR-4");
        Button buttonViewPlants = findViewById(R.id.buttonViewPlants);
        buttonViewPlants.setOnClickListener(this::viewPlants);
    }

    private void savePlant() {
        String name = editTextName.getText().toString();
        String species = editTextSpecies.getText().toString();
        boolean isGreenhouse = switchGreenhouse.isChecked();

        if (name.isEmpty() || species.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Plant plant = new Plant(name, species, isGreenhouse);
        dbHelper.savePlant(plant);
        Toast.makeText(this, "Plant saved", Toast.LENGTH_SHORT).show();
    }

    public void viewPlants(View view) {
        Intent intent = new Intent(this, PlantActivity.class);
        startActivity(intent);
    }
}


