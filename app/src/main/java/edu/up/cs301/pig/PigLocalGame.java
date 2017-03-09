package edu.up.cs301.pig;

import java.util.Random;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState myGameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        myGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        Log.i("PigLocalGame.canMove"," ");
        return playerIdx == myGameState.getID();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        Log.i("PigLocalGame.makeMove"," ");
        if (action instanceof PigHoldAction) {
            int playerID = myGameState.getID();
            if (playerID == 0){
                int score = myGameState.getPlayer00Score() + myGameState.getRunningTotal();
                myGameState.setPlayer00Score(score);
                myGameState.setID(1);
            }
            else if (playerID == 1){
                int score = myGameState.getPlayer01Score() + myGameState.getRunningTotal();
                myGameState.setPlayer01Score(score);
                myGameState.setID(0);
            }
            else {
                return false;
            }
            myGameState.setRunningTotal(0);
            return true;
        }
        else if (action instanceof PigRollAction){
            Random randomGenerator = new Random();
            int dieValue = randomGenerator.nextInt(6) + 1;
            myGameState.setCurrentDie(dieValue);
            int player = myGameState.getID();
            if (dieValue == 1){
                myGameState.setRunningTotal(0);
                myGameState.setID((player + 1) % 2);
            }
            else {
                int runningTotal = myGameState.getRunningTotal() + dieValue;
                myGameState.setRunningTotal(runningTotal);
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        Log.i("PigLocalGame.sendUpdate"," ");
        p.sendInfo(new PigGameState(myGameState));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        Log.i("PigLocalGame.chxOver"," ");
        if (myGameState.getPlayer00Score() >= 50) {
            return playerNames[0] + " won with a score of " + myGameState.getPlayer00Score();
        }
        else if (myGameState.getPlayer01Score() >= 50){
            return playerNames[1] + " won with a score of " + myGameState.getPlayer01Score();
        }
        else {
            return null;
        }
    }

}// class PigLocalGame
