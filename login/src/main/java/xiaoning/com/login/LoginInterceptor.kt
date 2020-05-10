package xiaoning.com.login

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import xiaoning.com.base.RouterPath
import xiaoning.com.componentbase.ServiceFactory
import java.lang.RuntimeException

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-11.
 *
 */
@Interceptor(priority = 5, name = "登录状态拦截器")
class LoginInterceptor : IInterceptor {
    private lateinit var context: Context
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        //onContinue 和 onInterrupt 至少需要调用其中一种，否则不会继续路由
        if (postcard?.extra == 1) { //是否需要登录
            if (ServiceFactory.instance.getAcoount().isLogin()) { //已经登录
                callback?.onContinue(postcard) // 处理完成，交还控制权
            } else { //没有登录 跳转到登录页面，并且把需要跳转的url带给登录页，登录成功跳转该url
                val originPath = postcard.path
                ARouter.getInstance().build(RouterPath.LOGIN).withString("originPath", originPath)
                    .greenChannel()
                    .navigation(context)
            }
        } else {
            callback?.onContinue(postcard)
        }

    }

    override fun init(context: Context?) {
        if (context != null) {
            this.context = context
        }
    }
}