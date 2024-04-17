package ru.ygmatveev.puppies.DaoModels

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.ygmatveev.puppies.DbModels.AnimalDb


@Dao
interface AnimalDao {
    @Insert
    fun addAnimal(animal: AnimalDb)

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): Flow<List<AnimalDb>>

    @Query("SELECT * FROM animals WHERE id = :id")
    fun getAnimalById(id: Int): AnimalDb

}