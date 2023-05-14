package com.example.conversiondeunidadescompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDao {

    //Es suspend fun porque la vamos a invocar desde una corrutina
    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    //getResults corre por su propio hilo automáticamente, no hace falta que sea suspend fun
    //Lo vamos a obtener como Flow<List<ConversionResult>>
    @Query("SELECT * FROM result_table")
    fun getResults(): Flow<List<ConversionResult>>

}