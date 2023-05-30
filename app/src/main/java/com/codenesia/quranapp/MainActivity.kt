package com.codenesia.quranapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codenesia.quranapp.data.DataItem
import com.codenesia.quranapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        mainViewModel.getQuranData()
        setContentView(binding.root)

        showAdapter()
    }

    private fun showAdapter() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvQuran.layoutManager = layoutManager

        mainViewModel.listQuran.observe(this){ data -> setDataAdapter(data) }
    }

    private fun setDataAdapter(data: ArrayList<DataItem>) {
        val adapter = MainAdapter(data)
        binding.rvQuran.adapter = adapter

        adapter.setOnItemClick{data -> selectData(data)}
    }

    private fun selectData(data: DataItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.NOMOR_AYAT, data.nomor.toString())
        startActivity(intent)
    }

}