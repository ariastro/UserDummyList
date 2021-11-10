package io.astronout.usersdummyapp.data.source.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class GetUsersResponse(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "per_page")
    val perPage: Int? = null,
    @Json(name = "total")
    val total: Int? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "data")
    val `data`: List<Data?>? = null,
    @Json(name = "support")
    val support: Support? = null
) : Parcelable {
    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Data(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "email")
        val email: String? = null,
        @Json(name = "first_name")
        val firstName: String? = null,
        @Json(name = "last_name")
        val lastName: String? = null,
        @Json(name = "avatar")
        val avatar: String? = null
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Support(
        @Json(name = "url")
        val url: String? = null,
        @Json(name = "text")
        val text: String? = null
    ) : Parcelable
}