package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.tile.TileState

class GameManager {

    enum class Player{
        X, O;
        companion object {
            fun fromState(state: TileState): Player {
                return when (state) {
                    TileState.X -> X
                    TileState.O -> O
                    else -> throw IllegalStateException("Unable to convert from $state state.")
                }
            }
        }
    }
}