package xiaoning.com.book

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import xiaoning.com.componentbase.ServiceFactory

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-18.
 *
 */
interface BookApi {
    @GET("bookroom/book/list")
    suspend fun getBookList(
        @Query("sid") sid: String,
        @Query("page") page: Int,
        @Query("stage") stage: String
    ): BookBean
}