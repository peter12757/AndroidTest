package com.eathemeat.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eathemeat.myapplication.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.rvTest.layoutManager = layoutManager
        binding.rvTest.adapter = ModuleAdapter()
    }

}