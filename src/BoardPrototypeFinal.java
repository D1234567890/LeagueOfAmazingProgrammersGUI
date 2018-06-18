import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BoardPrototypeFinal extends Application {

	private static FileReader fr;
	private static BufferedReader br;
	private static Random r = new Random();

	private static boolean loadedData = false;
	private static boolean timerOn = false;
	private static boolean timerActivatedBefore = false;

	private static short width = 2000;
	private static short height = 1000;

	private static byte HGap = 2;
	private static byte VGap = 20;
	private static byte slideCount = 0;
	private static byte frequency = 3;

	private static int timerWait = 5000;

	private static boolean ctrlPressed = false;
	private static boolean altPressed = false;
	private static boolean shiftPressed = false;

	private static Stage primaryStage;
	private static Scene scene;
	private static FlowPane flowpane0, flowpane1, flowpane2, flowpane3, flowpane4, flowpane5, flowpane6, flowpane7,
			flowpane8, flowpane9;
	private static Label labelZero, labelOne, labelTwo, labelThree, labelFour, labelFive, labelSix, labelSeven,
			labelEight, labelNine;

	private static Font titleFont = new Font("Impact", 40);

	private static ArrayList<Level> levels = new ArrayList<Level>();
	private static ArrayList<Image> logos = new ArrayList<Image>();
	private static ArrayList<Image> slideImages = new ArrayList<Image>();

	public static void main(String[] args) {
		new BoardPrototypeFinal();
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		primaryStage = new Stage();

		logos.add(new Image("HooverHS.jpg"));
		logos.add(new Image("GompPrep.png"));
		logos.add(new Image("LEAGUE.png"));
		logos.add(new Image("MalcomX.png"));
		logos.add(new Image("SanElijoMS.png"));
		logos.add(new Image("SanMarcosMS.png"));
		logos.add(new Image("SDCentral.jpg"));
		logos.add(new Image("WilsonMS.jpg"));
		
		slideImages.add(new Image("HooverHS.jpg"));
		slideImages.add(new Image("GompPrep.png"));
		slideImages.add(new Image("LEAGUE.png"));
		slideImages.add(new Image("MalcomX.png"));
		slideImages.add(new Image("SanElijoMS.png"));
		slideImages.add(new Image("SanMarcosMS.png"));
		slideImages.add(new Image("SDCentral.jpg"));
		slideImages.add(new Image("WilsonMS.jpg"));

		labelZero = new Label("Level 0");
		labelOne = new Label("Level 1");
		labelTwo = new Label("Level 2");
		labelThree = new Label("Level 3");
		labelFour = new Label("Level 4");
		labelFive = new Label("Level 5");
		labelSix = new Label("Level 6");
		labelSeven = new Label("Level 7");
		labelEight = new Label("Level 8");
		labelNine = new Label("Level 9");

		labelZero.setTranslateX(850);
		labelOne.setTranslateX(850);
		labelTwo.setTranslateX(850);
		labelThree.setTranslateX(850);
		labelFour.setTranslateX(850);
		labelFive.setTranslateX(850);
		labelSix.setTranslateX(850);
		labelSeven.setTranslateX(850);
		labelEight.setTranslateX(850);
		labelNine.setTranslateX(850);

		labelZero.setFont(titleFont);
		labelOne.setFont(titleFont);
		labelTwo.setFont(titleFont);
		labelThree.setFont(titleFont);
		labelFour.setFont(titleFont);
		labelFive.setFont(titleFont);
		labelSix.setFont(titleFont);
		labelSeven.setFont(titleFont);
		labelEight.setFont(titleFont);
		labelNine.setFont(titleFont);

		flowpane0 = new FlowPane();
		flowpane1 = new FlowPane();
		flowpane2 = new FlowPane();
		flowpane3 = new FlowPane();
		flowpane4 = new FlowPane();
		flowpane5 = new FlowPane();
		flowpane6 = new FlowPane();
		flowpane7 = new FlowPane();
		flowpane8 = new FlowPane();
		flowpane9 = new FlowPane();

		flowpane0.setPadding(new Insets(20));
		flowpane0.setVgap(VGap);
		flowpane0.setHgap(HGap);
		flowpane1.setPadding(new Insets(20));
		flowpane1.setVgap(VGap);
		flowpane1.setHgap(HGap);
		flowpane2.setPadding(new Insets(20));
		flowpane2.setVgap(VGap);
		flowpane2.setHgap(HGap);
		flowpane3.setPadding(new Insets(20));
		flowpane3.setVgap(VGap);
		flowpane3.setHgap(HGap);
		flowpane4.setPadding(new Insets(20));
		flowpane4.setVgap(VGap);
		flowpane4.setHgap(HGap);
		flowpane5.setPadding(new Insets(20));
		flowpane5.setVgap(VGap);
		flowpane5.setHgap(HGap);
		flowpane6.setPadding(new Insets(20));
		flowpane6.setVgap(VGap);
		flowpane6.setHgap(HGap);
		flowpane7.setPadding(new Insets(20));
		flowpane7.setVgap(VGap);
		flowpane7.setHgap(HGap);
		flowpane8.setPadding(new Insets(20));
		flowpane8.setVgap(VGap);
		flowpane8.setHgap(HGap);
		flowpane9.setPadding(new Insets(20));
		flowpane9.setVgap(VGap);
		flowpane9.setHgap(HGap);

		flowpane0.setStyle("-fx-background: gray;");
		flowpane1.setStyle("-fx-background: tan;");
		flowpane2.setStyle("-fx-background: red;");
		flowpane3.setStyle("-fx-background: orange;");
		flowpane4.setStyle("-fx-background: yellow;");
		flowpane5.setStyle("-fx-background: green;");
		flowpane6.setStyle("-fx-background: blue;");
		flowpane7.setStyle("-fx-background: purple;");
		flowpane8.setStyle("-fx-background: gray;");
		flowpane9.setStyle("-fx-background: white;");

		scene = new Scene(flowpane0, width, height);
		scene.getStylesheets().add("test.css");

		primaryStage.setScene(scene);
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

		if (!timerActivatedBefore) {
			BoardPrototypeFinal.timerController();
		}

		timerOn = true;

		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

			if (key.getCode() == KeyCode.DIGIT0) {
				BoardPrototypeFinal.displayLevel((byte) 0);
			} else if (key.getCode() == KeyCode.DIGIT1) {
				BoardPrototypeFinal.displayLevel((byte) 1);
			} else if (key.getCode() == KeyCode.DIGIT2) {
				BoardPrototypeFinal.displayLevel((byte) 2);
			} else if (key.getCode() == KeyCode.DIGIT3) {
				BoardPrototypeFinal.displayLevel((byte) 3);
			} else if (key.getCode() == KeyCode.DIGIT4) {
				BoardPrototypeFinal.displayLevel((byte) 4);
			} else if (key.getCode() == KeyCode.DIGIT5) {
				BoardPrototypeFinal.displayLevel((byte) 5);
			} else if (key.getCode() == KeyCode.DIGIT6) {
				BoardPrototypeFinal.displayLevel((byte) 6);
			} else if (key.getCode() == KeyCode.DIGIT7) {
				BoardPrototypeFinal.displayLevel((byte) 7);
			} else if (key.getCode() == KeyCode.DIGIT8) {
				BoardPrototypeFinal.displayLevel((byte) 8);
			} else if (key.getCode() == KeyCode.DIGIT9) {
				BoardPrototypeFinal.displayLevel((byte) 9);
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
				BoardPrototypeFinal.addStudent();
			} else if (key.getCode() == KeyCode.R && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototypeFinal.removeStudent();
			} else if (key.getCode() == KeyCode.C && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototypeFinal.changeStudent();
			} else if (key.getCode() == KeyCode.P && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototypeFinal.promoteStudent();
			} else if (key.getCode() == KeyCode.N && ctrlPressed) {
				if (!timerActivatedBefore)
					BoardPrototypeFinal.timerController();
				ctrlPressed = false;
				timerOn = true;
			} else if (key.getCode() == KeyCode.F && ctrlPressed) {
				ctrlPressed = false;
				timerOn = false;
			} else if (key.getCode() == KeyCode.S && ctrlPressed) {
				ctrlPressed = false;
				BoardPrototypeFinal.addSlide();
			}
		});

		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->

		{
			if (key.getCode() == KeyCode.CONTROL) {
				ctrlPressed = false;
			} else if (key.getCode() == KeyCode.ALT) {
				altPressed = false;
			} else if (key.getCode() == KeyCode.SHIFT) {
				shiftPressed = false;
			}
		});

		if (!loadedData) {

			try {

				fr = new FileReader("src/student_names.txt");
				br = new BufferedReader(fr);

				String line;
				String firstName;
				String lastName;
				String locationId = "";
				byte level;

				while ((line = br.readLine()) != null) {
					firstName = line.substring(0, line.indexOf(' '));
					lastName = line.substring(line.indexOf(' ') + 1, line.indexOf(','));
					level = Byte.parseByte(line.substring(line.indexOf(',') + 1, line.indexOf(',') + 2));
					locationId = line.substring(line.indexOf(',') + 3, line.indexOf(',') + 5);
					levels.get(level).addStudent(new Student(firstName + " " + lastName, locationId, level));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			loadedData = true;
		}

		BoardPrototypeFinal.updateDisplays();
	}

	public static void timerController() {

		new AnimationTimer() {

			long millis = System.currentTimeMillis();

			public void handle(long now) {

				if (timerOn) {

					if (System.currentTimeMillis() - millis >= timerWait) {

						millis = System.currentTimeMillis();
						BoardPrototypeFinal.displayLevel((byte) (slideCount % 9));

						if (slideCount % frequency == 0 && slideImages.size() > 0) {
							BoardPrototypeFinal.displaySlide(r.nextInt(slideImages.size()));
						} else if (slideCount % frequency == 1 && slideImages.size() > 0) {
							BoardPrototypeFinal.updateDisplays();
						}

						slideCount++;
					}
				}
			}
		}.start();
	}

	public static void addSlide() {

		TextInputDialog textInputDialog = new TextInputDialog("IMAGE NAME");
		Optional<String> imageName = textInputDialog.showAndWait();

		if (!slideImages.contains(new Image(imageName.get()))) {
			slideImages.add(new Image(imageName.get()));
		}
	}

	public static void displaySlide(int randomImage) {

		BoardPrototypeFinal.clearDisplays();

		ImageView imageView = new ImageView();
		TextFlow textFlow = new TextFlow();

		imageView.setImage(slideImages.get(randomImage));
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(800);
		textFlow.setTranslateX(550);
		textFlow.setTranslateY(50);
		textFlow.getChildren().add(imageView);

		flowpane0.getChildren().add(textFlow);
		scene.setRoot(flowpane0);

	}

	public static void displayLevel(byte levelNum) {

		switch (levelNum) {
		case 0:
			scene.setRoot(flowpane0);
			break;
		case 1:
			scene.setRoot(flowpane1);
			break;
		case 2:
			scene.setRoot(flowpane2);
			break;
		case 3:
			scene.setRoot(flowpane3);
			break;
		case 4:
			scene.setRoot(flowpane4);
			break;
		case 5:
			scene.setRoot(flowpane5);
			break;
		case 6:
			scene.setRoot(flowpane6);
			break;
		case 7:
			scene.setRoot(flowpane7);
			break;
		case 8:
			scene.setRoot(flowpane8);
			break;
		case 9:
			scene.setRoot(flowpane9);
			break;
		}
	}

	public static void clearDisplays() {

		flowpane0.getChildren().clear();
		flowpane1.getChildren().clear();
		flowpane2.getChildren().clear();
		flowpane3.getChildren().clear();
		flowpane4.getChildren().clear();
		flowpane5.getChildren().clear();
		flowpane6.getChildren().clear();
		flowpane7.getChildren().clear();
		flowpane8.getChildren().clear();
		flowpane9.getChildren().clear();

	}

	public static void updateDisplays() {

		BoardPrototypeFinal.clearDisplays();

		flowpane0.getChildren().add(labelZero);
		flowpane1.getChildren().add(labelOne);
		flowpane2.getChildren().add(labelTwo);
		flowpane3.getChildren().add(labelThree);
		flowpane4.getChildren().add(labelFour);
		flowpane5.getChildren().add(labelFive);
		flowpane6.getChildren().add(labelSix);
		flowpane7.getChildren().add(labelSeven);
		flowpane8.getChildren().add(labelEight);
		flowpane9.getChildren().add(labelNine);

		for (byte i = 0; i < levels.size(); i++) {

			for (Student student : levels.get(i).getStudents()) {

				TextFlow studentLabel = new TextFlow();
				Text name = new Text(student.getName());
				ImageView imageView = new ImageView("LEAGUE.png");

				final String location = student.getLocation();
				name.setId("fancytext");
				studentLabel.getChildren().add(name);

				switch (location) {
				case "HH":
					imageView.setImage(logos.get(0));
					break;
				case "GP":
					imageView.setImage(logos.get(1));
					break;
				case "CV":
					imageView.setImage(logos.get(2));
					break;
				case "MX":
					imageView.setImage(logos.get(3));
					break;
				case "SE":
					imageView.setImage(logos.get(4));
					break;
				case "SM":
					imageView.setImage(logos.get(5));
					break;
				case "DL":
					imageView.setImage(logos.get(6));
					break;
				case "WM":
					imageView.setImage(logos.get(7));
					break;
				}

				imageView.setPreserveRatio(true);
				imageView.setFitHeight(30);
				studentLabel.getChildren().add(imageView);
				studentLabel.setTranslateY(100);

				switch (i) {
				case 0:
					flowpane0.getChildren().add(studentLabel);
					break;
				case 1:
					flowpane1.getChildren().add(studentLabel);
					break;
				case 2:
					flowpane2.getChildren().add(studentLabel);
					break;
				case 3:
					flowpane3.getChildren().add(studentLabel);
					break;
				case 4:
					flowpane4.getChildren().add(studentLabel);
					break;
				case 5:
					flowpane5.getChildren().add(studentLabel);
					break;
				case 6:
					flowpane6.getChildren().add(studentLabel);
					break;
				case 7:
					flowpane7.getChildren().add(studentLabel);
					break;
				case 8:
					flowpane8.getChildren().add(studentLabel);
					break;
				case 9:
					flowpane9.getChildren().add(studentLabel);
					break;
				}
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

		BoardPrototypeFinal.updateDisplays();
	}

	public static void removeStudent() {

		boolean removedName = false;

		TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
		Optional<String> findName = textInputDialog.showAndWait();

		for (Level level : levels) {
			for (int i = 0; i < level.getStudents().size(); i++) {
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

		BoardPrototypeFinal.updateDisplays();
	}

	public static void addStudent() {

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

		BoardPrototypeFinal.updateDisplays();
	}

	public static void changeStudent() {

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
			for (int i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					level.getStudents().get(i).setName(newName.get());
					level.getStudents().get(i).setLocation(newLocationOfName.get());
					BoardPrototypeFinal.changeStudentLevel(level.getStudents().get(i), newLevelNum);
					i--;
				}
			}
		}

		BoardPrototypeFinal.updateDisplays();
	}

	public static void promoteStudent() {

		TextInputDialog textInputDialog = new TextInputDialog("FIND NAME");
		Optional<String> findName = textInputDialog.showAndWait();

		for (Level level : levels) {
			for (int i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					BoardPrototypeFinal.changeStudentLevel(level.getStudents().get(i), (byte) (level.getLevel() + 1));
					i--;
				}
			}
		}

		BoardPrototypeFinal.updateDisplays();
	}
}
