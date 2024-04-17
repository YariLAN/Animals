package ru.ygmatveev.puppies

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import ru.ygmatveev.puppies.databinding.ActivityAnimalBinding
import ru.ygmatveev.puppies.db.AnimalsDbContext

class AnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalBinding

    private lateinit var db: AnimalsDbContext

    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AnimalsDbContext.getDatabase(this)
        intent = getIntent()

        binding = ActivityAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        initDataAboutAnimal()
    }

    private fun initDataAboutAnimal() {
        Thread {
            val animal = db.animalsDao().getAnimalById(intent.getIntExtra("id", -1))

            binding.nameAnimal.text = animal.name

            val locations = animal.location.split(", ", ",")

            binding.loc.adapter = ArrayAdapter(this, R.layout.simple_list_item_activated_1, locations)
            binding.factNum1.text = animal.fact1
            binding.factNum2.text = animal.fact2
        }.start()
    }
}