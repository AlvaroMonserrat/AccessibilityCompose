package com.rrat.accessibilitycompose.data.repository

import android.content.Context

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        PostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy{
        InterestsRepository()
    }

}