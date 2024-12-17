package com.example.mymobileproject;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private ProductAdapter adapter;
    private com.example.mymobileproject.DatabaseHelper databaseHelper;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new com.example.mymobileproject.DatabaseHelper(this);

        int categoryId = getIntent().getIntExtra("categoryId", -1);

        if (categoryId != -1) {
            productList = databaseHelper.getProductsByCategory(categoryId);

            if (productList.isEmpty()) {
                Toast.makeText(this, "No products available for this category!", Toast.LENGTH_SHORT).show();
            } else {
                adapter = new ProductAdapter(productList);
                rvProducts.setAdapter(adapter);
            }
        } else {
            Toast.makeText(this, "Invalid category selected!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

