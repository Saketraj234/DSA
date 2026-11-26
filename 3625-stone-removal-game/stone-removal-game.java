/**
 * Problem: 3360. Stone Removal Game
 *
 * Alice and Bob play a game with n stones.
 * Alice removes 10 stones first, then Bob removes 9,
 * then Alice removes 8, and so on.
 *
 * A player who cannot remove the required number
 * of stones loses the game.
 *
 * Approach:
 * We use Simulation.
 *
 * Alice starts first, so initially aliceTurn = true.
 *
 * Each turn:
 * - Remove the required number of stones.
 * - Decrease the removal count by 1.
 * - Switch the player's turn.
 *
 * If the next turn belongs to Bob, Alice wins.
 * Otherwise, Alice loses.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canAliceWin(int n) {

        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove) {

            n -= remove;

            remove--;

            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}