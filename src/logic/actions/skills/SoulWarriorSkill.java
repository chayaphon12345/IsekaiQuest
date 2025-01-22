package logic.actions.skills;

import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.SkillAction;
import logic.actions.Target;
import logic.characters.BaseCharacter;
import utils.Assets;

import java.util.ArrayList;

public class SoulWarriorSkill extends SkillAction {
    public SoulWarriorSkill(BaseCharacter character) {
        super(
                character,
                "Soul Gluttony!",
                4,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Enemy
        );
        type = ActionType.Magical;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        if(getUser().getStats().getHealth() > 4) {
            ArrayList<BaseCharacter> playerTeam = GameController.getInstance().getPlayerTeam().getMembers();
            for (int i = 0; i < playerTeam.size(); i++) {
                playerTeam.get(i).takeDamageDirectly(getUser(), 4, type);
            }
            getUser().takeDamageDirectly(getUser(), 4, type);
            getUser().setShield(getUser().getShield() + 15);
        }
        else {
            getUser().setShield(getUser().getShield() + 5);
        }
    }

    @Override
    public String getDescription() {
        return "If this character has more than 4 HP, directly decrease all enemy HP and self HP by 4. then this character receive 15 shields. " +
                "Else this character receive 5 shields instead.";
    }
}
