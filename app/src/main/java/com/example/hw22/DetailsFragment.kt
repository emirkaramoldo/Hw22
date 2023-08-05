package com.example.hw22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw22.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var dataFromSongFragment: Song
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataFromSongFragment = arguments?.getSerializable("key") as Song
        binding.tvAuthorName.text = dataFromSongFragment.author
        binding.tvSongName.text = dataFromSongFragment.name
    }
}