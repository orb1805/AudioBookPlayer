package ru.orb.audiobookplayer.presentation.impl.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.orb.audiobookplayer.ui.theme.AudioBookPlayerTheme

class PlayerActivity : ComponentActivity() {

    /*@Inject
    lateinit var viewModel: MainActivityViewModel*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDi()
        // viewModel.start()
        setContent {
            AudioBookPlayerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    // MainView(booksLivaData = viewModel.books)
                }
            }
        }
    }

    private fun initDi() {
        // DaggerMainActivityComponent.factory().create().inject(this)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

    }
}