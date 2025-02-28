package logic.levels;

import javafx.scene.image.Image;
import logic.characters.enemy.Cyclops;
import logic.characters.enemy.Minotaur;
import logic.characters.enemy.Skeleton;
import logic.characters.enemy.Vampire;
import logic.team.Team;
import utils.Assets;

public class Level1 extends Level {
    public Level1() {
        super(new Team("Enemy"), 1, new Image(Assets.getAsset("/assets/images/home.png")));
        addMember();
    }

    @Override
    protected void addMember() {
        getEnemyTeam().addCharacter(new Skeleton(true), Team.Line.FRONT);
        getEnemyTeam().addCharacter(new Vampire(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new Vampire(true), Team.Line.MID);
        getEnemyTeam().addCharacter(new Cyclops(true), Team.Line.REAR);
    }
}
