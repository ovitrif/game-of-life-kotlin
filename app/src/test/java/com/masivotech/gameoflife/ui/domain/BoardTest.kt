package com.masivotech.gameoflife.ui.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class BoardTest {

    private lateinit var board: Board

    @Before
    fun setUp() {
        val seed = createRandomSeed(10, 10)
        board = Board(seed)
    }

    @Test
    fun `verify board size`() {
        assertThat(board.cells).hasSize(board.width * board.height)
    }

    @Test
    fun `verify number of neighbors is 3 for cells at corners`() {
        val cell1 = board.getCell(0, 0)!!
        val neighborsCell1 = board.getCellNeighbors(cell1)
        val cell2 = board.getCell(board.width - 1, 0)!!
        val neighborsCell2 = board.getCellNeighbors(cell2)
        val cell3 = board.getCell(0, board.height - 1)!!
        val neighborsCell3 = board.getCellNeighbors(cell3)
        val cell4 = board.getCell(board.width - 1, board.height - 1)!!
        val neighborsCell4 = board.getCellNeighbors(cell4)

        assertThat(neighborsCell1).hasSize(3)
        assertThat(neighborsCell2).hasSize(3)
        assertThat(neighborsCell3).hasSize(3)
        assertThat(neighborsCell4).hasSize(3)
    }

    @Test
    fun `verify number of neighbors is 5 for cells at edges excluding corners`() {
        // verify cells on first row
        for (x in 1 until board.width - 1) {
            val cell = board.getCell(x, 0)!!
            val neighbors = board.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on first column
        for (y in 1 until board.height - 1) {
            val cell = board.getCell(0, y)!!
            val neighbors = board.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on last row
        for (x in 1 until board.width - 1) {
            val cell = board.getCell(x, board.height - 1)!!
            val neighbors = board.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }

        // verify cells on last column
        for (y in 1 until board.height - 1) {
            val cell = board.getCell(board.width - 1, y)!!
            val neighbors = board.getCellNeighbors(cell)

            assertThat(neighbors).hasSize(5)
        }
    }

    @Test
    fun `verify number of neighbors is 8 for all other cells`() {
        for (x in 1 until board.width - 1) {
            for (y in 1 until board.height - 1) {
                val cell = board.getCell(x, y)!!
                val neighbors = board.getCellNeighbors(cell)

                assertThat(neighbors).hasSize(8)
            }
        }
    }
}
