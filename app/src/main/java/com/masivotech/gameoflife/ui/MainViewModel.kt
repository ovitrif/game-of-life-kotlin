package com.masivotech.gameoflife.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masivotech.gameoflife.ui.domain.Board
import com.masivotech.gameoflife.ui.domain.Game
import com.masivotech.gameoflife.ui.domain.createRandomSeed
import javax.inject.Inject

class MainViewModel @Inject constructor(
) : ViewModel() {

    private val game: Game

    val gameStarted = MutableLiveData<Boolean>()
    val gameOutput = MutableLiveData("")

    init {
        val initialSeed = createRandomSeed(10, 10)
        val board = Board(initialSeed, 10, 10)
        this.game = Game(board, this::onNewRound)
    }

    fun onStartGameClick() {
        gameStarted.value = true
        game.play(5)
    }

    private fun onNewRound(output: String) {
        gameOutput.value += output
    }
}
