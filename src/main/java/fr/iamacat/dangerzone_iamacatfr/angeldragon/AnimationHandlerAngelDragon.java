
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import java.util.HashMap;

import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.IMCAnimatedEntity;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.AnimationHandler;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.Channel;

public class AnimationHandlerAngelDragon extends AnimationHandler {

    public static HashMap<String, Channel> animChannels;

    public AnimationHandlerAngelDragon(final IMCAnimatedEntity entity) {
        super(entity);
    }

    @Override
    public void activateAnimation(final String name, final float startingFrame) {
        super.activateAnimation(AnimationHandlerAngelDragon.animChannels, name, startingFrame);
    }

    @Override
    public void stopAnimation(final String name) {
        super.stopAnimation(AnimationHandlerAngelDragon.animChannels, name);
    }

    @Override
    public void fireAnimationEventClientSide(fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.Channel p0,
        float p1, float p2) {

    }

    @Override
    public void fireAnimationEventServerSide(fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.Channel p0,
        float p1, float p2) {

    }

    static {
        (AnimationHandlerAngelDragon.animChannels = new HashMap<String, Channel>())
            .put("Living", new ChannelLiving("Living", 1.0f, 4, (byte) 1));
        AnimationHandlerAngelDragon.animChannels.put("Squeak", new ChannelSqueak("Squeak", 3.0f, 5, (byte) 0));
        AnimationHandlerAngelDragon.animChannels.put("Look", new ChannelLook("Look", 2.0f, 20, (byte) 0));
        AnimationHandlerAngelDragon.animChannels.put("Tilt", new ChannelTilt("Tilt", 11.0f, 3, (byte) 0));
        AnimationHandlerAngelDragon.animChannels.put("Living2", new ChannelLiving2("Living2", 2.0f, 5, (byte) 1));
    }
}
