package Juegos.Snake;

public class Fruto {
	private int posX, posY;
	
	public Fruto () {
		this.setPosX(0);
		this.setPosY(0);
	}
	
	public Fruto (int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}

	public int getPosX() { return posX; }
	public void setPosX(int posX) { this.posX = posX; }
	public int getPosY() { return posY; }
	public void setPosY(int posY) { this.posY = posY; }
}
