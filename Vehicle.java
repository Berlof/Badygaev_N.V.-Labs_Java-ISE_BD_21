import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITransport {
>         
    protected float _startPosX; 
      
    protected float _startPosY; 
     
    protected int _pictureWidth;

    protected int _pictureHeight; 
	
    public int maxSpeed;

    public int getMaxSpeed() {
    	return maxSpeed;
    }
    protected void setMaxSpeed(int maxSpeed) {
    	this.maxSpeed = maxSpeed;
    }         
    public float weight;
    public float getWeight() {
    	return weight;
    }
    protected void setWeight(float weight) {
    	this.weight = weight;
    }    
   
    public Color mainColor;
    public Color getMainColor() {
    	return mainColor;
    }
    protected void setMainColor(Color mainColor) {
    	this.mainColor = mainColor;
    }

    
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public abstract void DrawTractor(Graphics g);

    public abstract void MoveTransport(Direction direction);
}
