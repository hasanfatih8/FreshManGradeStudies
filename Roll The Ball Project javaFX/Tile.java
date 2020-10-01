
import javafx.scene.image.ImageView;

public class Tile {

	private String id;
	private String type;
	private String property;
	private ImageView image;
	
	//constructor of Tile class
	public Tile(String id, String type, String property) {

		this.id = id;
		this.type = type;
		this.property = property;

	}
	
	public ImageView getImage() {
		if (type.equalsIgnoreCase("Starter")) {
			if (property.equalsIgnoreCase("Vertical")) {
				image = new ImageView("file:StarterVertical.jpg");

			} else if (property.equalsIgnoreCase("Horizontal")) {
				image = new ImageView("file:StarterHorizontal.jpg");

			}
		} else if (type.equalsIgnoreCase("Pipe")) {
			if (property.equalsIgnoreCase("Vertical")) {
				image = new ImageView("file:PipeVertical.jpg");						/**************************************************/
																					//	   										  	  //
			} else if (property.equalsIgnoreCase("Horizontal")) {					//											   	  //
				image = new ImageView("file:PipeHorizontal.jpg");					//										          //
																					// 		ADDING IMAGES ACCORDING TO THEIR OWN      //
																					//		  PROPERTIES IN  THE WHOLE METHOD		  //
			} else if (property.equalsIgnoreCase("00")) {							//											      //	
				image = new ImageView("file:CurvedPipe00.jpg");						//									              //
																					//											      //
			} else if (property.equalsIgnoreCase("01")) {							/**************************************************/
				image = new ImageView("file:CurvedPipe01.jpg");

			} else if (property.equalsIgnoreCase("10")) {
				image = new ImageView("file:CurvedPipe10.jpg");

			} else if (property.equalsIgnoreCase("11")) {
				image = new ImageView("file:CurvedPipe11.jpg");

			}
		} else if (type.equalsIgnoreCase("PipeStatic")) {
			if (property.equalsIgnoreCase("Vertical")) {
				image = new ImageView("file:PipeStaticVertical.jpg");

			} else if (property.equalsIgnoreCase("Horizontal")) {
				image = new ImageView(
						"file:PipeStaticHorizontal.jpg");

			} else if (property.equalsIgnoreCase("01")) {
				image = new ImageView("file:PipeStatic01.jpg");

			}
		} else if (type.equalsIgnoreCase("End")) {
			if (property.equalsIgnoreCase("Vertical")) {
				image = new ImageView("file:EndVertical.jpg");

			} else if (property.equalsIgnoreCase("Horizontal")) {
				image = new ImageView("file:EndHorizontal.jpg");

			}
		} else if (type.equalsIgnoreCase("Empty")) {
			if (property.equalsIgnoreCase("none")) {
				image = new ImageView("file:Empty.jpg");

			} else if (property.equalsIgnoreCase("Free")) {
				image = new ImageView("file:EmptyFree.jpg");

			}

		}

		image.setFitHeight(150);
		image.setFitWidth(150);
		
		return image;

	}
    public ImageView getImageId(){ // an extra method to get ids of images
    	return image;
     }
	
    // getter setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String property) {
		this.type = property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String shape) {
		this.property = shape;
	}

	
}
