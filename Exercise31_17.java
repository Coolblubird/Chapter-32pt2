//Jordan Ashe 07-14-21
// Exercise31_01Client.java: The client sends the input to the server and receives
// result back from the server
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise31_17 extends Application {
	// Text field for receiving radius
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfSAmount = new TextField();
	private TextField tfTotal = new TextField();
	private Button btCalculate= new Button("Calculate");
	
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();

		Menu menuExit = new Menu("Exit");
		menuBar.getMenus().addAll(menuExit);
		
		MenuItem menuItemCalculate = new MenuItem("Calcuate");
		MenuItem menuItemExit = new MenuItem("Exit");
		menuExit.getItems().add(menuItemCalculate);
		menuExit.getItems().add(menuItemExit);
		
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(new Label("Investment Amount"), 0, 2);
		gridPane.add(new Label("Total"), 0, 3);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(tfSAmount, 1, 2);
		gridPane.add(tfTotal, 1, 3);
		gridPane.add(btCalculate, 2, 1);
		
		tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfSAmount.setAlignment(Pos.BASELINE_RIGHT);
		tfTotal.setAlignment(Pos.BASELINE_RIGHT);
		
		tfAnnualInterestRate.setPrefColumnCount(5);
		tfNumOfYears.setPrefColumnCount(5);
		tfSAmount.setPrefColumnCount(5);
						
		VBox pane = new VBox();
		pane.getChildren().addAll(menuBar,gridPane);
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		btCalculate.setOnAction(e -> perform());
		
		menuItemCalculate.setOnAction(e -> perform());
		menuItemExit.setOnAction(e -> System.exit(0));
		
		
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
			launch(args);
	}
	
	public void perform() {
		double mIR = Math.pow(1+ Double.parseDouble(tfAnnualInterestRate.getText()) / 12 /100, Double.parseDouble(tfNumOfYears.getText()) * 12);
		
		
		// Display to the text area
		tfTotal.setText("$" + String.valueOf(Double.parseDouble(tfSAmount.getText()) * (mIR)));
	}
}
