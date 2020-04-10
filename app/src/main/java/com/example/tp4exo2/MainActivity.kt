package com.example.tp4exo2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vuelivres = findViewById(R.id.liste) as ListView
        val livres = resources.getStringArray(R.array.titre)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, livres)
        vuelivres.adapter = adapter

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            vuelivres.setOnItemClickListener { _, _, position, _ ->
                val element = adapter.getItemId(position).toString() // The item that was clicked

                val pos =element.toInt()

                val title = findViewById(R.id.titlel) as TextView
                title.text = resources.getStringArray(R.array.titre)[pos]

                val auteur = findViewById(R.id.auteurl) as TextView
                auteur.text = resources.getStringArray(R.array.auteur)[pos]

                val resume = findViewById(R.id.resumel) as TextView
                resume.text = resources.getStringArray(R.array.resume)[pos]

                var img = resources.obtainTypedArray(R.array.couverture)
                //var i = resources.getIntArray(R.array.couverture)[pos]
                couverturel.setImageResource(img.getResourceId(pos,-1))
            }
        } else {
            vuelivres.setOnItemClickListener { _, _, position, _ ->
                val element = adapter.getItemId(position) // The item that was clicked


                val intent = Intent(this@MainActivity,BookDetailActivity::class.java)
                intent.putExtra("position",element.toString())
                startActivity(intent)
            }
        }


    }

}
