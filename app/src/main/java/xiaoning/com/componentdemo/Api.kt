package xiaoning.com.componentdemo

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
interface Api {
    @GET("article/list/{id}/json")
    suspend fun getSuspendListCoro(@Path("id") id: Int): HomeTitleBean
}