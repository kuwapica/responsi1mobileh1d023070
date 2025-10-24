package com.example.responsi1mobileh1d023070.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.responsi1mobileh1d023070.R
import com.example.responsi1mobileh1d023070.databinding.FragmentPlayerDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayerDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerDetailFragment (
    private val playerName: String,
    private val playerBirth: String,
    private val playerNationality: String,
    private val playerPosition: String,
) : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {

        binding.textViewPlayerName.text = playerName
        binding.textViewPlayerBirth.text = playerBirth
        binding.textViewPlayerNationality.text = playerNationality
        binding.textViewPlayerPosition.text = playerPosition

    }
}