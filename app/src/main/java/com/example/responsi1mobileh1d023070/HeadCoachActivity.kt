package com.example.responsi1mobileh1d023070

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.responsi1mobileh1d023070.data.model.TeamResponse
import com.example.responsi1mobileh1d023070.viewmodel.MainViewModel

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var tvCoachName: TextView
    private lateinit var tvCoachBirth: TextView
    private lateinit var tvCoachNationality: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head_coach)

        initViews()
        setupViewModel()
        loadData()
    }

    private fun initViews() {
        tvCoachName = findViewById(R.id.tv_coach_name)
        tvCoachBirth = findViewById(R.id.tv_coach_birth)
        tvCoachNationality = findViewById(R.id.tv_coach_nationality)
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.teamData.observe(this) { team ->
            team?.coach?.let { coach ->
                tvCoachName.text = coach.name ?: "Unknown Coach"
                tvCoachBirth.text = coach.dateOfBirth ?: "Birth date not available"
                tvCoachNationality.text = coach.nationality ?: "Nationality not available"
            } ?: run {
                Toast.makeText(this, "Coach data not available", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        viewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, "Error: $it", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
    private fun loadData() {
        viewModel.loadJuventusData()
    }
}