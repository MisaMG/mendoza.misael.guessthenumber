package mendoza.misael.guestthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var maxNum: Int = 100
    var minNum: Int = 0
    var num: Int = 0
    var won: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.Up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener {
            num = Random.nextInt(minNum, maxNum)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed. visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minNum = num
            if(checkingLimits()) {
                num = Random.nextInt(minNum, maxNum)
                guessings.setText(num.toString())
            } else {
                guessings.setText("Impossible!, you won :(")
            }
        }

        down.setOnClickListener {
            maxNum = num
            if (checkingLimits()) {
                num = Random.nextInt(minNum, maxNum)
                guessings.setText(num.toString())
            } else {
                guessings.setText("Impossible!, you won :(")
            }
        }

        guessed.setOnClickListener {
            if(!won) {
                guessings.setText("Guess the number is..." + num)
                guessed.setText("Let's play again :)")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
               resetValue()
            }
        }
    }

    fun checkingLimits(): Boolean{
        return  minNum != maxNum
    }

    fun resetValue(){
        var maxNum: Int = 100
        var minNum: Int = 0
        var num: Int = 0
        var won: Boolean = false
    }

}