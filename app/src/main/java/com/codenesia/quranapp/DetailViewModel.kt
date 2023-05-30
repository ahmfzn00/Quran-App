package com.codenesia.quranapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codenesia.quranapp.data.AyatItem
import com.codenesia.quranapp.data.SuratResponse
import com.codenesia.quranapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    private val _listAyat = MutableLiveData<ArrayList<AyatItem>>()
    val listAyat: LiveData<ArrayList<AyatItem>> = _listAyat

    fun getAyat(nomor: Int) {

        val client = ApiConfig.getApiService().getSurat(nomor)
        client.enqueue(object: Callback<SuratResponse> {
            override fun onResponse(call: Call<SuratResponse>, response: Response<SuratResponse>) {
                if (response.body() != null) {
                    val data = response.body()?.data
                    val surat = data?.ayat

                    _listAyat.value = surat as ArrayList<AyatItem>
                }
            }

            override fun onFailure(call: Call<SuratResponse>, t: Throwable) {
                Log.e("Detail", t.message.toString())
            }
        })
    }

}