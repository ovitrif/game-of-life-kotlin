package com.masivotech.gameoflife.ui.domain

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
            CellState.LIVE -> "X"
            CellState.DEAD -> "O"
        }
    }
}
