package xiaoning.com.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import xiaoning.com.base.RouterPath

class BookSplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_splash)
        ARouter.getInstance().build(RouterPath.BOOKROOM).navigation()
        finish()
    }
}