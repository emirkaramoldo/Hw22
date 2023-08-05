package com.example.hw22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw22.databinding.ItemSongBinding

class SongAdapter(
    val songList: ArrayList<Song>,val onClick:(position:Int)->Unit
): RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    inner class ViewHolder (private  val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val songModel = songList[adapterPosition]
            binding.tvName.text = songModel.name
            binding.tvAuthor.text = songModel.author
            binding.tvNumber.text = songModel.number.toString()
            binding.tvDuration.text = songModel.duration.toString()
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return songList.size
    }
}