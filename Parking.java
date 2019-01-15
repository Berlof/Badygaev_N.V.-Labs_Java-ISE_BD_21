import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Parking<T extends ITransport> {

    private ArrayList<T> _places;
    
    private int pictureWidth;
    public int getPictureWidth() {
    	return pictureWidth;
    }
    public void setPictureWidth(int pictureWidth) {
    	this.pictureWidth = pictureWidth;
    }

    private int pictureHeight;
    public int getPictureHeight() {
    	return pictureHeight;
    }
    public void setPictureHeight(int pictureHeight) {
    	this.pictureHeight = pictureHeight;
    }

    private int _placeSizeWidth = 210;
    

    private int _placeSizeHeight = 80;

    public Parking(int sizes, int pictureWidth, int pictureHeight)
    {
        _places = new ArrayList<T>();
        setPictureWidth( pictureWidth);
        setPictureHeight( pictureHeight);
        for (int i = 0; i < sizes; i++)
        {
            _places.add(null);
        }
    }
// Перегрузка оператора сравнения
    public int Add(T car)
    {
        for (int i = 0; i < _places.size(); i++)
        {
            if (CheckFreePlace(i))
            {
                _places.add(i, car);
                _places.get(i).SetPosition(5 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 15, getPictureWidth(), getPictureHeight());
                return i;
            }
        }
        return -1;
    }
//Перегрузка опреаторов вычитания
    public T Remove(int index)
    {
        if (index < 0 || index > _places.size())
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T car = _places.get(index);
            _places.set(index, null);
            return car;
        }
        return null;
    }
//Проверка
    private boolean CheckFreePlace(int index)
    {
        return _places.get(index) == null;
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);
        for (int i = 0; i < _places.size(); i++)
        {
            if (!CheckFreePlace(i))
            {
                
                _places.get(i).DrawTractor(g);
            }
        }
    }

    private void DrawMarking(Graphics g)
    {
    	g.setColor(Color.BLACK);
        
        g.drawRect( 0, 0, (_places.size() / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _places.size() / 5; i++)
        {
            
            for (int j = 0; j < 6; ++j)
            {
                
                g.drawLine( i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + 110, j * _placeSizeHeight);
            }
            g.drawLine( i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }
}
