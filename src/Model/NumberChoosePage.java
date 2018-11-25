package Model;

import Controller.NumbersController;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NumberChoosePage {
    private Stage owner;
    private int widthScene=850;
    private int heightScene=700;
    private int widthStage=850;
    private int heightStage=700;
    private String title = "Numbers";
    private Scene scene;
    private VBox root;
    private int topMarg = 20;
    private int rightMarg = 30;
    private int bottomMarg = 20;
    private int leftMarg = 30;
    private int rootSpacing = 50;
    public HBox hbox;

    public NumberChoosePage(){

        new JFXPanel();
        owner = new Stage(StageStyle.DECORATED);
        root = new VBox();
        scene = new Scene(root, widthScene, heightScene);
        scene.getStylesheets().add(StarterPage.class.getResource("../stylesheet/desktop.css").toExternalForm());
        hbox = new HBox();
        hbox.setId("inner");
        setStageProperty();
        setHBoxProperty();
    }

    public void setStageProperty(){
        owner.setScene(scene);
        owner.setTitle(title);
        owner.setWidth(widthStage);
        owner.setHeight(heightStage);
        owner.toBack();
        owner.show();
    }

    public void setHBoxProperty() {
        root.setPadding(new Insets(topMarg, rightMarg, bottomMarg, leftMarg));
        root.setSpacing(rootSpacing);
        hbox.setPadding(new Insets(topMarg, rightMarg, bottomMarg, leftMarg));
        hbox.setSpacing(rootSpacing);
        hbox.setAlignment(Pos.CENTER);
    }

    public void showNumberChoosePage(){
        Button teachBttn = new Button("NAUKA");
        teachBttn.setId("teachBttn");
        teachBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                NumbersPage starter = new NumbersPage();
                starter.showNumbersPage();
                owner.close();
            }
        });

        Button testBttn = new Button("TEST");
        testBttn.setId("testBttn");
        testBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                NumberTestPage starter = new NumberTestPage();
                Scene scene = starter.setScene();
                starter.setStageProperty(scene);
                starter.showNumberTestPage();
                owner.close();
            }
        });

        Button backBttn = new Button("BACK");
        backBttn.setId("bck");
        backBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                DesktopPage menu = new DesktopPage();
                menu.showDesktopPage();
                owner.close();
            }
        });

        hbox.getChildren().addAll(teachBttn, testBttn);

        root.getChildren().addAll(hbox, backBttn);
        root.setAlignment(Pos.CENTER);
    }


}