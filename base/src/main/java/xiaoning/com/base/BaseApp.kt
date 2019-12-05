package xiaoning.com.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import xiaoning.com.componentbase.BuildConfig

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-07.
 *
 */
 abstract class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
        BaseContext.init(this)
        val formart = PrettyFormatStrategy.newBuilder().showThreadInfo(false)
            .methodCount(2)
            .methodOffset(5)
            .tag("Logging")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formart) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
    private fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
    /**
     * Application 初始化
     */
    abstract fun initModuleApp(application:Application)
    /**
     * 所有 Application 初始化后的自定义操作
     */
    abstract fun initModuleData(application:Application)
}