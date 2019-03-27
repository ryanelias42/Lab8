import org.junit.Assert;
import org.junit.Test;

public class TestClass {
	

	
	BoardGame testGame = new BoardGame();
	
	
	@Test
	public void ShapeLocationGamePieceTests() {
		//testGame.addPlayer("player1", GamePiece.BLUE_RACER, Location.HALL);
		Assert.assertEquals("getShape and Shape.toString incorrect", "RACECAR", GamePiece.RED_RACER.getShape().toString());
		Assert.assertEquals("Location getName incorrect", "HALL",Location.HALL.name());
		Assert.assertEquals("GamePiece toString Incorrect","BLUE_RACER: a BLUE RACECAR with priority 2", GamePiece.BLUE_RACER.toString());
		Assert.assertEquals("GamePiece getColor incorrect", "MAGENTA",GamePiece.MAGENTA_RACER.getColor().toString());
		Assert.assertEquals("movesFirst method incorrect", "BLUE_RACER: a BLUE RACECAR with priority 2", GamePiece.movesFirst(GamePiece.BLUE_RACER,GamePiece.RED_THIMBLE).toString());
		Assert.assertEquals("movesFirst method incorrect", "BLUE_RACER: a BLUE RACECAR with priority 2", GamePiece.movesFirst(GamePiece.RED_THIMBLE,GamePiece.BLUE_RACER).toString());
		
	
	
	}
	
	@Test
	public void ColorTests() {
		Color col = Color.RED;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255 , col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0 , col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0 , col .getB());
	}
	
	@Test
	public void BoardGameTest() {
		testGame.addPlayer("player1", GamePiece.RED_RACER, Location.HALL);
		testGame.addPlayer("player2", GamePiece.RED_THIMBLE, Location.KITCHEN);
		testGame.addPlayer("player3", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		String[] testArray = new String[] {"player2", "player1"};
		String[] testAgainst1 = new String[] {"player1","player2"};
		String[] testAgainst2 = new String[] {"player1", "player2"};
		Location[] testLocArray = new Location[] {Location.CONSERVATORY,Location.BALLROOM};
		
		Assert.assertEquals("moveTwoPlayers incorrect",testAgainst1, testGame.moveTwoPlayers(testArray,testLocArray));
		Assert.assertEquals("moveTwoPlayers incorrect", testAgainst2, testGame.moveTwoPlayers(testAgainst1, testLocArray));
		
		Assert.assertEquals("addPlayer (false) is incorrect", false, testGame.addPlayer("testPlayer", GamePiece.RED_RACER, Location.BILLIARD_ROOM));
		
		Assert.assertEquals("getPlayerGamePiece incorrect", GamePiece.RED_RACER, testGame.getPlayerGamePiece("player1"));
		Assert.assertEquals("getPlayerWithGamePiece incorrect", "player1", testGame.getPlayerWithGamePiece(GamePiece.RED_RACER));
		Assert.assertEquals("getPlayerWithGamePiece incorrect", null, testGame.getPlayerWithGamePiece(GamePiece.MAGENTA_RACER));
		testGame.movePlayer("player1", Location.BALLROOM);
		Assert.assertEquals("movePlayer is incorrect", Location.BALLROOM, testGame.getPlayerLocation("player1"));
		
		testGame.addPlayer("player4", GamePiece.YELLOW_BOOT, Location.HALL);
		Assert.assertEquals("getPlayersAtLocation incorrect", "player4",testGame.getPlayersAtLocation(Location.HALL)[0]);
		
		Assert.assertEquals("getPlayers incorrect", 4, testGame.getPlayers().size());
		
		Assert.assertEquals("getPlayerPieces incorrect", true, testGame.getPlayerPieces().contains(GamePiece.RED_RACER));
		
		Assert.assertEquals("getPiecesAtLocation incorrect", GamePiece.RED_RACER, testGame.getPiecesAtLocation(Location.BALLROOM)[0]);
		
		
	}
	

}
