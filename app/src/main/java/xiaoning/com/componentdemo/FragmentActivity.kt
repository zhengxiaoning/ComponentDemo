package xiaoning.com.componentdemo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import xiaoning.com.componentbase.ServiceFactory

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-11.
 *
 */
class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_main)
        //通过组件提供的service实现fragment的实例化
        ServiceFactory.instance.getAcoount()
            .newUserFragment(this, R.id.fragment, supportFragmentManager, null, "")
    }
}