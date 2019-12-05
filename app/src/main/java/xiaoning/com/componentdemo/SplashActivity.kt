package xiaoning.com.componentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import xiaoning.com.base.RouterPath
import xiaoning.com.componentbase.ServiceFactory
import xiaoning.com.login.AccountService

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ARouter.getInstance().build(RouterPath.FCSMAIN).navigation()
        finish()
    }
}
