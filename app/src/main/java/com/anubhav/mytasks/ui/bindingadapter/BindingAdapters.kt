package com.anubhav.mytasks.ui.bindingadapter

import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip


@BindingAdapter("formatPriority")
fun Chip.formatPriority(priorityInIntFormat: Int) {
    val priorityInStringFormat = when (priorityInIntFormat) {
        1 -> "High"
        2 -> "Medium"
        3 -> "Low"

        else -> {
            " "
        }
    }
    this.text = priorityInStringFormat
}