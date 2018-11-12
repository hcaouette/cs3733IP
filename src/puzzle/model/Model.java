package puzzle.model;


public class Model {
	Block[] positions;
	
	public Model(){
		positions = new Block[10];
	}
	
	//create new block to add to the model's array
	public void addBlock(int pos, int tLX, int tLY, int tRX, int tRY, int bLX, int bLY, int bRX, int bRY) {
		positions[pos] = new Block( tLX,  tLY,  tRX,  tRY,  bLX,  bLY,  bRX,  bRY);
	}
	
	//add existing block to the model's array (set method v2)
	public void addBlock(int pos, Block blockB){
		positions[pos] = blockB;
	}
	
	public Block checkBlock(int i) {
		return positions[i];
	}

}
