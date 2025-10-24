package com.example.responsi1mobileh1d023070

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023070.data.model.Player
import com.example.responsi1mobileh1d023070.databinding.ActivityPlayerBinding
import com.example.responsi1mobileh1d023070.ui.adapter.OnPlayerClickListener
import com.example.responsi1mobileh1d023070.ui.adapter.PlayerAdapter
import com.example.responsi1mobileh1d023070.ui.fragment.PlayerDetailFragment
import com.example.responsi1mobileh1d023070.viewmodel.MainViewModel

class PlayerActivity : AppCompatActivity(),  OnPlayerClickListener {
    private lateinit var binding: ActivityPlayerBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = PlayerAdapter (emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.teamData.observe(this) { teamResponse ->
            adapter.setData(teamResponse.squad.orEmpty())
        }
        viewModel.loadJuventusData()
    }

    override fun onPlayerClick(player: Player) {
        player.let { b->
            PlayerDetailFragment(
                b.name?:"Unknown Name",
                b.dateOfBirth?: "Unknown Date of Birth",
                b.nationality?: "Unknown Nationality",
                b.position?: "Unknown Position"
            ).show(supportFragmentManager, PlayerDetailFragment::class.java.simpleName)
        }
    }
}