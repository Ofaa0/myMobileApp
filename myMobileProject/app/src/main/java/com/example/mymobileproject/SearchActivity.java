package com.example.mymobileproject;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearch;
    private RecyclerView rvSearchResults;
    private ProductAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.etSearch);
        rvSearchResults = findViewById(R.id.rvSearchResults);

        rvSearchResults.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DatabaseHelper(this);

        findViewById(R.id.btnSearch).setOnClickListener(v -> searchProducts());
    }

    private void searchProducts() {
        String query = etSearch.getText().toString().trim();
        if (!TextUtils.isEmpty(query)) {
            List<Product> searchResults = databaseHelper.searchProducts(query);
            if (searchResults.isEmpty()) {
                Toast.makeText(this, "No products found!", Toast.LENGTH_SHORT).show();
            } else {
                adapter = new ProductAdapter(searchResults);
                rvSearchResults.setAdapter(adapter);
            }
        } else {
            Toast.makeText(this, "Enter a search query!", Toast.LENGTH_SHORT).show();
        }
    }
}
