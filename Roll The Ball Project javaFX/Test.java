
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {
	// data fields
	public static ArrayList<String> listStatic = new ArrayList<>(); //array list for red and blue tiles
	public static ArrayList<Tile> tiles = new ArrayList<>(); //array list for all tiles
	MouseEvent tempEvent = null;
	double gapX = 0;
	double gapY = 0;
	boolean isDragged = false;
	Tile currentTile = null;
	public static int numberOfMoves = 0;
	public static Label trackingNumberOfMoves = new Label("Number of Moves: 0"); 
	public static String textField = "level1.txt";
	
	@Override
	public void start(Stage primaryStage) {

		Pane pane  = new Pane(); 			//creating pane
		GridPane grid = new GridPane();		//creating grid pane
		grid.setAlignment(Pos.CENTER);

		printGrid(grid);

		Circle circle = new Circle(); // creating the circle
		circle.setCenterX(73);
		circle.setCenterY(55);
		circle.setFill(Color.WHITE);	// setting circle's color
		circle.setRadius(15);			// setting circle's radius
		circle.setVisible(true);
		
		//when user drag the mouse, this method will run
		grid.setOnMouseDragged((event) -> {
			
			if (tempEvent == null || !tempEvent.getTarget().equals(event.getTarget())) { // to control if the mouse is on the same tile
				tempEvent = event;
				gapX = 0;
				gapY = 0;
				isDragged = false;
				for (int i = 0; i < tiles.size(); i++) {
					if (tiles.get(i).getImageId().equals(tempEvent.getTarget())) {
						currentTile = tiles.get(i);
					}
				}
			} else if (tempEvent.getTarget().equals(event.getTarget())) { // store the gap
				gapX = event.getX() - tempEvent.getX();
				gapY = event.getY() - tempEvent.getY();
			}
			
			if (!isDragged) {
				if (gapX < -75 && Integer.parseInt(currentTile.getId()) != 1 // move left
						&& Integer.parseInt(currentTile.getId()) != 5 && Integer.parseInt(currentTile.getId()) != 9
						&& Integer.parseInt(currentTile.getId()) != 13) { 
					if (controlStatic(Integer.parseInt(currentTile.getId())) && controlStatic(Integer.parseInt(currentTile.getId()) - 1) && targetGrey(Integer.parseInt(currentTile.getId())-1)) {
						change(Integer.parseInt(currentTile.getId()) - 1, Integer.parseInt(currentTile.getId()) - 2);
						printGrid(grid); //update grid
						
						numberOfMoves++; // increase number of moves
						trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
					}
					isDragged = true;
				} else if (gapX > 75 && Integer.parseInt(currentTile.getId()) != 4 // move right
						&& Integer.parseInt(currentTile.getId()) != 8 && Integer.parseInt(currentTile.getId()) != 12
						&& Integer.parseInt(currentTile.getId()) != 16) { 
					if (controlStatic(Integer.parseInt(currentTile.getId())) && controlStatic(Integer.parseInt(currentTile.getId())+1) && targetGrey(Integer.parseInt(currentTile.getId())+1)) {
						change(Integer.parseInt(currentTile.getId()) - 1, Integer.parseInt(currentTile.getId()));
						printGrid(grid); //update grid
						
						numberOfMoves++; // increase number of moves
						trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
					}
					isDragged = true;
				} else if (gapY < -75 && Integer.parseInt(currentTile.getId()) != 1 // move up
						&& Integer.parseInt(currentTile.getId()) != 2 && Integer.parseInt(currentTile.getId()) != 3
						&& Integer.parseInt(currentTile.getId()) != 4) { 
					if (controlStatic(Integer.parseInt(currentTile.getId()) ) && controlStatic(Integer.parseInt(currentTile.getId()) - 4) && targetGrey(Integer.parseInt(currentTile.getId()) - 4)) {
						change(Integer.parseInt(currentTile.getId()) - 1, Integer.parseInt(currentTile.getId()) - 5);
						printGrid(grid); //update grid
						
						numberOfMoves++; // increase number of moves
						trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
					}
					isDragged = true;
				} else if (gapY > 75 && Integer.parseInt(currentTile.getId()) != 13 // move down
						&& Integer.parseInt(currentTile.getId()) != 14 && Integer.parseInt(currentTile.getId()) != 15
						&& Integer.parseInt(currentTile.getId()) != 16) { 
					if (controlStatic(Integer.parseInt(currentTile.getId()) ) && controlStatic(Integer.parseInt(currentTile.getId()) + 4)&&targetGrey(Integer.parseInt(currentTile.getId()) + 4)) {
						change(Integer.parseInt(currentTile.getId()) - 1, Integer.parseInt(currentTile.getId()) + 3);
						printGrid(grid); //update grid
						
						numberOfMoves++; // increase number of moves
						trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
					}
					isDragged = true;
				}
				
				if(keyOfFirst("level1.txt")) {		//control if level 1 is correct then pass to level2
					roll(circle, grid, "level2.txt");
					circle.setCenterX(73);
					circle.setCenterY(55);
					
				}else if(keyOfSecond("level2.txt")) {	//control if level2 is correct then pass to level3
					roll(circle, grid, "level3.txt");
					circle.setCenterX(73);
					circle.setCenterY(55);
					
				}else if(keyOfThird("level3.txt")) {	//control if level3 is correct then pass to level4
					roll(circle, grid, "level4.txt");
					circle.setCenterX(73);
					circle.setCenterY(55);
					
				}else if(keyOfForth("level4.txt")) {	//control if level4 is correct then pass to level5
					roll2(circle, grid, "level5.txt", pane);
					circle.setCenterX(73);
					circle.setCenterY(55);
					
				}else if(keyOfForth("level5.txt")) {	//control if level5 is correct
					roll2(circle, grid, "level1.txt", pane);
					circle.setCenterX(73);
					circle.setCenterY(55);
				}

			}
		});

		Group root = new Group(circle);
		/* arranging the font and style of number of moves */
		trackingNumberOfMoves.setStyle("-fx-font-weight: bold");
		trackingNumberOfMoves.setFont(new Font("Comic Sans MS", 18));
		trackingNumberOfMoves.setLayoutX(0);
		trackingNumberOfMoves.setLayoutY(605);
		
		pane.getChildren().addAll(grid, root);			//adding root and grid on the pane
		pane.getChildren().add(trackingNumberOfMoves);	//adding the label on the pane
		primaryStage.setTitle("Roll the Ball");

		Scene scene = new Scene(pane, 600, 630);		//creating scene
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);					
		primaryStage.show();							//display the scene

	}
	
	public String convertNumberToString(int a) { // converting number of moves to string
		String idString = String.valueOf(a);
		return idString;
	}
	
	public void change(int i, int j) {	 // changing Ids in the tiles arraylist
		String tempId = tiles.get(i).getId();
		tiles.get(i).setId(tiles.get(j).getId());
		tiles.get(j).setId(tempId);
		Collections.swap(tiles, i, j);
	}
	
	public void roll(Circle circle, GridPane grid, String txt) { //to roll the ball for 1st, 2nd and 3rd level
		Path path = new Path();									// creating the path
		MoveTo moveTo = new MoveTo(73, 55);						// starting point of ball
		LineTo line1 = new LineTo(73, 525);						/* determining the lines */
		LineTo line2 = new LineTo(550, 525);					
		path.getElements().add(moveTo); // Adding all the elements to the path
		path.getElements().addAll(line1, line2);
		PathTransition pathTransition = new PathTransition(); // Creating the path transition
		pathTransition.setDuration(Duration.millis(9000)); // Setting the duration of the transition
		pathTransition.setNode(circle); // Setting the node for the transition
		pathTransition.setPath(path); // Setting the path for the transition
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // Setting the orientation of the path
		pathTransition.setCycleCount(1); // Setting the cycle count for the transition
		pathTransition.setAutoReverse(false); // Setting auto reverse value to true
		pathTransition.setOnFinished(e -> { // wait for passing level until the ball rolled
			circle.setCenterX(550);
			circle.setCenterY(525);
			if(circle.getCenterX() == 550 && circle.getCenterY() == 525) { 
				tiles.removeAll(tiles); //clear the tiles arraylist
				listStatic.removeAll(listStatic); //clear the listStatic arraylist
				readTxt(txt); //read text field
				numberOfMoves = 0; 
				trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
				for (int i = 0; i < tiles.size(); i++) {
					grid.add(tiles.get(i).getImage(), (i % 4), (i / 4));
				}
			}
		});
		pathTransition.play();// Playing the animation
	}
	
	public void roll2(Circle circle, GridPane grid, String txt, Pane pane) { //to roll the ball for 1st, 2nd and 3rd level
		Path path = new Path();									// creating the path
		MoveTo moveTo = new MoveTo(73, 55);						// starting point of ball
		LineTo line1 = new LineTo(73, 375);						/* determining the lines */
		LineTo line2 = new LineTo(526, 375);					
		LineTo line3 = new LineTo(526, 215);
		path.getElements().add(moveTo); // Adding all the elements to the path
		path.getElements().addAll(line1, line2, line3);
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(9000)); // Creating the path transition
		pathTransition.setNode(circle); // Setting the node for the transition
		pathTransition.setPath(path); // Setting the path for the transition
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // Setting the orientation of the path
		pathTransition.setCycleCount(1); // Setting the cycle count for the transition
		pathTransition.setAutoReverse(false); // Setting auto reverse value to true
		pathTransition.setOnFinished(e -> { // wait for passing level until the ball rolled
			circle.setCenterX(526);
			circle.setCenterY(225);
			
			if(circle.getCenterX() == 526 && circle.getCenterY() == 225) {
				if(txt.equalsIgnoreCase("level1.txt")) {
					ImageView congarts = new ImageView("file:Congarts.jpeg");
					congarts.setFitHeight(630);
					congarts.setFitWidth(600);
					pane.getChildren().add(congarts);
				}
				tiles.removeAll(tiles);  //clear the tiles arraylist
				listStatic.removeAll(listStatic); //clear the listStatic arraylist
				readTxt(txt); //read text field
				numberOfMoves = 0;
				trackingNumberOfMoves.setText("Number Of Moves: " + convertNumberToString(numberOfMoves));
				for (int i = 0; i < tiles.size(); i++) {
					grid.add(tiles.get(i).getImage(), (i % 4), (i / 4));
				}
				
			}
		});
		pathTransition.play();
	}
	
	//main method
	public static void main(String[] args)  {
 
		File input = new File("level1.txt");
		Scanner scan;
		try {
			scan = new Scanner(input);
			while (scan.hasNext()) { 								//reading first text field
	            String[] line = scan.nextLine().split(",");

	            if (line[2].equalsIgnoreCase("none")) {
	                tiles.add(new Tile(line[0], line[1], line[2]));

	            } else if (line[2].equalsIgnoreCase("00") || line[2].equalsIgnoreCase("01") || line[2].equalsIgnoreCase("10") || line[2].equalsIgnoreCase("11")) {
	            	if (line[1].equalsIgnoreCase("PipeStatic")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());
	                } else if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));
	                }
	            } else if (line[2].equalsIgnoreCase("Free")) {								
	               Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);

	            } else if (line[2].equalsIgnoreCase("Vertical")) {
	                if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));					

	                } else if (line[1].equalsIgnoreCase("PipeStatic")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());										

	                } else if (line[1].equalsIgnoreCase("End")) {							
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                } else if (line[1].equalsIgnoreCase("Starter")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());
	                }

	            } else if (line[2].equalsIgnoreCase("Horizontal")) {
	                if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));

	                } else if (line[1].equalsIgnoreCase("PipeStatic")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                } else if (line[1].equalsIgnoreCase("End")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                }

	            }

	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}     
		
		launch(args);

	}
	
	// to read the text file from computer
	public void readTxt(String txt) {
		File input = new File(txt);
		Scanner scan;
		try {
			scan = new Scanner(input);
			while (scan.hasNext()) {
	            String[] line = scan.nextLine().split(",");

	            if (line[2].equalsIgnoreCase("none")) {
	                tiles.add(new Tile(line[0], line[1], line[2]));

	            } else if (line[2].equalsIgnoreCase("00") || line[2].equalsIgnoreCase("01") || line[2].equalsIgnoreCase("10") || line[2].equalsIgnoreCase("11")) {
	            	if (line[1].equalsIgnoreCase("PipeStatic")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());
	                } else if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));
	                }
	            } else if (line[2].equalsIgnoreCase("Free")) {
	               Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    																		/**************************************************/
	            } else if (line[2].equalsIgnoreCase("Vertical")) {								
	                if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));

	                } else if (line[1].equalsIgnoreCase("PipeStatic")) {						// READING THE TEXT FIELD WHICH IS GIVEN AS PARAMETER 
	                    Tile tile = new Tile(line[0], line[1], line[2]);						// 				IN THE WHOLE METHOD
	                    tiles.add(tile);														
	                    listStatic.add(tile.getId());

	                } else if (line[1].equalsIgnoreCase("End")) {								
	                    Tile tile = new Tile(line[0], line[1], line[2]);						/**************************************************/
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                } else if (line[1].equalsIgnoreCase("Starter")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());
	                }

	            } else if (line[2].equalsIgnoreCase("Horizontal")) {
	                if (line[1].equalsIgnoreCase("Pipe")) {
	                    tiles.add(new Tile(line[0], line[1], line[2]));

	                } else if (line[1].equalsIgnoreCase("PipeStatic")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                } else if (line[1].equalsIgnoreCase("End")) {
	                    Tile tile = new Tile(line[0], line[1], line[2]);
	                    tiles.add(tile);
	                    listStatic.add(tile.getId());

	                }

	            }

	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setCircleDefault(Circle circle) {
		circle.setCenterX(73);
		circle.setCenterY(55);
	}

	public static boolean keyOfFirst(String a) { 						//key of 1st level
		if(a.equalsIgnoreCase(textField)) {
			
		}else {
			return false;
		}
		
		if(tiles.get(0).getProperty().equalsIgnoreCase("Vertical") 						
				&& tiles.get(4).getProperty().equalsIgnoreCase("Vertical") 				
				&& tiles.get(8).getProperty().equalsIgnoreCase("Vertical") 
				&& tiles.get(12).getProperty().equalsIgnoreCase("01")									
				&& tiles.get(13).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(14).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(15).getProperty().equalsIgnoreCase("Horizontal") ) {
			textField = "level2.txt";
			return true;
		}
		return false;
	}
	
	public static boolean keyOfSecond(String a) { 						// key of 2nd level
		if(a.equalsIgnoreCase(textField)) {
			
		}else {
			return false;
		}
		if(tiles.get(0).getProperty().equalsIgnoreCase("Vertical") 						
				&& tiles.get(4).getProperty().equalsIgnoreCase("Vertical") 					
				&& tiles.get(8).getProperty().equalsIgnoreCase("Vertical") 
				&& tiles.get(12).getProperty().equalsIgnoreCase("01")					
				&& tiles.get(13).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(14).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(15).getProperty().equalsIgnoreCase("Horizontal") ) {
			textField = "level3.txt";
			return true;
		}
		return false;
	}
	
	public static boolean keyOfThird(String a) { 							// key of 3rd level
		if(a.equalsIgnoreCase(textField)) {
			
		}else {
			return false;
		}
		if(tiles.get(0).getProperty().equalsIgnoreCase("Vertical") 						
				&& tiles.get(4).getProperty().equalsIgnoreCase("Vertical") 				
				&& tiles.get(8).getProperty().equalsIgnoreCase("Vertical") 		
				&& tiles.get(12).getProperty().equalsIgnoreCase("01")					
				&& tiles.get(13).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(14).getProperty().equalsIgnoreCase("Horizontal")			
				&& tiles.get(15).getProperty().equalsIgnoreCase("Horizontal")) {
			textField = "level4.txt";
			return true;
		}
		return false;
	}
	
	public static boolean keyOfForth(String a) {							// key of 4th  level
		if(a.equalsIgnoreCase(textField)) {
			
		}else {
			return false;
		}	
		if(tiles.get(0).getProperty().equalsIgnoreCase("Vertical") 						
				&& tiles.get(4).getProperty().equalsIgnoreCase("Vertical") 	
				&& tiles.get(8).getProperty().equalsIgnoreCase("01")
				&& tiles.get(9).getProperty().equalsIgnoreCase("Horizontal")
				&& tiles.get(10).getProperty().equalsIgnoreCase("Horizontal")
				&& tiles.get(11).getProperty().equalsIgnoreCase("00")
				&& tiles.get(7).getProperty().equalsIgnoreCase("Vertical")) {
			textField = "level5.txt";
			return true;
		}
		return false;
	}
	
	public static boolean keyOfFifth(String a) { 							// key of 5th level
		if(a.equalsIgnoreCase(textField)) {
			
		}else {
			return false;
		}
		if(tiles.get(0).getProperty().equalsIgnoreCase("Vertical") 						
				&& tiles.get(4).getProperty().equalsIgnoreCase("Vertical") 	
				&& tiles.get(8).getProperty().equalsIgnoreCase("01")
				&& tiles.get(9).getProperty().equalsIgnoreCase("Horizontal")
				&& tiles.get(10).getProperty().equalsIgnoreCase("Horizontal")
				&& tiles.get(11).getProperty().equalsIgnoreCase("00")
				&& tiles.get(7).getProperty().equalsIgnoreCase("Vertical")) {
			return true;
		}
		return false;
	}
	
	// to print the grid
	public static void printGrid(GridPane grid) {
		for (int i = 0; i < tiles.size(); i++) {
			grid.add(tiles.get(i).getImage(), (i % 4), (i / 4));
		}

	}
	
	// to move onto grey tiles
	public boolean targetGrey(int k){
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getId().equals(String.valueOf(k))&&tiles.get(i).getProperty().equals("Free")) {
                return true;
            }
        }
        return false;
    }
	
	// to not move the blue and red tiles
    public boolean controlStatic(int i) {
        for (int j = 0; j < listStatic.size(); j++) {
            if (Integer.valueOf(listStatic.get(j)) == i) {
                return false;
            }
        }
        return true;
    }
	
}
