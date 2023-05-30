package com.codenesia.quranapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codenesia.quranapp.data.DataItem
import com.codenesia.quranapp.data.QuranResponse
import com.codenesia.quranapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val _listQuran = MutableLiveData<ArrayList<DataItem>>()
    val listQuran: LiveData<ArrayList<DataItem>> = _listQuran

    fun getQuranData() {
        val client = ApiConfig.getApiService().getQuran()
        client.enqueue(object : Callback<QuranResponse> {

            override fun onResponse(call: Call<QuranResponse>, response: Response<QuranResponse>) {
                val data = response.body()
                if (data != null) {
                    _listQuran.value = ArrayList(data.data)
                }
            }

            override fun onFailure(call: Call<QuranResponse>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })
    }
}