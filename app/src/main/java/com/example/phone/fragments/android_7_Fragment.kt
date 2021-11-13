package com.example.phone.fragments

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.phone.DBhelper.MyDBhelper
import com.example.phone.R
import com.example.phone.databinding.FragmentAndroid7Binding
import com.example.phone.models.Phone


class android_7_Fragment : Fragment() {


    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android_7_, container, false)
        var binding = FragmentAndroid7Binding.bind(view)
        var bundle = Bundle()

        var model = arguments?.get("data").toString()

        binding.apply {
            appCompatButton.setOnClickListener {
                var name = this.editText2.text.toString().trim()
                var comment = this.editText.text.toString().trim()
                var one = true
                var two = true
                if (name.isEmpty()){
                    binding.editText2.error = "name should be entered"
                    binding.editText2.requestFocus()
                    one = false
                    return@setOnClickListener
                }
                if (comment.isEmpty()){
                    binding.apply {
                        editText.error = "Features should be entered"
                        editText.requestFocus()
                        two = false
                        return@setOnClickListener
                    }
                }
                if (one && two){
                    var phone = Phone(name,model.toString(),comment)
                    var database = MyDBhelper(mContext)
                    database.addPhone(phone)
                    binding.editText2.text.delete(0,name.length)
                    binding.editText.text.delete(0,comment.length)
                    activity?.onBackPressed()
                    Toast.makeText(mContext, "phone is added", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()

                }
                else{
                    Toast.makeText(mContext, "name and comment should be entered", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }

}