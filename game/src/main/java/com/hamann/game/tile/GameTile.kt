package com.hamann.game.tile

import com.hamann.game.board.BoardManager

class GameTile private constructor() {
    var state: TileState = TileState.EMPTY
        set(value) {
            if (field == TileState.EMPTY) {
                field = value
            } else {
                throw IllegalStateException("Tile value has already been set.")
            }
        }

    companion object {
        fun fillTiles(manager: BoardManager) {

        }
    }
}