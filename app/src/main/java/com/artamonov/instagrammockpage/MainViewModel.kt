package com.artamonov.instagrammockpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artamonov.instagrammockpage.models.Post
import com.artamonov.instagrammockpage.models.firstPost
import com.artamonov.instagrammockpage.models.secondPost


class MainViewModel : ViewModel() {

    val postsLiveData = MutableLiveData<List<Post>>()

    fun getPosts(): MutableList<Post> {
        val list : MutableList<Post> = mutableListOf()
        list.add(firstPost)
        list.add(secondPost)
        return list
    }
}
