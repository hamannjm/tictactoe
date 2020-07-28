package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.helpers.BoardHelper
import com.hamann.tictactoe.game.helpers.BoardTestsHelper
import org.junit.Before
import org.junit.Test

class BoardManagerTests {

    lateinit var boardManager: BoardManager



    @Before
    fun setup() {
        boardManager = BoardManager()
    }

    @Test
    fun boardManager_board_construction_correct_size() {
        assert(boardManager.board.size == BoardManager.BOARD_HEIGHT
                && boardManager.board.all { row ->
            row.size == BoardManager.BOARD_WIDTH
        })
    }

    @Test
    fun boardManager_board_construction_callbacks_added() {
        assert(boardManager.board.all { arrayOfGameTiles ->
            arrayOfGameTiles.all { tile ->
                tile.hasCallback
            }
        })
    }

    @Test
    fun boardManager_board_construction_correct_coordinates() {

    }

    @Test
    fun boardManager_board_construction_correct_startingState() {

    }

    fun boardManager_markTile() {

    }


}