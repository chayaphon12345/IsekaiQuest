package ui.battle_scene.components;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import logic.actions.Action;
import ui.common.BaseComponent;
import ui.common.BaseComponentController;
import utils.CustomLoader;

public class CharacterPopUp extends AnchorPane {
    protected Parent node; // this is the node that load from .fxml and should be added to the children of the StackPane
    protected CharacterPopUpController controller;

    public CharacterPopUp() {
        CustomLoader loader = new CustomLoader("CharacterPopUp.fxml");
        node = loader.load();
        controller = loader.getController();
        this.getChildren().add(node);

        this.setMaxWidth(1600);
        this.setMaxHeight(900);
        this.setLayoutX(0);
        this.setLayoutY(0);

        ((CharacterPopUpController) controller).init();
    }

    public CharacterPopUpController getController() {
        return (CharacterPopUpController) controller;
    }
}
