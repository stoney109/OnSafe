package com.example.onsafe.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.on_safe.R

class FindPwActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etCode: EditText
    private lateinit var btnRequestCode: Button
    private lateinit var btnConfirm: Button
    private lateinit var btnBack: ImageButton
    private lateinit var btnGoLogin: Button
    private lateinit var layoutCode: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw)

        etEmail = findViewById(R.id.etEmail)
        etCode = findViewById(R.id.etCode)
        btnRequestCode = findViewById(R.id.btnRequestCode)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnBack = findViewById(R.id.btnBack)
        btnGoLogin = findViewById(R.id.btnGoLogin)
        layoutCode = findViewById(R.id.layoutCode)

        btnBack.setOnClickListener { finish() }

        btnGoLogin.setOnClickListener { finish() }

        // 코드 받기
        btnRequestCode.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!emailRegex.matches(email)) {
                Toast.makeText(this, "올바른 이메일 형식을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // TODO: API 연결 - 재설정 코드 발송
            btnRequestCode.isEnabled = false
            btnRequestCode.alpha = 0.4f
            layoutCode.visibility = View.VISIBLE
            Toast.makeText(this, "재설정 코드를 발송했습니다.", Toast.LENGTH_SHORT).show()
        }

        // 재설정 코드 확인
        btnConfirm.setOnClickListener {
            val code = etCode.text.toString().trim()
            if (code.isEmpty()) {
                Toast.makeText(this, "재설정 코드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // TODO: API 연결 - 코드 확인 후 비밀번호 재설정 화면으로 이동
            Toast.makeText(this, "인증이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}