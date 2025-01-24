package logic.effects.buffs;

import javafx.scene.image.Image;
import logic.characters.BaseCharacter;
import logic.effects.TriggerEvent;
import logic.effects.TriggerType;
import utils.Assets;

public class FrontLineBuff extends LineBuff{
    public FrontLineBuff(BaseCharacter effectReceiver, int duration) {
        super(
                "Front Line Buff",
                effectReceiver,
                duration,
                TriggerType.NOT_TRIGGER,
                TriggerEvent.NONE,
                new Image(Assets.getAsset("/assets/effects/firstLineBuff.png"))
        );
    }

    @Override
    public void activate() {

    }

    @Override
    public String getDescription() {
        return "";
    }
}
