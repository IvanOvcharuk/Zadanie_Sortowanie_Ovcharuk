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
        //babelkowe
        fun babelkowe(tab : IntArray) { //działą
            for (i in 0 until (tab.size - 1)) {
                for (j in 0 until (tab.size - i - 1)) {
                    if (tab[j] > tab[j + 1]) {
                        val tmp = tab[j]
                        tab[j] = tab[j + 1]
                        tab[j + 1] = tmp
                    }
                }
            }
        }
        //Szybkie
        fun partition(array: IntArray, low: Int, high: Int): Int {
            val pivot = array[high]
            var i = low - 1
            for (j in low until high) {
                if (array[j] <= pivot) {
                    i++
                    val temp = array[i]
                    array[i] = array[j]
                    array[j] = temp
                }
            }
            val temp = array[i + 1]
            array[i + 1] = array[high]
            array[high] = temp
            return i + 1
        }

        fun szybkie(array: MutableList<Int>, low: Int, high: Int) {
            if (low < high) {
                val pivot = partition(array.toIntArray(), low, high)
                szybkie(array, low, pivot - 1)
                szybkie(array, pivot + 1, high)
            }
        }

        //Heapsort
        var heapSize = 0
        fun swap(A: IntArray, i: Int, j: Int) {
            var temp = A[i]
            A[i] = A[j]
            A[j] = temp
        }

        fun max_heapify(A: IntArray, i: Int) {
            var l = 2*i;
            var r = 2*i+1;
            var largest: Int;

            if ((l <= heapSize - 1) && (A[l] > A[i])) {
                largest = l;
            } else
                largest = i

            if ((r <= heapSize - 1) && (A[r] > A[l])) {
                largest = r
            }

            if (largest != i) {
                swap(A, i, largest);
                max_heapify(A, largest);
            }
        }

        fun heapsort(A: IntArray) {
            heapSize = A.size
            for (i in heapSize / 2 downTo 0) {
                max_heapify(A, i)
            }
            for (i in A.size - 1 downTo 1) {
                swap(A, i, 0)
                heapSize = heapSize - 1
                max_heapify(A, 0)

            }
        }

    }
}