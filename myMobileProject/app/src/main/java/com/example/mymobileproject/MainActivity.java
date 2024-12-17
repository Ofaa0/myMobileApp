package com.example.mymobileproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnSignUp, btnSearch, btnCategories, btnAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSearch = findViewById(R.id.btnSearch);
        btnCategories = findViewById(R.id.btnCategories);
        btnAdminLogin = findViewById(R.id.btnAdminLogin); // الزر لتسجيل الدخول كـ "مدير"

        btnLogin.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        btnSignUp.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));

        btnSearch.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SearchActivity.class)));

        btnCategories.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CategoriesActivity.class)));

        // فتح شاشة تسجيل الدخول كـ "مدير" عند الضغط على الزر
        btnAdminLogin.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AdminMainActivity.class)));
    }
}
