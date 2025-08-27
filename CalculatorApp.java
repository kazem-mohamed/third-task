package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // مكونات الواجهة
        TextField num1Field = new TextField();
        num1Field.setPromptText("ادخل الرقم الأول");

        TextField num2Field = new TextField();
        num2Field.setPromptText("ادخل الرقم الثاني");

        Label resultLabel = new Label("النتيجة ستظهر هنا");

        Button addButton = new Button("جمع (+)");
        Button subButton = new Button("طرح (-)");

        // الأحداث
        addButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = num1 + num2;
                resultLabel.setText("النتيجة: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("⚠ من فضلك أدخل أرقام صحيحة");
            }
        });

        subButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = num1 - num2;
                resultLabel.setText("النتيجة: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("⚠ من فضلك أدخل أرقام صحيحة");
            }
        });

        // تصميم الواجهة (VBox)
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 15; -fx-alignment: center;");
        root.getChildren().addAll(num1Field, num2Field, addButton, subButton, resultLabel);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("آلة حاسبة بسيطة");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
