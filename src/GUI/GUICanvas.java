package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Sand.SandBox;

public class GUICanvas extends Canvas {
	//TODO: generate new long for serialVersionUID
	private static final long serialVersionUID = -557652432650828632L;
	private int width;
	private int height;
	private boolean wasteMyTime = true;
	
	public GUICanvas(int width, int height) {
		this.setBackground(Color.GRAY);
		this.setSize(width, height-20);
		this.width = width;
		this.height = height;
	}
	
	
	public void draw(Graphics2D g2, SandBox sb) {
		if(wasteMyTime) {
			BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			this.clear(g2);
			int sizePerSand = (this.width)/sb.getSize();
			for(int i = 0; i < sb.getSize(); i ++) {
				for(int ii = 0; ii < sb.getSize(); ii ++) {
					int sand = sb.getSandAt(i, ii);
					Color c = new Color(0,0,0);
					if(sand == 0) {
						c = Color.blue;
					} else if(sand == 1) {
						c = Color.green;
					} else if(sand == 2){
						c = Color.red;
					} else if(sand == 3){
						c = Color.orange;
					}
					g.setColor(c);
					g.fillRect(ii*sizePerSand, i*sizePerSand, sizePerSand, sizePerSand);
					g.setColor(Color.BLACK);
					//g.drawString(new Integer(sand).toString(), ii*sizePerSand + 5, i*sizePerSand+12);
				}
			}
			this.render(g2, img);	
		}
	}
	
	public void clear(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.width, this.height);
	}
	
	public void render(Graphics g, BufferedImage img) {
		
		img = this.scaleToFrameSize(img);
		g.drawImage(img, 0, 0, null);
		g.dispose();
		
	}
	
	public BufferedImage scaleToFrameSize(BufferedImage img) {
		
		int[] targetRes = new int[2];
		targetRes[0] = this.getWidth();
		targetRes[1] = this.getHeight();
		
		return scale(targetRes, img);
		
	}
	
	public BufferedImage scale(int[] targetRes, BufferedImage img) {
		if(targetRes[1] != Main.WIDTH && targetRes[0] != Main.HEIGHT - 20) {
			Image image = img.getScaledInstance(targetRes[0], targetRes[1], Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(targetRes[0], targetRes[1], BufferedImage.TYPE_INT_ARGB); 
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(image, 0, 0, targetRes[0], targetRes[1], null);
			g.dispose();
		    return resizedImage;
		}
		return img;
	}
	
	public void addEventQueue(GUIEventQueue queue)  {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

		return;
	}
		
}
