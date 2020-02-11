package br.com.marvel.core.network

import br.com.marvel.core.network.responses.BaseResponse
import com.marvel.core.network.responses.CharacterResponse
import com.marvel.core.network.responses.ComicResponse
import com.marvel.core.network.responses.CreatorResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Representation interface of the Marvel API endpoints.
 */
interface MarvelService {

    /**
     * Fetches a single character resource. It is the canonical URI for any character resource
     * provided by the API.
     *
     * @param id A single character id.
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     * @param hash A md5 digest of the ts parameter, private API key and public.
     * @param timestamp A digital current record of the time.
     * @return Response for single character resource.
     */
    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String
    ): CharacterResponse

    /**
     * Fetches lists of comic characters with optional filters.
     *
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     * @param hash A md5 digest of the ts parameter, private API key and public.
     * @param timestamp A digital current record of the time.
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @return Response for comic characters resource.
     */
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("orderBy") orderBy: String
    ): BaseResponse<CharacterResponse>


    /**
     * Fetches lists of comic with optional filters.
     *
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     * @param hash A md5 digest of the ts parameter, private API key and public.
     * @param timestamp A digital current record of the time.
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @return Response for comic characters resource.
     */
    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("dateDescriptor") dateDescriptor: String
    ): BaseResponse<ComicResponse>


    /**
     * Fetches lists of comic with optional filters.
     *
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     * @param hash A md5 digest of the ts parameter, private API key and public.
     * @param timestamp A digital current record of the time.
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @return Response for comic characters resource.
     */
    @GET("/v1/public/creators")
    suspend fun getCreators(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): BaseResponse<CreatorResponse>

}
