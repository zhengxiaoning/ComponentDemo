package xiaoning.com.login

import com.google.gson.annotations.SerializedName


/**
 * Author by kobe, Email 995270893@qq.com, Date on 2019-11-12.
 *
 */
data class LoginBean(
    @SerializedName("data")
    var `data`: Data? = Data(),
    @SerializedName("error")
    var error: String = "",
    @SerializedName("status")
    var status: Int = 0
)

data class Data(
    @SerializedName("address")
    var address: String = "",
    @SerializedName("allow_online_notice")
    var allowOnlineNotice: Int = 0,
    @SerializedName("avator")
    var avator: String = "",
    @SerializedName("babys")
    var babys: List<Baby>? = listOf(),
    @SerializedName("birthday")
    var birthday: String = "",
    @SerializedName("created_at")
    var createdAt: Int = 0,
    @SerializedName("ehr_id")
    var ehrId: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("en_name")
    var enName: String = "",
    @SerializedName("firstlogin")
    var firstlogin: Int = 0,
    @SerializedName("last_login_at")
    var lastLoginAt: String = "",
    @SerializedName("open_id")
    var openId: String = "",
    @SerializedName("realname")
    var realname: String = "",
    @SerializedName("roles")
    var roles: Any = Any(),
    @SerializedName("sex")
    var sex: String = "",
    @SerializedName("sons")
    var sons: List<Son>? = listOf(),
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("tele")
    var tele: String = "",
    @SerializedName("token")
    var token: String = "",
    @SerializedName("type")
    var type: Int = 0,
    @SerializedName("uid")
    var uid: Int = 0,
    @SerializedName("unionid")
    var unionid: String = "",
    @SerializedName("updated_at")
    var updatedAt: Int = 0,
    @SerializedName("username")
    var username: String = ""
)

data class Baby(
    @SerializedName("avator")
    var avator: String = "",
    @SerializedName("class_id")
    var classId: Int = 0,
    @SerializedName("en_name")
    var enName: String = "",
    @SerializedName("kindship")
    var kindship: String = "",
    @SerializedName("sid")
    var sid: Int = 0
)

data class Son(
    @SerializedName("avator")
    var avator: String = "",
    @SerializedName("class_id")
    var classId: Int = 0,
    @SerializedName("en_name")
    var enName: String = "",
    @SerializedName("kindship")
    var kindship: String = "",
    @SerializedName("sid")
    var sid: Int = 0
)