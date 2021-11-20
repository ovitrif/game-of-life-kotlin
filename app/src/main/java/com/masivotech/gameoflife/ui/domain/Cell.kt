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
        val state = when (state) {
            CellState.LIVE -> "🟩"
            CellState.DEAD -> "🟥"
        }
        return "[x=$x, y=$y, $state]"
    }
}
