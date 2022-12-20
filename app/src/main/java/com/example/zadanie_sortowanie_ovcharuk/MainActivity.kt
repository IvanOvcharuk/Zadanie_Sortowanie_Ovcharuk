package com.example.zadanie_sortowanie_ovcharuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.flow.merge
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lbl = findViewById<TextView>(R.id.wynlbl)
        var lbl2 = findViewById<TextView>(R.id.srtlbl)
        var wstawianie = findViewById<TextView>(R.id.wstawianie)
        var babelkowe = findViewById<TextView>(R.id.babelkowe)
        var heapsort = findViewById<TextView>(R.id.heapsort)
        var scalanie = findViewById<TextView>(R.id.scalanie)
        var wykonaj = findViewById<Button>(R.id.wykonaj)
        var ilerazy = findViewById<EditText>(R.id.ilerazy)
        var ileelementow = findViewById<EditText>(R.id.ileelementow)

        fun losowanie(size: Int): MutableList<Int> {
            val random = Random()
            return List(size) { random.nextInt(1000) }.toMutableList()
        }

        fun Czas(t1 : Long, t2 : Long) : Long
        {
            return t2 - t1
        }
        //wstawianie
        fun wstawianie(tab: IntArray) { //działa
            for (count in 1..tab.count() - 1){
                val item = tab[count]
                var i = count
                while (i>0 && item < tab[i - 1]){
                    tab[i] = tab[i - 1]
                    i -= 1
                }
                tab[i] = item
            }
        }

    }
}