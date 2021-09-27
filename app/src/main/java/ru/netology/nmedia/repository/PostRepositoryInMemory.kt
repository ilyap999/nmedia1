package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.R
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemory : PostRepository {

    private companion object {
        val defaultPost = Post(
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            author = "Нетология. Университет интернет-профессий будущего",
            likes = 10,
            shares = 1598L,
            views = 1135000L
        )
    }
    override val data = MutableLiveData(defaultPost)

    override fun like() {
        val currentPost = data.value ?: return
        if (currentPost.likedByMe) {
            data.value = currentPost.copy(
                likedByMe = !currentPost.likedByMe,
                likes = currentPost.likes - 1
            )
        } else {
            data.value = currentPost.copy(
                likedByMe = !currentPost.likedByMe,
                likes = currentPost.likes + 1
            )
        }

    }

    override fun share() {
        val currentPost = data.value ?: return
        data.value = currentPost.copy(
            shares = currentPost.shares + 1
        )
    }
}
