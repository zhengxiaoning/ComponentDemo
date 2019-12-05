package xiaoning.com.componentbase

import xiaoning.com.componentbase.empty_service.EmptyAccountService
import xiaoning.com.componentbase.service.IAccountService

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-06.
 *
 */
class ServiceFactory private constructor() {
    private var accountService: IAccountService? = null

    companion object {
         val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ServiceFactory()
        }
    }

    /**
     * 接收 Login 组件实现的 Service 实例
     */
    fun setAccount(service: IAccountService) {
        accountService = service
    }

    /**
     * 返回 Login 组件的 Service 实例
     */
    fun getAcoount() = accountService ?: EmptyAccountService()

}