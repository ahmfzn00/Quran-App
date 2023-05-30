package com.codenesia.quranapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codenesia.quranapp.data.DataItem

class MainAdapter(private val listQuran: ArrayList<DataItem>): RecyclerView.Adapter<MainAdapter.ListViewHolder>() {


    private lateinit var onItemClickCallback: OnItemClickCallback


    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val namaSurahArab : TextView = itemView.findViewById(R.id.it_tv_surahArab)
        private val namaSurah : TextView = itemView.findViewById(R.id.it_tv_surah)
        fun binding(quran: DataItem) {
            namaSurah.text = quran.namaLatin
            namaSurahArab.text = quran.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return MainAdapter.ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quran, parent, false)
        )
    }

    override fun getItemCount(): Int = listQuran.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listQuran[position]
        holder.binding(data)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(
                listQuran[position]
            )
        }
    }

    fun setOnItemClick(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }
}