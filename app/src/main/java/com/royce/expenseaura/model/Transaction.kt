package com.royce.expenseaura.model

data class Transaction(
    val title: String,
    val category: String,
    val date: String,
    val amount: Double
)
