package com.devign.welcomeactivity.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devign.welcomeactivity.Model.Player
import com.devign.welcomeactivity.R
import com.devign.welcomeactivity.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        // get Constant passed from LeagueActivity
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        println(player)
    }

    fun onSkillFinishClicked(view: View){
        if(player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }

    fun onBeginnerClicked(view: View){
        skillBallerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view: View){
        skillBeginnerBtn.isChecked = false
        player.skill = "baller"
    }

}