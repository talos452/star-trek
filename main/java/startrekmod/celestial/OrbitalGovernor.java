package startrekmod.celestial;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import startrekmod.entity.EntityCelestial;

public class OrbitalGovernor extends PhysicsGovernor
{
    protected double radius;
    protected float angle;
    protected float angularVelocity;
    protected PhysicsGovernor axis;
    
    public OrbitalGovernor (double radius, float angularVelocity, PhysicsGovernor axis)
    {
        //Dummy constructor call.
        super (0, 0, 0);
        
        this.radius = radius;
        this.angularVelocity = angularVelocity;
        this.axis = axis;
        
        angle = (float)(Math.random () * Math.PI * 2);
        this.posX = axis.posX + radius * MathHelper.sin (angle);
        this.posY = axis.posY;
        this.posZ = axis.posZ + radius * MathHelper.cos (angle);
    }
    
    @Override
    public void updatePosition (EntityCelestial celestial)
    {
        angle += angularVelocity;
        
        posX = axis.posX + radius * MathHelper.sin (angle);
        posY = axis.posY;
        posZ = axis.posZ + radius * MathHelper.sin (angle);
        
        celestial.setPosition (posX, posY, posZ);
    }
}
