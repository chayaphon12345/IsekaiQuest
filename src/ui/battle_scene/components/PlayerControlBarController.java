package ui.battle_scene.components;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import logic.GameController;
import logic.characters.BaseCharacter;
import logic.skillCards.SkillCard;
import ui.common.BaseComponentController;

public class PlayerControlBarController extends BaseComponentController {

    @FXML
    private StackPane stackPane;

    @FXML
    private StackPane mana;

    @FXML
    private StackPane spirit;

    @FXML
    private Text manaText;

    @FXML
    private Text spiritText;

    @FXML
    private ImageView skillCardImg;

    @FXML
    private Button useSkillCardButton;

    @FXML
    private AnchorPane skillCardBox;

    private EventHandler<MouseEvent> skillCardButtonEventHandler;

    private CharacterControlBar characterControlBar;

    @Override
    public void init() {
        //showCharacterControlBar(GameController.getInstance().getPlayerTeam().getMembers().get(1));
        skillCardImg.setVisible(false);
        useSkillCardButton.setDisable(true);
        skillCardButtonEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        };
        updateManaBar(0);
        updateSpiritBar(0);

        GameController.getInstance().setPlayerControlBarController(this);
    }

    public void showCharacterControlBar(BaseCharacter character) {
        characterControlBar = new CharacterControlBar(character);
        stackPane.getChildren().add(characterControlBar);
    }

    public void hideCharacterControlBar() {
        stackPane.getChildren().remove(characterControlBar);
    }

    public void updateManaBar(int currentMana) {
        manaText.setText(currentMana + "/15");
        mana.setPrefWidth(currentMana * 20); // 20 from 15 mana = 300 width
    }

    public void updateSpiritBar(int currentSpirit) {
        spiritText.setText(currentSpirit + "/100");
        spirit.setPrefWidth(currentSpirit * 3);
    }

    public void setSkillCard(SkillCard skillCard) {
        skillCardImg.setImage(skillCard.getSkillAction().getIconImg());
        skillCardImg.setVisible(true);
        useSkillCardButton.setDisable(false);
        skillCardButtonEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                System.out.println("button clicked!");
                //Button btn = (Button) actionEvent.getSource();
                if (GameController.getInstance().getCurrentAction() != null) {
                    GameController.getInstance().getCurrentAction().setFromSkillCard(true);
                    if (useSkillCardButton.getText().equals("CANCEL")) {
                        GameController.getInstance().setCurrentAction(null);
                        GameController.getInstance().getPlayerControlBarController().getCharacterControlBar().getController().getCharacter().resetTarget();
                        GameController.getInstance().setCharactersColorToNormal();
                        useSkillCardButton.setText("USE");
                        return;
                    }
                }
//                if (useSkillCardButton.getProperties().get("actionIndex") == null) {
//                    System.out.println("No action index found");
//                    return;
//                }
                if (skillCardImg.isVisible() && !useSkillCardButton.isDisable()) {
                    skillCard.performAction();
                    getCharacterControlBar().getController().getUseNormalBtn().setText("USE");
                    getCharacterControlBar().getController().getUseSkillBtn().setText("USE");
                    getCharacterControlBar().getController().getUseUltimateBtn().setText("USE");
                    useSkillCardButton.setText("CANCEL");
                }
            }
        };

        useSkillCardButton.addEventHandler(MouseEvent.MOUSE_CLICKED, skillCardButtonEventHandler);
        useSkillCardButton.setText("USE");
    }

    public void unsetSkillCard() {
        skillCardImg.setVisible(false);
        useSkillCardButton.removeEventHandler(MouseEvent.MOUSE_CLICKED, skillCardButtonEventHandler);
        useSkillCardButton.setDisable(true);
    }

    public CharacterControlBar getCharacterControlBar() {
        return characterControlBar;
    }

    public void setCharacterControlBar(CharacterControlBar characterControlBar) {
        this.characterControlBar = characterControlBar;
    }

    public Button getUseSkillCardButton() {
        return useSkillCardButton;
    }

    @Override
    public PlayerControlBar getNode() {
        return (PlayerControlBar) super.getNode();
    }
}
