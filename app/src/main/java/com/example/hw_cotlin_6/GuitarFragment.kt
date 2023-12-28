package com.example.hw_cotlin_6

import GuitarModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_cotlin_6.databinding.FragmentGuitarBinding

class GuitarFragment : Fragment() {

    private lateinit var binding: FragmentGuitarBinding
    private lateinit var guitarAdapter: GuitarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuitarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val guitars = loadGuitarData()

        binding.guitarRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        guitarAdapter = GuitarAdapter(guitars) { selectedGuitar ->
            showToast("Selected guitar: ${selectedGuitar.name}")
        }
        binding.guitarRecyclerView.adapter = guitarAdapter
    }

    private fun loadGuitarData(): List<GuitarModel> {
        return listOf(
            GuitarModel(
                "Электрогитара",
                "Электрическая гитара для исполнения рок-музыки.",
                "https://3tone.me/upload/iblock/af6/1vw3p3l9t9y9523369yxlwd5llijevee.jpeg"
            ),
            GuitarModel(
                "Акустическая гитара",
                "Акустическая гитара для исполнения акустической музыки.",
                "https://object.pscloud.io/cms/cms/Photo/img_0_813_61_0.jpg"
            ),
            GuitarModel(
                "Бас-гитара",
                "Гитара с низкими частотами для поддержки ритма в музыке.",
                "https://sound.kg/wp-content/uploads/2022/12/preview-6-324x324.jpg"
            ),
            GuitarModel(
                "Классическая гитара",
                "Традиционная классическая гитара с нейлоновыми струнами.",
                "https://piano.by/images/cache/d942c8811941ca18bb32f507517e0e11.webp"
            )
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
