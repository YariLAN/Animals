package ru.ygmatveev.puppies.db

import androidx.room.RoomDatabase
import androidx.room.Room
import android.content.Context
import androidx.room.Database
import ru.ygmatveev.puppies.DaoModels.AnimalDao
import ru.ygmatveev.puppies.DbModels.AnimalDb

// Антотация базы данных

@Database (entities = [AnimalDb::class], version = 1)
abstract class AnimalsDbContext() : RoomDatabase() {

    abstract fun animalsDao(): AnimalDao

    companion object {
        fun getDatabase(context: Context): AnimalsDbContext {
            return Room.databaseBuilder(context,
                AnimalsDbContext::class.java,
                "animals.db"
            ).build()
        }
    }
}