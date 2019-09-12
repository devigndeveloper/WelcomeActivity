package com.devign.welcomeactivity.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devign.welcomeactivity.Utilities.EXTRA_LEAGUE
import com.devign.welcomeactivity.R
import com.devign.welcomeactivity.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        // get Constant passed from LeagueActivity
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onSkillFinishClicked(view: View){
        if(skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }

    fun onBeginnerClicked(view: View){
        skillBallerBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClicked(view: View){
        skillBeginnerBtn.isChecked = false
        skill = "baller"
    }

}