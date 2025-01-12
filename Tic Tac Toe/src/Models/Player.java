package Models;
public class Player {
    public String playerName;
    public char mark;

    public Player(String playerName,char mark)
    {
        this.playerName=playerName;
        this.mark=mark;
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public char getMark()
    {
        return mark;
    }

}
