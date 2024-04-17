package ru.ygmatveev.puppies.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ygmatveev.puppies.AnimalActivity
import ru.ygmatveev.puppies.CatsActivity
import ru.ygmatveev.puppies.R
import ru.ygmatveev.puppies.databinding.ItemAnimalLayoutBinding
import ru.ygmatveev.puppies.model.AnimalModel

class AnimalAdapter(context: Context) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animals: ArrayList<AnimalModel> = arrayListOf()

    private var context: Context = context;
    class AnimalViewHolder(animal: View): RecyclerView.ViewHolder(animal) {
        private val bind = ItemAnimalLayoutBinding.bind(animal)

        fun bind(animal: AnimalModel) = with(bind) {
            animalImage.setImageResource(animal.imgId)
            animalLabel.text = animal.label
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalAdapter.AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal_layout, parent, false)

        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])

        holder.itemView.setOnClickListener {
//            if (animals[position].label == "Cats") {
//                val intent = Intent(context, CatsActivity::class.java)
//                context.startActivity(intent)
//            }
//
//            if (animals[position].label == "Dogs") {
//                val intent = Intent(context, DogsActivity::class.java)
//                context.startActivity(intent)
//            }
//
//            if (animals[position].label == "Rabbits") {
//                val intent = Intent(context, RabbitsActivity::class.java)
//                context.startActivity(intent)
//            }

            val intent = Intent(context, AnimalActivity::class.java)
            intent.putExtra("id", animals[position].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    fun setList(list: ArrayList<AnimalModel>) {
        animals = list
        notifyDataSetChanged()
    }
}