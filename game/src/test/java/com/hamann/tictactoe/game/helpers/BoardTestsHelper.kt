package com.hamann.tictactoe.game.helpers

object BoardTestsHelper {
    class SimpleXYHolder(val x: Int, val y: Int)

    fun getPassingDiagonalChecks(): Collection<SimpleXYHolder> {
        return listOf(SimpleXYHolder(0,0), SimpleXYHolder(1,1), SimpleXYHolder(2,2), SimpleXYHolder(0,2), SimpleXYHolder(2,0))
    }

    fun getFailingDiagonalChecks(): Collection<SimpleXYHolder> {
        return listOf(SimpleXYHolder(0,1), SimpleXYHolder(1,0), SimpleXYHolder(2,1), SimpleXYHolder(1,2))
    }
}