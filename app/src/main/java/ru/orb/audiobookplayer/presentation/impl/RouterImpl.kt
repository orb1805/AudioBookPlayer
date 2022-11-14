package ru.orb.audiobookplayer.presentation.impl

import android.content.Context
import android.content.Intent
import ru.orb.audiobookplayer.presentation.api.Router
import ru.orb.audiobookplayer.presentation.impl.main.MainActivity
import ru.orb.audiobookplayer.presentation.impl.player.PlayerActivity
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val context: Context
) : Router {

    override fun openMainScreen() {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

    override fun openPlayer() {
        context.startActivity(Intent(context, PlayerActivity::class.java))
    }
}