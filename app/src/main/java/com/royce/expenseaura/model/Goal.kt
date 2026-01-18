package com.royce.expenseaura.model

data class Goal(
    val iconRes: Int,        // e.g. R.drawable.ic_bike
    val name: String,        // e.g. "New Bike"
    val amountSaved: Int,    // e.g. 300
    val targetAmount: Int    // e.g. 600
) {
    val progressPercent: Int
        get() = if (targetAmount > 0) (amountSaved * 100) / targetAmount else 0
}

