package Model;

public class Segment {
	float x,y,endX,endY;
	Color color;
	public Segment(float x, float y, float endX, float endY, String color) {
		super();
		this.x = x;
		this.y = y;
		this.endX = endX;
		this.endY = endY;
		this.color=identifyColor(color);
	}
	
	
	@Override
	public String toString() {
		return "Figure [x=" + x + ", y=" + y + ", endX=" + endX + ", endY=" + endY + ", color=" + color + "]\n";
	}


	private Color identifyColor(String colorText) {
		
		switch(colorText) {
			case("Bleu"):
				return Color.Bleu;
			case("Rouge"):
				return Color.Rouge;
			case("Orange"):
				return Color.Orange;
			case("Jaune"):
				return Color.Jaune;
			case("Noir"):
				return Color.Noir;
			case("Violet"):
				return Color.Violet;
			case("Marron"):
				return Color.Marron;
			case("Vert"):
				return Color.Vert;
			case("Gris"):
				return Color.Gris;
			case("Rose"):
				return Color.Rose;
			default:
				return null;
		}
	}
}
