package com.example.tugas_eka3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_eka3.databinding.ActivityRecyclerBinding

class Recycler : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding

    private lateinit var produkRecyclerView: RecyclerView
    private lateinit var produkAdapter: MyAdapter
    private lateinit var listProduk: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnback.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        produkRecyclerView = findViewById(R.id.bucketRV)
        listProduk = ArrayList()

        listProduk.add(
            ItemData(
                R.drawable.bunga1,
                "Rose Bouquet",
                "Elegan dan romantis untuk hari pernikahan"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga2,
                "Tulip Bouquet",
                "Tampilan modern dengan warna cerah"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga3,
                "Lily Bouquet",
                "Keindahan klasik dengan aroma yang menenangkan"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga4,
                "Daisy Bouquet",
                "Kesegaran alami untuk pernikahan santai"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga5,
                "Mixed Flowers",
                "Kombinasi bunga beragam untuk tampilan unik"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga6,
                "Sunflower Bouquet",
                "Energi dan keceriaan di hari bahagia"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga7,
                "Orchid Bouquet",
                "Keanggunan eksotis yang tahan lama"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga8,
                "Peony Bouquet",
                "Kemewahan dengan nuansa lembut dan romantis"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga9,
                "Hydrangea Bouquet",
                "Sentuhan elegan dengan warna lembut"
            )
        )
        listProduk.add(
            ItemData(
                R.drawable.bunga10,
                "Carnation Bouquet",
                "Bunga klasik dengan simbol cinta dan kekaguman"
            )
        )

        produkRecyclerView.layoutManager = LinearLayoutManager(this)
        produkRecyclerView.setHasFixedSize(true)
        produkAdapter = MyAdapter(listProduk)
        produkRecyclerView.adapter = produkAdapter
    }
}