package com.hamann.tictactoe.game.tile

class GameTile internal constructor() {
    var state: TileState =
        TileState.EMPTY
        set(value) {
            if (field == TileState.EMPTY) {
                field = value
            } else {
                throw IllegalStateException("Tile value has already been set.")
            }
        }
}