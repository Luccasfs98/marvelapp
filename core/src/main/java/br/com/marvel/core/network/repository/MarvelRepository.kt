package br.com.marvel.core.network.repository

import com.marvel.core.BuildConfig
import com.marvel.core.network.MarvelService
import com.marvel.core.network.responses.BaseResponse
import com.marvel.core.network.responses.CharacterResponse
import com.marvel.core.network.responses.ComicResponse
import com.marvel.core.network.responses.CreatorResponse
import com.marvel.core.utils.toMD5


/**
 * Repository module for handling marvel API network operations [MarvelService].
 */
class MarvelRepository(
    internal val service: MarvelService
) {

    companion object {
        private const val API_PUBLIC_KEY = BuildConfig.MARVEL_API_KEY_PUBLIC
        private const val API_PRIVATE_KEY = BuildConfig.MARVEL_API_KEY_PRIVATE
        private const val HASH_FORMAT = "%s%s%s"
    }

    /**
     * Get all info of Marvel character.
     *
     * @param id A single character id.
     * @return Response for single character resource.
     */
    suspend fun getCharacter(id: Long): BaseResponse<CharacterResponse> {
        val timestamp = System.currentTimeMillis().toString()
        return service.getCharacter(
            id = id,
            apiKey = API_PUBLIC_KEY,
            hash = generateApiHash(timestamp),
            timestamp = timestamp
        )
    }

    /**
     * Get all Marvel characters by paged.
     *
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @param orderBy ordena o resultado de acordo com as opções documentadas na API.
     * @return Response for comic characters resource.
     */
    suspend fun getCharacters(
        offset: Int,
        limit: Int,
        orderBy: String = "-modified"
    ): BaseResponse<CharacterResponse> {
        val timestamp = System.currentTimeMillis().toString()
        return service.getCharacters(
            apiKey = API_PUBLIC_KEY,
            hash = generateApiHash(timestamp),
            timestamp = timestamp,
            offset = offset,
            limit = limit,
            orderBy = orderBy
        )
    }


    /**
     * Get all Marvel Comics by paged.
     *
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @param orderBy ordena o resultado de acordo com as opções documentadas na API.
     * @return Response for comic characters resource.
     */
    suspend fun getComics(
        offset: Int,
        limit: Int,
        dateDescriptor: String = "thisWeek"
    ): BaseResponse<ComicResponse> {
        val timestamp = System.currentTimeMillis().toString()
        return service.getComics(
            apiKey = API_PUBLIC_KEY,
            hash = generateApiHash(timestamp),
            timestamp = timestamp,
            offset = offset,
            limit = limit,
            dateDescriptor = dateDescriptor
        )
    }


    /**
     * Get all Marvel Comics by paged.
     *
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @param orderBy ordena o resultado de acordo com as opções documentadas na API.
     * @return Response for comic characters resource.
     */
    suspend fun getCreators(
        offset: Int,
        limit: Int
    ): BaseResponse<CreatorResponse> {
        val timestamp = System.currentTimeMillis().toString()
        return service.getCreators(
            apiKey = API_PUBLIC_KEY,
            hash = generateApiHash(timestamp),
            timestamp = timestamp,
            offset = offset,
            limit = limit
        )
    }


    // ============================================================================================
    //  Private generators methods
    // ============================================================================================

    /**
     * Generate a md5 digest of the timestamp parameter, private API key and public.
     *
     * @param timestamp A digital current record of the time.
     * @return The MD5 Hash
     */
    private fun generateApiHash(timestamp: String) =
        HASH_FORMAT.format(timestamp, API_PRIVATE_KEY, API_PUBLIC_KEY).toMD5()
}
