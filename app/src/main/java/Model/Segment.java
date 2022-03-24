package Model;

public class Segment {
	private float x;
	private float y;
	private float endX;
	private float endY;
	private Color color;

	public Segment(float x, float y, float endX, float endY, String color) {
		super();
		this.setX(x);
		this.setY(y);
		this.setEndX(endX);
		this.setEndY(endY);
		this.color = identifyColor(color);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getEndY() {
		return endY;
	}

	public void setEndY(float endY) {
		this.endY = endY;
	}

	public float getEndX() {
		return endX;
	}

	public void setEndX(float endX) {
		this.endX = endX;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "Figure [x=" + getX() + ", y=" + getY() + ", endX=" + getEndX() + ", endY=" + getEndY() + ", color="
				+ color
				+ "]\n";
	}

	private Color identifyColor(String colorText) {

		switch (colorText) {
			case ("Bleu"):
				return Color.Bleu;
			case ("Rouge"):
				return Color.Rouge;
			case ("Orange"):
				return Color.Orange;
			case ("Jaune"):
				return Color.Jaune;
			case ("Noir"):
				return Color.Noir;
			case ("Violet"):
				return Color.Violet;
			case ("Marron"):
				return Color.Marron;
			case ("Vert"):
				return Color.Vert;
			case ("Gris"):
				return Color.Gris;
			case ("Rose"):
				return Color.Rose;
			default:
				return null;
		}
	}
}
