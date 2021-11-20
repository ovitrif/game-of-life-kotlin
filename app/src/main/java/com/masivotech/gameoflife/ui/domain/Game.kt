package com.masivotech.gameoflife.ui.domain

class Game(val board: Board) {

    init {
        board.seed()
    }

    fun runGameRound() {
        for (x in 0 until board.width) {
            for (y in 0 until board.height) {
                val cell = board.getCell(x, y)
                    ?: throw NullPointerException("Couldn't find cell on position [ x=$x y=$y ]")
                val nextState = calculateNextCellState(cell)
                TODO("Update cell state")
            }
        }
    }

    fun calculateNextCellState(cell: Cell): CellState {
        val numberOfLivingNeighbors = board.getCountOfLivingNeighbors(cell)

        return when (cell.state) {
            CellState.LIVE -> {
                when (numberOfLivingNeighbors) {
                    2, 3 -> CellState.LIVE
                    else -> CellState.DEAD
                }
            }
            CellState.DEAD -> {
                when (numberOfLivingNeighbors == 3) {
                    true -> CellState.LIVE
                    else -> CellState.DEAD
                }
            }
        }
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
