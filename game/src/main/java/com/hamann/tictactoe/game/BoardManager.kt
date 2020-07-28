package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.tile.GameTile
import com.hamann.tictactoe.game.tile.TileState

class BoardManager {

    var board: Array<Array<GameTile>> = getNewBoard()
        private set
    private var callback: BoardStateCallback? = null

    init {
    }

    private fun getNewBoard(): Array<Array<GameTile>> {
        return Array(BOARD_HEIGHT) { y ->
            Array(BOARD_WIDTH) { x ->
                GameTile(x, y).also { tile ->
                    tile.addCallback(object : GameTile.TileCallback {
                        override fun onTileStateChanged(x: Int, y: Int, state: TileState) {
                            reviewBoardState(x, y, state)
                        }
                    })
                }
            }
        }
    }

    internal fun markTile(x: Int, y: Int, player: GameManager.Player) {
        board[x][y].state = TileState.fromPlayer(player)
    }

    internal fun addCallback(callback: BoardStateCallback) {
        this.callback = callback
    }

//    0,0 0,1 0,2
//    1,0 1,1 1,2
//    2,0 2,1 2,2

    private fun reviewBoardState(x: Int, y: Int, state: TileState) {

    }

    interface BoardStateCallback {
        fun onWinnerFound(x1: Int, y1: Int, x2: Int, y2: Int, player: GameManager.Player)
        fun onDraw()
        fun switchPlayer(currentPlayer: GameManager.Player)
    }

    companion object {
        const val BOARD_HEIGHT = 3
        const val BOARD_WIDTH = 3

        const val X_ORIGIN = 0
        const val Y_ORIGIN = 0
    }
}