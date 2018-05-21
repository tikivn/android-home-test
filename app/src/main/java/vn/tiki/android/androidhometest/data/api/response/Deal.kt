package vn.tiki.android.androidhometest.data.api.response

import java.util.Date

class Deal(
    val productName: String,
    val productThumbnail: String,
    val productPrice: Double,
    val startedDate: Date,
    val endDate: Date
)
