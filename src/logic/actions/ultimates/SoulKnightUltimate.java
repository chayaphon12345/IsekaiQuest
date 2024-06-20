package logic.actions.ultimates;

import javafx.application.Platform;
import javafx.scene.image.Image;
import logic.GameController;
import logic.actions.ActionType;
import logic.actions.Target;
import logic.actions.UltimateAction;
import logic.characters.BaseCharacter;
import logic.characters.Stats;
import utils.Assets;

import java.util.ArrayList;

public class SoulKnightUltimate extends UltimateAction {
    public SoulKnightUltimate(BaseCharacter character) {
        super(
                character,
                "Soul Blast!",
                0,
                new Image(Assets.getAsset("/assets/actions/enemy/enemyAction.png")),
                Target.Friend
        );
        type = ActionType.Magical;
        this.spiritCost = 30;
    }
    @Override
    public void activate(BaseCharacter targetCharacter) {
        int damage = ((getUser().getStats().getMAX_HP() - getUser().getStats().getHealth()) / 10) + 10;
        ArrayList<BaseCharacter> playerTeam = GameController.getInstance().getPlayerTeam().getMembers();
        for(int i=0; i<playerTeam.size(); i++) {
            playerTeam.get(i).takeDamageDirectly(getUser(), damage, type);
        }
    }

    @Override
    public String getDescription() {
        return "Directly attack all enemy HP. Damage equals to this character lost HP divide by 10, then + 10.";
    }
}
