import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class blackjack extends Application {

private Label label = new Label("Dont hurt me");

    @Override
    public void start(Stage primaryStage) {
        // Erstelle UI-Elemente
        Button button = new Button("Click me to hurt the above");

        // Ändere den Text des Labels, wenn der Button geklickt wird
        button.setOnAction(event -> label.setText("AAAAAAAAAAAAAAAA"));

        // Erstelle einen Layout-Container
        VBox root = new VBox(10);
        root.getChildren().addAll(label, button);

        // Erstelle die Szene und füge sie zur Bühne hinzu
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("GUck mal hier ist der Titel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
