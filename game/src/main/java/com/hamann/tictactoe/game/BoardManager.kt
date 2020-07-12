package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.tile.GameTile
import com.hamann.tictactoe.game.tile.TileState

class BoardManager {
    private var board: Array<Array<GameTile>> = arrayOf()

    fun fillBoard() {
        board = Array(BOARD_HEIGHT) { Array(
            BOARD_WIDTH
        ) { GameTile() } }
    }

    fun markTile(x: Int, y: Int, state: TileState) {
        board[x][y].state = state
    }

    companion object {
        const val BOARD_HEIGHT = 3
        const val BOARD_WIDTH = 3
    }
}