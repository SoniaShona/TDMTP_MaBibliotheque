package com.example.tp4exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val pos =intent.getStringExtra("position").toInt()

        val title = findViewById(R.id.title) as TextView
        title.text = resources.getStringArray(R.array.titre)[pos]

        val auteur = findViewById(R.id.auteur) as TextView
        auteur.text = resources.getStringArray(R.array.auteur)[pos]

        val resume = findViewById(R.id.resume) as TextView
        resume.text = resources.getStringArray(R.array.resume)[pos]

        var img = resources.obtainTypedArray(R.array.couverture)
        //var i = resources.getIntArray(R.array.couverture)[pos]
        couverture.setImageResource(img.getResourceId(pos,-1))




    }
}
