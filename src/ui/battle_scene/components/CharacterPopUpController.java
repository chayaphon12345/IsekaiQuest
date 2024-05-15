package ui.battle_scene.components;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import logic.GameController;
import logic.actions.Action;
import ui.common.BaseComponentController;

public class CharacterPopUpController {
    @FXML
    private AnchorPane playerSide;
    @FXML
    private ImageView playerCharacterImg;
    @FXML
    private ImageView playerActionImg;
    @FXML
    private Text playerActionName;

    @FXML
    private AnchorPane enemySide;
    @FXML
    private ImageView enemyCharacterImg;
    @FXML
    private ImageView enemyActionImg;
    @FXML
    private Text enemyActionName;

    private StackPane node;

    public StackPane getNode() {
        return node;
    }

    public void setNode(StackPane node) {
        this.node = node;
    }

    public void init() {
        playerSide.setVisible(false);
        enemySide.setVisible(false);
    }

    public void popUpPlayerSide(Action action) {
        // Stop any ongoing transitions
        playerCharacterImg.getOpacity(); // Accessing opacity to force any previous fade transition to stop
        playerCharacterImg.setTranslateX(0); // Reset translate to initial position

        // Set up the pop-up content
        playerCharacterImg.setImage(action.getUser().getImgSprite());
        playerActionImg.setImage(action.getIconImg());
        playerActionName.setText(action.getName());
        playerSide.setVisible(true);

        // Add the pop-up content to a container node within the scene
        AnchorPane battleSceneAnchorPane = GameController.getInstance().getBattleSceneController().getAnchorPane();
        battleSceneAnchorPane.getChildren().add(1, GameController.getInstance().getBattleSceneController().getCharacterPopUp());

        // Create a fade-in transition
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), playerCharacterImg);
        fadeInTransition.setFromValue(0);
        fadeInTransition.setToValue(1);

        // Create a fade-out transition
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), playerCharacterImg);
        fadeOutTransition.setFromValue(1);
        fadeOutTransition.setToValue(0);

        // Create a translate transition to slide the image from right to left
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), playerCharacterImg);
        translateTransition.setToX(-120); // Set it to a value less than the scene width

        // Chain the fade transitions
        SequentialTransition fadeSequentialTransition = new SequentialTransition();
        fadeSequentialTransition.getChildren().addAll(fadeInTransition, fadeOutTransition);

        // Start the fade sequential transition
        fadeSequentialTransition.play();

        // Start the translate transition
        translateTransition.play();

//        playerCharacterImg.setImage(action.getUser().getImgSprite());
//        playerActionImg.setImage(action.getIconImg());
//        playerActionName.setText(action.getName());
//        playerSide.setVisible(true);
//        GameController.getInstance().getBattleSceneController().getAnchorPane().getChildren().add(
//                1, GameController.getInstance().getBattleSceneController().getCharacterPopUp()
//        );
//
//        // Create a fade-in transition
//        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), playerCharacterImg);
//        fadeInTransition.setFromValue(0);
//        fadeInTransition.setToValue(1);
//
//        // Create a fade-out transition
//        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), playerCharacterImg);
//        fadeOutTransition.setFromValue(1);
//        fadeOutTransition.setToValue(0);
//
//        // Create a translate transition to slide the image from right to left
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), playerCharacterImg);
//        translateTransition.setToX(-120); // Set it to a value less than the scene width
//
//        // Chain the transitions
//        SequentialTransition fadeSequentialTransition = new SequentialTransition();
//        fadeSequentialTransition.getChildren().addAll(fadeInTransition, fadeOutTransition);
//
//        // Set cycle count to indefinite for continuous animation
////        fadeSequentialTransition.setCycleCount(Timeline.INDEFINITE);
////        translateTransition.setCycleCount(Timeline.INDEFINITE);
//
//        // Start the animation
//        fadeSequentialTransition.play();
//        translateTransition.play();
    }

    public void popUpEnemySide(Action action) {
        // Stop any ongoing transitions
        enemyCharacterImg.getOpacity(); // Accessing opacity to force any previous fade transition to stop
        enemyCharacterImg.setTranslateX(0); // Reset translate to initial position

        // Set up the pop-up content
        Image characterImage = action.getUser().getImgSprite();
        if(action.getUser().getModifyWidth() !=0 && action.getUser().getModifyHeight() != 0) {
            enemyCharacterImg.setFitHeight(680 * (action.getUser().getModifyHeight() / 300));
            enemyCharacterImg.setFitWidth(680 * (action.getUser().getModifyWidth() / 250));
        }
        else {
            enemyCharacterImg.setFitHeight(680);
            enemyCharacterImg.setFitWidth(680);
        }
        enemyCharacterImg.setImage(characterImage);
        enemyCharacterImg.setScaleX(-1);
        enemyActionImg.setImage(action.getIconImg());
        enemyActionName.setText(action.getName());
        enemySide.setVisible(true);

        // Add the pop-up content to a container node within the scene
        AnchorPane battleSceneAnchorPane = GameController.getInstance().getBattleSceneController().getAnchorPane();
        battleSceneAnchorPane.getChildren().add(1, GameController.getInstance().getBattleSceneController().getCharacterPopUp());

        // Create a fade-in transition
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), enemyCharacterImg);
        fadeInTransition.setFromValue(0);
        fadeInTransition.setToValue(1);

        // Create a fade-out transition
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), enemyCharacterImg);
        fadeOutTransition.setFromValue(1);
        fadeOutTransition.setToValue(0);

        // Create a translate transition to slide the image from right to left
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), enemyCharacterImg);
        translateTransition.setToX(120); // Set it to a value less than the scene width

        // Chain the fade transitions
        SequentialTransition fadeSequentialTransition = new SequentialTransition();
        fadeSequentialTransition.getChildren().addAll(fadeInTransition, fadeOutTransition);

        // Start the fade sequential transition
        fadeSequentialTransition.play();

        // Start the translate transition
        translateTransition.play();
    }

    public void removePopUp() {
        //if(((CharacterPopUp) GameController.getInstance().getBattleSceneController().getAnchorPane().getChildren().get(0)).getController() == this) {
            GameController.getInstance().getBattleSceneController().getAnchorPane().getChildren().remove(1);
        //}
        playerSide.setVisible(false);
        playerCharacterImg.setX(60);
        enemySide.setVisible(false);
        enemyCharacterImg.setX(60);
    }
}
