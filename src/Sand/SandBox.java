package Sand;

public class SandBox {
	
	private int size;
	private int[][] board;
	
	public SandBox(int size) {
		this.size = size;
		this.board = new int[size][size];
	}
	
	public void toppleAll() {
		int center = (this.size-1)/2;
		while(!this.isStable()) {
			this.topple(center, center);
		}
	}
	
	public void setAll() {
		for(int i = 0; i < this.size; i ++) {
			for(int ii = 0; ii < this.size; ii ++) {
				this.board[i][ii] = 3;
			}
		}
	}
	
	private void topple(int i, int ii) {
		int k = (board[i][ii] - (board[i][ii] % 4))/4;
		board[i][ii] -= k*4;
		for(int j = -1; j < 2; j += 2) {
			if(inBounds(i+j) && inBounds(ii)) {
				board[i+j][ii] += k;
				if(board[i+j][ii] >= 4) {
					this.topple(i+j, ii);
				}
			}
			if(inBounds(i) && inBounds(ii+j)) {
				board[i][ii+j] += k;
				if(this.board[i][ii+j] >= 4) {
					this.topple(i, ii+j);
				}
			}
			if(inBounds(i) && inBounds(ii)) {
				if(this.board[i][ii] >= 4) {
					this.topple(i, ii);
				}
			}
		}
	}
	
	private boolean isStable() {
		for(int i = 0; i < this.size; i ++) {
			for(int ii = 0; ii < this.size; ii ++) {
				if(this.board[i][ii] >= 4) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean inBounds(int i) {
		return (i >= 0 && i < this.size);
	}
	
	public void setCenter(int val) {
		int center = (this.size-1)/2;
		this.board[center][center] = val;
		System.out.println(this.board[center][center]);
	}
	
	public void setSand(int i, int ii, int val) {
		this.board[i][ii] = val;
	}
	
	public int getSandAt(int i, int ii) {
		return this.board[i][ii];
	}
	
	public int getSize() {
		return this.size;
	}
	
}
