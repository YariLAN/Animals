package ru.ygmatveev.puppies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ygmatveev.puppies.DbModels.AnimalDb
import ru.ygmatveev.puppies.databinding.ActivityAddAnimalBinding
import ru.ygmatveev.puppies.db.AnimalsDbContext

class AddAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AnimalsDbContext.getDatabase(this)

        binding = ActivityAddAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val animal = AnimalDb(
                null,
                binding.editTextTextPersonName2.text.toString(),
                binding.locationName.text.toString(),
                binding.editTextTextPersonName4.text.toString(),
                binding.editTextTextPersonName5.text.toString())

            Thread {
                db.animalsDao().addAnimal(animal)
            }.start()

            intent = Intent(this, ListAnimalsActivity::class.java)
            startActivity(intent)
        }
    }
}