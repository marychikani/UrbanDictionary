package chikani.marycarmen.urbandictionary.model

import com.google.gson.annotations.SerializedName

data class ListObject(
    @SerializedName("definition")
    var definition: String,

    @SerializedName("thumbs_up")
    var thumbsUp: Int,

    @SerializedName("word")
    var word: String,

    @SerializedName("thumbs_down")
    var thumbsDown: Int,

    @SerializedName("example")
    var example: String

)
