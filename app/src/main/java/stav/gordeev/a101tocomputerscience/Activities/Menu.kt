package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
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
        initLinkingButtonsToTheirActivities()

    }

    /**
     * inits all the variables which includes Intents, Buttons
     */
    private fun initVar() {
        b_to_learning_languages = findViewById(R.id.b_to_learning_languages)
        b_to_extras = findViewById(R.id.b_to_extras)
        b_to_history = findViewById(R.id.b_to_history)
        b_to_motives = findViewById(R.id.b_to_motives)
        b_to_career_path = findViewById(R.id.b_to_career_path)
    }

    /**
     * This method initializes the button icons to their respective activities
     */
    private fun initLinkingButtonsToTheirActivities() {
        b_to_learning_languages.setOnClickListener {
            val intentToLearningLanguages = Intent(this, LearningLanguages::class.java)
            startActivity(intentToLearningLanguages)
        }
        b_to_extras.setOnClickListener {
            val intentToExtras =Intent(this, Extras::class.java)
            startActivity(intentToExtras)
        }
        b_to_history.setOnClickListener {
            val intentToHistory =Intent(this, HistoryOfLanguages::class.java)
            startActivity(intentToHistory)
        }
        b_to_motives.setOnClickListener {
            val intentToMotives = Intent(this, MotivesForApp::class.java)
            startActivity(intentToMotives)
        }
        b_to_career_path.setOnClickListener {
            val intentToCareerPath = Intent(this, CareerPath::class.java)
            startActivity(intentToCareerPath)
        }
    }
}