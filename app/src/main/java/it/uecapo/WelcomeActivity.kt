package it.uecapo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val displayName = intent.getStringExtra("login_activity_displayName")

        nomeLbl.text = displayName

        trovaParcheggioBtn.setOnClickListener {
            val mapsActivity = Intent(this@WelcomeActivity, MapsActivity::class.java)

            val m_bundle = Bundle()

            m_bundle.putString("citta", cittaText.text.toString())
            m_bundle.putString("via", viaText.text.toString())

            mapsActivity.putExtra("welcome_activity_data", m_bundle)
            startActivity(mapsActivity)
        }
    }
}
