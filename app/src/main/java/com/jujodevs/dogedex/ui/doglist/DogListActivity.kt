package com.jujodevs.dogedex.ui.doglist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.jujodevs.dogedex.core.networks.ApiResponseStatus
import com.jujodevs.dogedex.databinding.ActivityDogListBinding
import com.jujodevs.dogedex.ui.dogdetail.DogDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val GRID_SPAN_COUNT = 3

@AndroidEntryPoint
class DogListActivity : AppCompatActivity() {

    @Inject lateinit var adapter: DogAdapter
    private lateinit var binding: ActivityDogListBinding

    private val dogListViewModel by viewModels<DogListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dogRecycler.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)
        binding.dogRecycler.adapter = adapter
        adapter.setOnItemClickListener {
            startActivity(DogDetailActivity.create(this, it))
        }

        dogListViewModel.dogList.observe(this){ dogList->
            adapter.submitList(dogList)
        }

        dogListViewModel.status.observe(this){ status ->
            when(status) {
                is ApiResponseStatus.Error -> {
                    binding.loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.messageId, Toast.LENGTH_SHORT).show()
                }
                is ApiResponseStatus.Loading -> {
                    binding.loadingWheel.visibility = View.VISIBLE
                }
                is ApiResponseStatus.Success -> {
                    binding.loadingWheel.visibility = View.GONE
                }
            }
        }
    }
}