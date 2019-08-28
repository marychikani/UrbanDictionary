package chikani.marycarmen.urbandictionary.api

open class DataSourceException(message: String? = null) : Exception(message) {
    class RemoteDataNotFoundException : DataSourceException("Data not found")

}