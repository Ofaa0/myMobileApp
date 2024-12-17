package com.example.mymobileproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private ListView lvCategories;
    private DatabaseHelper databaseHelper;
    private List<Category> categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        lvCategories = findViewById(R.id.lvCategories);
        databaseHelper = new DatabaseHelper(this);

        categoriesList = databaseHelper.getAllCategories();

        if (categoriesList.isEmpty()) {
            Toast.makeText(this, "No categories available!", Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter<Category> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesList);
            lvCategories.setAdapter(adapter);
            lvCategories.setOnItemClickListener((parent, view, position, id) -> {
                Category category = categoriesList.get(position);
                Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
                intent.putExtra("categoryId", category.getId());
                startActivity(intent);
            });
        }
    }
}

