package com.example.contactsroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsroom.databinding.ContactListItemBinding
import com.example.contactsroom.model.Contacts

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private val contactsSet = mutableListOf<Contacts>()

    fun setUpContacts(contacts: List<Contacts>) {
        this.contactsSet.addAll(contacts)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ContactListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }


    //Replace the contents of a view
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactItem = contactsSet[position]
        holder.bindItem(contactItem)
    }

    override fun getItemCount(): Int {
        return contactsSet.size
    }



    inner class ContactViewHolder(private var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root) {
        //reference to all views in the contact item
        fun bindItem(contact: Contacts) {
            binding.nameTv.text = contact.name
            binding.phoneNoTv.text = contact.phoneNumber

        }

    }


}