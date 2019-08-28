package chikani.marycarmen.urbandictionary.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import chikani.marycarmen.urbandictionary.api.DataSourceException
import chikani.marycarmen.urbandictionary.model.Definition
import chikani.marycarmen.urbandictionary.repository.RepoDictionaryDataSource
import chikani.marycarmen.urbandictionary.repository.Result
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainActivityViewModel() : ViewModel(), CoroutineScope {

    private val listDefinition = MutableLiveData<Definition>()
    private val service = RepoDictionaryDataSource

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job


    fun getDictionaryData(term: String) {

        launch {
            try {

                val definitionDataSource = service.newInstance()

                withContext(Dispatchers.IO) {
                    try {
                        val result = definitionDataSource.getDefinitions(term)
                        if (result is Result.Success) {
                            listDefinition.postValue(result.data)

                        } else {

                            Log.i("E:", "Result.Error")

                        }

                    } catch (error: DataSourceException.RemoteDataNotFoundException) {

                        Log.i("EC:", "Result.Error")

                    }
                }


            } catch (e: Exception) {
                Log.i("EPC:", "Result.Error")
            }


        }


    }

    fun getDefinitions(): MutableLiveData<Definition> {
        return listDefinition
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }


    fun sortData(ascending: Boolean) {

        launch {

            withContext(Dispatchers.IO) {
                try {

                    val ss = listDefinition.value?.list?.sortedByDescending { definition ->
                        if (ascending) definition.thumbsUp else definition.thumbsDown
                    }.orEmpty()


                    listDefinition.value?.list = ss
                    listDefinition.postValue(listDefinition.value)

                } catch (e: Exception) {

                    Log.i("EPCS:", "Result.Error")
                }


            }
        }

    }

}

