package com.royce.expenseaura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.royce.expenseaura.adapter.RemindAdapter
import com.royce.expenseaura.databinding.FragmentRemindBinding
import com.royce.expenseaura.model.Remind

class RemindFragment : Fragment() {
    private var _binding: FragmentRemindBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var activeAdapter: RemindAdapter
    private lateinit var recurringAdapter: RemindAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRemindBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        setupClickListeners()
    }

    private fun setupRecyclerViews() {
        // Sample data for active reminders
        val activeReminders = listOf(
            Remind(1, "Budget Alert", "Daily at 9:00 AM", R.drawable.ic_reminder, true),
            Remind(2, "Water Bill", "1st of every month", R.drawable.ic_reminder, false)
        )

        // Sample data for recurring reminders
        val recurringReminders = listOf(
            Remind(3, "Workout", "Daily at 6:00 AM", R.drawable.ic_reminder, true)
        )

        // Setup active reminders RecyclerView
        activeAdapter = RemindAdapter(activeReminders.toMutableList()) { reminder, isChecked ->
            showToast("${reminder.title} ${if (isChecked) "enabled" else "disabled"}")
        }

        binding.rvActiveReminders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = activeAdapter
        }

        // Setup recurring reminders RecyclerView
        recurringAdapter = RemindAdapter(recurringReminders.toMutableList()) { reminder, isChecked ->
            showToast("${reminder.title} ${if (isChecked) "enabled" else "disabled"}")
        }

        binding.rvRecurringReminders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recurringAdapter
        }

        // Show/hide empty states
        updateEmptyStates(activeReminders, recurringReminders)
    }

    private fun setupClickListeners() {
        binding.fabAddReminder.setOnClickListener {
            showToast("Add new reminder clicked")
            // TODO: Implement add new reminder functionality
        }
    }

    private fun updateEmptyStates(active: List<Remind>, recurring: List<Remind>) {
        binding.apply {
            if (active.isEmpty()) {
                rvActiveReminders.visibility = View.GONE
                layoutEmptyActiveReminders.root.visibility = View.VISIBLE
            } else {
                rvActiveReminders.visibility = View.VISIBLE
                layoutEmptyActiveReminders.root.visibility = View.GONE
            }

            if (recurring.isEmpty()) {
                rvRecurringReminders.visibility = View.GONE
                layoutEmptyRecurringReminders.root.visibility = View.VISIBLE
            } else {
                rvRecurringReminders.visibility = View.VISIBLE
                layoutEmptyRecurringReminders.root.visibility = View.GONE
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}