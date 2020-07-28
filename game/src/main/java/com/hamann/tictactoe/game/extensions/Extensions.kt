package com.hamann.tictactoe.game.extensions

import com.hamann.tictactoe.game.tile.GameTile
import com.hamann.tictactoe.game.tile.TileState

fun Array<GameTile>.isWinner(state: TileState): Boolean {
    return this.all { tile -> tile.state == state }
}