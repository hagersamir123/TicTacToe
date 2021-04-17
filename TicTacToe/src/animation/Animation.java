package animation;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends SplitPane {

    protected final GridPane animationGridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btnYes;
    protected final Button btnNo;
    protected final Label label;

    public boolean isPlayAgain = false;
   
    private String stmt;

    public Animation(String stmt) {
        this.stmt = stmt;
        
        animationGridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        gridPane0 = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btnYes = new Button();
        btnNo = new Button();
        label = new Label();

        setDividerPositions(0.5);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setOrientation(javafx.geometry.Orientation.VERTICAL);
        setPrefHeight(350.0);
        setPrefWidth(650.0);
        getStylesheets().add("/resources/css/style.css");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane0.setMaxHeight(130.0);
        gridPane0.setMinHeight(130.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(60.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(70.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnYes, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnYes, 1);
        GridPane.setValignment(btnYes, javafx.geometry.VPos.CENTER);
        btnYes.setMnemonicParsing(false);
        btnYes.setPrefHeight(32.0);
        btnYes.setPrefWidth(90.0);
        btnYes.getStyleClass().add("btn");
        btnYes.setText("Yes");

        GridPane.setColumnIndex(btnNo, 1);
        GridPane.setHalignment(btnNo, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnNo, 1);
        GridPane.setValignment(btnNo, javafx.geometry.VPos.CENTER);
        btnNo.setMnemonicParsing(false);
        btnNo.setPrefHeight(32.0);
        btnNo.setPrefWidth(90.0);
        btnNo.getStyleClass().add("btn");
        btnNo.setText("No");

        GridPane.setColumnSpan(label, 2);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        label.getStyleClass().add("txtcong");
        label.setText("Do you want to play again?");
        label.setFont(new Font(20.0));

        animationGridPane.getRowConstraints().add(rowConstraints);
        getItems().add(animationGridPane);
        gridPane0.getColumnConstraints().add(columnConstraints0);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getRowConstraints().add(rowConstraints0);
        gridPane0.getRowConstraints().add(rowConstraints1);
        gridPane0.getChildren().add(btnYes);
        gridPane0.getChildren().add(btnNo);
        gridPane0.getChildren().add(label);
        getItems().add(gridPane0);
        
        btnYes.setOnAction((event) -> {
            isPlayAgain = true;
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });

        btnNo.setOnAction((event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });

        startAnimation();

    }

    private void startAnimation() {
        String str = stmt;
        Text[] text = new Text[stmt.length()];

        GridPane root = animationGridPane;
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int index = 0; index < stmt.length(); index++) {
                    int i = index;
                    text[i] = new Text(str.charAt(i) + "");
                    text[i].setFont(new Font("SansSerif", 48));

                    text[i].setFill(Color.GOLD);
                    addAnimationOfMove(text[i], (i + 1) * 100);
                    root.add(text[i], i, 0);
                }

            }
        }).run();
    }

    private void addAnimationOfMove(Text text, double duration) {

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDelay(Duration.millis(duration));
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(text);
        //translateTransition.setByY(50);
        translateTransition.setFromY(-25);
        translateTransition.setToY(25);
        translateTransition.setCycleCount(4);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

    }

}
