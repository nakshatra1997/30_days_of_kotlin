package com.prime.shuffler


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.prime.shuffler.databinding.FragmentTitlePageBinding


/**
 * A simple [Fragment] subclass.
 */
class TitlePageFragment : Fragment() {


data class Question(
    val shuffled: String,
    val unshuffled: String)

private val questions:MutableList<Question> =
    mutableListOf(Question(shuffled="anchge",unshuffled="change"),
        Question(shuffled="bainrow",unshuffled = "rainbow"),
        Question(shuffled = "riget",unshuffled = "tiger"))


    lateinit var currentQuestion: Question
    private var questionIndex = 0
    private var score=0
    private var count_questions=0
    private lateinit var binding: FragmentTitlePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // first inflating the layout
        binding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_title_page,container,false)

        //second randomizing the question
        randomizeQuestions()
        //binding this class to the layout
        binding.game=this

        binding.submit.setOnClickListener { view:View->
            count_questions+=1
            questionIndex+=1
            val inputAns=binding.answerWord.text.toString()
            if(inputAns.equals(currentQuestion.unshuffled)){
                Toast.makeText(context,"Your answer was correct..!!!!",Toast.LENGTH_SHORT).show()
                score+=1
            }else{
                Toast.makeText(context,"Your answer was wrong..!!!!",Toast.LENGTH_SHORT).show()
                score-=1
            }
            if(count_questions==questions.size){
                //navigate to game finished
                Toast.makeText(context,"GAME IS FINISHED!!!! YOUR SCORE IS"+score,
                    Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_titlePageFragment_to_gameFinished)
            }else{
                setQuestion()

                binding.invalidateAll()
            }

        }



        return binding.root
    }
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }
    private fun setQuestion(){
        currentQuestion=questions[questionIndex]
        binding.shuffledWord.text=currentQuestion.shuffled
        binding.answerWord.text.clear()
        binding.answerWord.hint="Enter your answer"
        //for setting the title on action bar
        (activity as AppCompatActivity).supportActionBar?.title=getString(R.string.question,count_questions+1)


    }
}
