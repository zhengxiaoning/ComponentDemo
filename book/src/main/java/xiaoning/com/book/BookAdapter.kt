package xiaoning.com.book

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.book_item_layout.view.*

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-19.
 *
 */
class BookAdapter(val mContext: Context, val datas: ArrayList<BookBean.Data.BookList.DataX>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.book_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = datas.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.itemView.apply {
                Glide.with(mContext)
                    .load("https://opas-file-aliyun.firstleap.cn${datas[position].pic}")
                    .into(cover)
                bookname.text = datas[position].bookName
                setOnClickListener {
                    val intent = Intent(mContext, TestActivity::class.java)
                    intent.putExtra(
                        "url",
                        "https://opas-file-aliyun.firstleap.cn${datas[position].pic}"
                    )
                    mContext.startActivity(intent)
                }
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}