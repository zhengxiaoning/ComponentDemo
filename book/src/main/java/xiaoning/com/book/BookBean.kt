package xiaoning.com.book

import com.google.gson.annotations.SerializedName


/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-18.
 *
 */
data class BookBean(
    @SerializedName("data")
    var `data`: Data = Data(),
    @SerializedName("error")
    var error: String = "",
    @SerializedName("status")
    var status: Int = 0
) {
    data class Data(
        @SerializedName("book_list")
        var bookList: BookList = BookList(),
        @SerializedName("stage")
        var stage: String = ""
    ) {
        data class BookList(
            @SerializedName("current_page")
            var currentPage: String = "",
            @SerializedName("data")
            var `data`: List<DataX> = listOf(),
            @SerializedName("from")
            var from: Any = Any(),
            @SerializedName("last_page")
            var lastPage: Int = 0,
            @SerializedName("next_page_url")
            var nextPageUrl: Any = Any(),
            @SerializedName("per_page")
            var perPage: Int = 0,
            @SerializedName("prev_page_url")
            var prevPageUrl: Any = Any(),
            @SerializedName("to")
            var to: Any = Any(),
            @SerializedName("total")
            var total: Int = 0
        ) {
            data class DataX(
                @SerializedName("bid")
                var bid: Int = 0,
                @SerializedName("book_name")
                var bookName: String = "",
                @SerializedName("cid")
                var cid: Int = 0,
                @SerializedName("color_code")
                var colorCode: Int = 0,
                @SerializedName("created_at")
                var createdAt: Int = 0,
                @SerializedName("finish_status")
                var finishStatus: Int = 0,
                @SerializedName("leap_stage")
                var leapStage: String = "",
                @SerializedName("new_stage")
                var newStage: String = "",
                @SerializedName("orientation")
                var orientation: Int = 0,
                @SerializedName("pic")
                var pic: String = "",
                @SerializedName("super_cid")
                var superCid: Int = 0
            )
        }
    }
}





