package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import stav.gordeev.a101tocomputerscience.R

class Extras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_extras)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initWebsiteCardLinks()
    }

    private fun initWebsiteCardLinks() {
        val cardScratch = findViewById<CardView>(R.id.cardScratch)
        val cardW3Schools = findViewById<CardView>(R.id.cardW3Schools)
        val cardStackOverflow = findViewById<CardView>(R.id.cardStackOverflow)
        val cardFreeCodeCamp = findViewById<CardView>(R.id.cardFreeCodeCamp)
        val cardEdabit = findViewById<CardView>(R.id.cardEdabit)

        cardScratch.setOnClickListener {
            openUrl("https://scratch.mit.edu")
        }

        cardW3Schools.setOnClickListener {
            openUrl("https://www.w3schools.com")
        }

        cardStackOverflow.setOnClickListener {
            openUrl("https://stackoverflow.com/questions")
        }

        cardFreeCodeCamp.setOnClickListener {
            // Assuming the correct link, update if different
            openUrl("https://www.freecodecamp.org")
        }

        cardEdabit.setOnClickListener {
            openUrl("https://edabit.com/challenges")
        }
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } catch (e: Exception) {
            // Optional: Handle exceptions, e.g., if no browser is available
            // You could show a Toast message here
            e.printStackTrace()
        }
    }
}