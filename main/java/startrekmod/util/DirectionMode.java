package startrekmod.util;

public enum DirectionMode
{
	NORTH(180),
	EAST(270),
	SOUTH(0),
	WEST(90);
	
	public int angle;
	
	DirectionMode(int angle)
	{
		this.angle = angle;
	}
	
	public static DirectionMode fromAngle(int angle)
	{
		switch(angle)
		{
		case 0:
			return SOUTH;
		case 90:
			return WEST;
		case 180:
			return NORTH;
		case 270:
			return EAST;
		}
		
		throw new IllegalArgumentException();
	}
}
