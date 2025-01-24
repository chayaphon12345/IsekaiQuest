package logic.effects.buffs;

import javafx.scene.image.Image;
import logic.characters.BaseCharacter;
import logic.effects.TriggerEvent;
import logic.effects.TriggerType;
import utils.Assets;

public class MidLineBuff extends LineBuff{
    public MidLineBuff(BaseCharacter effectReceiver, int duration) {
        super(
                "Mid Line Buff",
                effectReceiver,
                duration,
                TriggerType.NOT_TRIGGER,
                TriggerEvent.NONE,
                new Image(Assets.getAsset("/assets/effects/midLineBuff.png"))
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
