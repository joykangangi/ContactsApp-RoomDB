package com.example.contactsroom.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsroom.adapter.CategoryAdapter
import com.example.contactsroom.databinding.ActivityCategoryBinding
import com.example.contactsroom.datasource.CategoryImages

class CategoryActivity : AppCompatActivity() {
    private val myData = CategoryImages.categories
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GridLayoutManager(this, 2, RecyclerView.VERTICAL, false).apply {
            binding.categoryRv.layoutManager = this
        }
        binding.categoryRv.adapter = CategoryAdapter(this, myData) //To tell the recyclerView to use the ContactAdapter class

    }

}
