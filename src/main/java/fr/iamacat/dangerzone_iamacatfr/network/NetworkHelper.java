package fr.iamacat.dangerzone_iamacatfr.network;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.EnumMap;
import java.util.HashSet;

public class NetworkHelper
{
  private final FMLEmbeddedChannel clientOutboundChannel;
  private final FMLEmbeddedChannel serverOutboundChannel;
  private final HashSet<Class<? extends IPacket>> registeredClasses;
  private boolean isCurrentlySendingSemaphor;

  @SafeVarargs
  public NetworkHelper(String channelName, Class<? extends IPacket> ... handledPacketClasses)
  {
	  EnumMap<Side, FMLEmbeddedChannel> channelPair = NetworkRegistry.INSTANCE.newChannel(channelName, new ChannelCodec(handledPacketClasses), new ChannelHandler());

    //EnumMap channelPair = NetworkRegistry.INSTANCE.newChannel(channelName, new ChannelHandler[] { new ChannelCodec(handledPacketClasses), new ChannelHandler() });
    this.clientOutboundChannel = ((FMLEmbeddedChannel)channelPair.get(Side.CLIENT));
    this.serverOutboundChannel = ((FMLEmbeddedChannel)channelPair.get(Side.SERVER));

    this.registeredClasses = new HashSet(handledPacketClasses.length);
    for (Class c : handledPacketClasses)
    {
      this.registeredClasses.add(c);
    }
  }

  public void sendPacketToServer(IPacket packet)
  {
    checkClassAndSync(packet.getClass());
    this.clientOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.TOSERVER);
    this.clientOutboundChannel.writeOutbound(new Object[] { packet });
    this.isCurrentlySendingSemaphor = false;
  }

  public void sendPacketToPlayer(IPacket packet, EntityPlayerMP player)
  {
    checkClassAndSync(packet.getClass());
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.PLAYER);
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
    this.serverOutboundChannel.writeOutbound(new Object[] { packet });
    this.isCurrentlySendingSemaphor = false;
  }

  public void sendPacketToAllPlayers(IPacket packet)
  {
    checkClassAndSync(packet.getClass());
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.ALL);
    this.serverOutboundChannel.writeOutbound(new Object[] { packet });
    this.isCurrentlySendingSemaphor = false;
  }

  public void sendPacketToAllAroundPoint(IPacket packet, TargetPoint tp)
  {
    checkClassAndSync(packet.getClass());
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.ALLAROUNDPOINT);
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(tp);
    this.serverOutboundChannel.writeOutbound(new Object[] { packet });
    this.isCurrentlySendingSemaphor = false;
  }

  public void sendPacketToAllInDimension(IPacket packet, int dimension)
  {
    checkClassAndSync(packet.getClass());
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.DIMENSION);
    this.serverOutboundChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimension));
    this.serverOutboundChannel.writeOutbound(new Object[] { packet });
    this.isCurrentlySendingSemaphor = false;
  }

  private void checkClassAndSync(Class<? extends IPacket> clazz)
  {
    if (!this.registeredClasses.contains(clazz))
    {
      throw new RuntimeException("[ERROR] NetworkHelper got unknown Packet type " + clazz + " to send.");
    }

    while (this.isCurrentlySendingSemaphor)
    {
      Thread.yield();
    }
    this.isCurrentlySendingSemaphor = true;
  }
  @Sharable
  public class ChannelHandler extends SimpleChannelInboundHandler<IPacket> {
    public ChannelHandler() {
    }
    protected void channelRead0(ChannelHandlerContext ctx, IPacket msg) throws Exception {
    }
  }
  private class ChannelCodec extends FMLIndexedMessageToMessageCodec<IPacket>
  {
	  /*
	  Class<? extends IPacket>[] handledPacketClasses;

	  public ChannelCodec(Class<? extends IPacket>[] HPC)
	  {
		  this.handledPacketClasses = HPC;
	  }

    @SafeVarargs
    public ChannelCodec() { for (int i = 0; i < handledPacketClasses.length; i++)
      {
        addDiscriminator(i, handledPacketClasses[i]);
      }
    }
    */

	  @SafeVarargs
      public ChannelCodec(Class<? extends IPacket> ... handledPacketClasses)
      {
          for (int i = 0; i < handledPacketClasses.length; i++)
          {
              addDiscriminator(i, handledPacketClasses[i]);
          }
      }

    public void encodeInto(ChannelHandlerContext ctx, IPacket msg, ByteBuf bytes)
      throws Exception
    {
      msg.writeBytes(ctx, bytes);
    }

    public void decodeInto(ChannelHandlerContext ctx, ByteBuf bytes, IPacket msg)
    {
      msg.readBytes(ctx, bytes);
    }
  }

  public static abstract interface IPacket
  {
    public abstract void writeBytes(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);

    public abstract void readBytes(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);
  }
}
