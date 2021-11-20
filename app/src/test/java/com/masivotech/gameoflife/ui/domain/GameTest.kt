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
        println(game.printBoard())

        assertThat(game.board.cells).hasSize(game.board.width * game.board.height)
    }

    @Test
    fun `verify number of neighbors is 3 for cells at corners`() {
        val cell1 = game.getCell(0, 0)!!
        val neighborsCell1 = game.getCellNeighbors(cell1)
        val cell2 = game.getCell(game.board.width - 1, 0)!!
        val neighborsCell2 = game.getCellNeighbors(cell2)
        val cell3 = game.getCell(0, game.board.height - 1)!!
        val neighborsCell3 = game.getCellNeighbors(cell3)
        val cell4 = game.getCell(game.board.width - 1, game.board.height - 1)!!
        val neighborsCell4 = game.getCellNeighbors(cell4)

        assertThat(neighborsCell1).hasSize(3)
        assertThat(neighborsCell2).hasSize(3)
        assertThat(neighborsCell3).hasSize(3)
        assertThat(neighborsCell4).hasSize(3)
    }


    @Test
    fun `verify number of neighbors is 5 for cells at edges excluding corners`() {
        // verify cells on first row
        for (x in 1 until game.board.width - 1) {
            val cell = game.getCell(x, 0)!!
            val neighbors = game.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on first column
        for (y in 1 until game.board.height - 1) {
            val cell = game.getCell(0, y)!!
            val neighbors = game.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on last row
        for (x in 1 until game.board.width - 1) {
            val cell = game.getCell(x, game.board.height - 1)!!
            val neighbors = game.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on last column
        for (y in 1 until game.board.height - 1) {
            val cell = game.getCell(game.board.width - 1, y)!!
            val neighbors = game.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }
    }
}
