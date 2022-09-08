package com.example.wordle

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var x = 0
        var fail_txt = findViewById<TextView>(R.id.txt_fail)
        var word_correct = findViewById<TextView>(R.id.txt_correct_word)
        var target_word = wordToGuess
        Log.i("correct word", target_word)

        findViewById<Button>(R.id.btn_guess).setOnClickListener{
            x++
            findViewById<Button>(R.id.btn_guess).hideKeyboard()
            if(x==1){
                var word1 = findViewById<EditText>(R.id.txt_guess).getText().toString().uppercase()
                if(word1!=target_word ){
                    findViewById<TextView>(R.id.txt_word1).setText(word1)
                    findViewById<TextView>(R.id.txt_result1).setText(checkGuess(word1))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                }
                else{
                    findViewById<TextView>(R.id.txt_word1).setText(word1)
                    findViewById<TextView>(R.id.txt_result1).setText(checkGuess(word1))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                    fail_txt.setText("Congratulations! That's the correct word!")
                    fail_txt.visibility = View.VISIBLE
                    findViewById<Button>(R.id.btn_guess).setBackgroundColor(Color.GRAY)
                    findViewById<Button>(R.id.btn_guess).setClickable(false)
                }

            }
            if(x==2){
                var word2 = findViewById<EditText>(R.id.txt_guess).getText().toString().uppercase()
                if(word2!= target_word){
                    findViewById<TextView>(R.id.txt_word2).setText(word2)
                    findViewById<TextView>(R.id.txt_result2).setText(checkGuess(word2))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                }
                else{
                    findViewById<TextView>(R.id.txt_word2).setText(word2)
                    findViewById<TextView>(R.id.txt_result2).setText(checkGuess(word2))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                    fail_txt.setText("Congratulations! That's the correct word!")
                    fail_txt.visibility = View.VISIBLE
                    findViewById<Button>(R.id.btn_guess).setBackgroundColor(Color.GRAY)
                    findViewById<Button>(R.id.btn_guess).setClickable(false)
                }
            }
            if(x==3){
                var word3 = findViewById<EditText>(R.id.txt_guess).getText().toString().uppercase()
                if(word3!=target_word){
                    findViewById<TextView>(R.id.txt_word3).setText(word3)
                    findViewById<TextView>(R.id.txt_result3).setText(checkGuess(word3))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                    fail_txt.visibility = View.VISIBLE
                    word_correct.setText(target_word)
                    word_correct.visibility = View.VISIBLE
                    findViewById<Button>(R.id.btn_guess).setBackgroundColor(Color.GRAY)
                    findViewById<Button>(R.id.btn_guess).setClickable(false)
                }
                else{
                    findViewById<TextView>(R.id.txt_word3).setText(word3)
                    findViewById<TextView>(R.id.txt_result3).setText(checkGuess(word3))
                    findViewById<EditText>(R.id.txt_guess).getText().clear()
                    fail_txt.setText("Congratulations! That's the correct word!")
                    fail_txt.visibility = View.VISIBLE
                    findViewById<Button>(R.id.btn_guess).setBackgroundColor(Color.GRAY)
                    findViewById<Button>(R.id.btn_guess).setClickable(false)

                }
            }


        }



    }

    var wordToGuess = getRandomFourLetterWord()
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            //var wordToGuess =
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}

