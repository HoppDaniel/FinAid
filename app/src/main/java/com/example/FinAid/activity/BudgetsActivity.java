package com.example.FinAid.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.FinAid.adapter.BudgetAdapter;
import com.example.FinAid.model.Budget;
import com.example.FinAid.model.database.local.BudgetDatabaseHandler;
import com.example.finaid.R;

import java.util.ArrayList;
import java.util.List;

public class BudgetsActivity extends AppCompatActivity {

    private RecyclerView budgetsRecyclerView;
    private BudgetAdapter budgetAdapter;
    private List<Budget> budgets;
    private BudgetDatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budgets_view);

        budgetsRecyclerView = findViewById(R.id.budgetsRecyclerView);

        // Initialize the database handler
        dbHandler = new BudgetDatabaseHandler(this);

        // Initialize the budgets list and fill it with data from the database
        budgets = dbHandler.getAllBudgets();

        budgetAdapter = new BudgetAdapter(this, budgets);

        // Set an OnClickListener to handle when a budget is selected
        budgetAdapter.setOnItemClickListener(new BudgetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Budget budget) {
                // Here you can start a new Activity for the selected budget.
                // For example:
                Intent intent = new Intent(BudgetsActivity.this, BudgetActivity.class);
                intent.putExtra("budget_id", budget.getId());
                startActivity(intent);
            }
        });

        budgetsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        budgetsRecyclerView.setAdapter(budgetAdapter);
    }
}
