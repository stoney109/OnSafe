package com.example.onsafe.ui.login

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.on_safe.R

class ModeSelectActivity : AppCompatActivity() {

    private lateinit var cardGuardian: LinearLayout
    private lateinit var cardCamera: LinearLayout
    private lateinit var btnNext: Button

    // 0 = 미선택, 1 = 보호자, 2 = 카메라
    private var selectedMode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_select)

        cardGuardian = findViewById(R.id.cardGuardian)
        cardCamera = findViewById(R.id.cardCamera)
        btnNext = findViewById(R.id.btnNext)

        cardGuardian.setOnClickListener {
            selectedMode = 1
            updateCardState()
        }

        cardCamera.setOnClickListener {
            selectedMode = 2
            updateCardState()
        }

        btnNext.setOnClickListener {
            // TODO: 선택된 모드 저장 후 다음 화면으로
            if (selectedMode == 0) return@setOnClickListener
            // 예: SharedPreferences에 모드 저장
            // val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
            // prefs.edit().putInt("mode", selectedMode).apply()
            // startActivity(Intent(this, PermissionActivity::class.java))
        }
    }

    private fun updateCardState() {
        when (selectedMode) {
            1 -> {
                // 보호자 선택 — 파란 테두리
                cardGuardian.setBackgroundResource(R.drawable.bg_mode_card_selected)
                cardCamera.setBackgroundResource(R.drawable.bg_mode_card_normal)
            }
            2 -> {
                // 카메라 선택 — 파란 테두리
                cardCamera.setBackgroundResource(R.drawable.bg_mode_card_selected)
                cardGuardian.setBackgroundResource(R.drawable.bg_mode_card_normal)
            }
        }
        // 다음 버튼 활성화
        btnNext.isEnabled = true
        btnNext.alpha = 1.0f
    }
}