
public enum GamePiece{
	
	RED_RACER(new GamePieceAppearance(Color.valueOf("RED"), Shape.valueOf("RACECAR")), 0),
	BLUE_RACER(new GamePieceAppearance(Color.valueOf("BLUE"), Shape.valueOf("RACECAR")), 2),
	MAGENTA_RACER(new GamePieceAppearance(Color.valueOf("MAGENTA"), Shape.valueOf("RACECAR")), 1),
	RED_THIMBLE(new GamePieceAppearance(Color.valueOf("RED"), Shape.valueOf("THIMBLE")), 10),
	BLUE_BOOT(new GamePieceAppearance(Color.valueOf("BLUE"), Shape.valueOf("BOOT")), 5),
	GREEN_BOOT(new GamePieceAppearance(Color.valueOf("GREEN"), Shape.valueOf("BOOT")), 8),
	YELLOW_BOOT(new GamePieceAppearance(Color.valueOf("YELLOW"), Shape.valueOf("BOOT")), 7);
	
	private GamePieceAppearance appearance;
	private int priority;
	
	private GamePiece(GamePieceAppearance appearance, int priority) {
		this.appearance = appearance;
		this.priority = priority;
	}
	
	public Color getColor() {
		return this.appearance.getColor();
	}
	
	public Shape getShape() {
		return this.appearance.getShape();
	}
	
	public static GamePiece movesFirst(GamePiece a, GamePiece b) {
		if (a.priority < b.priority) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public String toString() {
		return String.format("%s: a %s %s with priority %d", this.name(),this.appearance.getColor(),this.appearance.getShape(),this.priority);
	}
	

}
