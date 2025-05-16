package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import stav.gordeev.a101tocomputerscience.R


class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b_to_menu: ImageButton = findViewById(R.id.b_to_menu);
        val IntentToMenu: Intent = Intent(this, Menu::class.java); //Go to Menu - this is a hub for all the other activities


        //Go to Menu when the ImageButton is clicked
        b_to_menu.setOnClickListener {
            startActivity(IntentToMenu)
        }
    };
}