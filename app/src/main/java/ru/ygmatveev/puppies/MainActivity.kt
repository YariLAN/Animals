package ru.ygmatveev.puppies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.ygmatveev.puppies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate((layoutInflater))

        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java);
            startActivity(intent);
        }

        mainBinding.imageSetting.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java);
            startActivity(intent);
        }

        mainBinding.button2.setOnClickListener {
            val intent = Intent(this, ListAnimalsActivity::class.java);
            startActivity(intent);
        }
    }
}