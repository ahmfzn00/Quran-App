package com.codenesia.quranapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codenesia.quranapp.data.AyatItem
import com.codenesia.quranapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val NOMOR_AYAT = "nomor"
        var nomor = String()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)

        setContentView(binding.root)

        nomor = intent.getStringExtra(NOMOR_AYAT).toString()
        Toast.makeText(this, nomor, Toast.LENGTH_SHORT).show()

        detailViewModel.getAyat(nomor.toInt())
        showAyat()
    }

    private fun showAyat(){
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvAyat.layoutManager = linearLayoutManager

        detailViewModel.listAyat.observe(this){ ayat -> setAyat(ayat) }
    }

    private fun setAyat(ayat: ArrayList<AyatItem>) {
        val adapter = DetailAdapter(ayat)
        binding.rvAyat.adapter = adapter
    }
}
