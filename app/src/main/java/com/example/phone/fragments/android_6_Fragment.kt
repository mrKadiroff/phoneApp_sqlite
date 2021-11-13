package com.example.phone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.phone.R
import com.example.phone.interfaces.OnCliclinear
import com.example.phone.utils.List
import com.example.phone.adapters.Linear_adapter
import com.example.phone.databinding.FragmentAndroid6Binding


class android_6_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android_6_, container, false)
        var binding = FragmentAndroid6Binding.bind(view)
        var adapter = Linear_adapter(List.PhoneList , object : OnCliclinear{
            override fun onClicItem(item: String) {
                var bundle = Bundle()
                bundle.putString("data" , item)
                findNavController().navigate(R.id.action_android_6_Fragment_to_android_7_Fragment,bundle)
            }

        })
        binding.rv1.adapter = adapter



        return view
    }


}