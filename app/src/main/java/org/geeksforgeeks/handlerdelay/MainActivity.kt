package org.geeksforgeeks.handlerdelay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        val mDelay: Long = 5000

        mButton.setOnClickListener {
            mStartCounter(mTextView, mDelay)

            Handler(Looper.getMainLooper()).postDelayed({

                mSomeFUnction()
            }, mDelay)
        }
    }

    private fun mSomeFUnction(){
        Toast.makeText(applicationContext, "Toast is called post delay", Toast.LENGTH_SHORT).show()
    }

    private fun mStartCounter(view: TextView, delay: Long){
        Thread{
            for(i in 0..delay/1000){
                runOnUiThread {
                    view.text = i.toString()
                }
                Thread.sleep(1000)
            }
        }.start()
    }
}