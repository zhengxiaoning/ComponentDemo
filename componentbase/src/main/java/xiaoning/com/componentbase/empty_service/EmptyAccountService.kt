package xiaoning.com.componentbase.empty_service

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import xiaoning.com.componentbase.ServiceFactory
import xiaoning.com.componentbase.service.IAccountService

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
class EmptyAccountService : IAccountService {
    override fun getAccountSid(): Int {
        return 0
    }

    override fun newUserFragment(
        activity: Activity,
        containerId: Int,
        manager: FragmentManager,
        bundle: Bundle?,
        tag: String
    ): Fragment? {
        return null
    }

    override fun isLogin(): Boolean {

        return false
    }

    override fun getAccountId(): String {
        return ""
    }

}