package ru.ygmatveev.puppies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import androidx.annotation.UiThread
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import ru.ygmatveev.puppies.adapter.AnimalAdapter
import ru.ygmatveev.puppies.databinding.ActivityListAnimalsBinding
import ru.ygmatveev.puppies.db.AnimalsDbContext
import ru.ygmatveev.puppies.model.AnimalModel

class ListAnimalsActivity : AppCompatActivity() {

    lateinit var binding: ActivityListAnimalsBinding
    lateinit var adapter: AnimalAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var db: AnimalsDbContext

    private var imageIds: Array<Int> = arrayOf(
        R.drawable.screen_shot_2019_08_08_at_10_51_04_am
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AnimalsDbContext.getDatabase(this)

        binding = ActivityListAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        recyclerView = binding.rvAnimals

        adapter = AnimalAdapter(this)

        binding.rvAnimals.adapter = adapter
        adapter.setList(initAnimalModelList())
    }

    override fun onStart() {
        super.onStart()
        adapter.setList(initAnimalModelList()) // refresh adapter
    }

    override fun onStop() {
        super.onStop()
        adapter.setList(arrayListOf()) // clear adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.setList(arrayListOf())
    }

    private fun initAnimalModelList(): ArrayList<AnimalModel> {
        val animalList = ArrayList<AnimalModel>()

        db.animalsDao().getAllAnimals().asLiveData().observe(this@ListAnimalsActivity) {
            for (animal in it) {
                animalList.add(AnimalModel(animal.id!!, animal.name, imageIds[0]))
            }

            adapter.setList(animalList)
        }

        return animalList
    }
}