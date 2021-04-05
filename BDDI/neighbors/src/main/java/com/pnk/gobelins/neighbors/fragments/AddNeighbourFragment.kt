package com.pnk.gobelins.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.pnk.gobelins.neighbors.R
import com.pnk.gobelins.neighbors.databinding.FragmentAddNeighbourBinding

class AddNeighbourFragment : Fragment() {
    private lateinit var formView: View
    lateinit var binding: FragmentAddNeighbourBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_neighbour, container, false)
        formView = binding.root
        return formView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    /**
     * Bind all watchers
     */
    private fun bind() {
        with(binding) {
            saveButton.setOnClickListener {
//                save()
                println("save")
            }
        }
    }

//    private fun save() {
//        val lastNeighborId = NeighborRepository.getInstance().getNeighbours().last().id ?: 0
//        val id = lastNeighborId + 1
//        with(binding) {
//            val newNeighbor = Neighbor(
//                id = id,
//                name = inputName.text.toString(),
//                avatarUrl = inputImage.text.toString(),
//                address = inputAddress.text.toString(),
//                phoneNumber = inputTel.text.toString(),
//                aboutMe = inputBio.text.toString(),
//                favorite = false,
//                webSite = inputWebsite.text.toString()
//            )
//            NeighborRepository.getInstance().createNeighbor(newNeighbor)
//        }
//    }
}
