package com.hamann.tictactoe.game.helpers

import com.hamann.tictactoe.game.BoardManager
import com.hamann.tictactoe.game.GameBoard
import com.hamann.tictactoe.game.GameManager
import com.hamann.tictactoe.game.tile.GameTile
import com.hamann.tictactoe.game.tile.TileState

object BoardTestsHelper {
    val emptyBoard: GameBoard
        get() {
            return GameBoard()
        }

    fun getTestableBoardScenarios(): List<Array<Any?>> {
        return listOf(
            buildHorizontalXWinner(),
            buildHorizontalOWinner(),
            buildVerticalXWinner(),
            buildVerticalOWinner()
        )
    }

    private fun buildHorizontalXWinner(): Array<Any?> {
        val boardState = emptyBoard
        boardState.also {
            it.getRow(0).forEach { tile ->
                tile.state = TileState.X
            }
        }
        val winner = BoardHelper.Winner(0, 0, 2, 0, GameManager.Player.X)
        return buildTestCaseArray(
            boardState,
            2,
            0,
            TileState.X,
            winner,
            "first row horizontal X win."
        )
    }

    private fun buildHorizontalOWinner(): Array<Any?> {
        val boardState = emptyBoard
        boardState.also {
            it.getRow(0).forEach { tile ->
                tile.state = TileState.O
            }
        }
        val winner = BoardHelper.Winner(0, 0, 2, 0, GameManager.Player.O)
        return buildTestCaseArray(
            boardState,
            2,
            0,
            TileState.O,
            winner,
            "first row horizontal O win."
        )
    }

    private fun buildVerticalXWinner(): Array<Any?> {
        val boardState = emptyBoard
        boardState.also {
            it.getColumn(0).forEach { tile ->
                tile.state = TileState.X
            }
        }
        val winner = BoardHelper.Winner(0, 0, 0, 2, GameManager.Player.X)
        return buildTestCaseArray(
            boardState,
            0,
            2,
            TileState.X,
            winner,
            "first column vertical X win."
        )
    }

    private fun buildVerticalOWinner(): Array<Any?> {
        val boardState = emptyBoard
        boardState.also {
            it.getColumn(0).forEach { tile ->
                tile.state = TileState.O
            }
        }
        val winner = BoardHelper.Winner(0, 0, 0, 2, GameManager.Player.O)
        return buildTestCaseArray(
            boardState,
            0,
            2,
            TileState.O,
            winner,
            "first column vertical O win."
        )
    }

    private fun buildTestCaseArray(
        boardState: GameBoard,
        x: Int,
        y: Int,
        state: TileState,
        winner: BoardHelper.Winner?,
        scenario: String
    ): Array<Any?> {
        return arrayOf(boardState, x, y, state, winner, scenario)
    }
}