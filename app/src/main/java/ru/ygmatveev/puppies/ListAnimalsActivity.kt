package ru.ygmatveev.puppies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import androidx.recyclerview.widget.RecyclerView
import ru.ygmatveev.puppies.adapter.AnimalAdapter
import ru.ygmatveev.puppies.databinding.ActivityListAnimalsBinding
import ru.ygmatveev.puppies.model.AnimalModel

class ListAnimalsActivity : AppCompatActivity() {

    lateinit var binding: ActivityListAnimalsBinding
    lateinit var adapter: AnimalAdapter
    lateinit var recyclerView: RecyclerView

    private var imageIds: Array<Int> = arrayOf(
        R.drawable._655791576_6_gas_kvas_com_p_sobaki_foto_shchenki_6,
        R.drawable._c874ef1cb9a53dac440b3e962c8350c,
        R.drawable._644815486_31_fikiwiki_com_p_khomyaki_krasivie_kartinki_39,
        R.drawable.s1200_11_1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

    private fun initAnimalModelList(): ArrayList<AnimalModel> {
        val animalList = ArrayList<AnimalModel>()

        animalList.add(AnimalModel(imageIds[0], "Dogs"))
        animalList.add(AnimalModel(imageIds[1], "Cats"))
        animalList.add(AnimalModel(imageIds[2], "Hamsters"))
        animalList.add(AnimalModel(imageIds[3], "Rabbits"))

        return animalList
    }
}