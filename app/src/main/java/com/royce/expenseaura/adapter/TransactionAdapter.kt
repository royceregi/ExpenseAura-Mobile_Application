package com.royce.expenseaura.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.royce.expenseaura.R
import com.royce.expenseaura.model.Transaction

class TransactionAdapter(
    private val transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    // ViewHolder
    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: MaterialCardView = itemView.findViewById(R.id.transaction_card)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val category: TextView = itemView.findViewById(R.id.tv_category)
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val amount: TextView = itemView.findViewById(R.id.tv_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transactions, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]

        holder.title.text = transaction.title
        holder.category.text = transaction.category
        holder.date.text = transaction.date

        // Amount formatting
        val amountText = if (transaction.amount < 0) {
            "-$${String.format("%.2f", Math.abs(transaction.amount))}"
        } else {
            "+$${String.format("%.2f", transaction.amount)}"
        }
        holder.amount.text = amountText

        // Color for income vs expense
        val context = holder.itemView.context
        if (transaction.amount < 0) {
            holder.amount.setTextColor(context.getColor(R.color.colorAccent)) // Expense
        } else {
            holder.amount.setTextColor(context.getColor(R.color.colorGradientStart)) // Income
        }
    }

    override fun getItemCount(): Int = transactions.size
}