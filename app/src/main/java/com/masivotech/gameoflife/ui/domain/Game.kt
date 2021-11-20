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
        val state = when (state) {
            CellState.LIVE -> "🟩"
            CellState.DEAD -> "🟥"
        }
        return "[x=$x, y=$y, $state]"
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

    init {
        seed()
    }

    private fun seed() {
        if (board.cells.isNotEmpty()) throw IllegalStateException("Seed was already done")

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
        for (x in 0 until board.width) {
            for (y in 0 until board.height) {
                var cell = board.cells.find { cell -> cell.x == x && cell.y == y }
                    ?: throw NullPointerException("Couldn't find cell on position [ x=$x y=$y ]")
                cell = calculateNextCellState(cell)
            }
        }
    }

    fun calculateNextCellState(cell: Cell): Cell {
        TODO()
    }

    fun getCellNeighbors(cell: Cell): ArrayList<Cell> {
        val neighbors = ArrayList<Cell>()

        for (x in -1..1) {
            for (y in -1..1) {
                val neighborX = cell.x + x
                val neighborY = cell.y + y
                val neighborCell = getCell(neighborX, neighborY)

                if (neighborCell != null && neighborCell != cell) {
                    neighbors.add(neighborCell)
                }
            }
        }

        return neighbors
    }

    private fun createRandomCellState(): CellState {
        val random = Random.nextInt(0, 2)
        return CellState.values()[random]
    }

    fun getCell(x: Int, y: Int): Cell? {
        return board.cells.find { it.x == x && it.y == y }
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
