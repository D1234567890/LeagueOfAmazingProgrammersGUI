import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
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

public class Display extends Application {

	// Class References

	private static File imageFiles = new File("src/Slide Images for the League");
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	private static TextInputDialog textInputDialog;
	private static Random r;

	// Primitives

	private static boolean loadedData = false;
	private static boolean timerOn = false;
	private static boolean timerActivatedBefore = false;
	private static boolean ctrlPressed = false;
	private static boolean keyCreated = false;

	private static short width = (short) toolkit.getScreenSize().getWidth();
	private static short height = (short) toolkit.getScreenSize().getHeight();

	private static byte HGap = 2;
	private static byte VGap = 20;
	private static byte frequency = 5;

	private static short translateX = (short) ((toolkit.getScreenSize().getWidth() / 2) - 75);

	private static int timerWait = 6000;
	private static int slideCount = 0;
	private static int slideOffset = 0;

	// Java FX References

	private static Stage primaryStage;
	private static Scene scene;

	private static FlowPane flowpane0, flowpane1, flowpane2, flowpane3, flowpane4, flowpane5, flowpane6, flowpane7,
			flowpane8, flowpane9, flowpaneImage;

	private static Label labelZero, labelOne, labelTwo, labelThree, labelFour, labelFive, labelSix, labelSeven,
			labelEight, labelNine;

	// Miscellaneous

	private static Font titleFont = new Font("Impact", 40);

	private static ArrayList<Level> levels = new ArrayList<Level>();
	private static ArrayList<Image> logos = new ArrayList<Image>();
	private static ArrayList<Image> slideImages = new ArrayList<Image>();

	private static ArrayList<TextFlow> keyComponents = new ArrayList<TextFlow>();

	public static void main(String[] args) {

		new Display();
		launch(args);
	}

	public void start(Stage alternateStage) throws Exception {

		// Startup Code

		for (File imageFile : imageFiles.listFiles()) {
			slideImages.add(new Image("Slide Images for the League/" + imageFile.getName()));
		}

		logos.add(new Image("Slide Images for the League/HooverHS.jpg"));
		logos.add(new Image("Slide Images for the League/GompPrep.png"));
		logos.add(new Image("Slide Images for the League/LEAGUE.png"));
		logos.add(new Image("Slide Images for the League/MalcomX.png"));
		logos.add(new Image("Slide Images for the League/SanElijoMS.png"));
		logos.add(new Image("Slide Images for the League/SanMarcosMS.png"));
		logos.add(new Image("Slide Images for the League/SDCentral.jpg"));
		logos.add(new Image("Slide Images for the League/WilsonMS.jpg"));

		primaryStage = new Stage();

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

		labelZero.setTranslateX(translateX);
		labelOne.setTranslateX(translateX);
		labelTwo.setTranslateX(translateX);
		labelThree.setTranslateX(translateX);
		labelFour.setTranslateX(translateX);
		labelFive.setTranslateX(translateX);
		labelSix.setTranslateX(translateX);
		labelSeven.setTranslateX(translateX);
		labelEight.setTranslateX(translateX);
		labelNine.setTranslateX(translateX);

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
		flowpaneImage = new FlowPane();

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
		flowpaneImage.setPadding(new Insets(20));
		flowpaneImage.setVgap(VGap);
		flowpaneImage.setHgap(HGap);

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

		// Automatic Timer Activation

		if (!timerActivatedBefore) {
			Display.timerController();
			timerOn = true;
		}

		// Keyboard Shortcuts

		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

			if (key.getCode() == KeyCode.DIGIT0) {
				Display.displayLevelSlide((byte) 0);
			} else if (key.getCode() == KeyCode.DIGIT1) {
				Display.displayLevelSlide((byte) 1);
			} else if (key.getCode() == KeyCode.DIGIT2) {
				Display.displayLevelSlide((byte) 2);
			} else if (key.getCode() == KeyCode.DIGIT3) {
				Display.displayLevelSlide((byte) 3);
			} else if (key.getCode() == KeyCode.DIGIT4) {
				Display.displayLevelSlide((byte) 4);
			} else if (key.getCode() == KeyCode.DIGIT5) {
				Display.displayLevelSlide((byte) 5);
			} else if (key.getCode() == KeyCode.DIGIT6) {
				Display.displayLevelSlide((byte) 6);
			} else if (key.getCode() == KeyCode.DIGIT7) {
				Display.displayLevelSlide((byte) 7);
			} else if (key.getCode() == KeyCode.DIGIT8) {
				Display.displayLevelSlide((byte) 8);
			} else if (key.getCode() == KeyCode.DIGIT9) {
				Display.displayLevelSlide((byte) 9);
			}

			if (key.getCode() == KeyCode.CONTROL) {
				ctrlPressed = true;
			}

			if (key.getCode() == KeyCode.A && ctrlPressed) {
				ctrlPressed = false;
				Display.addStudent();
			} else if (key.getCode() == KeyCode.R && ctrlPressed) {
				ctrlPressed = false;
				Display.removeStudent();
			} else if (key.getCode() == KeyCode.C && ctrlPressed) {
				ctrlPressed = false;
				Display.changeStudent();
			} else if (key.getCode() == KeyCode.N && ctrlPressed) {

				if (!timerActivatedBefore) {
					Display.timerController();
				}

				ctrlPressed = false;
				timerOn = true;
			} else if (key.getCode() == KeyCode.F && ctrlPressed) {
				ctrlPressed = false;
				timerOn = false;
			} else if (key.getCode() == KeyCode.S && ctrlPressed) {
				ctrlPressed = false;
				Display.addImageSlide();
			} else if (key.getCode() == KeyCode.U && ctrlPressed) {
				ctrlPressed = false;
				Display.updateDisplays();
			}
		});

		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->

		{
			if (key.getCode() == KeyCode.CONTROL) {
				ctrlPressed = false;
			}
		});

		// Reading File Data

		if (!loadedData) {

			levels = Salesforce.getStudents();
			Display.updateDisplays();
			loadedData = true;
		}
	}

	public static void timerController() {

		new AnimationTimer() {

			long millis = System.currentTimeMillis();

			public void handle(long now) {

				if (timerOn) {

					if (System.currentTimeMillis() - millis >= timerWait) {

						slideImages.clear();

						for (File imageFile : imageFiles.listFiles()) {
							slideImages.add(new Image("Slide Images for the League/" + imageFile.getName()));
						}

						r = new Random();

						millis = System.currentTimeMillis();
						Display.displayLevelSlide((byte) ((byte) ((slideCount - slideOffset) % 10)));

						if (slideCount % frequency == 0 && slideImages.size() > 0) {
							slideOffset++;
							Display.displayImageSlide(r.nextInt(slideImages.size()));
						} else if (slideCount % frequency == 1) {
							flowpaneImage.getChildren().clear();
						}

						slideCount++;
					}
				}
			}
		}.start();
	}

	public static void addImageSlide() {

		textInputDialog = new TextInputDialog("IMAGE NAME");
		Optional<String> imageName = textInputDialog.showAndWait();

		if (!slideImages.contains(new Image(imageName.get()))) {
			slideImages.add(new Image(imageName.get()));
		}
	}

	public static void displayImageSlide(int randomImage) {

		ImageView imageView = new ImageView();
		TextFlow textFlow = new TextFlow();

		imageView.setImage(slideImages.get(randomImage));
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(900);
		textFlow.getChildren().add(imageView);

		flowpaneImage.getChildren().add(textFlow);
		scene.setRoot(flowpaneImage);

	}

	public static void displayLevelSlide(byte levelNum) {

		Display.clearKey();

		switch (levelNum) {
		case 0:
			scene.setRoot(flowpane0);
			flowpane0.getChildren().addAll(keyComponents);
			break;
		case 1:
			scene.setRoot(flowpane1);
			flowpane1.getChildren().addAll(keyComponents);
			break;
		case 2:
			scene.setRoot(flowpane2);
			flowpane2.getChildren().addAll(keyComponents);
			break;
		case 3:
			scene.setRoot(flowpane3);
			flowpane3.getChildren().addAll(keyComponents);
			break;
		case 4:
			scene.setRoot(flowpane4);
			flowpane4.getChildren().addAll(keyComponents);
			break;
		case 5:
			scene.setRoot(flowpane5);
			flowpane5.getChildren().addAll(keyComponents);
			break;
		case 6:
			scene.setRoot(flowpane6);
			flowpane6.getChildren().addAll(keyComponents);
			break;
		case 7:
			scene.setRoot(flowpane7);
			flowpane7.getChildren().addAll(keyComponents);
			break;
		case 8:
			scene.setRoot(flowpane8);
			flowpane8.getChildren().addAll(keyComponents);
			break;
		case 9:
			scene.setRoot(flowpane9);
			flowpane9.getChildren().addAll(keyComponents);
			break;
		}
	}

	public static void clearKey() {

		for (Node node : flowpane0.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane0.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane1.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane1.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane2.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane2.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane3.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane3.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane4.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane4.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane5.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane5.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane6.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane6.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane7.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane7.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane8.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane8.getChildren().remove(node);
				break;
			}
		}

		for (Node node : flowpane9.getChildren()) {
			if (node == keyComponents.get(0)) {
				flowpane9.getChildren().remove(node);
				break;
			}
		}
	}

	public static void resetDisplays() {

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
		
		if (!keyCreated) {
			Display.createKeys();
		}
		
		keyCreated = true;
	}

	public static void createKeys() {

		TextFlow key1 = new TextFlow();

		Text labelForKey1 = new Text("The League");
		Text labelForKey2 = new Text("San Diego Central");
		Text labelForKey3 = new Text("Malcolm X Library");
		Text labelForKey4 = new Text("Hoover High School");
		Text labelForKey5 = new Text("Gompers Prep Middle School");
		Text labelForKey6 = new Text("San Elijo Middle School");
		Text labelForKey7 = new Text("Wilson Middle School");
		Text labelForKey8 = new Text("San Marcos Middle School");

		ImageView imageForKey1 = new ImageView();
		ImageView imageForKey2 = new ImageView();
		ImageView imageForKey3 = new ImageView();
		ImageView imageForKey4 = new ImageView();
		ImageView imageForKey5 = new ImageView();
		ImageView imageForKey6 = new ImageView();
		ImageView imageForKey7 = new ImageView();
		ImageView imageForKey8 = new ImageView();

		imageForKey1.setPreserveRatio(true);
		imageForKey2.setPreserveRatio(true);
		imageForKey3.setPreserveRatio(true);
		imageForKey4.setPreserveRatio(true);
		imageForKey5.setPreserveRatio(true);
		imageForKey6.setPreserveRatio(true);
		imageForKey7.setPreserveRatio(true);
		imageForKey8.setPreserveRatio(true);

		imageForKey1.setFitHeight(60);
		imageForKey2.setFitHeight(60);
		imageForKey3.setFitHeight(60);
		imageForKey4.setFitHeight(60);
		imageForKey5.setFitHeight(60);
		imageForKey6.setFitHeight(60);
		imageForKey7.setFitHeight(60);
		imageForKey8.setFitHeight(60);

		imageForKey1.setImage(logos.get(2));
		imageForKey2.setImage(logos.get(6));
		imageForKey3.setImage(logos.get(3));
		imageForKey4.setImage(logos.get(0));
		imageForKey5.setImage(logos.get(1));
		imageForKey6.setImage(logos.get(4));
		imageForKey7.setImage(logos.get(7));
		imageForKey8.setImage(logos.get(5));

		key1.getChildren().addAll(imageForKey1, labelForKey1, imageForKey2, labelForKey2, imageForKey3, labelForKey3,
				imageForKey4, labelForKey4, imageForKey5, labelForKey5, imageForKey6, labelForKey6, imageForKey7,
				labelForKey7, imageForKey8, labelForKey8);

		key1.setTranslateY(400);

		keyComponents.add(key1);
	}

	public static void updateDisplays() {

		Display.resetDisplays();

		for (byte i = 0; i < levels.size(); i++) {

			for (Student student : levels.get(i).getStudents()) {

				TextFlow studentLabel = new TextFlow();
				Text name = new Text(student.getName());
				ImageView imageView = new ImageView("Slide Images for the League/LEAGUE.png");

				final String location = student.getLocation();
				name.setId("textfont");
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
	}

	public static void removeStudent() {

		boolean removedName = false;

		textInputDialog = new TextInputDialog("FIND STUDENT (ENTER FULL NAME)");
		Optional<String> findName = textInputDialog.showAndWait();

		OUTER_LOOP: for (Level level : levels) {
			for (int i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					level.removeStudent(level.getStudents().get(i));
					removedName = true;
					break OUTER_LOOP;
				}
			}
		}

		if (!removedName) {
			System.out.println("Sorry, the name " + findName.get() + " was not found. Check for typing errors and retry.");
		}

		Display.updateDisplays();
	}

	public static void addStudent() {

		boolean containsLevel = false;

		textInputDialog = new TextInputDialog("FULL NAME");
		Optional<String> newName = textInputDialog.showAndWait();

		textInputDialog = new TextInputDialog("LOCATION CODE");
		Optional<String> locationOfName = textInputDialog.showAndWait();

		textInputDialog = new TextInputDialog("LEVEL NUMBER (0-9)");
		Optional<String> levelOfName = textInputDialog.showAndWait();
		byte levelNum = Byte.parseByte(levelOfName.get());

		for (Level level : levels) {
			if (level.getLevel() == levelNum) {
				level.addStudent(new Student(newName.get(), locationOfName.get(), levelNum));
				containsLevel = true;
				break;
			}
		}

		if (!containsLevel) {
			levels.add(new Level(levelNum));
			for (Level level : levels) {
				if (level.getLevel() == levelNum) {
					level.addStudent(new Student(newName.get(), locationOfName.get(), levelNum));
					break;
				}
			}
		}

		Display.updateDisplays();
	}

	public static void changeStudent() {

		textInputDialog = new TextInputDialog("FIND STUDENT (ENTER FULL NAME)");
		Optional<String> findName = textInputDialog.showAndWait();

		textInputDialog = new TextInputDialog("NEW NAME");
		Optional<String> newName = textInputDialog.showAndWait();

		textInputDialog = new TextInputDialog("NEW LOCATION");
		Optional<String> newLocationOfName = textInputDialog.showAndWait();

		textInputDialog = new TextInputDialog("NEW LEVEL");
		Optional<String> levelOfName = textInputDialog.showAndWait();
		byte newLevelNum = Byte.parseByte(levelOfName.get());

		OUTER_LOOP: for (Level level : levels) {
			for (int i = 0; i < level.getStudents().size(); i++) {
				if (level.getStudents().get(i).getName().equalsIgnoreCase(findName.get())) {
					level.getStudents().get(i).setName(newName.get());
					level.getStudents().get(i).setLocation(newLocationOfName.get());
					Display.changeStudentLevel(level.getStudents().get(i), newLevelNum);
					break OUTER_LOOP;
				}
			}
		}

		Display.updateDisplays();
	}
}