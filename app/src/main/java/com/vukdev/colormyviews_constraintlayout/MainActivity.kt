package com.vukdev.colormyviews_constraintlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        // posto ce se ista akcija primeniti na svaki od box-eva, pravim listu od njih + box-eve sam
        // postavio u belo, tako da ce biti vidljivi za klik, ako i layout contraint obojimo
        val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, mojKonstrejntLayout, redBtn, greenBtn, yellowBtn)

        for (box in clickableViews) {
            box.setOnClickListener {
                makeColored(it)
            }
        }
    }


    private fun makeColored(view: View) {
        when (view.id) {
            // Box-ovi koji koriste nativnu Color klasu
            R.id.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxTwoText -> view.setBackgroundColor(Color.GRAY)
            // Box-ovi koji dobijaju boju preko Android-ovog resursa
            R.id.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

            //za button-e korsitim custom resurse
            R.id.redBtn -> boxThreeText.setBackgroundResource(R.color.crvena)
            R.id.greenBtn -> boxFourText.setBackgroundResource(R.color.zelena)
            R.id.yellowBtn -> boxFiveText.setBackgroundResource(R.color.zuta)

            //sve ostalo + hint da se vidi gde su box-evi da bi se kliknuli
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}
