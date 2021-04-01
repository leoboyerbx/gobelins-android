package com.pnk.gobelins.neighbors.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.adapters.ListNeighborHandler
import com.pnk.gobelins.neighbors.adapters.ListNeighborsAdapter
import com.pnk.gobelins.neighbors.data.NeighborRepository
import com.pnk.gobelins.neighbors.models.Neighbor

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
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
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, listHandler = this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        confirm(
            getString(R.string.prompt_delete_title),
            String.format(getString(R.string.prompt_delete_message), neighbor.name)
        ) {
            NeighborRepository.getInstance().deleteNeighbor(neighbor)
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onLikeNeighbor(neighbor: Neighbor) {
        NeighborRepository.getInstance().updateFavoriteStatus(neighbor)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onOpenPage(neighbor: Neighbor) {
        val url = Uri.parse(if (neighbor.webSite.startsWith("http://")) neighbor.webSite else "http://${neighbor.webSite}")
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
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
}
