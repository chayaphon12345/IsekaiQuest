package logic.actions.skills;

import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.SkillAction;
import logic.actions.Target;
import logic.characters.BaseCharacter;
import logic.characters.Stats;
import utils.Assets;

import java.util.ArrayList;

public class SoulKnightSkill extends SkillAction {
    public SoulKnightSkill(BaseCharacter character) {
        super(
                character,
                "Devilish Magnify",
                5,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Enemy
        );
        type = ActionType.Physical;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        targetCharacter.takeDamage(getUser(), getUser().getStats().getAttack() + 10, type);

        Stats newStats = getUser().getStats();
        newStats.setAttack(newStats.getAttack() + 3);
        if(newStats.getAttack() > 50) newStats.setAttack(50);
        getUser().setStats(newStats);
    }

    @Override
    public String getDescription() {
        return "Attack 1 enemy. Damage base on ATK + 10. Then increase own ATK by 3, but not more than 50 ATK in total.";
    }
}
