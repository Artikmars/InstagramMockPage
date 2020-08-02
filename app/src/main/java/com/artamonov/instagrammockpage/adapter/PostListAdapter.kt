package com.artamonov.instagrammockpage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artamonov.instagrammockpage.R
import com.artamonov.instagrammockpage.models.Post
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.post_item.view.*

class PostListAdapter(
    private val mDataSource: AdapterDataSource<Post>,
    private val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(messageId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feedItem = mDataSource.get(position)
        holder.bindItem(feedItem)
    }

    override fun getItemCount(): Int {
        return mDataSource.count
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var postItem: Post? = null

        fun bindItem(item: Post?) {
            this.postItem = item

            view.post_author_name.text = postItem?.author
            view.post_geo_tag.text = postItem?.geoTag
            view.post_description.text = postItem?.description

            Glide.with(context).load(postItem?.profilePhoto).placeholder(R.drawable.ic_baseline_tag_faces_24)
                .apply(RequestOptions.circleCropTransform())
                .into(view.profile_image)

            Glide.with(context).load(postItem?.postImagePath)
                .placeholder(R.drawable.ic_baseline_tag_faces_24)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(view.post_image)

            view.post_author_name.setOnClickListener {
                listener.onItemClick(R.string.author_name_clicked) }

            view.post_geo_tag.setOnClickListener {
                listener.onItemClick(R.string.geo_tag_clicked)
            }

            view.post_description.setOnClickListener {
                listener.onItemClick(R.string.post_description_clicked)
            }

            view.profile_image.setOnClickListener {
                listener.onItemClick(R.string.profile_image_clicked)
            }

            view.post_image.setOnClickListener {
                listener.onItemClick(R.string.post_image_clicked)
            }

            view.post_dots.setOnClickListener {
                listener.onItemClick(R.string.post_dots_clicked)
            }

            view.post_like.setOnClickListener {
                listener.onItemClick(R.string.post_like_clicked)
            }

            view.post_comment.setOnClickListener {
                listener.onItemClick(R.string.post_comment_clicked)
            }

            view.post_reply.setOnClickListener {
                listener.onItemClick(R.string.post_reply_clicked)
            }

            view.post_bookmark.setOnClickListener {
                listener.onItemClick(R.string.post_bookmark_clicked)
            }

        }
    }
}
