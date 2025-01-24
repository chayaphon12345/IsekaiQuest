package logic.levels;

import javafx.scene.image.Image;
import logic.characters.enemy.DevilSage;
import logic.characters.enemy.Golem;
import logic.characters.enemy.Minotaur;
import logic.characters.enemy.Vampire;
import logic.team.Team;
import utils.Assets;

public class Level4 extends Level {
    public Level4() {
        super(new Team("Enemy"), 2, new Image(Assets.getAsset("/assets/images/battleBg_castle_night.png")));
        addMember();
    }

    @Override
    protected void addMember() {
        getEnemyTeam().addCharacter(new Golem(true), Team.Line.FRONT);
        getEnemyTeam().addCharacter(new Minotaur(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new Vampire(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new Golem(true), Team.Line.REAR);
    }
}
