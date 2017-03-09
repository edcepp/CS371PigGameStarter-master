package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;
import java.util.Random;

import android.util.Log;

/**
 * Created by eepp on 3/7/17.
 */

public class PigComputerSmartPlayer extends GameComputerPlayer {

    private final double RUNNING_MAX = 14;
    /**
     * ctor does nothing extra
     */
    public PigComputerSmartPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        Log.i("PigComputerPlayer.recei"," ");
        if (info instanceof PigGameState) {
            PigGameState gameState = (PigGameState) info;
            if (playerNum != gameState.getID()) {
                return;
            }

            sleep(2000);
            GameAction action;
            // computer player has won if it holds
            if (gameState.getRunningTotal() + gameState.getPlayer01Score() >= 50){
                action = new PigHoldAction(this);
            }
            // max running score to 14
            else {
                double holdThreshold = (RUNNING_MAX - gameState.getRunningTotal());
                if (holdThreshold < 0.0) {
                    holdThreshold = 0.0;
                }
                holdThreshold /= RUNNING_MAX;
                if (Math.random() > holdThreshold) {
                    action = new PigHoldAction(this);
                } else {
                    action = new PigRollAction(this);
                }
            }
            game.sendAction(action);
        }
    }//receiveInfo

}
