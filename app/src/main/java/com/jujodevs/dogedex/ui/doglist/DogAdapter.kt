package com.jujodevs.dogedex.ui.doglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jujodevs.dogedex.domain.model.Dog
import com.jujodevs.dogedex.databinding.DogListItemBinding
import javax.inject.Inject

class DogAdapter @Inject constructor(): ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {

    private var onItemClickListener: ((Dog) -> Unit)? = null

    companion object DiffCallback: DiffUtil.ItemCallback<Dog>(){
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(DogListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        dogViewHolder.bind(getItem(position))
    }

    fun setOnItemClickListener(onItemClickListener: (Dog) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    inner class DogViewHolder(private val binding: DogListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(dog: Dog){
            binding.dogListItemLayout.setOnClickListener{
                onItemClickListener?.invoke(dog)
            }
            binding.dogImage.load(dog.imageUrl)
        }
    }
}