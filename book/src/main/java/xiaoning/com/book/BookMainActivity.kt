package xiaoning.com.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Checkable
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_book_main.*
import kotlinx.coroutines.*
import xiaoning.com.base.RetrofitManager
import xiaoning.com.base.RouterPath
import xiaoning.com.base.singleClick
import xiaoning.com.componentbase.ServiceFactory

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
            } catch (e: Exception) {
                Toast.makeText(this@BookMainActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }
            adapter.notifyDataSetChanged()

        }


    }

    private suspend fun loadData() = withContext(Dispatchers.IO) {

        RetrofitManager.getInstance(BookBaseUrl.URL)?.create(BookApi::class.java)
            ?.getBookList(
                ServiceFactory.instance.getAcoount().getAccountSid().toString(),
                1,
                "stage4"
            )?.data?.bookList?.data?.forEach { datas.add(it) }

    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}
