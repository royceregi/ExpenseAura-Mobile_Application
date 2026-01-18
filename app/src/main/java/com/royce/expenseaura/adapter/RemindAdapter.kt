package com.royce.expenseaura.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.royce.expenseaura.R
import com.royce.expenseaura.model.Remind

class RemindAdapter(
    private var reminders: MutableList<Remind>,
    private val onToggle: (Remind, Boolean) -> Unit
) : RecyclerView.Adapter<RemindAdapter.RemindViewHolder>() {

    inner class RemindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iv_reminder_icon)
        val title: TextView = itemView.findViewById(R.id.tv_reminder_title)
        val time: TextView = itemView.findViewById(R.id.tv_reminder_time)
        val switch: SwitchCompat = itemView.findViewById(R.id.switch_reminder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemindViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reminder, parent, false)
        return RemindViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemindViewHolder, position: Int) {
        val reminder = reminders[position]

        holder.icon.setImageResource(reminder.iconRes)
        holder.title.text = reminder.title
        holder.time.text = reminder.time
        holder.switch.isChecked = reminder.isEnabled

        holder.switch.setOnCheckedChangeListener(null) // clear old listener
        holder.switch.isChecked = reminder.isEnabled

        holder.switch.setOnCheckedChangeListener { _, isChecked ->
            reminder.isEnabled = isChecked
            onToggle(reminder, isChecked) // callback to fragment
        }
    }

    override fun getItemCount(): Int = reminders.size

    fun updateList(newList: List<Remind>) {
        reminders.clear()
        reminders.addAll(newList)
        notifyDataSetChanged()
    }
}
