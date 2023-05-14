package com.example.conversiondeunidadescompose.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")//Nombre de la tabla
data class ConversionResult(

    @PrimaryKey(autoGenerate = true)//El id se va a autogenerar cuando se guarde el objeto
    @ColumnInfo(name = "result_id")
    val id : Int,

    @ColumnInfo(name = "result_message1")
    val messagePart1 : String,

    @ColumnInfo(name = "result_message2")
    val messagePart2 : String
)
