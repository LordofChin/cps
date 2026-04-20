package edu.cmu;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventHandlingDemo extends Application implements EventHandler<ActionEvent>
{
	private Text txt2 = new Text("initial text 2");
	private Text txt3 = new Text("initial text 2");

	private int pressed2 = 0;
	private int pressed3 = 0;
	public static void main(String [] args)
	{
		launch();
	}
	public void start(Stage pStage) 
	{
		
		// circle text
			Text cText = new Text("initial text");
			cText.setLayoutX(50);
			cText.setLayoutY(200);
			
		//circle segment
			Circle circle = new Circle(150); 
			circle.setFill(Color.FORESTGREEN);
			circle.setOnMouseEntered(event -> {
				cText.setText("circle entered");
			});
			circle.setOnMouseExited(event -> {
				cText.setText("initial text");
			});
		// moveable circle segment
			Circle mcircle = new Circle(30);
			mcircle.setFill(Color.PINK);
			
		// circle button segment
			Button csButton = new Button("Shrink circle");
			csButton.setLayoutX(150);
			csButton.setLayoutY(200);
			csButton.setOnAction(event -> {
				circle.setRadius(circle.getRadius() - 30);
			});
			Button ceButton = new Button("Enlarge circle");
			ceButton.setLayoutX(300);
			ceButton.setLayoutY(200);
			ceButton.setOnAction(event -> {
				circle.setRadius(circle.getRadius() + 30);
			});

		
		// text segment
			Text txt = new Text("initial text");
			txt.setLayoutX(50);
			txt.setLayoutY(50);

		// text segment 2
			txt2.setLayoutX(150);
			txt2.setLayoutY(50);
			
		// text segment 3
			txt3.setLayoutX(300);
			txt3.setLayoutY(50);

		// button segment
			Button btnShow = new Button("Show Text");
			btnShow.setLayoutX(50);
			btnShow.setLayoutY(100);
			btnShow.setOnAction(new ButtonHandler(txt));
			
		// button segment 2
			Button btn2 = new Button("Show Text (in-class)");
			btn2.setLayoutX(150);
			btn2.setLayoutY(100);
			btn2.setOnAction(this);
		
		// button segment 3
			Button btn3 = new Button("Show Text (in-class)");
			btn3.setLayoutX(300);
			btn3.setLayoutY(100);
			btn3.setOnAction(event -> {
				System.out.println("button clicked");
				txt3.setText(String.format("Pressed %d times", ++pressed3));	
			});
		
		// pane segment
			Pane pane = new Pane(
					circle,
					txt, 
					btnShow, 
					txt2, 
					btn2, 
					txt3, 
					btn3,
					csButton,
					ceButton,
					cText,
					mcircle
					);
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			
		// scene segment
			Scene scene = new Scene(pane, 800, 300);
			
			scene.setOnKeyPressed(e -> {
				switch(e.getCode())
				{
				case W:	mcircle.setCenterY(mcircle.getCenterY() - 10); break;
				case S:	mcircle.setCenterY(mcircle.getCenterY() + 10); break;
				case A:	mcircle.setCenterX(mcircle.getCenterX() - 10); break;
				case D:	mcircle.setCenterX(mcircle.getCenterX() + 10); break;
				case I:	circle.setTranslateY(circle.getTranslateY() - 10); break;
				case K:	circle.setTranslateY(circle.getTranslateY() + 10); break;
				case J:	circle.setTranslateX(circle.getTranslateX() - 10); break;
				case L:	circle.setTranslateX(circle.getTranslateX() + 10); break;
					default: break;
				}
			});
		
		// stage segment
			pStage.setTitle("EventHandlingDemo");
			pStage.setScene(scene);
			pStage.show();
	}
	@Override
	public void handle(ActionEvent event) {
		System.out.println("Button Click");
		txt2.setText(String.format("Pressed %d times", ++pressed2));	
	}
}

class ButtonHandler implements EventHandler<ActionEvent>
{
	private Text txt;
	private int pressed = 0;
	public ButtonHandler(Text txt)
	{
		this.txt = txt;
	}
	@Override
	public void handle(ActionEvent event) 
	{
		System.out.println("Button Click");
		txt.setText(String.format("Pressed %d times", ++pressed));
	}
	
}
