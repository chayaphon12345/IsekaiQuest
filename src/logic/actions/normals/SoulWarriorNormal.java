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
import logic.interfaces.Debuffable;
import utils.Assets;

public class SoulWarriorNormal extends NormalAction implements Debuffable {
    public SoulWarriorNormal(BaseCharacter character) {
        super(
                character,
                "Warrior Ramming",
                3,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Enemy
        );
        type = ActionType.Physical;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        targetCharacter.takeDamage(getUser(), this.getUser().getStats().getAttack(), type);
        giveDebuff(targetCharacter);
    }

    @Override
    public String getDescription() {
        return "Attack 1 enemy. Damage base on own ATK. Then give debuff 'Broken Armor' to that enemy.";
    }

    @Override
    public Effect giveDebuff(BaseCharacter character) {
        boolean hasBrokenArmor = false;
        BrokenArmor brokenArmor = new BrokenArmor(character, 2);
        for(int i=0; i<character.getStatusEffect().size(); i++) {
            Effect effect = character.getStatusEffect().get(i);
            if(effect instanceof BrokenArmor) {
                brokenArmor = (BrokenArmor) effect;
                hasBrokenArmor = true;
            }
        }
        if(hasBrokenArmor) {
            brokenArmor.addDuration(2);
        } else {
            character.getStatusEffect().add(brokenArmor);
            brokenArmor.activate();
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                character.getCard().getController().setEffect(character.getStatusEffect()); // before trigger event
                GameController.getInstance().runEffectByEvent(TriggerEvent.RECEIVE_DEBUFF, character);
            }
        });
        return brokenArmor;
    }
}
