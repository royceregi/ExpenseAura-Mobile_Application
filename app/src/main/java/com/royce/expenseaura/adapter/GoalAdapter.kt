package com.royce.expenseaura.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.royce.expenseaura.R
import com.royce.expenseaura.model.Goal

class GoalAdapter(private val goals: List<Goal>) :
    RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivIcon: ImageView = itemView.findViewById(R.id.iv_goal_icon)
        val tvName: TextView = itemView.findViewById(R.id.tv_goal_name)
        val tvAmount: TextView = itemView.findViewById(R.id.tv_goal_amount)
        val tvProgress: TextView = itemView.findViewById(R.id.tv_goal_progress)
        val progressBar: LinearProgressIndicator = itemView.findViewById(R.id.progress_goal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goals[position]

        holder.ivIcon.setImageResource(goal.iconRes)
        holder.tvName.text = goal.name
        holder.tvAmount.text = "$${goal.amountSaved} / $${goal.targetAmount}"
        holder.tvProgress.text = "${goal.progressPercent}%"

        holder.progressBar.progress = goal.progressPercent
    }

    override fun getItemCount(): Int = goals.size
}