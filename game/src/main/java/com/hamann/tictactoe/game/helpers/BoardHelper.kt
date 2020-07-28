package com.hamann.tictactoe.game.helpers

import com.hamann.tictactoe.game.BoardManager
import com.hamann.tictactoe.game.GameBoard
import com.hamann.tictactoe.game.GameManager
import com.hamann.tictactoe.game.extensions.isWinner
import com.hamann.tictactoe.game.tile.TileState

object BoardHelper {

    internal const val MAX_WIDTH_INDEX = BoardManager.BOARD_WIDTH - 1
    internal const val MAX_HEIGHT_INDEX = BoardManager.BOARD_HEIGHT - 1

    internal fun checkForWinner(board: GameBoard, x: Int, y: Int, state: TileState): Winner? {
        //validate inputs
        if (x < 0 || x > 2) {
            throw Throwable("Invalid value for parameter: x")
        }
        if (y < 0 || y > 2) {
            throw Throwable("Invalid value for parameter: y")
        }
        if (state == TileState.EMPTY) {
            throw Throwable("Invalid value for parameter: state")
        }
        //check row
        return when {
            board.getRow(y).isWinner(state) -> {
                Winner(BoardManager.X_ORIGIN, y, MAX_WIDTH_INDEX, y, GameManager.Player.fromState(state))
            }
            board.getColumn(x).isWinner(state) -> {
                Winner(x, BoardManager.Y_ORIGIN, x, MAX_HEIGHT_INDEX, GameManager.Player.fromState(state))
            }
            needToCheckDiagonals(x, y) -> {
                when {
                    board.getDiagonal().isWinner(state) -> {
                        Winner(BoardManager.X_ORIGIN, BoardManager.Y_ORIGIN, MAX_WIDTH_INDEX, MAX_HEIGHT_INDEX, GameManager.Player.fromState(state))
                    }
                    board.getReverseDiagonal().isWinner(state) -> {
                        Winner(MAX_WIDTH_INDEX, BoardManager.Y_ORIGIN, BoardManager.X_ORIGIN, MAX_HEIGHT_INDEX, GameManager.Player.fromState(state))
                    }
                    else -> {
                        null
                    }
                }
            }
            else -> {
                null
            }
        }
    }

//    0,0 0,1 0,2
//    1,0 1,1 1,2
//    2,0 2,1 2,2
    internal fun needToCheckDiagonals(x: Int, y: Int): Boolean {
        return (x == y
                || (x == BoardManager.X_ORIGIN && y == MAX_HEIGHT_INDEX)
                || (y == BoardManager.Y_ORIGIN && x == MAX_WIDTH_INDEX))
    }

    data class Winner(val x1: Int, val y1: Int, val x2: Int, val y2: Int, val player: GameManager.Player)
}