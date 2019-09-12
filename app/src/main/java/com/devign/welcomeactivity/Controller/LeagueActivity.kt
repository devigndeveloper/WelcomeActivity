package com.devign.welcomeactivity.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.devign.welcomeactivity.Model.Player
import com.devign.welcomeactivity.R
import com.devign.welcomeactivity.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    // Saves parcelables and constants so that it retains its data when InstanceStates change (rotating screen)
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    // Singles out each button so that only one button highlights
    fun onMensClicked(view: View) {
        LeagueWomensBtn.isChecked = false
        LeagueCoedBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        LeagueMensBtn.isChecked = false
        LeagueCoedBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        LeagueMensBtn.isChecked = false
        LeagueWomensBtn.isChecked = false

        player.league = "coed"
    }
    // End

    // Next click directs user to SkillActivity
    fun leagueNextClicked(view: View) {
        // if a league has been selected..
        if (player.league != "") {
            // Enable user to click the NEXT button
            val skillActivity = Intent(this, SkillActivity::class.java)
            // pass a variable into the SkillActivity
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
            // if a league hasn't been selected..
        } else {
            // display a Toast to let a user know what they need to do
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
    // End


}
