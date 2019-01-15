import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class Parking<T extends ITransport> {

    private HashMap<Integer, T> _places;

    private int _maxCount;

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
    /// Конструктор
    public Parking(int sizes, int pictureWidth, int pictureHeight)
    {
    	_maxCount = sizes;
    	_places = new HashMap<Integer,T>();
        setPictureWidth( pictureWidth);
        setPictureHeight( pictureHeight);
    }
    /// Перегрузка оператора сложения
    public int Add(T car)
    {
    	if(_places.size() == _maxCount)
        {
            return -1;
        }
    	
        for (int i = 0; i < _maxCount; i++)
        {
            if (CheckFreePlace(i))
            {
                _places.put(i, car);
                _places.get(i).SetPosition(5 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 15, getPictureWidth(), getPictureHeight());
                return i;
            }
        }
        return -1;
    }
    public T Remove(int index)
    {
        if (index < 0 || index > _maxCount)
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T car = _places.get(index);
            _places.remove(index);
            return car;
        }
        return null;
    }
    private boolean CheckFreePlace(int index)
    {
    	return !_places.containsKey(index);
    }
    public void Draw(Graphics g)
    {
        DrawMarking(g);
        Object[] keys = _places.keySet().toArray();
        for (int i = 0; i < keys.length; i++)
        {
            _places.get(keys[i]).DrawTractor(g);
        }
    }
    private void DrawMarking(Graphics g)
    {
    	g.setColor(Color.BLACK);
        //границы праковки
        g.drawRect( 0, 0, (_maxCount / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _maxCount / 5; i++)
        {
            //отрисовываем, по 5 мест на линии
            for (int j = 0; j < 6; ++j)
            {
                //линия рамзетки места
                g.drawLine( i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + 110, j * _placeSizeHeight);
            }
            g.drawLine( i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }
}
