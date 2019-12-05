package xiaoning.com.base

import android.annotation.SuppressLint
import android.content.Context

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-18.
 *
 */
@SuppressLint("StaticFieldLeak")
object BaseContext {
    lateinit var context:Context
    fun init(context: Context){
        this.context = context
    }
}