package com.example.FinAid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.FinAid.model.Budget;
import com.example.finaid.R;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder> {

    private List<Budget> budgetList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Budget budget);
    }

    public BudgetAdapter(Context context, List<Budget> budgetList) {
        this.context = context;
        this.budgetList = budgetList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_view, parent, false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        Budget budget = budgetList.get(position);
        holder.budgetName.setText(budget.getName());
        holder.budgetTotalAmount.setText(String.valueOf(budget.getTotalAmount()));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(budget);
            }
        });
    }

    class BudgetViewHolder extends RecyclerView.ViewHolder {
        TextView budgetName;
        TextView budgetTotalAmount;

        BudgetViewHolder(View itemView) {
            super(itemView);
            budgetName = itemView.findViewById(R.id.budgetName);
        }
    }

    @Override
    public int getItemCount() {
        return budgetList.size();
    }
}
