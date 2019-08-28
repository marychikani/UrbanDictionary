package chikani.marycarmen.urbandictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import chikani.marycarmen.urbandictionary.R
import chikani.marycarmen.urbandictionary.model.ListObject


class DictionaryAdapter(var dictionaryList: List<ListObject>) : RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.info_word, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dictionaryList.size
    }

    override fun onBindViewHolder(viewGroup: ViewHolder, viewType: Int) {

        viewGroup.txtWord.text = dictionaryList[viewType].word
        viewGroup.txtDefinition.text = dictionaryList[viewType].definition
        viewGroup.txtExample.text = dictionaryList[viewType].example
        viewGroup.txtThumbsUp.text = dictionaryList[viewType].thumbsUp.toString()
        viewGroup.txtThumbsDown.text = dictionaryList[viewType].thumbsDown.toString()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtWord = itemView.findViewById<TextView>(R.id.txtWord)
        val txtDefinition = itemView.findViewById<TextView>(R.id.txtDefinition)
        val txtExample = itemView.findViewById<TextView>(R.id.txtExample)
        val txtThumbsUp = itemView.findViewById<TextView>(R.id.txtThumbsUp)
        val txtThumbsDown = itemView.findViewById<TextView>(R.id.txtThumbsDown)

    }


    fun update(list: List<ListObject>) {
        dictionaryList = list
        notifyDataSetChanged()
    }

}