package chikani.marycarmen.urbandictionary.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import chikani.marycarmen.urbandictionary.model.Definition
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DefaultItemAnimator
import chikani.marycarmen.urbandictionary.model.ListObject
import chikani.marycarmen.urbandictionary.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private var ascending = true
    private var adapter: DictionaryAdapter? = null

    private lateinit var mActivityModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(chikani.marycarmen.urbandictionary.R.layout.activity_main)

        mActivityModel = ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel()::class.java)

        //Create observable of listDefinitions
        mActivityModel.getDefinitions().observe(this, androidx.lifecycle.Observer<Definition> { t ->

            if (t != null) {
                //add list to my recyclerview
                setupRecyclerView(t.list)
            }

            determinateBar.visibility = View.GONE

        })



        btnSearch.setOnClickListener {


            determinateBar.visibility = View.VISIBLE
            //pass word to the viewmodel
            mActivityModel.getDictionaryData(wordToSearch.text.toString().trim())

        }

        imageButton.setOnClickListener() {

            //sort listDefinitions
            sortData(ascending)
            ascending = !ascending

        }


    }


    fun setupRecyclerView(data: List<ListObject>) {

        if (adapter == null) {
            adapter = DictionaryAdapter(data)
            recyclerDictionary.setLayoutManager(LinearLayoutManager(this, RecyclerView.VERTICAL, false))

            recyclerDictionary.setAdapter(adapter)
            recyclerDictionary.setItemAnimator(DefaultItemAnimator())
            recyclerDictionary.setNestedScrollingEnabled(true)
        } else {

            adapter?.update(data)
        }
    }


    private fun sortData(ascending: Boolean) {

        mActivityModel.sortData(ascending)
    }
}



