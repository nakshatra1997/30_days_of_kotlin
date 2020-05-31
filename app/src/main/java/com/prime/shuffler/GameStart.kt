package com.prime.shuffler


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.prime.shuffler.databinding.FragmentGameStartBinding
import android.widget.Toast



/**
 * A simple [Fragment] subclass.
 */
class GameStart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //first inflating the layout using binding
        val binding= DataBindingUtil.inflate<FragmentGameStartBinding>(inflater,
            R.layout.fragment_game_start,container,false)

        // then setting the listener for button on this layout
       binding.startGame.setOnClickListener { view:View->
            //on clicking the button,user should navigate to other fragment
           view.findNavController().navigate(R.id.action_gameStart_to_titlePageFragment)
       }

        return binding.root
    }


}
