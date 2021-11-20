package com.masivotech.gameoflife.ui.domain

import androidx.annotation.VisibleForTesting
import com.masivotech.gameoflife.testing.OpenForTesting
import kotlin.random.Random

@OpenForTesting
class Board(
    val width: Int = 10,
    val height: Int = 10,
) {
    val cells: ArrayList<Cell> = ArrayList(width * height)

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

    fun seed() {
        if (cells.isNotEmpty()) throw IllegalStateException("Seed was already done")

        repeat(width) { indexX ->
            repeat(height) { indexY ->
                cells.add(
                    Cell(
                        state = createRandomCellState(),
                        x = indexX,
                        y = indexY
                    )
                )
            }
        }
    }

    private fun createRandomCellState(): CellState {
        val random = Random.nextInt(0, 2)
        return CellState.values()[random]
    }
}
