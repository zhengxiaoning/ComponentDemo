package xiaoning.com.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import xiaoning.com.componentbase.service.IAccountService

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
class AccountService : IAccountService {
    override fun getAccountSid(): Int {
        return AccountUtils.userInfo?.sid!!
    }

    override fun newUserFragment(
        activity: Activity,
        containerId: Int,
        manager: FragmentManager,
        bundle: Bundle?,
        tag: String
    ): Fragment? {
        val transaction = manager.beginTransaction()
        val userFragment = UserFragment()
        transaction.add(containerId, userFragment, tag)
        transaction.commit()
        return userFragment
    }

    override fun isLogin(): Boolean {
        return AccountUtils.userInfo != null
    }

    override fun getAccountId(): String? {
        return AccountUtils.userInfo?.Url
    }
}