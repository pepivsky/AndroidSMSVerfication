package com.pepivsky.verification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var edtNum1: EditText
    lateinit var edtNum2: EditText
    lateinit var edtNum3: EditText
    lateinit var edtNum4: EditText
    lateinit var edtNum5: EditText
    lateinit var edtNum6: EditText
    lateinit var btnEnviarCodigo: Button

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupOTPInputs()

        auth = FirebaseAuth.getInstance()

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Toast.makeText(applicationContext, "Verificado!", Toast.LENGTH_LONG).show()
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
            ) {

                Log.d("TAG", "onCodeSent:$verificationId")
                Toast.makeText(applicationContext, "Codigo enviado!", Toast.LENGTH_LONG).show()
                storedVerificationId = verificationId
                resendToken = token

                /*var intent = Intent(applicationContext,Verify::class.java)
                intent.putExtra("storedVerificationId",storedVerificationId)
                startActivity(intent)*/
            }
        }

        //setupOTPInputs()

        //verfifyNum()
    }

    private fun sendVerificationcode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(number) // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this) // Activity (for callback binding)
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    /*private fun verfifyNum() {
        PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                .setPhoneNumber("+527731711423")       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks)          // OnVerificationStateChangedCallbacks
                .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }*/

    private fun setupOTPInputs() {
        edtNum1 = findViewById(R.id.edtNum1)
        edtNum2 = findViewById(R.id.edtNum2)
        edtNum3 = findViewById(R.id.edtNum3)
        edtNum4 = findViewById(R.id.edtNum4)
        edtNum5 = findViewById(R.id.edtNum5)
        edtNum6 = findViewById(R.id.edtNum6)
        btnEnviarCodigo = findViewById(R.id.btnEnviar)

        btnEnviarCodigo.setOnClickListener {
            sendVerificationcode("+527731711423")
        }


        edtNum1.addTextChangedListener(object :
                TextWatcher { //Listener para setear el texto cuando sea  escrito
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()) {
                    edtNum2.requestFocus()
                }

            }

            override fun afterTextChanged(s: Editable?) {}

        })

        edtNum2.addTextChangedListener(object :
                TextWatcher { //Listener para setear el texto cuando sea  escrito
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()) {
                    edtNum3.requestFocus()
                }

            }

            override fun afterTextChanged(s: Editable?) {}

        })

        edtNum3.addTextChangedListener(object :
                TextWatcher { //Listener para setear el texto cuando sea  escrito
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()) {
                    edtNum4.requestFocus()
                }

            }

            override fun afterTextChanged(s: Editable?) {}

        })

        edtNum4.addTextChangedListener(object :
                TextWatcher { //Listener para setear el texto cuando sea  escrito
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()) {
                    edtNum5.requestFocus()
                }

            }

            override fun afterTextChanged(s: Editable?) {}

        })

        edtNum5.addTextChangedListener(object :
                TextWatcher { //Listener para setear el texto cuando sea  escrito
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()) {
                    edtNum6.requestFocus()
                }

            }

            override fun afterTextChanged(s: Editable?) {}

        })

    }
}