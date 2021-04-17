/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

/**
 *
 * @author Mohamed Elsayed
 */
public class Result {
    public int ID;
    public String board;
    public String time;
    public Boolean isWin;
    public boolean isFirst;
    public String friendName;
    public String XO;

    public Result(int ID, String board, String time, Boolean isWin, boolean isFirst, String friendName, String XO) {
        this.ID = ID;
        this.board = board;
        this.time = time;
        this.isWin = isWin;
        this.isFirst = isFirst;
        this.friendName = friendName;
        this.XO = XO;
    }
}
