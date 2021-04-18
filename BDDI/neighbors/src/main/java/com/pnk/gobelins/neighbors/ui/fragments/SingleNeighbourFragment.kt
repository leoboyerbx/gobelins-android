package com.pnk.gobelins.neighbors.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.adapters.NeighborBindingAdapter
import com.pnk.gobelins.neighbors.databinding.FragmentSingleNeighborBinding
import com.pnk.gobelins.neighbors.di.DI
import com.pnk.gobelins.neighbors.models.Neighbor

class SingleNeighbourFragment(val neighbor: Neighbor) : Fragment() {
    private lateinit var binding: FragmentSingleNeighborBinding
    private val liveNeighbor = MutableLiveData<Neighbor>(neighbor)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_single_neighbor, container, false)
        binding.neighbor = liveNeighbor
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.singleLikeButton.setOnClickListener {
            DI.repository.updateFavoriteStatus(neighbor)
            refresh()
        }
    }
    private fun refresh() {
        liveNeighbor.value = neighbor
        NeighborBindingAdapter.bindFavorite(binding.singleLikeButton, neighbor.favorite)
    }
}
