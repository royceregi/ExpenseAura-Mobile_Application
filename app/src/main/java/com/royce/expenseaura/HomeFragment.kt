// Fixed HomeFragment.kt
package com.royce.expenseaura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

//        val btnRemind: Button = view.findViewById(R.id.btn_remind)
//        val btnBudget: Button = view.findViewById(R.id.btn_budget)
//
//        btnRemind.setOnClickListener {
//            parentFragmentManager.commit {
//                replace(R.id.fragment_container, RemindFragment())
//                addToBackStack(null)
//            }
//        }
//
//        btnBudget.setOnClickListener {
//            parentFragmentManager.commit {
//                replace(R.id.fragment_container, ExpenseFragment())
//                addToBackStack(null)
//            }
//        }

        return view
    }
}
