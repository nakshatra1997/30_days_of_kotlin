package com.prime.shuffler


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.prime.shuffler.databinding.FragmentGameFinishedBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFinished : Fragment() {

    private lateinit var binding: FragmentGameFinishedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_game_finished,container,false)
        binding.PlayAgain.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_gameFinished_to_titlePageFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title=getString(R.string.game_over)
        return binding.root
    }


}
