package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import stav.gordeev.a101tocomputerscience.R

class LearningLanguages : AppCompatActivity() {
    // ImageButtons that lead to each sub-activity (ie the lessons)
    lateinit var bToLessonDataTypes: ImageButton
    lateinit var bToLessonIfStatements: ImageButton
    lateinit var bToLessonForLoops: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learning_languages)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initializeImageButtons()
    }

    private fun initializeImageButtons() {
        bToLessonDataTypes = findViewById(R.id.bToLessonDataTypes)
        bToLessonIfStatements = findViewById(R.id.bToLessonIfStatements)
        bToLessonForLoops = findViewById(R.id.bToLessonForLoops)

        bToLessonDataTypes.setOnClickListener {
            val intentToLessonDataTypes: Intent = Intent(this, LessonDataTypes::class.java)
            startActivity(intentToLessonDataTypes)
        }
        bToLessonIfStatements.setOnClickListener {
            val intentToLessonIfStatements: Intent = Intent(this, LessonIfStatements::class.java)
            startActivity(intentToLessonIfStatements)
        }
        bToLessonForLoops.setOnClickListener {
            val intentToLessonForLoops: Intent = Intent(this, LessonForLoops::class.java)
            startActivity(intentToLessonForLoops)
        }

    }
}