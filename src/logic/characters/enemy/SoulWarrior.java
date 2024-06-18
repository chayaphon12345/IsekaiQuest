package logic.characters.enemy;

import javafx.scene.image.Image;
import logic.actions.Action;
import logic.actions.normals.SkeletonNormal;
import logic.actions.normals.SoulWarriorNormal;
import logic.actions.skills.SkeletonSkill;
import logic.actions.skills.SoulWarriorSkill;
import logic.actions.ultimates.SkeletonUltimate;
import logic.actions.ultimates.SoulWarriorUltimate;
import logic.characters.Attacker;
import logic.characters.Stats;
import utils.Assets;

import java.util.ArrayList;
import java.util.Arrays;

public class SoulWarrior extends Attacker {
    public SoulWarrior() {
        super(
                "",
                "Soul Warrior",
                new Stats(200, 30, 25, 15, 25),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeleton.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeletonWithBg.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                300,
                200
        );
        super.setActionList(new ArrayList<Action>(Arrays.asList(new SoulWarriorNormal(this), new SoulWarriorSkill(this), new SoulWarriorUltimate(this))));
    }

    public SoulWarrior(boolean isBot) {
        super(
                "",
                "Soul Warrior",
                new Stats(200, 30, 25, 15, 25),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeleton.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeletonWithBg.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                300,
                200
        );
        super.setActionList(new ArrayList<Action>(Arrays.asList(new SoulWarriorNormal(this), new SoulWarriorSkill(this), new SoulWarriorUltimate(this))));
        this.setBot(isBot);
        this.setActionPattern(new ArrayList<Integer>(Arrays.asList(0,1,0,1,1,0,2)));
    }
}
