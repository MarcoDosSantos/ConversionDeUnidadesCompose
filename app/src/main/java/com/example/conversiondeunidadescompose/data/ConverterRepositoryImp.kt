package com.example.conversiondeunidadescompose.data

import kotlinx.coroutines.flow.Flow
//Necesitamos una instancia del Dao como un parámetro del constructor de esta clase
class ConverterRepositoryImp (private val dao: ConverterDao): ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }
}