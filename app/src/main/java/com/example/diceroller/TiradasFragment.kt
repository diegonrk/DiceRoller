package com.example.diceroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diceroller.databinding.FragmentTiradasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TiradasFragment : Fragment() {

    private var _binding: FragmentTiradasBinding? = null
    private val binding get() = _binding!!

    private val tiradasViewModel: TiradasViewModel by activityViewModels {
        TiradasViewModelFactory((activity?.application as DiceRollerApplication).tiradasRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTiradasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TiradasAdapter(emptyList())
        binding.recyclerViewTiradas.adapter = adapter
        binding.recyclerViewTiradas.layoutManager = LinearLayoutManager(requireContext())


        tiradasViewModel.allTiradas.observe(viewLifecycleOwner) { tiradasList ->
            adapter.updateList(tiradasList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}