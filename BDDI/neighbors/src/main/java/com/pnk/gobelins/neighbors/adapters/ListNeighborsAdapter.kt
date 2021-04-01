package com.pnk.gobelins.neighbors.adapters

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.internal.ContextUtils
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.models.Neighbor

class ListNeighborsAdapter(
    items: List<Neighbor>,
    private val listHandler: ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {

    private val mNeighbours: List<Neighbor> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.neighbor_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        // Display Neighbour Name
        holder.mNeighbourName.text = neighbour.name
        holder.mNeighbourDescription.text = neighbour.aboutMe
        val context = holder.mNeighbourAvatar.context
        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_delete_24)
            .skipMemoryCache(false)
            .into(holder.mNeighbourAvatar)

        if (neighbour.favorite) {
            holder.mLikeButton.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            holder.mLikeButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        holder.mDeleteButton.setOnClickListener {
            listHandler.onDeleteNeibor(neighbour)
        }
        holder.mDeleteButton.setOnClickListener {
            listHandler.onDeleteNeibor(neighbour)
        }
        holder.mPageButton.setOnClickListener {
            listHandler.onOpenPage(neighbour)
        }
        holder.mLikeButton.setOnClickListener {
            listHandler.onLikeNeighbor(neighbour)
        }
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mNeighbourAvatar: ImageView
        val mNeighbourName: TextView
        val mNeighbourDescription: TextView
        val mDeleteButton: ImageButton
        val mLikeButton: ImageButton
        val mPageButton: ImageButton

        init {
            // Enable click on item
            mNeighbourAvatar = view.findViewById(R.id.item_list_avatar)
            mNeighbourName = view.findViewById(R.id.item_list_name)
            mNeighbourDescription = view.findViewById(R.id.item_list_description)
            mDeleteButton = view.findViewById(R.id.item_list_delete_button)
            mLikeButton = view.findViewById(R.id.item_list_like_button)
            mPageButton = view.findViewById(R.id.item_list_page_button)
        }
    }
}
