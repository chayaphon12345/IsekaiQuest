package logic.actions.ultimates;

import javafx.application.Platform;
import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.Target;
import logic.actions.UltimateAction;
import logic.characters.BaseCharacter;
import logic.effects.Effect;
import logic.effects.buffs.MaliciousWill;
import logic.effects.buffs.PowerBoostingMeal;
import logic.effects.buffs.SoulBoost;
import logic.interfaces.Buffable;
import logic.team.Team;
import utils.Assets;

import java.util.ArrayList;

public class DullahanUltimate extends UltimateAction implements Buffable {
    public DullahanUltimate(BaseCharacter character) {
        super(
                character,
                "Bloodshed Decree!",
                0,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Enemy
        );
        type = ActionType.Physical;
        this.spiritCost = 35;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        int additionalDmg = (int) (0.5 * (getUser().getStats().getMagic()));
        ArrayList<BaseCharacter> playerTeam = GameController.getInstance().getPlayerTeam().getMembers();
        for(int i=0; i<playerTeam.size(); i++) {
            playerTeam.get(i).takeDamage(getUser(), getUser().getStats().getAttack() + additionalDmg, type);
        }

        for (BaseCharacter character : GameController.getInstance().getEnemyTeam().getMembers()) {
            giveBuff(character);
        }
    }

    @Override
    public String getDescription() {
        return "Attack all enemy. Damage base on own ATK + half of own MAT. Then give a buff 'Soul Boost' for 3 turns and 'Malicious Will' for 2 turns to every character in the same team.";
    }

    @Override
    public Effect giveBuff(BaseCharacter character) {
        boolean hasSoulBoost = false;
        SoulBoost soulBoost = new SoulBoost(character, 3);

        for(int i=0; i<character.getStatusEffect().size(); i++) {
            Effect effect = character.getStatusEffect().get(i);
            if(effect instanceof SoulBoost) {
                soulBoost = (SoulBoost) effect;
                hasSoulBoost = true;
            }
        }
        if(hasSoulBoost) {
            soulBoost.addDuration(3);
        } else {
            character.getStatusEffect().add(soulBoost);
            soulBoost.activate();
        }

        boolean hasMaliciousWill = false;
        MaliciousWill maliciousWill = new MaliciousWill(character, 2);

        for(int i=0; i<character.getStatusEffect().size(); i++) {
            Effect effect = character.getStatusEffect().get(i);
            if(effect instanceof MaliciousWill) {
                maliciousWill = (MaliciousWill) effect;
                hasMaliciousWill = true;
            }
        }
        if(hasMaliciousWill) {
            maliciousWill.addDuration(2);
        } else {
            character.getStatusEffect().add(maliciousWill);
            maliciousWill.activate();
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                character.getCard().getController().setEffect(character.getStatusEffect());
            }
        });
        return soulBoost;
    }
}
