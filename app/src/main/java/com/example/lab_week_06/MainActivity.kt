package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        val clickListener = object : CatViewHolder.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        }
        CatAdapter(layoutInflater, GlideImageLoader(this), clickListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                // 7 Kucing Baru
                CatModel(
                    Gender.Male, CatBreed.ExoticShorthair, "Rocky", "A grumpy but lovable couch potato",
                    "https://cdn2.thecatapi.com/images/4i2.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.BalineseJavanese, "Willow", "Very talkative and elegant",
                    "https://cdn2.thecatapi.com/images/13v.jpg"
                ),
                CatModel(
                    Gender.Male, CatBreed.AmericanCurl, "Jasper", "Loves chasing laser dots",
                    "https://cdn2.thecatapi.com/images/aob.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.ExoticShorthair, "Hazel", "Loves to be brushed",
                    "https://cdn2.thecatapi.com/images/9j5.jpg"
                ),
                CatModel(
                    Gender.Male, CatBreed.BalineseJavanese, "Oliver", "Will do anything for a treat",
                    "https://cdn2.thecatapi.com/images/3r8.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.AmericanCurl, "Pepper", "Quick, playful, and full of energy",
                    "https://cdn2.thecatapi.com/images/5iYq9A-tW.jpg"
                ),
                CatModel(
                    Gender.Unknown, CatBreed.ExoticShorthair, "Binx", "Mysterious and a bit magical",
                    "https://cdn2.thecatapi.com/images/KJF8fB_20.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}