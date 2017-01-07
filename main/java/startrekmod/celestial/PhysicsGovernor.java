package startrekmod.celestial;

import startrekmod.entity.EntityCelestial;

public abstract class PhysicsGovernor
{
    protected double posX, posY, posZ;
    
    protected PhysicsGovernor (double posX, double posY, double posZ)
    {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public abstract void updatePosition (EntityCelestial celestial);
}
