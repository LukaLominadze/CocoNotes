package com.example.coconotes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var noteCardModels: ArrayList<NoteCardModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteCardModels = ArrayList<NoteCardModel>()
        setupNoteCardModels()

        val recyclerView = findViewById<RecyclerView>(R.id.NoteRecyclerView)
        val recyclerViewAdapter = NoteCardRecyclerViewAdapter(this, noteCardModels)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupNoteCardModels() {
        val titles = resources.getStringArray(R.array.notecards)

        noteCardModels.ensureCapacity(titles.size)

        for(i in 0..titles.size-1) {
            noteCardModels.add(NoteCardModel(titles[i], "Here is the first line of the note"))
        }
    }
}