package com.jujodevs.dogedex.ui.doglist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jujodevs.dogedex.databinding.ActivityDogListBinding
import com.jujodevs.dogedex.ui.dogdetail.DogDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DogListActivity : AppCompatActivity() {

    @Inject lateinit var adapter: DogAdapter
    private lateinit var binding: ActivityDogListBinding

    private val dogListViewModel by viewModels<DogListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dogRecycler.layoutManager = LinearLayoutManager(this)
        binding.dogRecycler.adapter = adapter
        adapter.setOnItemClickListener {
            startActivity(DogDetailActivity.create(this, it))
        }

        dogListViewModel.dogList.observe(this){ dogList->
            adapter.submitList(dogList)
        }
    }
}