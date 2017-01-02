package startrekmod.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketPhaserDrill implements IMessage
{
    public float angle;
    public int drillID;

    public PacketPhaserDrill ()
    {
    }

    public PacketPhaserDrill (float angle, int drillID)
    {
        this.angle = angle;
        this.drillID = drillID;
    }

    @Override
    public void fromBytes (ByteBuf data)
    {
        angle = data.readFloat ();
        drillID = data.readInt ();
    }

    @Override
    public void toBytes (ByteBuf data)
    {
        data.writeFloat (angle);
        data.writeInt (drillID);
    }
}
