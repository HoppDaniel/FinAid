package com.example.FinAid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaid.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button existingBudgetsButton;
    Button createNewBudgetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view
        );

        existingBudgetsButton = findViewById(R.id.existing_budgets_button);
        createNewBudgetButton = findViewById(R.id.create_new_budget_button);

        existingBudgetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BudgetsActivity.class);
                startActivity(intent);
            }
        });

        createNewBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateBudgetActivity.class);
                startActivity(intent);
            }
        });
    }

}
