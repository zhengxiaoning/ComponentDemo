package xiaoning.com.book

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import androidx.core.animation.addListener
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_book_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xiaoning.com.base.RouterPath
import kotlin.concurrent.thread

@Route(path = "/book/splash")
class BookSplashActivity : AppCompatActivity() {
    lateinit var img: ImageView
    private val coroutine = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_splash)
        img = findViewById(R.id.splash)
        coroutine.launch {
            delay(1000)
            ARouter.getInstance().build(RouterPath.BOOKROOM).navigation()
        }

    }





}
