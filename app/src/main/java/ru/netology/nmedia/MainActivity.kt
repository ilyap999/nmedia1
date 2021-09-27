package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding

import ru.netology.nmedia.dto.longToString

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                avatar.setImageResource(R.drawable.ic_netology_48dp)
                content.text = post.content
                author.text = post.author
                published.text = post.published
                textLike.text = longToString(post.likes)
                textShare.text = longToString(post.shares)
                textView.text = longToString(post.views)

                buttonLike.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.ic_baseline_favorite_24
                    } else {
                        R.drawable.ic_baseline_favorite_border_24
                    }
                )
            }
        }
        binding.buttonLike.setOnClickListener {
            viewModel.like()
        }
        binding.buttonShare.setOnClickListener {
            viewModel.share()
        }
    }
}
