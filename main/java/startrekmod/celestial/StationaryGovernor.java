package startrekmod.celestial;

import startrekmod.entity.EntityCelestial;

public class StationaryGovernor extends PhysicsGovernor
{
    public StationaryGovernor (double posX, double posY, double posZ)
    {
        super (posX, posY, posZ);
    }
    
    @Override
    public void updatePosition (EntityCelestial celestial)
    {
        celestial.setPosition (posX, posY, posZ);
    }
}
