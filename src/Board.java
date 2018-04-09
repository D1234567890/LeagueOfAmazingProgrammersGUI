import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Board extends Application {

	private static Stage primaryStage;
	private static VBox root;
	private static Scene scene;
	private static Button add;
	private static Button remove;
	private static Button change;
	private static Button promote;

	static ArrayList<Level> levels = new ArrayList<Level>();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		primaryStage = new Stage();
		root = new VBox();
		scene = new Scene(root, 500, 1000);

		add = new Button("Add Name");
		remove = new Button("Remove Name");
		change = new Button("Change name");
		promote = new Button("Promote Name");

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
					for (Student student: level.getStudents()) {
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
					for (Student student: level.getStudents()) {
						if (student.getName().equalsIgnoreCase(findName.get())) {
							student.setName(newName.get());
							student.setLocation(newLocationOfName.get());
							Board.changeStudentLevel(student, newLevelNum);
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
					for (Student student: level.getStudents()) {
						if (student.getName().equalsIgnoreCase(findName.get())) {
							Board.changeStudentLevel(student, (byte) (student.getLevelNum() + 1));
						}
					}
				}

			}

		});

		root.getChildren().add(add);
		root.getChildren().add(change);
		root.getChildren().add(remove);
		root.getChildren().add(promote);

		primaryStage.setScene(scene);
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
