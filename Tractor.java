
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Tractor extends TractorBase{
        
    private Color dopColor;
    public Color getDopColor() {
    	return dopColor;
    }
    private void setDopColor(Color dopColor) {
    	this.dopColor = dopColor;
    }
        
    private boolean frontEquipment;
    public boolean getFrontEquipment() {
    	return frontEquipment;
    }
    private void setFrontEquipment(boolean frontEquipment) {
    	this.frontEquipment = frontEquipment;
    }
    public Tractor(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean frontEquipment)   
    {
    	super(maxSpeed, weight, mainColor);
        setDopColor(dopColor);
        setFrontEquipment(frontEquipment);
    } 

    public void DrawTractor(Graphics g)
    {  	
    	 /// îòðèñîâêà ïåðåäíåãî êîâøà     
     if (frontEquipment)
        {
        	 g.setColor(Color.BLACK);
             g.drawLine( (int)_startPosX + 70, (int)_startPosY + 20, (int)_startPosX + 95, (int)_startPosY + 60);
             g.drawLine( (int)_startPosX + 95, (int)_startPosY + 60, (int)_startPosX + 105, (int)_startPosY + 60);
             g.drawLine( (int)_startPosX + 70, (int)_startPosY + 20, (int)_startPosX + 105, (int)_startPosY + 60);
             int n = 0;
             g.setColor(dopColor);
             while (n < 20)
             {
                 n++;
                 g.drawLine( (int)_startPosX + 70, (int)_startPosY + 20, (int)_startPosX + 95 + n, (int)_startPosY + 60);
             }
        }
        super.DrawTractor(g);   
    }
}

