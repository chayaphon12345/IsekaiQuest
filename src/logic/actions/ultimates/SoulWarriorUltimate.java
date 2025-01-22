package logic.actions.ultimates;

import javafx.application.Platform;
import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.Target;
import logic.actions.UltimateAction;
import logic.characters.BaseCharacter;
import logic.characters.Stats;
import logic.interfaces.Healable;
import utils.Assets;

import java.util.ArrayList;

public class SoulWarriorUltimate extends UltimateAction implements Healable {
    public SoulWarriorUltimate(BaseCharacter character) {
        super(
                character,
                "For All Defense!",
                0,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Friend
        );
        type = ActionType.Physical;
        this.spiritCost = 30;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        if(getUser().getStats().getHealth() >= 10) {
            int reduceHp = (int) (0.1 * getUser().getStats().getHealth());
            Stats newStats = getUser().getStats();
            newStats.setHealth(newStats.getHealth() - reduceHp);
            getUser().setStats(newStats);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    getUser().updateCharacterHp();
                    getUser().updateCheckAlive();
                }
            });

            ArrayList<BaseCharacter> team = GameController.getInstance().getEnemyTeam().getMembers();
            for(int i=0; i<team.size(); i++) {
                team.get(i).setShield(team.get(i).getShield() + 25);
            }
        }
        else {
            heal(getUser(), 50);
        }
    }

    @Override
    public String getDescription() {
        return "If this character has more than or equal to 10 HP. " +
                "Then decrease this character HP by 10% and give 25 shields to all character in the same team. " +
                "Else heal this character by 50 HP.";
    }

    @Override
    public void heal(BaseCharacter character, int amount) {
        character.getCard().getController().displayHeal(amount);
        Stats newStats = character.getStats();
        newStats.setHealth(newStats.getHealth() + amount);
        character.setStats(newStats);
        character.updateCharacterHp();
    }
}
