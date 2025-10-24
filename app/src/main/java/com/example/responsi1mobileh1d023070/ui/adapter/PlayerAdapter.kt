package com.example.responsi1mobileh1d023070.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023070.R
import com.example.responsi1mobileh1d023070.data.model.Player
import com.example.responsi1mobileh1d023070.databinding.PlayerListBinding
import okhttp3.EventListener

class PlayerAdapter(private var players: List<Player>, private val onPlayerClickListener: OnPlayerClickListener) :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>(){

    inner class PlayerViewHolder(val binding: PlayerListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = PlayerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return PlayerViewHolder(binding)
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        val context = holder.itemView.context

        holder.binding.tvPlayerName.text = player.name ?: "Unknown Name"
        holder.binding.tvPlayerNationality.text = player.nationality ?: "Unknown Nationality"

        holder.binding.root.setOnClickListener {
            onPlayerClickListener.onPlayerClick(player)
        }

        val backgroundColorRes = when (player.position) {
            "Goalkeeper" -> R.color.yellow
            "Defence", "Left-Back", "Right-Back", "Centre-Back", "Full-Back", "Wing-Back" -> R.color.blue
            "Midfield", "Defensive Midfield", "Central Midfield", "Attacking Midfield", "Left Midfield", "Right Midfield"   -> R.color.green
            "Offence", "Centre-Forward", "Striker", "Winger", "Left Winger", "Right Winger", "Second Striker"    -> R.color.red
            else         -> R.color.grey // Fallback
        }

        val cardColor = ContextCompat.getColor(context, backgroundColorRes)

        (holder.binding.root as? CardView)?.setCardBackgroundColor(cardColor)
    }

    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}

interface OnPlayerClickListener {
    fun onPlayerClick(player: Player)
}