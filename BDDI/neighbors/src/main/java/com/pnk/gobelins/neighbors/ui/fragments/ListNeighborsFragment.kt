package com.pnk.gobelins.neighbors.ui.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pnk.gobelins.neighbors.NavigationListener
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.adapters.ListNeighborHandler
import com.pnk.gobelins.neighbors.adapters.ListNeighborsAdapter
import com.pnk.gobelins.neighbors.di.DI
import com.pnk.gobelins.neighbors.models.Neighbor
import com.pnk.gobelins.neighbors.viewmodels.NeighborViewModel

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var viewModel: NeighborViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NeighborViewModel::class.java)
    }

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // convertit vue XML en objet java, équialent du setcontentview pour les activités
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // update title
        (activity as? NavigationListener)?.updateTitle(R.string.listNeighborsTitle)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
        val addNeighbor: FloatingActionButton = view.findViewById(R.id.add_neighbor)
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        confirm(
            getString(R.string.prompt_delete_title),
            String.format(getString(R.string.prompt_delete_message), neighbor.name)
        ) {
            DI.repository.deleteNeighbor(neighbor)
        }
    }

    override fun onLikeNeighbor(neighbor: Neighbor) {
        DI.repository.updateFavoriteStatus(neighbor)
    }

    override fun onOpenPage(neighbor: Neighbor) {
        val url = Uri.parse(if (neighbor.webSite.startsWith("http://")) neighbor.webSite else "http://${neighbor.webSite}")
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
    }

    override fun onOpenSingle(neighbor: Neighbor) {
        (activity as? NavigationListener)?.showFragment(SingleNeighbourFragment(neighbor))
    }

    private fun confirm(title: String, message: String, callback: (() -> Unit)?) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                R.string.yes,
                DialogInterface.OnClickListener { dialog, which ->
                    callback?.invoke()
                }
            ) // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton(R.string.no, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    fun refresh() {
//        DI.repository.getNeighbours().observe(viewLifecycleOwner) {
//            if (recyclerView.adapter == null) {
//                val adapter = ListNeighborsAdapter(it, this)
//                recyclerView.adapter = adapter
//            } else {
//                (recyclerView.adapter as? ListNeighborsAdapter)?.updateData(it)
//            }
//        }
        viewModel.neighbors.observe(viewLifecycleOwner) {
            val adapter = ListNeighborsAdapter(it, this)
            recyclerView.adapter = adapter
        }
    }
}
