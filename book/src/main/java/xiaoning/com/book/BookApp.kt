package xiaoning.com.book

import android.app.Application
import xiaoning.com.base.AppConfig
import xiaoning.com.base.BaseApp
import xiaoning.com.login.LoginApp

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-18.
 *
 */
class BookApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
        initModuleData(this)
    }

    override fun initModuleApp(application: Application) {//自身Application向外提供方法供其他模块反射调用


    }

    override fun initModuleData(application: Application) {  //反射初始化其他application提供的方法
        try {
            val clazz = Class.forName("xiaoning.com.login.LoginApp")
            val instance = clazz.newInstance() as LoginApp
            instance.initModuleApp(this)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
}