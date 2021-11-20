package com.masivotech.gameoflife.ui.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class GameTest {

    private lateinit var game: Game

    @Before
    fun setUp() {
        game = Game()
    }

    @Test
    fun `verify board size`() {
        game.seed()

        println(game.printBoard())

        assertThat(game.board.cells).hasSize(game.board.width * game.board.height)
    }
}
