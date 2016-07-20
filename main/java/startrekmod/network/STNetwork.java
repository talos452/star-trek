package com.vulcanforge.startrekmod.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class STNetwork
{
	public static SimpleNetworkWrapper network
		= NetworkRegistry.INSTANCE.newSimpleChannel("StarTrek");
	
	public STNetwork()
	{
		
	}
}
