package chikani.marycarmen.urbandictionary.model

import com.google.gson.annotations.SerializedName

data class Definition(

    @SerializedName("list")
    var  list: List<ListObject>

)