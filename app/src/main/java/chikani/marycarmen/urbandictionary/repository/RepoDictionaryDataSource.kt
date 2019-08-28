package chikani.marycarmen.urbandictionary.repository

import chikani.marycarmen.urbandictionary.api.DataSourceException
import chikani.marycarmen.urbandictionary.api.DictionaryApi
import chikani.marycarmen.urbandictionary.model.Definition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class RepoDictionaryDataSource(val apiService: DictionaryApi) {


    suspend fun getDefinitions(term: String): Result<Definition> = withContext(Dispatchers.IO) {

        //get data from apiService, passing term
        val request = apiService.getCurrentWordData(term).await()

        try {
            val response = request
            //return definition object
            Result.Success(response)
        } catch (ex: HttpException) {
            Result.Error(DataSourceException.RemoteDataNotFoundException())
        } catch (ex: Throwable) {
            Result.Error(DataSourceException.RemoteDataNotFoundException())
        }


    }

    companion object {
        //Create instance of Repository API
        fun newInstance() =
            RepoDictionaryDataSource(DictionaryApi.create())
    }


}