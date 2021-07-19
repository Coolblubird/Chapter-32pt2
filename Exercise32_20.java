import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.*;


public class Exercise32_20 extends Application {   
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		TabPane tabPane = new TabPane();
		Tab tab1 = new Tab("Line");
		StackPane pane1 = new StackPane();
		pane1.getChildren().add(new Line(10, 10, 80, 80));
		VBox vbox = new VBox();
		
		tab1.setContent(pane1);
		Tab tab2 = new Tab("Rectangle");
		tab2.setContent(new Rectangle(10, 10, 200, 200));
		Tab tab3 = new Tab("Circle");
		tab3.setContent(new Circle(50, 50, 20));    
		Tab tab4 = new Tab("Ellipse");
		tab4.setContent(new Ellipse(10, 10, 100, 80));
		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
		
		RadioButton rb1 = new RadioButton("Top");
		rb1.setSelected(true);
		RadioButton rb2 = new RadioButton("Bottom");
		RadioButton rb3 = new RadioButton("Left");
		RadioButton rb4 = new RadioButton("Right");
		
		ToggleGroup group = new ToggleGroup();
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb4.setToggleGroup(group);
		
		rb1.setOnAction(e -> {
			if (rb1.isSelected()) {
				tabPane.setSide(Side.TOP);
			}
		});
		
		rb2.setOnAction(e -> {
			if (rb2.isSelected()) {
				tabPane.setSide(Side.BOTTOM);
			}
		});
		
		rb3.setOnAction(e -> {
			if (rb3.isSelected()) {
				tabPane.setSide(Side.LEFT);
			}
		});
		
		rb4.setOnAction(e -> {
			if (rb4.isSelected()) {
				tabPane.setSide(Side.RIGHT);
			}
		});
		
		HBox hbox = new HBox();
		
		hbox.getChildren().addAll(rb1,rb2,rb3,rb4);
		
		vbox.getChildren().addAll(tabPane,hbox);
		
		Scene scene = new Scene(vbox, 300, 250);  
		primaryStage.setTitle("DisplayFigure"); // Set the window title
		primaryStage.setScene(scene); // Place the scene in the window
		primaryStage.show(); // Display the window
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 * line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}