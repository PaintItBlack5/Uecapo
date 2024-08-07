package it.uecapo

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.media.ToneGenerator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrazione.*

class RegistrazioneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrazione)

        var db : SQLiteDatabase = openOrCreateDatabase("prova", Context.MODE_PRIVATE,null)



        Registrati.setOnClickListener {
            var riga = "INSERT INTO USERS VALUES ('" + username.text.toString() + "','" + password.text.toString() + "')"
            db.execSQL(riga)

            Toast.makeText(this,"CONGRATULAZIONI. Registrazione corretta!",Toast.LENGTH_LONG).show()

            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("login_activity_displayName", username.text.toString())
            startActivity(intent)
            finish()

        }

        Torna.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
