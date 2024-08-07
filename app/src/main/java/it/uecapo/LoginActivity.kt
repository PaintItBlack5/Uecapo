package it.uecapo

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var db : SQLiteDatabase = openOrCreateDatabase("prova", Context.MODE_PRIVATE,null)
        creaDB(db)


        loginBtn.setOnClickListener {
            val welcomeIntent = Intent(this@LoginActivity, WelcomeActivity::class.java)

            var cursor: Cursor = db.rawQuery("SELECT * FROM users",null)
            var username = nomeText.text.toString()
            var password = passwordText.text.toString()
            var condizione: Int = 0


            while (cursor.moveToNext()){
                var nomeE:String = cursor.getString(0)
                var passwordE:String = cursor.getString(1)

                if (nomeE.toUpperCase() == username.toUpperCase() && passwordE == password) {

                    val welcomeIntent = Intent(this@LoginActivity, WelcomeActivity::class.java)
                    condizione = 1

                    welcomeIntent.putExtra("login_activity_displayName", username)
                    Toast.makeText(this,"Credenziali CORRETTE.",Toast.LENGTH_LONG).show()
                    startActivity(welcomeIntent)
                    finish()
                }
                if(condizione == 0) {
                    Toast.makeText(this,"Credenziali sbagliate. RIPROVA",Toast.LENGTH_LONG).show()
                }
            }
        }

        btnRegistrati.setOnClickListener {
            val intent = Intent(this, RegistrazioneActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun creaDB (db: SQLiteDatabase){
        db.execSQL("CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)")
        //db.execSQL("delete from users")
        //db.execSQL("INSERT INTO users VALUES('davide91','davide91');")
        //db.execSQL("INSERT INTO users VALUES('davide90','davide90');")

    }

}
