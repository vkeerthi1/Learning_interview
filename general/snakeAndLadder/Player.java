public class Player {
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String playerName;
    private int id;

    Player(String playerName, int id) {
        this.playerName = playerName;
        this.id = id;
    }
}
