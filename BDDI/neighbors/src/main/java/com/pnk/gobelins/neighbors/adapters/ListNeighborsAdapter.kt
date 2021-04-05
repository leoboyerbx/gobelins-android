package com.pnk.gobelins.neighbors.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.databinding.NeighborItemBinding
import com.pnk.gobelins.neighbors.models.Neighbor

class ListNeighborsAdapter(
    items: List<Neighbor>,
    private val listHandler: ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {

    private val mNeighbours: MutableList<Neighbor> = items.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NeighborItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.neighbor_item, parent, false)
        return ViewHolder(binding)
    }

    fun updateData(neighbors: List<Neighbor>) {
        mNeighbours.clear()
        mNeighbours.addAll(neighbors)
        notifyDataSetChanged()
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]

        holder.binding.neighbor = neighbour

        holder.binding.itemListLikeButton.setOnClickListener {
            listHandler.onDeleteNeibor(neighbour)
        }
        holder.binding.itemListDeleteButton.setOnClickListener {
            listHandler.onDeleteNeibor(neighbour)
        }
        holder.binding.itemListPageButton.setOnClickListener {
            listHandler.onOpenPage(neighbour)
        }
        holder.binding.itemListLikeButton.setOnClickListener {
            listHandler.onLikeNeighbor(neighbour)
        }
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(val binding: NeighborItemBinding) : RecyclerView.ViewHolder(binding.root)
}
