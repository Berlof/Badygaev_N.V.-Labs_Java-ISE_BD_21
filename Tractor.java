import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public class Tractor {
	   
    private int _startPosX;        
    private int _startPosY;       
    private int _pictureWidth;       
    private int _pictureHeight;        
    private int carWidth = 120;   
    private int carHeight = 60;          
    private int maxSpeed;
    public int getMaxSpeed() {
    	return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
    	this.maxSpeed = maxSpeed;
    }          
    private float weight;
    public float getWeight() {
    	return weight;
    }
    public void setWeight(float weight) {
    	this.weight = weight;
    }            
    private Color mainColor;
    public Color getMainColor() {
    	return mainColor;
    }
    public void setMainColor(Color mainColor) {
    	this.mainColor = mainColor;
    }       
    private Color dopColor;
    public Color getDopColor() {
    	return dopColor;
    }
    public void setDopColor(Color dopColor) {
    	this.dopColor = dopColor;
    }       
    public Tractor(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {
        setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
        setDopColor(dopColor);
    }   
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public void MoveTransport(Direction direction)
    {
        float step = maxSpeed * 100 / weight;
        switch (direction)
        {
            // вправо                
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево              
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх                 
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //Вниз            
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }  
    public void DrawTractor(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine( _startPosX + 70, _startPosY + 20, _startPosX + 95, _startPosY + 60);
        g.drawLine( _startPosX + 95, _startPosY + 60, _startPosX + 105, _startPosY + 60);
        g.drawLine( _startPosX + 70, _startPosY + 20, _startPosX + 105, _startPosY + 60);
        int n = 0;
        while (n < 20)
        {
            n++;
            g.drawLine( _startPosX + 70, _startPosY + 20, _startPosX + 95 + n, _startPosY + 60);
        }
        g.drawRect(_startPosX , _startPosY, 50, 15);
        g.drawRect(_startPosX, _startPosY, 50, 40);
        g.fillOval( _startPosX - 10, _startPosY+40, 100, 25);
        g.drawRect( _startPosX + 50, _startPosY +15, 20, 25);
        g.setColor(Color.YELLOW);
        g.fillRect( _startPosX, _startPosY, 50, 40);
        g.fillRect( _startPosX + 50, _startPosY + 15, 20, 25);
        g.setColor(Color.BLUE);
        g.fillRect( _startPosX, _startPosY, 50, 15);
        g.setColor(Color.BLACK);
        g.fillOval( _startPosX - 10, _startPosY + 40, 100, 25);
    }
}
