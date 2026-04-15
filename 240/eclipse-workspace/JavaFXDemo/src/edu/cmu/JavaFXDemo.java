package edu.cmu;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class JavaFXDemo extends Application
{
	public static void main (String [] args)
	{
			launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Button btn1 = new Button("press me");
		btn1.setLayoutX(50);
		btn1.setLayoutY(100);
		Button btn2 = new Button("click me");
		btn2.setLayoutX(150);
		btn2.setLayoutY(100);

		Circle circle = new Circle(120, 140, 100);
		
		Pane pane = new Pane(circle, btn1, btn2);
		
		//Group grp1 = new Group(btn1,btn2);
		Scene scene = new Scene(pane, 300, 300);
		
		primaryStage.setTitle("My GUI");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Rectangle rect = new Rectangle(50, 100, 750, 100);
		rect.setFill(Color.MAROON);
		Label lbl = new Label("Central Michigan University");
		lbl.setTextFill(Color.GOLD);
		lbl.setFont(new Font("Mono", 60));
		lbl.setLayoutY(100);
		lbl.setLayoutX(50);
		Text txt = new Text("CMU likes to sugon deez nuts");
		txt.setLayoutY(250);
		txt.setLayoutX(50);
		txt.setFont(new Font("Comic Sans", 30));
		txt.setFill(Color.PURPLE);
		Group grp2 = new Group(rect, lbl,txt);
		Stage secondaryStage = new Stage();
		//secondaryStage.(Color.RED);
		secondaryStage.setTitle("stage 2");
		Scene secondaryScene = new Scene(grp2, 900, 300);
		secondaryStage.setScene(secondaryScene);
		secondaryStage.show();
		secondaryStage.setResizable(false);
		
	}
}

