package com.example.innowisepokemons
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ChoiceAdapter(
    private var choiceList: List<Pokemon>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val choiceView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_choice, parent, false)
        return ViewHolder(choiceView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentView = choiceList[position]
        holder.bind(currentView, onClick)
    }

    fun updateAdapter(newChoiceList: List<Pokemon>) {
        val diffUtilCallback = ChoiceDiffUtilCallback(choiceList, newChoiceList)
        choiceList = newChoiceList
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return choiceList.size
    }
}