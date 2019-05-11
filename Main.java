package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    private static final double SCENE_WIDTH = 600.d;
    private static final double SCENE_HEIGHT = 600.d;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");

        Button movingButton = new Button("Click me");
        Pane pane = new Pane(movingButton);

        setOnActionEvent(movingButton);

        primaryStage.setScene(new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT, Color.BLUEVIOLET));
        primaryStage.setResizable(Boolean.FALSE);
        primaryStage.show();
    }

    private void setOnActionEvent(Button button) {
        button.setOnAction(event ->  {
            double randomX = ThreadLocalRandom.current().nextDouble(button.getWidth(), SCENE_WIDTH-button.getWidth());
            double randomY = ThreadLocalRandom.current().nextDouble(button.getHeight(), SCENE_HEIGHT-button.getHeight());
            button.setTranslateX(randomX);
            button.setTranslateY(randomY);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
