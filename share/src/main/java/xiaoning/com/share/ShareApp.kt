package xiaoning.com.share

import android.app.Application
import xiaoning.com.base.AppConfig
import xiaoning.com.base.BaseApp

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-07.
 *
 */
class ShareApp:BaseApp() {
    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
        initModuleData(this)
    }
    override fun initModuleApp(application: Application) {
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

    override fun initModuleData(application: Application) {

    }
}