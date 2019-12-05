package xiaoning.com.login

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import xiaoning.com.base.BaseApp
import xiaoning.com.componentbase.BuildConfig
import xiaoning.com.componentbase.ServiceFactory

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-07.
 *
 */
class LoginApp:BaseApp() {
    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
        initModuleData(this)
    }
    override fun initModuleApp(application: Application) {
        ServiceFactory.instance.setAccount(AccountService())
    }

    override fun initModuleData(application: Application) {

    }

}