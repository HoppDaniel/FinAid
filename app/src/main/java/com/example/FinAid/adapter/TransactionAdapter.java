package com.example.FinAid.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.FinAid.model.Transaction;
import com.example.finaid.R;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Transaction> transactionList;
    private Activity activity;

    public TransactionAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_view, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Transaction transaction = transactionList.get(position);
        holder.transactionName.setText(transaction.getName());
        holder.transactionAmount.setText(String.valueOf(transaction.getAmount()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView transactionAmount;
        TextView transactionName;

        ViewHolder(View view) {
            super(view);
            transactionAmount = view.findViewById(R.id.your_transaction_amount_id);
            transactionName = view.findViewById(R.id.your_transaction_name_id);
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public void setTransactions(List<Transaction> transactionList) {
        this.transactionList = transactionList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView transactionAmount;
        TextView transactionName;

        ViewHolder(View view) {
            super(view);
            transactionAmount = view.findViewById(R.id.);
            transactionName = view.findViewById(R.id.your_transaction_name_id);
        }
    }
}
