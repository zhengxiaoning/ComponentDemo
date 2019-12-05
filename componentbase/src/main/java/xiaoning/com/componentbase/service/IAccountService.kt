package xiaoning.com.componentbase.service

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
interface IAccountService {
    /**
     * 是否已经登录
     */
    fun isLogin(): Boolean

    /**
     * 获取登录用户的accountID
     */
    fun getAccountId():String?
    /**
     * 获取登录用户的sid
     */
    fun getAccountSid():Int
    /**
     * 创建userFragment
     */
    fun newUserFragment(activity:Activity,containerId:Int,manager:FragmentManager,
                        bundle:Bundle?,tag:String):Fragment?

}