package it.uecapo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_posti_liberi.*

class PostiLiberiActivity : AppCompatActivity() {

    val tableLayout by lazy { TableLayout(this) }

    // var posti = arrayOf<Array<String>>()
    val posti = Array(2, {IntArray(3)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posti_liberi)

        val bundle: Bundle? = intent.extras
        val locazione: String = bundle!!.getString("Locazione").toString()

        var list = mutableListOf<Posto>()
        list.add(Posto("Napoli, Via Roma",1,"18.00",1))
        list.add(Posto("Napoli, Via Roma",1,"13.00",2))
        list.add(Posto("Napoli, Via Roma",0,"    --",3))
        list.add(Posto("Napoli, Via Roma",0,"    --",4))
        list.add(Posto("Napoli, Via Roma",0,"    --",5))
        list.add(Posto("Napoli, Via Roma",1,"10.30",6))
        list.add(Posto("Napoli, Via Roma",1,"11.00",7))
        list.add(Posto("Napoli, Via Roma",0,"    --",8))
        list.add(Posto("Napoli, Via Roma",1,"14.30",9))
        list.add(Posto("Napoli, Via Roma",1,"18.00",10))
        list.add(Posto("Napoli, Via Roma",1,"18.30",11))


        list.add(Posto("Napoli, Via Caracciolo",1,"10.30",1))
        list.add(Posto("Napoli, Via Caracciolo",1,"10.30",2))
        list.add(Posto("Napoli, Via Caracciolo",0,"    --",3))
        list.add(Posto("Napoli, Via Caracciolo",1,"18.30",4))
        list.add(Posto("Napoli, Via Caracciolo",0,"    --",5))
        list.add(Posto("Napoli, Via Caracciolo",0,"    --",6))
        list.add(Posto("Napoli, Via Caracciolo",1,"11.00",7))
        list.add(Posto("Napoli, Via Caracciolo",0,"    --",8))


        list.add(Posto("San Giorgio a Cremano, Via Recanati",0,"    --",1))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",0,"    --",2))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",1,"13.00",3))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",1,"11.00",4))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",0,"    --",5))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",1,"10.00",6))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",0,"    --",7))
        list.add(Posto("San Giorgio a Cremano, Via Recanati",0,"    --",8))

        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"11.00",9))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"15.30 ",10))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"12.00",11))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"12.00",12))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"13.00",13))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"11.30",14))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"16.30",15))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"18.00",16))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",1,"12.00",17))
        list.add(Posto("San Giorgio a Cremano, Via De Lauzieres",0,"    --",18))


        var testo: String = " \n"
        for (i in list){
            var loc = i.locazione
            var disp: String = i.disponibilita.toString()
            var orar = i.orario
            var pos = i.posto

            if (disp == "1"){
                disp = "occupato"
            }else
            {
                disp = "libero       "
            }

            if (loc == locazione){
                testo = testo +"\t\t\t\t\t"+ pos + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + disp + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + orar + "\n\n"
            }

        }

        testoProva.text = testo.capitalize()




        //Toast.makeText(this, list[4].orario, Toast.LENGTH_LONG).show()

        /*val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tableLayout.apply {
            layoutParams = lp
            isShrinkAllColumns = true*/
        }

        //fetchData()
        //createTable(2, 3)

}

    /*

    fun fetchData() {
        posti[0][0] = 1 // disp
        posti[0][1] = 2 // orario
        posti[0][2] = 3 // n posto

        posti[1][0] = 4
        posti[1][1] = 5
        posti[1][2] = 6
    }



    fun createTable(rows: Int, cols: Int) {

        val row = TableRow(this)
        row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        val textView1 = TextView(this)
        textView1.apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT)
            text = "Disponibilità"
            setBackgroundResource(R.color.c1)
        }

        val textView2 = TextView(this)
        textView2.apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT)
            text = "Orario"
            setBackgroundResource(R.color.c2)
        }

        val textView3 = TextView(this)
        textView3.apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT)
            text = "N. Posto"
            setBackgroundResource(R.color.c1)
        }

        row.addView(textView1)
        row.addView(textView2)
        row.addView(textView3)
        tableLayout.addView(row)


        for (i in 0 until rows) {

            val row = TableRow(this)
            row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            for (j in 0 until cols) {

                val textView = TextView(this)
                textView.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT)
                    text = posti[i][j].toString()
                }
                row.addView(textView)
            }
            tableLayout.addView(row)
        }
        linearLayout.addView(tableLayout)
    }*/



