package com.masivotech.gameoflife.ui.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GameTest {

    @Mock
    private lateinit var board: Board

    private lateinit var game: Game

    @Before
    fun setUp() {
        game = Game(board)
    }

    @Test
    fun `verify live cell with 2 live neighbors survives`() {
        whenever(board.getCountOfLivingNeighbors(any())).thenReturn(2)
        val cell = mockCell(CellState.LIVE)

        val nextState = game.calculateNextCellState(cell)

        assertThat(nextState).isEqualTo(CellState.LIVE)
    }

    @Test
    fun `verify live cell with 3 live neighbors survives`() {
        whenever(board.getCountOfLivingNeighbors(any())).thenReturn(3)
        val cell = mockCell(CellState.LIVE)

        val nextState = game.calculateNextCellState(cell)

        assertThat(nextState).isEqualTo(CellState.LIVE)
    }

    @Test
    fun `verify dead cell with 3 live neighbors becomes live`() {
        whenever(board.getCountOfLivingNeighbors(any())).thenReturn(3)
        val cell = mockCell(CellState.DEAD)

        val nextState = game.calculateNextCellState(cell)

        assertThat(nextState).isEqualTo(CellState.LIVE)
    }

    @Test
    fun `verify live cell with less than 2 live neighbors dies`() {
        for(liveNeighbors in 0..1) {
            whenever(board.getCountOfLivingNeighbors(any())).thenReturn(liveNeighbors)
            val cell = mockCell(CellState.LIVE)

            val nextState = game.calculateNextCellState(cell)

            assertThat(nextState).isEqualTo(CellState.DEAD)
        }
    }

    @Test
    fun `verify live cell with more than 3 live neighbors dies`() {
        for(liveNeighbors in 4..8) {
            whenever(board.getCountOfLivingNeighbors(any())).thenReturn(liveNeighbors)
            val cell = mockCell(CellState.LIVE)

            val nextState = game.calculateNextCellState(cell)

            assertThat(nextState).isEqualTo(CellState.DEAD)
        }
    }

    @Test
    fun `verify dead cell with less than 3 live neighbor remains dead`() {
        for(liveNeighbors in 0..2) {
            whenever(board.getCountOfLivingNeighbors(any())).thenReturn(4)
            val cell = mockCell(CellState.DEAD)

            val nextState = game.calculateNextCellState(cell)

            assertThat(nextState).isEqualTo(CellState.DEAD)
        }
    }

    @Test
    fun `verify dead cell with more than 3 live neighbor remains dead`() {
        for(liveNeighbors in 4..8) {
            whenever(board.getCountOfLivingNeighbors(any())).thenReturn(4)
            val cell = mockCell(CellState.DEAD)

            val nextState = game.calculateNextCellState(cell)

            assertThat(nextState).isEqualTo(CellState.DEAD)
        }
    }

    @Test
    fun `verify next round updates board`() {
        whenever(board.cells).thenReturn(arrayListOf())
        game.advanceToNextGeneration()

        verify(board).update(any())
    }

    private fun mockCell(state: CellState) = Cell(state,0, 0)
}
