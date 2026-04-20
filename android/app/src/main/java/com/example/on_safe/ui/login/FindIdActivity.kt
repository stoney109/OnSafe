package com.example.onsafe.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.on_safe.R

class FindIdActivity : AppCompatActivity() {

    private lateinit var etPhone: EditText
    private lateinit var etCode: EditText
    private lateinit var btnRequestCode: Button
    private lateinit var btnConfirm: Button
    private lateinit var btnBack: ImageButton
    private lateinit var btnGoLogin: Button
    private lateinit var layoutCode: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)

        etPhone = findViewById(R.id.etPhone)
        etCode = findViewById(R.id.etCode)
        btnRequestCode = findViewById(R.id.btnRequestCode)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnBack = findViewById(R.id.btnBack)
        btnGoLogin = findViewById(R.id.btnGoLogin)
        layoutCode = findViewById(R.id.layoutCode)

        btnBack.setOnClickListener { finish() }

        btnGoLogin.setOnClickListener { finish() }

        // 인증 요청
        btnRequestCode.setOnClickListener {
            val phone = etPhone.text.toString().trim()
            val phoneRegex = Regex("^01[016789]-\\d{3,4}-\\d{4}$")
            if (phone.isEmpty()) {
                Toast.makeText(this, "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!phoneRegex.matches(phone)) {
                Toast.makeText(this, "010-0000-0000 형식으로 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // TODO: API 연결 - 인증코드 발송
            btnRequestCode.isEnabled = false
            btnRequestCode.alpha = 0.4f
            layoutCode.visibility = View.VISIBLE
            Toast.makeText(this, "인증번호를 발송했습니다.", Toast.LENGTH_SHORT).show()
        }

        // 인증코드 확인
        btnConfirm.setOnClickListener {
            val code = etCode.text.toString().trim()
            if (code.isEmpty()) {
                Toast.makeText(this, "인증코드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // TODO: API 연결 - 인증코드 확인 후 아이디 표시
            Toast.makeText(this, "인증이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}