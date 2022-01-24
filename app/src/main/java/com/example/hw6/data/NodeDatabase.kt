package com.example.hw6.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Node::class], version = 1, exportSchema = false)
@TypeConverters(NodeConverter::class)

abstract class NodeDatabase: RoomDatabase() {

    abstract fun nodeDao(): NodeDao

    companion object{
        @Volatile
        private var INSTANCE: NodeDatabase? = null

        fun getDatabase(context: Context): NodeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NodeDatabase::class.java,
                    "node_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}