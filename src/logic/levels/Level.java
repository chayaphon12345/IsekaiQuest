package logic.levels;

import javafx.scene.image.Image;
import logic.team.Team;

/**
 * Level
 * this class stores the information of the level
 * enemy team, action pattern, etc.
 */
public abstract class Level {
    private Team enemyTeam;
    private int levelDifficulty;
    private Image bg;

    public Level(Team enemyTeam, int levelDifficulty, Image bg) {
        this.enemyTeam = enemyTeam;
        this.levelDifficulty = levelDifficulty;
        this.bg = bg;
    }
    abstract protected void addMember();
    public Team getEnemyTeam() { return enemyTeam; }
    public Image getImgIcon() { return getEnemyTeam().getRear().get(0).getImgIcon(); }
    public int getLevelDifficulty() { return levelDifficulty; }
    public Image getBg() {
        return bg;
    }

    public void setBg(Image bg) {
        this.bg = bg;
    }
}
