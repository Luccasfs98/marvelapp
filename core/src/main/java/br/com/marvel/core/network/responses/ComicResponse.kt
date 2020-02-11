package com.marvel.core.network.responses

/**
 * Created by Gustavo de Jesus Gomes on 28 Dezembro, 2019
 * Company: Android Geek - www.androidgeek.dev
 */
data class ComicResponse (
    val id: Int,
    val title: String,
    val thumbnail: ThumbnailResponse
)