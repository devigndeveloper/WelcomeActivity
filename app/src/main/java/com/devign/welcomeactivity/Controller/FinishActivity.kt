package com.devign.welcomeactivity.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devign.welcomeactivity.Model.Player
import com.devign.welcomeactivity.R
import com.devign.welcomeactivity.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        // Pulling passed constants from previous activities/buttons
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        // Html input into searchLeaguesText
        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
