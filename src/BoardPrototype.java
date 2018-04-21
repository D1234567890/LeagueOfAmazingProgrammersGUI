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
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardPrototype extends Application {

	private static short width = 750;
	private static short height = 500;

	private static byte HGap = 2;
	private static byte VGap = 20;

	private static Stage primaryStage;
	private static Scene scene;
	private static FlowPane flowpane;
	private static Label levelLabel;
	private static Button add, remove, change, promote;
	private static Button levelZero, levelOne, levelTwo, levelThree, levelFour, levelFive, levelSix, levelSeven,
			levelEight, levelNine;

	Font titleFont = new Font("Impact", 40);

	static ArrayList<Level> levels = new ArrayList<Level>();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		primaryStage = new Stage();

		flowpane = new FlowPane();

		scene = new Scene(flowpane, width, height);

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

		add.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

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
							BoardPrototype.changeStudentLevel(student, newLevelNum);
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
							BoardPrototype.changeStudentLevel(student, (byte) (student.getLevelNum() + 1));
						}
					}
				}

			}

		});

		levelZero.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 0) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: black;");
				levelLabel.setText("Level 0");
			}
		});

		levelOne.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					
					if (node instanceof Label && node != levelLabel) {
						System.out.println("OK");
						flowpane.getChildren().remove(node);
						System.out.println("OK");
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 1) {
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: tan;");
				levelLabel.setText("Level 1");
			}
		});

		levelTwo.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 2) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: red;");
				levelLabel.setText("Level 2");
			}
		});

		levelThree.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 3) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: orange;");
				levelLabel.setText("Level 3");
			}
		});

		levelFour.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 4) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: yellow;");
				levelLabel.setText("Level 4");
			}
		});

		levelFive.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 5) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: blue;");
				levelLabel.setText("Level 5");
			}
		});

		levelSix.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 6) {
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: green;");
				levelLabel.setText("Level 6");
			}
		});

		levelSeven.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 7) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: purple;");
				levelLabel.setText("Level 7");
			}
		});

		levelEight.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 8) {
						
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: gray;");
				levelLabel.setText("Level 8");
			}
		});

		levelNine.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				for (Node node : flowpane.getChildren()) {
					if (node instanceof Label && node != levelLabel) {
						flowpane.getChildren().remove(node);
					}
				}

				ArrayList<Label> nameLabels = new ArrayList<Label>();

				for (Level level : levels) {
					if (level.getLevel() == 9) {
						for (Student student : level.getStudents()) {
							nameLabels.add(new Label(student.getName()));
						}
					}
				}

				flowpane.getChildren().addAll(nameLabels);
				flowpane.setStyle("-fx-background: white;");
				levelLabel.setText("Level 9");
			}
		});

		flowpane.getChildren().addAll(add, remove, change, promote, levelZero, levelOne, levelTwo, levelThree,
				levelFour, levelFive, levelSix, levelSeven, levelEight, levelNine, levelLabel);

		flowpane.setPadding(new Insets(20));
		flowpane.setVgap(VGap);
		flowpane.setHgap(HGap);
		flowpane.setStyle("-fx-background: orange;");

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
