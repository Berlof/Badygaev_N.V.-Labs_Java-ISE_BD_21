import java.awt.Color;
import java.awt.Graphics;

public class TractorBase extends Vehicle {
        
    protected int carWidth = 120;
        
    protected int carHeight = 60;
	
	
    public TractorBase(int maxSpeed, float weight, Color mainColor)
    {
        setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
    }

	@Override
	public void MoveTransport(Direction direction) {
		float step = maxSpeed * 100 / weight; switch (direction)
        {
                 
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                break;
              
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
         
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
      
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
	}

	@Override
	public void DrawTractor(Graphics g) {
		 g.drawRect((int)_startPosX , (int)_startPosY, 50, 15);
	        g.drawRect((int)_startPosX, (int)_startPosY, 50, 40);
	        g.fillOval( (int)_startPosX - 10, (int)_startPosY+40, 100, 25);
	        g.drawRect( (int)_startPosX + 50, (int)_startPosY +15, 20, 25);
	        
	        g.setColor(mainColor);
	        
	        g.fillRect( (int)_startPosX, (int)_startPosY, 50, 40);
	        g.fillRect( (int)_startPosX + 50,(int) _startPosY + 15, 20, 25);
	        g.setColor(Color.BLUE);
	        g.fillRect((int) _startPosX, (int)_startPosY, 50, 15);
	        g.setColor(Color.BLACK);
	        g.fillOval( (int)_startPosX - 10,(int) _startPosY + 40, 100, 25);
	}
}