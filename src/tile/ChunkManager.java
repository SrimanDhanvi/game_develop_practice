package tile;

import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import my_first2D_game.GamePanel;

public class ChunkManager extends Patterns{
	
	GamePanel gp;
	HashMap<Point, Chunk> chunkMap = new HashMap<>();
	
	public ChunkManager(GamePanel gp) {
		this.gp = gp;
	}
	
	public Chunk getChunk(int chunkX, int chunkY) {
		Point key = new Point(chunkX, chunkY);
		if (!chunkMap.containsKey(key)) {
			Chunk newChunk = generateChunk(chunkX, chunkY);
			chunkMap.put(key, newChunk);
		}
		return chunkMap.get(key);
	}
	
	private void placeStructure(int[][] chunkTiles, int[][] pattern, int startX, int startY) {
		for (int y=0;y<pattern.length;y++) {
			for (int x=0;x<pattern[0].length;x++) {
				int px = startX + x;
				int py = startY + y;
			if (px>=0 && py>=0 && px < Chunk.size && py < Chunk.size) {
				chunkTiles[px][py] = pattern [y][x];
			}
		}
	}
}
	
	int[] tileWeights = {
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
			13,13,
			14,14,
			21,
			22,22,
			23,
			24
	};
	

	
	private Chunk generateChunk(int chunkX, int chunkY) {
		
		
		Chunk chunk = new Chunk();
		long seed = (chunkX*341873128712L) ^ (chunkY*132897987541L);
		Random rand = new Random(seed);
		
		for (int y = 0;y < Chunk.size;y++) {
			for (int x = 0;x < Chunk.size;x++) {
				chunk.tiles[x][y] = tileWeights[rand.nextInt(tileWeights.length)];
			}
		}
		if (rand.nextInt(100)<50) {
			placeStructure(chunk.tiles,cageDesign1, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<20) {
			placeStructure(chunk.tiles,pipePattern1, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
		placeStructure(chunk.tiles,boxWall, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
		}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,boxWall1, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,maze, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,boxWall2, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,boxWall3, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,boxWall4, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,boxWall5, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<99) {
			placeStructure(chunk.tiles,doubleRoom, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<10) {
			placeStructure(chunk.tiles,boxWall_light, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		if (rand.nextInt(100)<10) {
			placeStructure(chunk.tiles,boxWall_light2, rand.nextInt(Chunk.size-4), rand.nextInt(Chunk.size-4));
			}
		
		return chunk;
	}
	
	public int getTileID(int worldTileX, int worldTileY) {
		int chunkX = Math.floorDiv(worldTileX, Chunk.size);
		int chunkY = Math.floorDiv(worldTileY, Chunk.size);
		int tileX = Math.floorMod(worldTileX, Chunk.size);
		int tileY = Math.floorMod(worldTileY, Chunk.size);
		
		Chunk chunk = getChunk(chunkX, chunkY);
		return chunk.tiles[tileX][tileY];
	}

}
