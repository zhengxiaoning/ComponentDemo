package xiaoning.com.share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_share.*
import xiaoning.com.base.RouterPath
import xiaoning.com.componentbase.ServiceFactory

@Route(path = RouterPath.SHARE, extras = 1)
class ShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        val content = intent.getStringExtra("share")
        share.text = content ?: "请登录后进行分享"
        if (content == null) {
            toLogin()
        }
        toShare()

    }

    fun toLogin() {
        ARouter.getInstance().build(RouterPath.LOGIN)
            .withString("module", "share")
            .navigation()
    }

    fun toShare() {
        if (ServiceFactory.instance.getAcoount().isLogin()) {
            Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "分享失败：用户未登录", Toast.LENGTH_SHORT).show()
        }
    }
}
