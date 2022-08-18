package com.rrat.accessibilitycompose.data.repository

import com.rrat.accessibilitycompose.data.model.Post
import com.rrat.accessibilitycompose.data.raw.posts
import com.rrat.accessibilitycompose.util.addOrRemove
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


class PostsRepository {

    private val favorites = MutableStateFlow<Set<String>>(setOf())

    fun getPost(postId: String?): Post?{
        return posts.find{ it.id == postId}
    }

    fun getPosts(): List<Post>{
        return posts
    }

    fun observeFavorites(): Flow<Set<String>> = favorites

    fun toggleFavorite(postId: String){
        val set = favorites.value.toMutableSet()
        set.addOrRemove(postId)
        favorites.value = set
    }
}