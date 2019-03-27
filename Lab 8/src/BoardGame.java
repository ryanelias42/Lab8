import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame {
	
	
	protected LinkedHashMap<String , GamePiece> playerPieces;
	protected LinkedHashMap<String , Location> playerLocations;
	
	public BoardGame() {
		playerPieces = new LinkedHashMap<String , GamePiece>();
		playerLocations = new LinkedHashMap<String , Location>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) {
		
		//run for each and see if the gamePiece is already taken
		for (GamePiece val:playerPieces.values()) {
			if (val.equals(gamePiece)) {
				return false;
			}
		}
		//if we get through the for each loop above then that piece is not on the board.
		//now it is safe to add this player/piece into the game at the location.
		
		
		playerPieces.put(playerName,gamePiece);
		playerLocations.put(playerName,initialLocation);
		return true;
	}
	
	public GamePiece getPlayerGamePiece(String playerName) {
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece) {
		//loops HashMap in search of the key associated with the given value, then returns the name. returns null if no gamePiece is found. 
		//probably a way better way to do this.
		for (String name: playerPieces.keySet()) {
			if (playerPieces.get(name).equals(gamePiece)) {
				return name;
			}
		}
		return null;
	}
	
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.replace(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) {
		
		String holderName;
		Location holderLoc;
		
		if (playerPieces.get(playerNames[0]).equals(GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1])))) {
			playerLocations.replace(playerNames[0], newLocations[0]);
			playerLocations.replace(playerNames[1], newLocations[1]);
			return playerNames;
		}
		
		else {
			holderName = playerNames[0];
			holderLoc = newLocations[0];
			
			playerNames[0] = playerNames[1];
			newLocations[0] = newLocations[1];
			
			playerNames[1] = holderName;
			newLocations[1] = holderLoc;
			
			playerLocations.replace(playerNames[0], newLocations[0]);
			playerLocations.replace(playerNames[1], newLocations[1]);
			
			return playerNames;
		}
		
	}
	
	public Location getPlayerLocation(String playerName) {
		return playerLocations.get(playerName);
	}
	
	public String[] getPlayersAtLocation(Location loc) {
		ArrayList<String> locations = new ArrayList<String>();
		
		for (String name: playerLocations.keySet()) {
			if (playerLocations.get(name).equals(loc)) {
				locations.add(name);
			}
		}
		String[] result = new String[locations.size()];
		for (int i = 0; i < result.length; ++i) {
			result[i] = locations.get(i);
		}
		return result;
	}
	
	public GamePiece[] getPiecesAtLocation(Location loc) {
		
		ArrayList<String> namesAtLocation = new ArrayList<String>();
		
		for (String name: playerLocations.keySet()) {
			if (playerLocations.get(name).equals(loc)) {
				namesAtLocation.add(name);
			}
		}
		GamePiece[] result = new GamePiece[namesAtLocation.size()];
		for (int i = 0; i < result.length; ++i) {
			result[i] = playerPieces.get(namesAtLocation.get(i));
		}
		return result;	
	}
	
	
	public Set<String> getPlayers() {
		return playerLocations.keySet();
	}
	
	public Set<Location> getPlayerLocations() {

		//Set<String> targetSet = new HashSet<>(sourceMap.values());
		Set<Location> result = new HashSet<>(playerLocations.values());
		return result;
		
	}
	
	public Set<GamePiece> getPlayerPieces() {
		Set<GamePiece> result = new HashSet<>(playerPieces.values());
		return result;
	}

}

