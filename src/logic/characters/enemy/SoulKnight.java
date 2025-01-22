package logic.characters.enemy;

import javafx.scene.image.Image;
import logic.actions.Action;
import logic.actions.normals.SoulKnightNormal;
import logic.actions.normals.SoulWarriorNormal;
import logic.actions.skills.SoulKnightSkill;
import logic.actions.skills.SoulWarriorSkill;
import logic.actions.ultimates.SoulKnightUltimate;
import logic.actions.ultimates.SoulWarriorUltimate;
import logic.characters.Attacker;
import logic.characters.Stats;
import utils.Assets;

import java.util.ArrayList;
import java.util.Arrays;

public class SoulKnight extends Attacker {
    public SoulKnight() {
        super(
                "",
                "Soul Knight",
                new Stats(200, 28, 15, 20, 16, 25, 40, 20),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/soulKnight/soulKnight.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeletonWithBg.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                320,
                220
        );
        super.setActionList(new ArrayList<Action>(Arrays.asList(new SoulKnightNormal(this), new SoulKnightSkill(this), new SoulKnightUltimate(this))));
    }

    public SoulKnight(boolean isBot) {
        super(
                "",
                "Soul Knight",
                new Stats(200, 28, 15, 20, 16, 25, 40, 20),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/soulKnight/soulKnight.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/skeletonWithBg.png")),
                new Image(Assets.getAsset("/assets/characters/enemy/skeleton/icon.png")),
                320,
                220
        );
        super.setActionList(new ArrayList<Action>(Arrays.asList(new SoulKnightNormal(this), new SoulKnightSkill(this), new SoulKnightUltimate(this))));
        this.setBot(isBot);
        this.setActionPattern(new ArrayList<Integer>(Arrays.asList(0,1,0,1,1,0,2)));
    }
}
