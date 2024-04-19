import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        auth = FirebaseAuth.getInstance()

        sign_in_button.setOnClickListener {
            val email = email_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            signInWithEmailAndPassword(email, password)
        }

        sign_up_button.setOnClickListener {
            val email = email_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            createAccount(email, password)
        }

        sign_out_button.setOnClickListener {
            signOut()
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)