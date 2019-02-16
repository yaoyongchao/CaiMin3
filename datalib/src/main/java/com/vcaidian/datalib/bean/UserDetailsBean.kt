package com.vcaidian.datalib.bean

import com.vcaidian.datalib.base.BaseResponseBody
import com.vcaidian.datalib.db.CurStation
import com.vcaidian.datalib.db.User

class UserDetailsBean : BaseResponseBody() {
    val account: List<AccountBean>? = null
    val base: User? = null
    val code_balance: Long = 0
    val cur_station: CurStation? = null
}
