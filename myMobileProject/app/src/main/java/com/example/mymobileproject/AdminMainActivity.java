package com.example.mymobileproject;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminMainActivity extends AppCompatActivity {

    private Button btnViewUsers, btnManageCategories, btnManageProducts, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        btnViewUsers = findViewById(R.id.btnViewUsers);
        btnManageCategories = findViewById(R.id.btnManageCategories);
        btnManageProducts = findViewById(R.id.btnManageProducts);
        btnLogout = findViewById(R.id.btnLogout);

        btnViewUsers.setOnClickListener(view -> {
            // الانتقال إلى شاشة عرض المستخدمين
        });

        btnManageCategories.setOnClickListener(view -> {
            // الانتقال إلى شاشة إدارة الفئات
        });

        btnManageProducts.setOnClickListener(view -> {
            // الانتقال إلى شاشة إدارة المنتجات
        });

        btnLogout.setOnClickListener(view -> {
            // إنهاء الجلسة والعودة إلى شاشة تسجيل الدخول
            finish();
        });
    }
}

