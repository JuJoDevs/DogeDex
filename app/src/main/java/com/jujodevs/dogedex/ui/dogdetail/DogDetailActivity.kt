package com.jujodevs.dogedex.ui.dogdetail

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.jujodevs.dogedex.R
import com.jujodevs.dogedex.databinding.ActivityDogDetailBinding
import com.jujodevs.dogedex.domain.model.Dog

class DogDetailActivity : AppCompatActivity() {

    companion object{
        private const val DOG_KEY = "dog"

        fun create(context: Context, dog: Dog): Intent =
            Intent(context, DogDetailActivity::class.java)
                .putExtra(DOG_KEY, dog)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val dog = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent?.extras?.getParcelable(DOG_KEY, Dog::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent?.extras?.getParcelable(DOG_KEY)
        }

        if (dog == null){
            Toast.makeText(this, R.string.error_showing_dog_not_found, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        binding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dog.lifeExpectancy)
        binding.dog = dog
    }
}