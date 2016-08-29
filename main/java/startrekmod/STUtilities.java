package startrekmod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.*;

import java.util.UUID;

import io.netty.buffer.ByteBuf;

public class STUtilities
{
	public static Minecraft client;

	public static void init ()
	{
		client = Minecraft.getMinecraft ();
	}

	public static MinecraftServer getServer ()
	{
		return MinecraftServer.getServer ();
	}

	public static ServerConfigurationManager getManager ()
	{
		return getServer ().getConfigurationManager ();
	}

	public static EntityPlayer getPlayerByUUID (UUID ID)
	{
		for (Object player : getManager ().playerEntityList)
			if (((EntityPlayer) player).getPersistentID ().equals (ID))
				return (EntityPlayer) player;

		return null;
	}

	public static EntityPlayer getPlayerByName (String name)
	{
		for (Object player : getManager ().playerEntityList)
			if (((EntityPlayer) player).getDisplayName ().equals (name))
				return (EntityPlayer) player;

		return null;
	}

	public static Entity getEntityByUUID (UUID ID, World world)
	{
		for (Object server : getServer ().worldServers)
			for (Object entity : ((WorldServer) server).loadedEntityList)
				if (((Entity) entity).getPersistentID ().equals (ID))
					return (Entity) entity;

		return null;
	}

	public static void writeStringsToBuffer (ByteBuf buffer, String... text)
	{
		buffer.writeInt (text.length);

		for (String str : text)
		{
			buffer.writeInt (str.getBytes ().length);
			buffer.writeBytes (str.getBytes ());
		}
	}

	public static String[] readStringsFromBuffer (ByteBuf buffer)
	{
		String[] text = new String[buffer.readInt ()];

		for (int i = 0; i < text.length; i++)
		{
			int strlen = buffer.readInt ();
			text[i] = buffer.readBytes (strlen).toString ();
		}

		return text;
	}
}
