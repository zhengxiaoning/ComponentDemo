package xiaoning.com.base

import android.content.Context
import android.preference.PreferenceManager

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-18.
 *
 */
object SharedUtil {


    fun save(key:String,value:Boolean){

        val editor = PreferenceManager.getDefaultSharedPreferences(BaseContext.context).edit()
            .putBoolean(key,value).apply()
    }
    fun save(key: String, value: Float) {
        val editor = PreferenceManager.getDefaultSharedPreferences(BaseContext.context).edit()
            .putFloat(key, value).apply()
    }

    fun save(key: String, value: Int) {
        val editor = PreferenceManager.getDefaultSharedPreferences(BaseContext.context).edit()
            .putInt(key, value).apply()
    }

    fun save(key: String, value: String) {
        val editor = PreferenceManager.getDefaultSharedPreferences(BaseContext.context).edit()
            .putString(key, value).apply()
    }

    fun save(key: String, value: Long) {
        val editor = PreferenceManager.getDefaultSharedPreferences(BaseContext.context).edit()
            .putLong(key, value).apply()
    }

    fun read(key: String, defValue: Boolean): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(BaseContext.context).getBoolean(key, defValue)
    }

    fun read(key: String, defValue: Float): Float {
        return PreferenceManager.getDefaultSharedPreferences(BaseContext.context).getFloat(key, defValue)
    }

    fun read(key: String, defValue: String): String {
        return PreferenceManager.getDefaultSharedPreferences(BaseContext.context).getString(key, defValue)!!
    }

    fun read(key: String, defValue: Int): Int {
        return PreferenceManager.getDefaultSharedPreferences(BaseContext.context).getInt(key, defValue)
    }

    fun read(key: String, defValue: Long): Long {
        return PreferenceManager.getDefaultSharedPreferences(BaseContext.context).getLong(key, defValue)
    }
}