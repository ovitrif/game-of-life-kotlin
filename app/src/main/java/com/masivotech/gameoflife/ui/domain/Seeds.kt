package com.masivotech.gameoflife.ui.domain

import kotlin.random.Random

fun createRandomSeed(width: Int, height: Int): ArrayList<Cell> {
    val cells = ArrayList<Cell>(width * height)

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

    return cells
}

private fun createRandomCellState(): CellState {
    val random = Random.nextInt(0, 2)
    return CellState.values()[random]
}
