package logic.effects.buffs;

import javafx.scene.image.Image;
import logic.characters.BaseCharacter;
import logic.effects.TriggerEvent;
import logic.effects.TriggerType;
import utils.Assets;

public class RearLineBuff extends LineBuff{
    public RearLineBuff(BaseCharacter effectReceiver, int duration) {
        super(
                "Rear Line Buff",
                effectReceiver,
                duration,
                TriggerType.NOT_TRIGGER,
                TriggerEvent.NONE,
                new Image(Assets.getAsset("/assets/effects/rearLineBuff.png"))
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
