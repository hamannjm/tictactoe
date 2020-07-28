package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.helpers.BoardHelper
import com.hamann.tictactoe.game.helpers.BoardTestsHelper
import com.hamann.tictactoe.game.tile.GameTile
import com.hamann.tictactoe.game.tile.TileState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class BoardHelperTests(private val board: GameBoard,
                       private val x: Int,
                       private val y: Int,
                       private val state: TileState,
                       private val expected: BoardHelper.Winner?,
                       private val scenario: String) {
    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "boardScenario: {5}")
        fun boards() = BoardTestsHelper.getTestableBoardScenarios()
    }

    @Test
    fun test_boardHelper_checkWinner() {
        val result = BoardHelper.checkForWinner(board, x, y, state)
        assertEquals(expected, result)
    }
}