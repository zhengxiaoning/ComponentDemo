package xiaoning.com.login

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-12.
 *
 */
interface LoginApi {
    @GET("user/login/parent")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("device") device: String
    ): LoginBean
}