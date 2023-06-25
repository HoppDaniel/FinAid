package com.example.FinAid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finaid.R;

public class BudgetActivity extends AppCompatActivity {

    private Button addTransactionButton;
    private Button detailsDiagramButton;
    private Button detailsListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_view);

        addTransactionButton = findViewById(R.id.addTransactionButton);
        detailsDiagramButton = findViewById(R.id.detailsDiagramButton);
        detailsListButton = findViewById(R.id.detailsListButton);

        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddTransactionActivity
                Intent intent = new Intent(BudgetActivity.this, AddTransactionActivity.class);
                startActivity(intent);
            }
        });

        detailsDiagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DetailsDiagramActivity
                Intent intent = new Intent(BudgetActivity.this, DetailsDiagramActivity.class);
                startActivity(intent);
            }
        });

        detailsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DetailsListActivity
                Intent intent = new Intent(BudgetActivity.this, DetailsListActivity.class);
                startActivity(intent);
            }
        });
    }
}





