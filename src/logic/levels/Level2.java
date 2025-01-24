package logic.levels;

import javafx.scene.image.Image;
import logic.characters.enemy.*;
import logic.team.Team;
import utils.Assets;

public class Level2 extends Level {
    public Level2() {
        super(new Team("Enemy"), 1, new Image(Assets.getAsset("/assets/images/battleBg_castle_night.png")));
        addMember();
    }

    @Override
    protected void addMember() {
        getEnemyTeam().addCharacter(new SoulWarrior(true), Team.Line.FRONT);
        getEnemyTeam().addCharacter(new SoulKnight(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new SoulKnight(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new Dullahan(true), Team.Line.REAR);
    }
}
