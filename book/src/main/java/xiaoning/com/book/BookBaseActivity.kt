package xiaoning.com.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open abstract class BookBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_base)
        initView()
    }

    abstract fun initView()
}
