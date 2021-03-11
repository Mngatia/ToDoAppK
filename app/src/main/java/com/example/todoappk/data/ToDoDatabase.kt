package com.example.todoappk.data

import android.content.Context
import androidx.room.*
import com.example.todoappk.data.models.ToDoData


@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase(){

    abstract fun todoDao(): ToDoDao

//    companion object {
//
//        @Volatile
//        private var INSTANCE: ToDoDatabase? = null
//
//        fun getDatabase(context: Context): ToDoDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null){
//                return tempInstance
//            }
//
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ToDoDatabase::class.java,
//                    "todo_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase = INSTANCE ?: synchronized(this){
            INSTANCE ?: builDatabase(context).also { INSTANCE = it}
        }

        private fun builDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ToDoDatabase::class.java,
        "todo_database").build()
    }
}