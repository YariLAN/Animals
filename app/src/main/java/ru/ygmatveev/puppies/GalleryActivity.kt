package ru.ygmatveev.puppies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.ygmatveev.puppies.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {
    lateinit var binding: ActivityGalleryBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate((layoutInflater));

        setContentView(binding.root)

        binding.button3.setOnClickListener {

            if(binding.radiobtn.checkedRadioButtonId != -1) {

                if (binding.labrador.isChecked || binding.novi.isChecked) {
                    Toast.makeText(this, "Неверный ответ", Toast.LENGTH_SHORT).show();
                }

                if (binding.gold.isChecked) {
                    Toast.makeText(this, "Верный ответ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}