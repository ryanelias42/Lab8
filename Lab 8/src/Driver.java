public class Driver {
		
	public static void main(String[] args) {
		
		BoardGame test1 = new BoardGame();
		test1.addPlayer("test", GamePiece.RED_RACER, Location.HALL);
		test1.addPlayer("test2", GamePiece.BLUE_RACER, Location.HALL);
		
		System.out.println(test1.getPlayersAtLocation(Location.HALL)[1]);
		
		//System.out.println(test1.getPlayerLocation("test"));
		
		//test1.movePlayer("test", Location.DINING_ROOM);
		//System.out.println(test1.getPlayerLocation("test"));
		
	}
	
}
