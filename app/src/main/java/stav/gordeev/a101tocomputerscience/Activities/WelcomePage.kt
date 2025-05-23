package stav.gordeev.a101tocomputerscience.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import stav.gordeev.a101tocomputerscience.R


class WelcomePage : AppCompatActivity() {
    //Declare all variables - these are user inputs to store data about them
    lateinit var etUsername: EditText;
    lateinit var etAge: EditText;
    lateinit var rgExperiences: RadioGroup;
    lateinit var rbExperience1: RadioButton;
    lateinit var rbExperience2: RadioButton;
    lateinit var rbExperience3: RadioButton;
    lateinit var rbExperience4: RadioButton;
    lateinit var rbExperience5: RadioButton;
    lateinit var sbExcitementOfUser: SeekBar;
    lateinit var tvExcitementMeter: TextView;
    lateinit var bSendUserInfo: Button;

    //button the menu
    lateinit var bToMenu: ImageButton;

    // this is a flag that prevents the user to go to the menu if they didn't fill out and sent their user data, or it is not valid
    var canGoToMenu = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        implementSeekbarMeterLogic()

        setButtonThatSendsUserInfoLogic()

        linkButtonToMenuActivity()
    }

    /**
     * Update the text of the TextView that shows the current value of the SeekBar below the SeekBar itself.
     */
    private fun implementSeekbarMeterLogic() {
        // Set initial text for the TextView based on the SeekBar's starting progress
        tvExcitementMeter.text = sbExcitementOfUser.progress.toString()

        // Set up a listener for the SeekBar to update the TextView whenever the progress changes
        sbExcitementOfUser.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the TextView text whenever the SeekBar's progress changes
                tvExcitementMeter.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    /**
     * Link the button to the menu activity. Also checks if the user has sent their info successfully before letting them into the app and alerting them if not
     */
    private fun linkButtonToMenuActivity() {
        bToMenu.setOnClickListener {
            // check if the user has sent their info successfully before letting them into the app
            if (!canGoToMenu) {
                val alertInfoIsNotSent: AlertDialog = AlertDialog.Builder(this).create();

                alertInfoIsNotSent.setTitle("Successfully send user info before going to menu")
                alertInfoIsNotSent.show()

                return@setOnClickListener
            }

            val IntentToMenu: Intent = Intent(this, Menu::class.java); //Go to Menu - this is a hub for all the other activities
            //Go to Menu if the user has sent their info successfully
            startActivity(IntentToMenu)
        }
    }

    private fun setButtonThatSendsUserInfoLogic() {
        bSendUserInfo.setOnClickListener {
            if (!areInputsValid()) {
                return@setOnClickListener;
            }

            canGoToMenu = true;

            //if inputs are valid, store the info in a newly made SharedPreferences file
            val userData: SharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
            val editor: SharedPreferences.Editor = userData.edit();

            editor.putString("username", etUsername.text.toString());
            editor.putInt("age", etAge.text.toString().toInt());
            editor.putInt("experience", rgExperiences.checkedRadioButtonId);
            editor.putInt("excitement", sbExcitementOfUser.progress);

            editor.apply(); //save the info

            Toast.makeText(this, "Successfully sent user info", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Check if the user has inputted information in the fields. (also checks if the age is valid)
     */
    private fun areInputsValid(): Boolean {
        if (etUsername.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter a username", Toast.LENGTH_LONG).show()
            return false
        }
        if (etAge.text.toString().isEmpty() || etAge.text.toString().toInt() < 0) {
            Toast.makeText(this, "Please enter a valid age", Toast.LENGTH_LONG).show()
            return false
        }
        if (rgExperiences.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please enter your experience", Toast.LENGTH_LONG).show()
            return false
        }

        return true;
    }

    /**
     * Initialize all variables - these are user inputs to store data about them, as well as the buttons
     */
    private fun initComponents() {
        etUsername = findViewById(R.id.etUsername);
        etAge = findViewById(R.id.etAge);
        rgExperiences = findViewById(R.id.rgExperiences);
        rbExperience1 = findViewById(R.id.rbExperience1);
        rbExperience2 = findViewById(R.id.rbExperience2);
        rbExperience3 = findViewById(R.id.rbExperience3);
        rbExperience4 = findViewById(R.id.rbExperience4);
        rbExperience5 = findViewById(R.id.rbExperience5);
        sbExcitementOfUser = findViewById(R.id.sbExcitementOfUser);
        tvExcitementMeter = findViewById(R.id.tvExcitementMeter);
        bSendUserInfo = findViewById(R.id.bSendUserInfo);

        bToMenu = findViewById(R.id.b_to_menu);
    }
}