package com.example.myapplicationex1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplicationex1.R
import com.example.myapplicationex1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val mineViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        val textView: TextView = binding.textDashboard
        mineViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // 네 번째 이미지뷰에 대한 클릭 이벤트 처리
        val imageView4: ImageView = binding.imageView4
        imageView4.setOnClickListener {
            // NavController를 통해 네비게이션 액션을 실행
            findNavController().navigate(R.id.navigation_mine)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
