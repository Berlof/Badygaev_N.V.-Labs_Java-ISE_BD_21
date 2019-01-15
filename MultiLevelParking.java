import java.util.ArrayList;

public class MultiLevelParking {

	ArrayList<Parking<ITransport>> parkingStages;

	private final int countPlaces = 20;
    public MultiLevelParking(int countStages, int pictureWidth, int pictureHeight)
    {
        parkingStages = new ArrayList<Parking<ITransport>>();
        for (int i = 0; i < countStages; ++i)
        {
            parkingStages.add(new Parking<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Parking<ITransport> getParking(int ind)
    {
        if (ind > -1 && ind < parkingStages.size())
        {
            return parkingStages.get(ind);
        }
        return null;
    }
}
