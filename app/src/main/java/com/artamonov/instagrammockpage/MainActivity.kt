package com.artamonov.instagrammockpage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.artamonov.instagrammockpage.adapter.AdapterDataSource
import com.artamonov.instagrammockpage.adapter.PostListAdapter
import com.artamonov.instagrammockpage.models.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var viewModel = MainViewModel()
    private var adapter: PostListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.postsLiveData.observe(this, Observer {
            initAdapter()
        })

        camera_btn.setOnClickListener { showToast(R.string.camera_button_clicked) }
        instagram_logo.setOnClickListener { showToast(R.string.logo_clicked) }
        direct_messages_btn.setOnClickListener { showToast(R.string.direct_messages_clicked) }

    }

    private fun initAdapter() {
        val linearLayoutManager = LinearLayoutManager(this)
        posts_list.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        posts_list.addItemDecoration(dividerItemDecoration)

        adapter = PostListAdapter(
            object : AdapterDataSource<Post> {
                override fun getCount(): Int {
                    return viewModel.getPosts().size
                }
                override fun get(position: Int): Post? {
                    return viewModel.getPosts()[position]
                }
            }, this,
        object : PostListAdapter.OnItemClickListener {
            override fun onItemClick(messageId: Int) {
                showToast(messageId)
            }

        }
        )

        posts_list.adapter = adapter
    }

    private fun showToast(resourceId: Int) {
        Toast.makeText(this, getString(resourceId), Toast.LENGTH_SHORT).show()
    }
}