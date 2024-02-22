package com.example.armadapp

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [BuildAr::class], version = 1, exportSchema = false)
public abstract class BuildArRoomDatabase : RoomDatabase() {

    abstract fun buildArDao() : BuildArDao

    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BuildArRoomDatabase? = null
    }

    fun getDatabase(
        context: Context,
        scope: CoroutineScope
    ): BuildArRoomDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                BuildArRoomDatabase::class.java,
                "build_ar_database"
            )
                // Wipes and rebuilds instead of migrating if no Migration object.
                .fallbackToDestructiveMigration()
                .addCallback(BuildArRoomDatabaseCallback(scope))
                .build()
            INSTANCE = instance
            // return instance
            instance
        }
    }
    private class BuildArRoomDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        /**
         * Override the onCreate method to populate the database.
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // If you want to keep the data through app restarts,
            // comment out the following line.
//                INSTANCE?.let { database ->
//                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.fourDigitDao())
//                    }
//                }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(dao: BuildArDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            dao.deleteAll()
            Log.d("BuildArRoomDatabase", "Database Deleted!!!")
        }
    }
}
