package com.example.lab6_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)

        val countries = createSampleCountries()

        adapter = CountryAdapter(countries) { country ->
            Toast.makeText(this, "Выбранная страна: ${country.name}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }

    private fun createSampleCountries(): List<Country> {
        return listOf(
            Country("Казахстан", "19 миллионов", R.drawable.kazakhstan),
            Country("США", "331 миллион", R.drawable.usa),
            Country("Китай", "1.4 миллиарда", R.drawable.china),
            Country("Индия", "1.3 миллиарда", R.drawable.india),
            Country("Бразилия", "213 миллионов", R.drawable.brazil)
        )
    }
}