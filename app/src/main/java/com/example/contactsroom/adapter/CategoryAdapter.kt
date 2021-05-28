package com.example.contactsroom.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsroom.databinding.CategoryListItemBinding
import com.example.contactsroom.model.Categories
import com.example.contactsroom.ui.MainActivity


/** Adapter for the [ RecyclerView] in [ CategoryActivity]. Displays [ Category] data object.*/

class CategoryAdapter(
    private var context: Context,
    private val categorySet: List<Categories>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryItem = categorySet[position]
        holder.bindCat(categoryItem)

        holder.itemView.setOnClickListener {
            val titleCat: String = context.getString(categoryItem.categoryName)

            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(NAME_EXTRA,titleCat)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = categorySet.size

    inner class CategoryViewHolder(private var binding: CategoryListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindCat(category: Categories) {
            binding.categoryName.text = context.getString(category.categoryName)
            binding.categoryImage.setImageResource(category.categoryImage)
        }
    }

    companion object {//key to pass intent values
    const val NAME_EXTRA = "name_extras"
    }

}