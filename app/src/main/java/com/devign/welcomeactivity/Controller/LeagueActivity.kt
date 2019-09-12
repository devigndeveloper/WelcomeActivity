package com.devign.welcomeactivity.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devign.welcomeactivity.Utilities.EXTRA_LEAGUE
import com.devign.welcomeactivity.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    // Singles out each button so that only one button highlights
    fun onMensClicked(view: View) {
        LeagueWomensBtn.isChecked = false
        LeagueCoedBtn.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        LeagueMensBtn.isChecked = false
        LeagueCoedBtn.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        LeagueMensBtn.isChecked = false
        LeagueWomensBtn.isChecked = false

        selectedLeague = "coed"
    }
    // End

    // Next click directs user to SkillActivity
    fun leagueNextClicked(view: View) {
        // if a league has been selected..
        if (selectedLeague != "") {
            // Enable user to click the NEXT button
            val skillActivity = Intent(this, SkillActivity::class.java)
            // pass a variable into the SkillActivity
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
            // if a league hasn't been selected..
        } else {
            // display a Toast to let a user know what they need to do
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
    // End


}
