package com.hamann.tictactoe.game.tile

import com.hamann.tictactoe.game.GameManager

enum class TileState {
    X, O, EMPTY;
    companion object {
        fun fromPlayer(player: GameManager.Player): TileState {
            return when (player) {
                GameManager.Player.X -> X
                GameManager.Player.O -> O
            }
        }
    }
}