import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardPrototype extends Application {

	private static short width = 800;
	private static short height = 500;

	private static byte HGap = 2;
	private static byte VGap = 20;

	private static boolean ctrlPressed = false;
	private static boolean altPressed = false;
	private static boolean shiftPressed = false;

	private static Stage primaryStage;
	private static Scene scene;
	private static FlowPane flowpane;
	private static Label levelLabel;
	private static Button home, add, remove, change, promote;
	private static Button levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive, levelSix, levelSeven,
			levelEight, levelNine;

	private static Font titleFont = new Font("Impact", 40);

	private static ArrayList<Level> levels = new ArrayList<Level>();
	private static ArrayList<Node> unremovableNodes = new ArrayList<Node>();

	public static void main(String[] args) {
		new BoardPrototype();
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		primaryStage = new Stage();

		flowpane = new FlowPane();

		scene = new Scene(flowpane, width, height);

		home = new Button("Home");
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

		levelLabel = new Label("The League");
		levelLabel.setFont(titleFont);
		unremovableNodes.add(levelLabel);

		flowpane.getChildren().addAll(home, add, remove, change, promote, levelZero, levelOne, levelTwo, levelThree,
				levelFour, levelFive, levelSix, levelSeven, levelEight, levelNine, levelLabel);

		flowpane.setPadding(new Insets(20));
		flowpane.setVgap(VGap);
		flowpane.setHgap(HGap);
		flowpane.setStyle("-fx-background: orange;");

		primaryStage.setScene(scene);
		primaryStage.setTitle("League of Amazing Programmers GUI");
		primaryStage.show();

		levels.add(new Level((byte) 0));
		levels.add(new Level((byte) 1));
		levels.add(new Level((byte) 2));
		levels.add(new Level((byte) 3));
		levels.add(new Level((byte) 4));
		levels.add(new Level((byte) 5));
		levels.add(new Level((byte) 6));
		levels.add(new Level((byte) 7));
		levels.add(new Level((byte) 8));
		levels.add(new Level((byte) 9));

		add.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.addName();
			}

		});

		remove.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeName();
			}

		});

		change.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.changeName();
			}

		});

		promote.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.promoteName();
			}

		});

		levelZero.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 0);
				flowpane.setStyle("-fx-background: black;");
				levelLabel.setText("Level 0");
			}
		});

		levelOne.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 1);
				flowpane.setStyle("-fx-background: tan;");
				levelLabel.setText("Level 1");
			}
		});

		levelTwo.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 2);
				flowpane.setStyle("-fx-background: red;");
				levelLabel.setText("Level 2");
			}
		});

		levelThree.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 3);
				flowpane.setStyle("-fx-background: orange;");
				levelLabel.setText("Level 3");
			}
		});

		levelFour.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 4);
				flowpane.setStyle("-fx-background: yellow;");
				levelLabel.setText("Level 4");
			}
		});

		levelFive.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 5);
				flowpane.setStyle("-fx-background: blue;");
				levelLabel.setText("Level 5");
			}
		});

		levelSix.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 6);
				flowpane.setStyle("-fx-background: green;");
				levelLabel.setText("Level 6");
			}
		});

		levelSeven.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 7);
				flowpane.setStyle("-fx-background: purple;");
				levelLabel.setText("Level 7");
			}
		});

		levelEight.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 8);
				flowpane.setStyle("-fx-background: gray;");
				levelLabel.setText("Level 8");
			}
		});

		levelNine.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				BoardPrototype.removeAndAddNames((byte) 9);
				flowpane.setStyle("-fx-background: white;");
				levelLabel.setText("Level 9");
			}
		});

		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

			if (key.getCode() == KeyCode.DIGIT0) {
				BoardPrototype.removeAndAddNames((byte) 0);
				flowpane.setStyle("-fx-background: black;");
				levelLabel.setText("Level 0");
			} else if (key.getCode() == KeyCode.DIGIT1) {
				BoardPrototype.removeAndAddNames((byte) 1);
				flowpane.setStyle("-fx-background: tan;");
				levelLabel.setText("Level 1");
			} else if (key.getCode() == KeyCode.DIGIT2) {
				BoardPrototype.removeAndAddNames((byte) 2);
				flowpane.setStyle("-fx-background: red;");
				levelLabel.setText("Level 2");
			} else if (key.getCode() == KeyCode.DIGIT3) {
				BoardPrototype.removeAndAddNames((byte) 3);
				flowpane.setStyle("-fx-background: orange;");
				levelLabel.setText("Level 3");
			} else if (key.getCode() == KeyCode.DIGIT4) {
				BoardPrototype.removeAndAddNames((byte) 4);
				flowpane.setStyle("-fx-background: yellow;");
				levelLabel.setText("Level 4");
			} else if (key.getCode() == KeyCode.DIGIT5) {
				BoardPrototype.removeAndAddNames((byte) 5);
				flowpane.setStyle("-fx-background: blue;");
				levelLabel.setText("Level 5");
			} else if (key.getCode() == KeyCode.DIGIT6) {
				BoardPrototype.removeAndAddNames((byte) 6);
				flowpane.setStyle("-fx-background: green;");
				levelLabel.setText("Level 6");
			} else if (key.getCode() == KeyCode.DIGIT7) {
				BoardPrototype.removeAndAddNames((byte) 7);
				flowpane.setStyle("-fx-background: purple;");
				levelLabel.setText("Level 7");
			} else if (key.getCode() == KeyCode.DIGIT8) {
				BoardPrototype.removeAndAddNames((byte) 8);
				flowpane.setStyle("-fx-background: gray;");
				levelLabel.setText("Level 8");
			} else if (key.getCode() == KeyCode.DIGIT9) {
				BoardPrototype.removeAndAddNames((byte) 9);
				flowpane.setStyle("-fx-background: white;");
				levelLabel.setText("Level 9");
			}

			if (key.getCode() == KeyCode.CONTROL) {
				ctrlPressed = true;
			} else if (key.getCode() == KeyCode.ALT) {
				altPressed = true;
			} else if (key.getCode() == KeyCode.SHIFT) {
				shiftPressed = true;
			}

			if (key.getCode() == KeyCode.A && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototype.addName();
			} else if (key.getCode() == KeyCode.R && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototype.removeName();
			} else if (key.getCode() == KeyCode.C && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototype.changeName();
			} else if (key.getCode() == KeyCode.P && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototype.promoteName();
			}
		});

		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if (key.getCode() == KeyCode.CONTROL) {
				ctrlPressed = false;
				System.out.println("released");
			} else if (key.getCode() == KeyCode.ALT) {
				altPressed = false;
			} else if (key.getCode() == KeyCode.SHIFT) {
				shiftPressed = false;
			}
		});
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
				student.setLevelNum(levelNum);
			}
		}
	}

	public static void removeAndAddNames(byte levelNum) {
		for (byte i = 0; i < flowpane.getChildren().size(); i++) {
			if (flowpane.getChildren().get(i) instanceof Label
					&& !(unremovableNodes.contains(flowpane.getChildren().get(i)))) {
				flowpane.getChildren().remove(i);
				i--;
			}
		}

		for (Level level : levels) {
			if (level.getLevel() == levelNum) {

				Label studentText = new Label();
				String appendTo = "";

				for (Student student : level.getStudents()) {
					appendTo += (student.getName() + ", ");
				}

				if (level.getStudents().size() != 0) {
					Font textFont = new Font("Times", 100 / level.getStudents().size());
					studentText.setFont(textFont);
				}

				studentText.setText(appendTo);
				studentText.setTranslateX(-100);
				studentText.setTranslateY(100);
				flowpane.getChildren().add(studentText);
			}
		}
	}

	public static void removeName() {

		boolean removedName = false;

		TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
		Optional<String> findName = textInputDialog.showAndWait();

		for (Level level : levels) {
			for (byte i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					level.removeStudent(level.getStudents().get(i));
					removedName = true;
					i--;
				}
			}
		}

		if (!removedName) {
			System.out.println("Sorry, no name was found, please check for typos.");
		}
	}

	public static void addName() {

		boolean containsLevel = false;

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
				containsLevel = true;
			}
		}

		if (!containsLevel) {
			levels.add(new Level(levelNum));
			for (Level level : levels) {
				if (level.getLevel() == levelNum) {
					level.addStudent(new Student(newName.get(), locationOfName.get(), levelNum));
				}
			}
		}
	}

	public static void changeName() {

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
			for (byte i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					level.getStudents().get(i).setName(newName.get());
					level.getStudents().get(i).setLocation(newLocationOfName.get());
					BoardPrototype.changeStudentLevel(level.getStudents().get(i), newLevelNum);
					i--;
				}
			}
		}
	}

	public static void promoteName() {

		TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
		Optional<String> findName = textInputDialog.showAndWait();

		for (Level level : levels) {
			for (byte i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					BoardPrototype.changeStudentLevel(level.getStudents().get(i), (byte) (level.getLevel() + 1));
					i--;
				}
			}
		}
	}
}
