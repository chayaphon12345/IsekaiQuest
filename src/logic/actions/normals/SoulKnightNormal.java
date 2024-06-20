package logic.actions.normals;

import javafx.application.Platform;
import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.NormalAction;
import logic.actions.Target;
import logic.characters.BaseCharacter;
import logic.effects.Effect;
import logic.effects.TriggerEvent;
import logic.effects.debuffs.BrokenArmor;
import utils.Assets;

public class SoulKnightNormal extends NormalAction {
    public SoulKnightNormal(BaseCharacter character) {
        super(
                character,
                "Overwhelming Strike!",
                3,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Enemy
        );
        type = ActionType.Physical;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        int additionalDmg = (int) (getUser().getStats().getAttack() * ((double) targetCharacter.getStats().getHealth() / targetCharacter.getStats().getMAX_HP()));
        targetCharacter.takeDamage(getUser(), this.getUser().getStats().getAttack() + additionalDmg, type);
    }

    @Override
    public String getDescription() {
        return "Attack 1 enemy. Damage base on own ATK + additional damage which equals to multiply of own ATK and percentage of target HP";
    }
}
