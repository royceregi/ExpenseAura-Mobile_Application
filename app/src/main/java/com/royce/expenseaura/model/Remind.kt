package com.royce.expenseaura.model

data class Remind(
    val id: Int,
    val title: String,
    val time: String,
    val iconRes: Int,        // e.g. R.drawable.ic_reminder
    var isEnabled: Boolean   // for switch on/off state
)
