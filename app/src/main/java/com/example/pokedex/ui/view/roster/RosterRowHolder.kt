package com.example.pokedex.ui.view.roster

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.RosterRowBinding

class RosterRowHolder(
    private val binding: RosterRowBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.name.text = name
    }
}