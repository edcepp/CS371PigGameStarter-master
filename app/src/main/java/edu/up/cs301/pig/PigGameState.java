package edu.up.cs301.pig;
import edu.up.cs301.game.infoMsg.GameState;
/**
 * Created by eepp on 3/4/17.
 */


public class PigGameState extends GameState {
    private int myID;
    private int myPlayer00Score;
    private int myPlayer01Score;
    private int myRunningTotal;
    private int myCurrentDie;

 // ********** Constructors

   public PigGameState() {
        myID = 0;
        myPlayer00Score = 0;
        myPlayer01Score = 0;
        myRunningTotal = 0;
        myCurrentDie = 1;
    }

    public PigGameState(PigGameState aGameState) {
        myID = aGameState.getID();
    }

    // ********** getters

    public int getID (){
        return myID;
    }
    public int getPlayer00Score(){
        return myPlayer00Score;
    }
    public int getPlayer01Score(){
        return myPlayer01Score;
    }
    public int getRunningTotal(){
        return myRunningTotal;
    }
    public int getCurrentDie(){
        return myCurrentDie;
    }

    // ********** setters

    public void setID (int anID){
        myID = anID;
    }
    public void setPlayer00Score (int aScore){
        myPlayer00Score = aScore;
    }
    public void setPlayer01Score (int aScore){
        myPlayer01Score = aScore;
    }
    public void setRunningTotal (int aTotal){
        myRunningTotal = aTotal;
    }
    public void setCurrentDie (int aDie){
        myCurrentDie = aDie;
    }

}
