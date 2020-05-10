package xiaoning.com.book

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_book_main.*
import kotlinx.coroutines.*
import xiaoning.com.base.RetrofitManager
import xiaoning.com.base.RouterPath
import xiaoning.com.componentbase.ServiceFactory
//import xiaoning.com.login.LoginActivity
import java.security.MessageDigest

@Route(path = RouterPath.BOOKROOM, extras = 1)
class BookMainActivity : AppCompatActivity() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var datas = ArrayList<BookBean.Data.BookList.DataX>()
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_main)
        Log.d("serviceFactory", "${ServiceFactory.instance.getAcoount().isLogin()}")
        adapter = BookAdapter(this, datas)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 3)

        coroutineScope.launch {
            try {
                loadData()
                Log.d("book", "loaddata")
                progress.visibility = View.GONE
            } catch (e: Exception) {
                // progress.visibility = View.GONE
                Log.d("book", "loaddata出错")
                Toast.makeText(this@BookMainActivity, e.message, Toast.LENGTH_SHORT).show()

            }
            adapter.notifyDataSetChanged()

        }

    }

    lateinit var bean: BookBean
    private suspend fun loadData() = withContext(Dispatchers.Main) {
        try {
            bean = RetrofitManager.getInstance(BookBaseUrl.URL).create(BookApi::class.java)
                .getBookList(
                    ServiceFactory.instance.getAcoount().getAccountSid().toString(),
                    1,
                    "stage16"
                )

            bean.data.bookList.data.forEach { datas.add(it) }

        } catch (e: Exception) {
            Toast.makeText(this@BookMainActivity, "出错", Toast.LENGTH_SHORT).show()
            Log.d("book", "1002出错")
        }

        Log.d("book", "${Thread.currentThread().name}2")
//        val s = URL("https://www.jianshu.com/p/3aed63d0abf2").readText()
//        withContext(Dispatchers.Main){
//            text.text = s
//        }

    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}
