package puzzle.model;


public class Model {
	Block[] positions;
	
	Model(){
		positions = new Block[10];
	}
	
	//create new block to add to the model's array
	void addBlock(int tLX, int tLY, int tRX, int tRY, int bLX, int bLY, int bRX, int bRY) {
		for(int i=0; i<positions.length; i++) {
			if(positions[i] == null) {
				positions[i] = new Block( tLX,  tLY,  tRX,  tRY,  bLX,  bLY,  bRX,  bRY);
			}
		}
	}
	
	//add existing block to the model's array (set method v2)
	void addBlock(Block blockB){
		for(int i=0; i<positions.length; i++) {
			if(positions[i] == null) {
				positions[i] = blockB;
			}
		}
	}
	
	Block checkBlock(int i) {
		return positions[i];
	}

}
