package xiaoning.com.base

import android.view.View
import android.widget.Checkable

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-21.
 *
 */
var lastClickTime = 0L
var lastId = -1

inline fun <T : View> T.singleClick(
    id: Int = 0,
    time: Long = 2500L,
    crossinline block: (T) -> Unit
) {
    //先判断点击是不是同一id 若是，则再次点击时应加上几秒内防重复点击逻辑；若不是，则再次点击时可以先点击。
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastId != id) {
            lastClickTime = currentTime
            lastId = id
            block(this)
        } else {
            if (currentTime - lastClickTime > time || this is Checkable) {
                lastClickTime = currentTime
                lastId = id
                block(this)
            }
        }


    }
}