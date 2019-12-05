package xiaoning.com.base

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
class RetrofitManager constructor(url: String) {
    private var retrofit: Retrofit
    private var mUrl = url

    init {
        retrofit = getRetrofit(mUrl)
    }

    companion object {
        @Volatile
        private var instance: RetrofitManager? = null

        fun getInstance(mUrl: String): RetrofitManager? {
            //不能判断instance==null才新创建，否则用instance，这样会造成不同基地址只能创建一次，所以只能每次都创建新的单例
//            instance ?: synchronized(this) {
//                instance ?: RetrofitManager(mUrl).also { instance = it }
//            }
            synchronized(this) {
                RetrofitManager(mUrl).also { instance = it }
            }
            return instance
        }
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }


    private fun getOkHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor(loggingInterceptor())
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addNetworkInterceptor(addHeaderInterceptor())
            .addNetworkInterceptor(logInterceptor)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor.Logger {
        return HttpLoggingInterceptor.Logger {
            com.orhanobut.logger.Logger.json(it)
        }
    }

    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor {
            val token = SharedUtil.read("token", "")
            val originalRequest = it.request()
            val request = originalRequest.newBuilder()
                .addHeader("Referer", "http://app.firstleap.cn")
                .addHeader("Authorization", "Bearer $token")
                .method(originalRequest.method(), originalRequest.body())
                .build()
            it.proceed(request)
        }
    }

    private fun getRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(getOkHttpClient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}