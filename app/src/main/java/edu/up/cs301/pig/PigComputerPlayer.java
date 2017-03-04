package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;
import java.util.Random;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
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
        if (info instanceof PigGameState){
            PigGameState gameState = (PigGameState)info;
            if (playerNum != gameState.getID()) {
                return;
            }
        }
        Random randomGenerator = new Random();
        int randomValue = randomGenerator.nextInt(2);
        GameAction action;
        if (randomValue == 0) {
            action = new PigHoldAction(this);
        }
        else {
            action = new PigRollAction(this);
        }
        game.sendAction(action);
    }//receiveInfo

}
