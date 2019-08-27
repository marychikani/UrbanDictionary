package chikani.marycarmen.urbandictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import chikani.marycarmen.urbandictionary.R
import chikani.marycarmen.urbandictionary.model.ListObject


class DictionaryAdapter(var dictionaryList: List<ListObject>) : RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.info_word, p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dictionaryList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.txt_word.text = dictionaryList[p1].word
        p0.txt_definition.text = dictionaryList[p1].definition
        p0.txt_example.text = dictionaryList[p1].example
        p0.txt_thumbs_up.text = dictionaryList[p1].thumbs_up.toString()
        p0.txt_thumbs_down.text = dictionaryList[p1].thumbs_down.toString()

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txt_word = itemView.findViewById<TextView>(R.id.txt_word)
        val txt_definition = itemView.findViewById<TextView>(R.id.txt_definition)
        val txt_example = itemView.findViewById<TextView>(R.id.txt_example)
        val txt_thumbs_up = itemView.findViewById<TextView>(R.id.txt_thumbs_up)
        val txt_thumbs_down = itemView.findViewById<TextView>(R.id.txt_thumbs_down)

    }


    fun update(list: List<ListObject>) {
        dictionaryList = list
        notifyDataSetChanged()
    }

}