package com.royce.expenseaura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.royce.expenseaura.adapter.GoalAdapter
import com.royce.expenseaura.adapter.TransactionAdapter
import com.royce.expenseaura.model.Goal
import com.royce.expenseaura.model.Transaction

class ExpenseFragment : Fragment(R.layout.fragment_expense) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ---------------- Goals ----------------
        val rvGoals = view.findViewById<RecyclerView>(R.id.rv_goals)

        val goals = listOf(
            Goal(R.drawable.ic_bike, "New Bike", 300, 600),
            Goal(R.drawable.ic_expense, "Emergency Fund", 150, 1000),
            Goal(R.drawable.ic_transactions, "Vacation Trip", 200, 800)
        )

        rvGoals.layoutManager = LinearLayoutManager(requireContext())
        rvGoals.adapter = GoalAdapter(goals)

        val emptyGoalsLayout = view.findViewById<View>(R.id.layout_empty_goals)
        if (goals.isEmpty()) {
            rvGoals.visibility = View.GONE
            emptyGoalsLayout.visibility = View.VISIBLE
        } else {
            rvGoals.visibility = View.VISIBLE
            emptyGoalsLayout.visibility = View.GONE
        }

        // ---------------- Transactions ----------------
        val rvTransactions = view.findViewById<RecyclerView>(R.id.rv_transactions)

        val transactions = listOf(
            Transaction("Grocery Shopping", "Food", "15 Jun 2023", -45.75),
            Transaction("Salary", "Income", "01 Jun 2023", 1500.00),
            Transaction("Netflix", "Entertainment", "10 Jun 2023", -12.99)
        )

        rvTransactions.layoutManager = LinearLayoutManager(requireContext())
        rvTransactions.adapter = TransactionAdapter(transactions)

        val emptyTransactionsLayout = view.findViewById<View>(R.id.layout_empty_transactions)
        if (transactions.isEmpty()) {
            rvTransactions.visibility = View.GONE
            emptyTransactionsLayout.visibility = View.VISIBLE
        } else {
            rvTransactions.visibility = View.VISIBLE
            emptyTransactionsLayout.visibility = View.GONE
        }
    }
}
