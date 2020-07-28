package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.tile.GameTile

class GameBoard {
    private val board = Array(BoardManager.BOARD_HEIGHT) { y ->
        Array(BoardManager.BOARD_WIDTH) { x ->
            GameTile(x, y)
        }
    }

    fun at(x: Int, y: Int): GameTile {
        return board[y][x]
    }

    fun getColumn(index: Int): Array<GameTile> {
        return board.map { rows ->
            rows[index]
        }.toTypedArray()
    }

    fun getRow(index: Int): Array<GameTile> {
        return board[index]
    }

    fun getDiagonal(): Array<GameTile> {
        return arrayOf(
            at(0, 0),
            at(1, 1),
            at(2, 2)
        )
    }

    fun getReverseDiagonal(): Array<GameTile> {
        return arrayOf(
            at(2,0),
            at(1,1),
            at(0,2)
        )
    }
}