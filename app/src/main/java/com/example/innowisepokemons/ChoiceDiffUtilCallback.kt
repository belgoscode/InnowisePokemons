package com.example.innowisepokemons

import androidx.recyclerview.widget.DiffUtil

class ChoiceDiffUtilCallback(
    private val oldMap: Map<Int, Pokemon?>,
    private val newMap: Map<Int, Pokemon?>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldMap.size

    override fun getNewListSize(): Int = newMap.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMap[oldItemPosition]?.id == newMap[newItemPosition]?.id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMap[oldItemPosition] == newMap[newItemPosition]
}