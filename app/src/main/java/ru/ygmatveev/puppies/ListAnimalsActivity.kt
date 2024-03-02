package ru.ygmatveev.puppies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ygmatveev.puppies.databinding.ActivityListAnimalsBinding

class ListAnimalsActivity : AppCompatActivity() {

    lateinit var binding: ActivityListAnimalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListAnimalsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.imageView2.setOnClickListener {
            val intent = Intent(this, RabbitsActivity::class.java);
            startActivity(intent);
        }

        binding.imageView3.setOnClickListener {
            val intent = Intent(this, DogsActivity::class.java);
            startActivity(intent);
        }

        binding.imageView4.setOnClickListener {
            val intent = Intent(this, CatsActivity::class.java);
            startActivity(intent);
        }
    }


}