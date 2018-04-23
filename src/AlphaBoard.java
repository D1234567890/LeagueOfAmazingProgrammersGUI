import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AlphaBoard extends Application {

	private static short width = 750;
	private static short height = 500;

	private static Stage primaryStage;
	private static Scene scene, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11;
	private static FlowPane flowpane, flowpane2, flowpane3, flowpane4, flowpane5, flowpane6, flowpane7, flowpane8,
			flowpane9, flowpane10, flowpane11;
	private static Button add, remove, change, promote;
	private static Button levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive, levelSix, levelSeven,
			levelEight, levelNine;

	static ArrayList<Level> levels = new ArrayList<Level>();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		primaryStage = new Stage();

		flowpane = new FlowPane();
		flowpane2 = new FlowPane();
		flowpane3 = new FlowPane();
		flowpane4 = new FlowPane();
		flowpane5 = new FlowPane();
		flowpane6 = new FlowPane();
		flowpane7 = new FlowPane();
		flowpane8 = new FlowPane();
		flowpane9 = new FlowPane();
		flowpane10 = new FlowPane();
		flowpane11 = new FlowPane();

		scene = new Scene(flowpane, width, height);
		scene2 = new Scene(flowpane2, width, height);
		scene3 = new Scene(flowpane3, width, height);
		scene4 = new Scene(flowpane4, width, height);
		scene5 = new Scene(flowpane5, width, height);
		scene6 = new Scene(flowpane6, width, height);
		scene7 = new Scene(flowpane7, width, height);
		scene8 = new Scene(flowpane8, width, height);
		scene9 = new Scene(flowpane9, width, height);
		scene10 = new Scene(flowpane10, width, height);
		scene11 = new Scene(flowpane11, width, height);

		add = new Button("Add Name");
		remove = new Button("Remove Name");
		change = new Button("Change name");
		promote = new Button("Promote Name");

		levelZero = new Button("0");
		levelOne = new Button("1");
		levelTwo = new Button("2");
		levelThree = new Button("3");
		levelFour = new Button("4");
		levelFive = new Button("5");
		levelSix = new Button("6");
		levelSeven = new Button("7");
		levelEight = new Button("8");
		levelNine = new Button("9");

		add.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				TextInputDialog textInputDialog = new TextInputDialog("NAME");
				Optional<String> newName = textInputDialog.showAndWait();

				textInputDialog = new TextInputDialog("LOCATION");
				Optional<String> locationOfName = textInputDialog.showAndWait();

				textInputDialog = new TextInputDialog("LEVEL");
				Optional<String> levelOfName = textInputDialog.showAndWait();
				byte levelNum = Byte.parseByte(levelOfName.get());

				for (Level level : levels) {
					if (level.getLevel() == levelNum) {
						level.addStudent(new Student(newName.get(), locationOfName.get(), levelNum));
					}
				}

			}

		});

		remove.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
				Optional<String> findName = textInputDialog.showAndWait();

				for (Level level : levels) {
					for (Student student : level.getStudents()) {
						if (student.getName().equalsIgnoreCase(findName.get())) {
							level.removeStudent(student);
						}
					}
				}

			}

		});

		change.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
				Optional<String> findName = textInputDialog.showAndWait();

				textInputDialog = new TextInputDialog("NEW NAME");
				Optional<String> newName = textInputDialog.showAndWait();

				textInputDialog = new TextInputDialog("NEW LOCATION");
				Optional<String> newLocationOfName = textInputDialog.showAndWait();

				textInputDialog = new TextInputDialog("NEW LEVEL");
				Optional<String> levelOfName = textInputDialog.showAndWait();
				byte newLevelNum = Byte.parseByte(levelOfName.get());

				for (Level level : levels) {
					for (Student student : level.getStudents()) {
						if (student.getName().equalsIgnoreCase(findName.get())) {
							student.setName(newName.get());
							student.setLocation(newLocationOfName.get());
							AlphaBoard.changeStudentLevel(student, newLevelNum);
						}
					}
				}

			}

		});

		promote.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
				Optional<String> findName = textInputDialog.showAndWait();

				for (Level level : levels) {
					for (Student student : level.getStudents()) {
						if (student.getName().equalsIgnoreCase(findName.get())) {
							AlphaBoard.changeStudentLevel(student, (byte) (student.getLevelNum() + 1));
						}
					}
				}

			}

		});

		levelZero.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene2);
				flowpane2.getChildren().addAll(levelOne, levelTwo, levelThree, levelFour, levelFive, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane2.getChildren().add(levelZero);
				flowpane2.getChildren().remove(levelZero);
			}
		});

		levelOne.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene3);
				flowpane3.getChildren().addAll(levelZero, levelTwo, levelThree, levelFour, levelFive, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane3.getChildren().add(levelOne);
				flowpane3.getChildren().remove(levelOne);
			}
		});

		levelTwo.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene4);
				flowpane4.getChildren().addAll(levelZero, levelOne, levelThree, levelFour, levelFive, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane4.getChildren().add(levelTwo);
				flowpane4.getChildren().remove(levelTwo);
			}
		});

		levelThree.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene5);
				flowpane5.getChildren().addAll(levelZero, levelOne, levelTwo, levelFour, levelFive, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane5.getChildren().add(levelThree);
				flowpane5.getChildren().remove(levelThree);
			}
		});

		levelFour.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene6);
				flowpane6.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFive, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane6.getChildren().add(levelFour);
				flowpane6.getChildren().remove(levelFour);
			}
		});

		levelFive.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene7);
				flowpane7.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFour, levelSix,
						levelSeven, levelEight, levelNine);
				flowpane7.getChildren().add(levelFive);
				flowpane7.getChildren().remove(levelFive);
			}
		});

		levelSix.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene8);
				flowpane8.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive,
						levelSeven, levelEight, levelNine);
				flowpane8.getChildren().add(levelSix);
				flowpane8.getChildren().remove(levelSix);
			}
		});

		levelSeven.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene9);
				flowpane9.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive,
						levelSix, levelEight, levelNine);
				flowpane9.getChildren().add(levelSeven);
				flowpane9.getChildren().remove(levelSeven);
			}
		});

		levelEight.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene10);
				flowpane10.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive,
						levelSix, levelSeven, levelNine);
				flowpane10.getChildren().add(levelEight);
				flowpane10.getChildren().remove(levelEight);
			}
		});

		levelNine.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				primaryStage.setScene(scene11);
				flowpane11.getChildren().addAll(levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive,
						levelSix, levelSeven, levelEight);
				flowpane11.getChildren().add(levelNine);
				flowpane11.getChildren().remove(levelNine);
			}
		});

		flowpane.getChildren().addAll(add, remove, change, promote, levelZero, levelOne, levelTwo, levelThree,
				levelFour, levelFive, levelSix, levelSeven, levelEight, levelNine);

		flowpane.setPadding(new Insets(20));
		flowpane.setVgap(20);
		flowpane.setStyle("-fx-background: pink;");

		flowpane2.setPadding(new Insets(20));
		flowpane2.setVgap(20);
		flowpane2.setStyle("-fx-background: black;");

		flowpane3.setPadding(new Insets(20));
		flowpane3.setVgap(20);
		flowpane3.setStyle("-fx-background: tan;");

		flowpane4.setPadding(new Insets(20));
		flowpane4.setVgap(20);
		flowpane4.setStyle("-fx-background: red;");

		flowpane5.setPadding(new Insets(20));
		flowpane5.setVgap(20);
		flowpane5.setStyle("-fx-background: orange;");

		flowpane6.setPadding(new Insets(20));
		flowpane6.setVgap(20);
		flowpane6.setStyle("-fx-background: yellow;");

		flowpane7.setPadding(new Insets(20));
		flowpane7.setVgap(20);
		flowpane7.setStyle("-fx-background: blue;");

		flowpane8.setPadding(new Insets(20));
		flowpane8.setVgap(20);
		flowpane8.setStyle("-fx-background: green;");

		flowpane9.setPadding(new Insets(20));
		flowpane9.setVgap(20);
		flowpane9.setStyle("-fx-background: purple;");

		flowpane10.setPadding(new Insets(20));
		flowpane10.setVgap(20);
		flowpane10.setStyle("-fx-background: gray;");

		flowpane11.setPadding(new Insets(20));
		flowpane11.setVgap(20);
		flowpane11.setStyle("-fx-background: white;");

		primaryStage.setScene(scene);
		primaryStage.setTitle("League of Amazing Programmers GUI");
		primaryStage.show();
	}

	public static void addLevel(byte levelNum) {

		boolean containsLevel = false;

		for (Level level : levels) {
			if (level.getLevel() == levelNum) {
				containsLevel = true;
			}
		}

		if (!containsLevel) {
			levels.add(new Level(levelNum));
		} else {
			System.out.println("There already exists a class with that level number!");
		}
	}

	public static void removeLevel(byte levelNum) {
		for (Level level : levels) {
			if (level.getLevel() == levelNum) {
				levels.remove(level);
			}
		}
	}

	public static void changeStudentLevel(Student student, byte levelNum) {
		for (Level level : levels) {
			if (level.hasStudent(student)) {
				level.removeStudent(student);
			}
			if (level.getLevel() == levelNum) {
				level.addStudent(student);
			}
		}
		student.setLevelNum(levelNum);
	}
}
