package com.masivotech.gameoflife.ui.domain

import androidx.annotation.VisibleForTesting
import com.masivotech.gameoflife.testing.OpenForTesting

@OpenForTesting
@Suppress("LeakingThis")
class Board(
    seed: ArrayList<Cell>,
    val width: Int = 10,
    val height: Int = 10,
) {

    lateinit var cells: ArrayList<Cell>

    init {
        if (validateSeed(seed)) {
            cells = seed
        } else {
            throw IllegalArgumentException("Invalid seed")
        }
    }

    fun getCountOfLivingNeighbors(cell: Cell): Int {
        return getCellNeighbors(cell).count { it.state == CellState.LIVE }
    }

    @VisibleForTesting
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

    fun getCell(x: Int, y: Int): Cell? {
        return cells.find { it.x == x && it.y == y }
    }

    fun update(nextState: ArrayList<Cell>) {
        cells = nextState
    }

    fun render(): String {
        var output = ""

        for (cell in cells) {
            output += "$cell "

            if (cell.y == width - 1) {
                output += "\n"
            }
        }

        return output
    }

    private fun validateSeed(seed: ArrayList<Cell>): Boolean {
        // TODO improve validation (e.g. validate value for cell positions)
        return when {
            seed.size != width * height -> false
            else -> true
        }
    }
}
