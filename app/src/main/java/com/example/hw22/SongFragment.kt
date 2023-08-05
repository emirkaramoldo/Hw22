package com.example.hw22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw22.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding
    private var songList = arrayListOf(
        Song(1, "Blank Spase", "Taylor Switw", 3.22),
        Song(2, "Watch Me", "Silento", 5.36),
        Song(3, "Earned it", "The Weekend", 4.51),
        Song(4, "The Hills", "The Weekend", 3.41),
        Song(5, "Writing's On The Wall", "Sam Smith", 5.33)
    )
    private val bundle = Bundle()
    private val detailsFragment: DetailsFragment = DetailsFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SongAdapter(songList, this::onClick)
        binding.rvSong.adapter = adapter
    }

    fun onClick(position: Int) {
        bundle.putSerializable("key", songList[position])
        detailsFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.details_container,detailsFragment).addToBackStack(null).commit()
    }
}