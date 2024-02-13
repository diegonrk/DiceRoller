package com.example.diceroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.example.diceroller.R
import com.example.diceroller.TiradasDAO
import com.example.diceroller.TiradasDataBase
import com.example.diceroller.TwoDicesViewModel
import com.example.diceroller.TwoDicesViewModelFactory
import com.example.diceroller.databinding.FragmentDadosBinding

class DadosFragment : Fragment() {
    private var _binding: FragmentDadosBinding?= null
    private val binding get() = _binding!!

    private val tiradasDao: TiradasDAO by lazy {
        TiradasDataBase.getDataBase(requireContext()).TiradasDAO()
    }

    private val TwoDicesViewModel: TwoDicesViewModel by activityViewModels {
        TwoDicesViewModelFactory(tiradasDao)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         _binding = FragmentDadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        TwoDicesViewModel.tiradas.observe(viewLifecycleOwner) { listaDeTiradas ->
            listaDeTiradas?.let {

                val ultimaTirada = it.lastOrNull()

                ultimaTirada?.let {
                    binding.ivDice1?.let {imageViewDice ->
                        rollDice(ultimaTirada.dado_1, imageViewDice) }
                    binding.ivDice2?.let {imageViewDice ->
                        rollDice(ultimaTirada.dado_2, imageViewDice) }
                }
            }
        }
    }



    internal fun rollDice(currentSide: Int, imageViewDice: ImageView?) {
        val imgDiceResource = when(currentSide){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6

            else -> R.drawable.dice_6
        }

        imageViewDice?.setImageResource(imgDiceResource)
        imageViewDice?.contentDescription = currentSide.toString()
    }
}