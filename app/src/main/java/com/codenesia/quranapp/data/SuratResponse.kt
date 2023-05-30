package com.codenesia.quranapp.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class SuratResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("jumlahAyat")
	val jumlahAyat: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("suratSebelumnya")
	val suratSebelumnya: SuratSebelumnya? = null,

	@field:SerializedName("tempatTurun")
	val tempatTurun: String? = null,

	@field:SerializedName("ayat")
	val ayat: List<AyatItem>? = null,

	@field:SerializedName("arti")
	val arti: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("suratSelanjutnya")
	val suratSelanjutnya: SuratSelanjutnya? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null,

	@field:SerializedName("namaLatin")
	val namaLatin: String? = null
) : Parcelable


@Parcelize
data class SuratSebelumnya(

	@field:SerializedName("jumlahAyat")
	val jumlahAyat: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null,

	@field:SerializedName("namaLatin")
	val namaLatin: String? = null
) : Parcelable

@Parcelize
data class SuratSelanjutnya(

	@field:SerializedName("jumlahAyat")
	val jumlahAyat: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null,

	@field:SerializedName("namaLatin")
	val namaLatin: String? = null
) : Parcelable


@Parcelize
data class AyatItem(

	@field:SerializedName("teksArab")
	val teksArab: String? = null,

	@field:SerializedName("teksLatin")
	val teksLatin: String? = null,

	@field:SerializedName("nomorAyat")
	val nomorAyat: Int? = null,

	@field:SerializedName("teksIndonesia")
	val teksIndonesia: String? = null
) : Parcelable
