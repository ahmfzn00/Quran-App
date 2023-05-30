package com.codenesia.quranapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codenesia.quranapp.data.AyatItem

class DetailAdapter(private val listAyat: ArrayList<AyatItem>): RecyclerView.Adapter<DetailAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nomorAyat : TextView = itemView.findViewById(R.id.nomorAyat)
        private val ayatArab : TextView = itemView.findViewById(R.id.ayatArab)
        private val artiAyat: TextView = itemView.findViewById(R.id.artiAyat)
        fun binding(quran: AyatItem) {
            nomorAyat.text = quran.nomorAyat.toString()
            ayatArab.text = quran.teksArab
            artiAyat.text = quran.teksIndonesia
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return DetailAdapter.ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ayat, parent, false)
        )
    }

    override fun getItemCount(): Int = listAyat.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listAyat[position]
        holder.binding(data)
    }


}