package xiaoning.com.music2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import xiaoning.com.base.RouterPath

@Route(path = RouterPath.MUSIC,extras = 1)

class MusicMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_main)
    }
}
