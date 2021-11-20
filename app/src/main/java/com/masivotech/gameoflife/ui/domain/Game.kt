package com.masivotech.gameoflife.ui.domain

import kotlin.random.Random


enum class CellState {
    LIVE,
    DEAD,
}

data class Cell(
    val state: CellState,
    val x: Int,
    val y: Int,
) {
    override fun toString(): String {
        return when (state) {
            CellState.LIVE -> "🟩"
            CellState.DEAD -> "🟥"
        }
    }
}

class Board(
    val width: Int = 10,
    val height: Int = 10,
) {
    val cells: ArrayList<Cell> = ArrayList(width * height)
}

class Game {

    val board = Board()

    fun seed() {
        repeat(board.width) { indexX ->
            repeat(board.height) { indexY ->
                board.cells.add(
                    Cell(
                        state = createRandomCellState(),
                        x = indexX,
                        y = indexY
                    )
                )
            }
        }
    }

    fun runGameRound() {
        TODO()
    }

    fun calculateNextCellState(cell: Cell): Cell {
        TODO()
    }

    fun getCellNeighbors(cell: Cell): ArrayList<Cell> {
        TODO()
    }

    private fun createRandomCellState(): CellState {
        val random = Random.nextInt(0, 2)
        return CellState.values()[random]
    }

    fun printBoard(): String {
        var output = ""
        for (cell in board.cells) {
            output += "$cell "

            if (cell.y == board.width - 1) {
                output += "\n"
            }
        }

        return output
    }
}
