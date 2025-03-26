package com.example.lab6_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countries: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val populationTextView: TextView = itemView.findViewById(R.id.populationTextView)
        val flagImageView: ImageView = itemView.findViewById(R.id.flagImageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countries[position]

        holder.nameTextView.text = currentCountry.name
        holder.populationTextView.text = "Популяция: ${currentCountry.population}"
        holder.flagImageView.setImageResource(currentCountry.flagResource)

        holder.itemView.setOnClickListener {
            onItemClick(currentCountry)
        }
    }

    override fun getItemCount() = countries.size
}