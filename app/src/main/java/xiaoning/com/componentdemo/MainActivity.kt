package xiaoning.com.componentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import xiaoning.com.base.RetrofitManager
import xiaoning.com.base.RouterPath


@Route(path = RouterPath.MAIN, extras = 1)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        GlobalScope.launch {
//            var data: String = ""
//            withContext(Dispatchers.IO) {
//                data = RetrofitManager.getInstance("https://www.wanandroid.com/")
//                    ?.create(Api::class.java)?.getSuspendListCoro(1).toString()
//            }
//            Log.d("hahaha", data)
//        }
        login.setOnClickListener {
            ARouter.getInstance().build("/login/login").navigation()
        }
        share.setOnClickListener {
            ARouter.getInstance().build("/share/share").navigation()
        }

    }


}
