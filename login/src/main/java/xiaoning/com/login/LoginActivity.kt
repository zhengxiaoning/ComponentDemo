package xiaoning.com.login

import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*
import xiaoning.com.base.RetrofitManager
import xiaoning.com.base.RouterPath
import xiaoning.com.base.SharedUtil
import xiaoning.com.componentbase.ServiceFactory

@Route(path = RouterPath.LOGIN)
class LoginActivity : AppCompatActivity() {
    private val coroutine: CoroutineScope = CoroutineScope(Dispatchers.Main)
    var bean: LoginBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener {
            //            AccountUtils.userInfo = UserInfo("admin", "zhengxiaoning")
        }
        share.setOnClickListener {
            ARouter.getInstance().build("/share/share").withString("share", "分享数据到微博")
                .navigation()
        }
        val originPath = intent.getStringExtra("originPath")
        val module = intent.getStringExtra("module")
        loginBt.setOnClickListener {
            
            coroutine.launch {
                when {
                    phoneNumber.text.toString() == "" -> Toast.makeText(
                        this@LoginActivity,
                        "手机号不能为空",
                        Toast.LENGTH_SHORT
                    ).show()
                    verifyCodeEdit.text.toString() == "" -> Toast.makeText(
                        this@LoginActivity,
                        "密码不能为空",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> {
                        try {
                            login()
                            var url = ""
                            var userName = ""
                            var token = ""
                            var sid = 0
                            bean?.data?.let {
                                url = it.sons?.get(1)!!.avator
                                userName = it.sons?.get(1)!!.enName
                                token = it.token
                                sid = it.sons?.get(1)!!.sid
                            }
                            SharedUtil.save("token", token)
                            AccountUtils.userInfo = UserInfo(url, userName, sid)
                            //ServiceFactory.instance.setAccount(AccountService())
                            if (originPath != null && originPath.isNotEmpty()) {
                                ARouter.getInstance().build(originPath)
                                    .withString("url", url)
                                    .withString("userName", userName)
                                    .navigation()
                            }

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            Toast.makeText(this@LoginActivity, e.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                        Log.d("login", bean.toString())
                    }
                }

            }
        }
        shareBt.setOnClickListener {
            ARouter.getInstance().build(RouterPath.SHARE).withString("share", "分享数据到微博")
                .navigation()
        }

    }

    suspend fun login() = withContext(Dispatchers.IO) {
        bean = RetrofitManager.getInstance(LoginBaseUrl.BASE_URL).create(LoginApi::class.java)
            .login(phoneNumber.text.toString(), verifyCodeEdit.text.toString(), Build.MODEL)

    }
    companion object{
        val a = 1
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutine.cancel()
    }
}
