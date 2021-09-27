package ru.netology.nmedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemory

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemory()
    val data: LiveData<Post> = repository.data
    fun like() {
        repository.like()
    }
    fun share() {
        repository.share()
    }
}
