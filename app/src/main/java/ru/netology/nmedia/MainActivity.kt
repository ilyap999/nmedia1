package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.longToString

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            author = "Нетология. Университет интернет-профессий будущего"
        )
        with(binding) {
            avatar.setImageResource(R.drawable.ic_netology_48dp)
            content.text = post.content
            author.text = post.author
            published.text = post.published
            //textLike.text = post.likes.toString()
            textLike.text = longToString(post.likes)
            //textShare.text = post.shares.toString()
            textShare.text = longToString(post.shares)
            //textView.text = post.views.toString()
            textView.text = longToString(post.views)

            buttonLike.setOnClickListener {
                //Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show()
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) {
                    buttonLike.setImageResource(R.drawable.ic_baseline_favorite_24)
                    post.likes++
                } else {
                    buttonLike.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    post.likes--
                }
                //textLike.text = post.likes.toString()
                textLike.text = longToString(post.likes)

            }

            buttonShare.setOnClickListener {
                post.shares++
                //textShare.text = post.shares.toString()
                textShare.text = longToString(post.shares)
            }
        }
    }
}
