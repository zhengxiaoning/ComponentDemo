package xiaoning.com.componentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_fcsmain.*
import xiaoning.com.base.RouterPath
import xiaoning.com.componentbase.ServiceFactory

@Route(path = RouterPath.FCSMAIN, extras = 1)

class FCSMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcsmain)
        val url = intent.getStringExtra("url")
        val userName = intent.getStringExtra("userName")
        Glide.with(this).load(url).into(avator)
        name.text = userName
        bookRoom.setOnClickListener {
            ARouter.getInstance().build(RouterPath.BOOKROOM).navigation()
        }
        music.setOnClickListener {
            ARouter.getInstance().build(RouterPath.MUSIC).navigation()
        }
    }
}
