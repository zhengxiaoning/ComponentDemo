package xiaoning.com.componentdemo

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import xiaoning.com.base.AppConfig
import xiaoning.com.base.BaseApp
import xiaoning.com.componentbase.BuildConfig
import xiaoning.com.componentbase.ServiceFactory

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-07.
 *
 */
class MainApp : BaseApp() {
    override fun initModuleApp(application: Application) {
        for (i in AppConfig.moduleApps) {
            try {
                val clazz = Class.forName(i) //类的对象
                val baseApp: BaseApp = clazz.newInstance() as BaseApp //类的实例
                baseApp.initModuleApp(this)

            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun initModuleData(application: Application) {
        for (i in AppConfig.moduleApps) {
            try {
                val clazz = Class.forName(i)
                val baseApp: BaseApp = clazz.newInstance() as BaseApp
                baseApp.initModuleApp(this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        // 初始化组件 Application
        initModuleApp(this)
        // 所有 Application 初始化后的操作
        initModuleData(this)

    }
}