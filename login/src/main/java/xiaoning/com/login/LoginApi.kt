package xiaoning.com.login

import kotlinx.coroutines.Deferred
import retrofit2.http.*

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