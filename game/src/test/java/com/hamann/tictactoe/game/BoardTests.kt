package com.hamann.tictactoe.game

import com.hamann.tictactoe.game.helpers.BoardHelper
import com.hamann.tictactoe.game.helpers.BoardTestsHelper
import org.junit.Test

class BoardTests {

    @Test
    fun boardManager_board_construction_correct_size() {
        val manager = BoardManager()
        assert(manager.board.size == BoardManager.BOARD_HEIGHT
                && manager.board.all { row ->
            row.size == BoardManager.BOARD_WIDTH
        })
    }

    @Test
    fun boardManager_board_construction_callbacks_added() {
        val manager = BoardManager()
        assert(manager.board.all { arrayOfGameTiles ->
            arrayOfGameTiles.all { tile ->
                tile.hasCallback
            }
        })
    }

    @Test
    fun boardManager_board_construction_correct_coordinates() {
        val manager = BoardManager()
    }

    @Test
    fun boardManager_board_construction_correct_startingState() {

    }

    fun boardManager_markTile() {

    }

    @Test
    fun boardHelper_checkDiagonals_true() {
        val coordsToCheck = BoardTestsHelper.getPassingDiagonalChecks()
        val results = coordsToCheck.map{ coords ->
            BoardHelper.needToCheckDiagonals(coords.x, coords.y)
        }
        assert(results.all { it })
    }

    @Test
    fun boardHelper_checkDiagonals_false() {
        val coordsToCheck = BoardTestsHelper.getFailingDiagonalChecks()
        val results = coordsToCheck.map { coords ->
            BoardHelper.needToCheckDiagonals(coords.x, coords.y)
        }
        assert(results.all { !it })
    }
}