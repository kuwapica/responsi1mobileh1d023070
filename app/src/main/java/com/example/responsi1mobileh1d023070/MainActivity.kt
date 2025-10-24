package com.example.responsi1mobileh1d023070

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023070.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ball)
            it.tvLayout.setText(R.string.club_history)
        }
        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.person)
            it.tvLayout.setText(R.string.head_coach)
        }
        binding.layoutSquad.let {
            it.imgIcon.setImageResource(R.drawable.squad)
            it.tvLayout.setText(R.string.team_squad)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryClubActivity::class.java))
        }
        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, HeadCoachActivity::class.java))
        }
        binding.layoutSquad.root.setOnClickListener {
            startActivity(Intent(this, PlayerActivity::class.java))
        }
    }
}