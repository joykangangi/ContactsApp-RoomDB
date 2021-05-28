package com.example.contactsroom.datasource

import com.example.contactsroom.R
import com.example.contactsroom.model.Categories

object CategoryImages {
    val categories = listOf(
        Categories(R.string.work, R.drawable.ic__work),
        Categories(R.string.friends, R.drawable.ic_friends),
        Categories(R.string.school, R.drawable.ic_school),
        Categories(R.string.blacklist, R.drawable.ic_iblacklist),
        Categories(R.string.neighbors, R.drawable.ic_home)
    )
}