package com.marvel.core.network.responses


/**
 * Marvel API character thumbnail network response.
 *
 * @param path The directory path of to the image.
 * @param extension The file extension for the image.
 */
data class ThumbnailResponse(
    val path: String,
    val extension: String
)
