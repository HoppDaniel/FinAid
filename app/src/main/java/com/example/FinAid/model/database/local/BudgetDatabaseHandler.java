package com.example.FinAid.model.database.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.FinAid.model.Budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetDatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BudgetDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public BudgetDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BUDGET_TABLE = "CREATE TABLE Budgets (id INTEGER PRIMARY KEY, name TEXT, totalAmount REAL)";
        db.execSQL(CREATE_BUDGET_TABLE);

        String CREATE_TRANSACTION_TABLE = "CREATE TABLE Transactions (id INTEGER PRIMARY KEY, budgetId INTEGER, name TEXT, amount REAL, type TEXT)";
        db.execSQL(CREATE_TRANSACTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Budgets");
        db.execSQL("DROP TABLE IF EXISTS Transactions");
        onCreate(db);
    }

    public List<Budget> getAllBudgets() {
        List<Budget> budgets = new ArrayList<>();

        String selectQuery = "SELECT  * FROM Budgets";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Budget budget = new Budget();
                budget.setId(cursor.getInt(0));
                budget.setName(cursor.getString(1));
                budget.setTotalAmount(cursor.getDouble(2));
                // Adding budget to list
                budgets.add(budget);
            } while (cursor.moveToNext());
        }

        return budgets;
    }

}
