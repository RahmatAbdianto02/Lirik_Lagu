package com.dicoding.liriklagu.DetailLirik

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.liriklagu.Data.Singer
import com.dicoding.liriklagu.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_LIRIK = "key_lirik"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.songImageView)
        val tvName: TextView = findViewById(R.id.titleJudulView)
        val tvDescription: TextView = findViewById(R.id.lyricsTextView)

        // Mengambil data dari intent
        val lirikLagu = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(KEY_LIRIK, Singer::class.java)
        } else {
            intent.getParcelableExtra<Singer>(KEY_LIRIK)
        }

        // Menampilkan data jika tidak null
        lirikLagu?.let {
            tvName.text = it.name
            tvDescription.text = it.description

            // Pastikan untuk mengimpor Glide dengan benar
            Glide.with(this)
                .load(it.photo)
                .into(imgPhoto)
        }
    }
}
