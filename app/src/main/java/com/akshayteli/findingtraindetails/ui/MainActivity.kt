package com.akshayteli.findingtraindetails.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshayteli.findingtraindetails.R
import com.akshayteli.findingtraindetails.adapter.TrainRecyclerAdapter
import com.akshayteli.findingtraindetails.model.Request

class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter: TrainRecyclerAdapter
    lateinit var recyclerView:RecyclerView
    lateinit var btnSearch:Button
    lateinit var txtSearch:TextView
    lateinit var request: Request
    lateinit var txtTrainCount:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch = findViewById(R.id.btnSearch)
        recyclerView = findViewById(R.id.recyclerView)
        txtSearch = findViewById(R.id.search)
        txtTrainCount = findViewById(R.id.trainNumber)
        initRecycler()
        createData()

        supportActionBar?.hide()
    }

    private fun createData() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerAdapter = TrainRecyclerAdapter()
            adapter = recyclerAdapter

        }
    }

    private fun initRecycler() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getListDataObserver().observe(this) {
            if (it != null) {
                if(it.size> 0){
                    txtTrainCount.text = "Train Count : ${it.size}"
                    Log.d("TAG", "initRecycler: ${it.size}")
                    it?.let { it1 -> recyclerAdapter.setListData(it1) }
                    recyclerAdapter.notifyDataSetChanged()
                }
                else{
                    txtTrainCount.text = "Train Count : 0"
                    recyclerAdapter.setListData(null)
                    recyclerAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "No data found for this train", Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Error in getting data from api.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btnSearch.setOnClickListener {
            viewModel.makeAPICall( txtSearch.text.toString())
            closeKeyBoard()
        }
    }

    override fun onResume() {
        super.onResume()
        createData()
    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}