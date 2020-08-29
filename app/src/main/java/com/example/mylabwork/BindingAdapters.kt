package com.example.mylabwork

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mylabwork.base.DevLifeApiStatus


@BindingAdapter("gifUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("devLifeApiStatusImg")
fun bindStatus(statusImageView: ImageView, status: DevLifeApiStatus?) {
    when (status) {
        DevLifeApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_loading_animation)
        }
        DevLifeApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        DevLifeApiStatus.DONE -> {
            statusImageView.visibility = View.GONE

        }
    }
}

@BindingAdapter("devLifeApiStatusTxt")
fun bindStatus(statusTextView: TextView, status: DevLifeApiStatus?) {
    when (status) {
        DevLifeApiStatus.LOADING -> {
            statusTextView.visibility = View.GONE
        }
        DevLifeApiStatus.ERROR -> {
            statusTextView.visibility = View.VISIBLE

        }
        DevLifeApiStatus.DONE -> {
            statusTextView.visibility = View.GONE
        }
    }
}