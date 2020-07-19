package com.hamann.tictactoe.game.tile

import com.hamann.tictactoe.game.exceptions.TileStateException

class GameTile internal constructor(val x: Int, val y: Int) {
    var state: TileState = TileState.EMPTY
        internal set(value) {
            if (field == TileState.EMPTY) {
                field = value
                callback?.onTileStateChanged(x, y, field)
            } else {
                throw TileStateException("Tile value has already been set.")
            }
        }

    private var callback: TileCallback? = null
    val hasCallback: Boolean
        get() {
            return callback != null
        }

    fun addCallback(callback: TileCallback) {
        this.callback = callback
    }

    fun removeCallback() {
        this.callback = null
    }

    interface TileCallback {
        fun onTileStateChanged(x: Int, y: Int, state: TileState)
    }
}