package com.example.diceroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.diceroller.TiradasDAO
import com.example.diceroller.TiradasDataBase
import com.example.diceroller.TwoDicesViewModel
import com.example.diceroller.TwoDicesViewModelFactory
import com.example.diceroller.databinding.FragmentBotonBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class BotonFragment : Fragment() {
    private var _binding: FragmentBotonBinding? = null
    private val binding get() = _binding!!

    private val tiradasDao: TiradasDAO by lazy {
        TiradasDataBase.getDataBase(requireContext()).TiradasDAO()
    }

    private val dices: TwoDicesViewModel by activityViewModels {
        TwoDicesViewModelFactory(tiradasDao)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBotonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRoll.setOnClickListener {
            dices.rollDices()
        }

        binding.btnClearList.setOnClickListener {

            showClearListConfirmationDialog()



        }
    }

    private fun showClearListConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Vaciar lista")
            .setMessage("¿Estás seguro de que quieres vaciar la lista de tiradas?")
            .setPositiveButton("Sí") { _, _ ->
                dices.clearAll()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}