package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import stav.gordeev.a101tocomputerscience.R

class Menu : AppCompatActivity() {
    //The different button icons leading to the other activities
    lateinit var b_to_learning_languages: ImageButton
    lateinit var b_to_extras: ImageButton
    lateinit var b_to_history: ImageButton
    lateinit var b_to_motives: ImageButton
    lateinit var b_to_career_path: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initVar()
        // Set click listeners
        setButtonListeners()
    }

    /**
     * inits all the variables to their respective view component
     */
    private fun initVar() {
        b_to_learning_languages = findViewById(R.id.b_to_learning_languages)
        b_to_extras = findViewById(R.id.b_to_extras)
        b_to_history = findViewById(R.id.b_to_history)
        b_to_motives = findViewById(R.id.b_to_motives)
        b_to_career_path = findViewById(R.id.b_to_career_path)
    }

    /**
     * Sets the click listeners for the buttons. upon clicking the button, it gives each button a click sound and also makes it navigate to a different activity, depending on the button's id.
     */
    private fun setButtonListeners() {
        b_to_history.setOnClickListener { playClickSoundAndNavigate(b_to_history) }
        b_to_learning_languages.setOnClickListener { playClickSoundAndNavigate(b_to_learning_languages) }
        b_to_career_path.setOnClickListener { playClickSoundAndNavigate(b_to_career_path) }
        b_to_extras.setOnClickListener { playClickSoundAndNavigate(b_to_extras) }
        b_to_motives.setOnClickListener { playClickSoundAndNavigate(b_to_motives) }
    }


    /**
     * Gives the given button a click sound.
     */
    private fun playClickSound() {
        val mpButtonPressed = MediaPlayer.create(this, R.raw.sfx_button_being_clicked)

        // Set a listener to release the MediaPlayer when playback is complete.
        mpButtonPressed?.setOnCompletionListener { player: MediaPlayer ->
            player.release()
        }

        // Start playing.
        mpButtonPressed?.start()
    }

    /**
     * Makes the given button have a click sound and also make it navigate to a different activity, depending on the button's id.
     */
    private fun playClickSoundAndNavigate(button: ImageButton) {
        // give the button a click sound
        playClickSound()
        // make the button the capability to navigate to a different activity, depending on the button's id
        when (button.id) {
            R.id.b_to_history -> {
                val intentToLearningLanguages = Intent(this, LearningLanguages::class.java)
                startActivity(intentToLearningLanguages)
            }
            R.id.b_to_learning_languages -> {
                val intentToExtras =Intent(this, Extras::class.java)
                startActivity(intentToExtras)
            }
            R.id.b_to_career_path -> {
                val intentToCareerPath = Intent(this, CareerPath::class.java)
                startActivity(intentToCareerPath)
            }
            R.id.b_to_motives -> {
                val intentToMotives = Intent(this, MotivesForApp::class.java)
                startActivity(intentToMotives)
            }
            R.id.b_to_extras -> {
                val intentToExtras = Intent(this, Extras::class.java)
                startActivity(intentToExtras)
            }
        }
    }
}

