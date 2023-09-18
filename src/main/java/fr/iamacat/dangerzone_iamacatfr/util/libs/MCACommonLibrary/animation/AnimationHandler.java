
package fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Quaternion;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCAClientLibrary.MCAModelRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.IMCAnimatedEntity;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Vector3f;

public abstract class AnimationHandler {

    public static AnimTickHandler animTickHandler;
    private IMCAnimatedEntity animatedEntity;
    public ArrayList<Channel> animCurrentChannels;
    public HashMap<String, Long> animPrevTime;
    public HashMap<String, Float> animCurrentFrame;
    private HashMap<String, ArrayList<String>> animationEvents;

    public AnimationHandler(final IMCAnimatedEntity entity) {
        this.animCurrentChannels = new ArrayList<Channel>();
        this.animPrevTime = new HashMap<String, Long>();
        this.animCurrentFrame = new HashMap<String, Float>();
        this.animationEvents = new HashMap<String, ArrayList<String>>();
        if (AnimationHandler.animTickHandler == null) {
            AnimationHandler.animTickHandler = new AnimTickHandler();
        }
        AnimationHandler.animTickHandler.addEntity(entity);
        this.animatedEntity = entity;
    }

    public IMCAnimatedEntity getEntity() {
        return this.animatedEntity;
    }

    public void activateAnimation(final HashMap<String, Channel> animChannels, final String name,
        final float startingFrame) {
        if (animChannels.get(name) != null) {
            final Channel selectedChannel = animChannels.get(name);
            final int indexToRemove = this.animCurrentChannels.indexOf(selectedChannel);
            if (indexToRemove != -1) {
                this.animCurrentChannels.remove(indexToRemove);
            }
            this.animCurrentChannels.add(selectedChannel);
            this.animPrevTime.put(name, System.nanoTime());
            this.animCurrentFrame.put(name, startingFrame);
            if (this.animationEvents.get(name) == null) {
                this.animationEvents.put(name, new ArrayList<String>());
            }
        } else {
            System.out.println("The animation called " + name + " doesn't exist!");
        }
    }

    public abstract void activateAnimation(final String p0, final float p1);

    public void stopAnimation(final HashMap<String, Channel> animChannels, final String name) {
        final Channel selectedChannel = animChannels.get(name);
        if (selectedChannel != null) {
            final int indexToRemove = this.animCurrentChannels.indexOf(selectedChannel);
            if (indexToRemove != -1) {
                this.animCurrentChannels.remove(indexToRemove);
                this.animPrevTime.remove(name);
                this.animCurrentFrame.remove(name);
                this.animationEvents.get(name)
                    .clear();
            }
        } else {
            System.out.println("The animation called " + name + " doesn't exist!");
        }
    }

    public abstract void stopAnimation(final String p0);

    public void animationsUpdate() {
        final Iterator<Channel> it = this.animCurrentChannels.iterator();
        while (it.hasNext()) {
            final Channel anim = it.next();
            final float prevFrame = this.animCurrentFrame.get(anim.name);
            final boolean animStatus = updateAnimation(
                this.animatedEntity,
                anim,
                this.animPrevTime,
                this.animCurrentFrame);
            if (this.animCurrentFrame.get(anim.name) != null) {
                this.fireAnimationEvent(anim, prevFrame, this.animCurrentFrame.get(anim.name));
            }
            if (!animStatus) {
                it.remove();
                this.animPrevTime.remove(anim.name);
                this.animCurrentFrame.remove(anim.name);
                this.animationEvents.get(anim.name)
                    .clear();
            }
        }
    }

    public boolean isAnimationActive(final String name) {
        boolean animAlreadyUsed = false;
        for (final Channel anim : this.animatedEntity.getAnimationHandler().animCurrentChannels) {
            if (anim.name.equals(name)) {
                animAlreadyUsed = true;
                break;
            }
        }
        return animAlreadyUsed;
    }

    private void fireAnimationEvent(final Channel anim, final float prevFrame, final float frame) {
        if (isWorldRemote(this.animatedEntity)) {
            this.fireAnimationEventClientSide(anim, prevFrame, frame);
        } else {
            this.fireAnimationEventServerSide(anim, prevFrame, frame);
        }
    }

    @SideOnly(Side.CLIENT)
    public abstract void fireAnimationEventClientSide(final Channel p0, final float p1, final float p2);

    public abstract void fireAnimationEventServerSide(final Channel p0, final float p1, final float p2);

    public boolean alreadyCalledEvent(final String animName, final String eventName) {
        if (this.animationEvents.get(animName) == null) {
            System.out.println(
                "Cannot check for event " + eventName + "! Animation " + animName + "does not exist or is not active.");
            return true;
        }
        return this.animationEvents.get(animName)
            .contains(eventName);
    }

    public void setCalledEvent(final String animName, final String eventName) {
        if (this.animationEvents.get(animName) != null) {
            this.animationEvents.get(animName)
                .add(eventName);
        } else {
            System.out.println(
                "Cannot set event " + eventName + "! Animation " + animName + "does not exist or is not active.");
        }
    }

    public static boolean updateAnimation(final IMCAnimatedEntity entity, final Channel channel,
        final HashMap<String, Long> prevTimeAnim, final HashMap<String, Float> prevFrameAnim) {
        if (!FMLCommonHandler.instance()
            .getEffectiveSide()
            .isServer()
            && (!FMLCommonHandler.instance()
                .getEffectiveSide()
                .isClient() || isGamePaused())) {
            final long currentTime = System.nanoTime();
            prevTimeAnim.put(channel.name, currentTime);
            return true;
        }
        if (channel.mode == 3) {
            return true;
        }
        final long prevTime = prevTimeAnim.get(channel.name);
        final float prevFrame = prevFrameAnim.get(channel.name);
        final long currentTime2 = System.nanoTime();
        final double deltaTime = (currentTime2 - prevTime) / 1.0E9;
        final float numberOfSkippedFrames = (float) (deltaTime * channel.fps);
        final float currentFrame = prevFrame + numberOfSkippedFrames;
        if (currentFrame < channel.totalFrames) {
            prevTimeAnim.put(channel.name, currentTime2);
            prevFrameAnim.put(channel.name, currentFrame);
            return true;
        }
        if (channel.mode == 1) {
            prevTimeAnim.put(channel.name, currentTime2);
            prevFrameAnim.put(channel.name, 0.0f);
            return true;
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    private static boolean isGamePaused() {
        final Minecraft MC = Minecraft.getMinecraft();
        return MC.isSingleplayer() && MC.currentScreen != null
            && MC.currentScreen.doesGuiPauseGame()
            && !MC.getIntegratedServer()
                .getPublic();
    }

    @SideOnly(Side.CLIENT)
    public static void performAnimationInModel(final HashMap<String, MCAModelRenderer> parts,
        final IMCAnimatedEntity entity) {
        for (final Map.Entry<String, MCAModelRenderer> entry : parts.entrySet()) {
            final String boxName = entry.getKey();
            final MCAModelRenderer box = entry.getValue();
            boolean anyRotationApplied = false;
            boolean anyTranslationApplied = false;
            boolean anyCustomAnimationRunning = false;
            for (final Channel channel : entity.getAnimationHandler().animCurrentChannels) {
                if (channel.mode != 3) {
                    final float currentFrame = entity.getAnimationHandler().animCurrentFrame.get(channel.name);
                    final KeyFrame prevRotationKeyFrame = channel.getPreviousRotationKeyFrameForBox(
                        boxName,
                        entity.getAnimationHandler().animCurrentFrame.get(channel.name));
                    final int prevRotationKeyFramePosition = (prevRotationKeyFrame != null)
                        ? channel.getKeyFramePosition(prevRotationKeyFrame)
                        : 0;
                    final KeyFrame nextRotationKeyFrame = channel.getNextRotationKeyFrameForBox(
                        boxName,
                        entity.getAnimationHandler().animCurrentFrame.get(channel.name));
                    final int nextRotationKeyFramePosition = (nextRotationKeyFrame != null)
                        ? channel.getKeyFramePosition(nextRotationKeyFrame)
                        : 0;
                    float SLERPProgress = (currentFrame - prevRotationKeyFramePosition)
                        / (nextRotationKeyFramePosition - prevRotationKeyFramePosition);
                    if (SLERPProgress > 1.0f || SLERPProgress < 0.0f) {
                        SLERPProgress = 1.0f;
                    }
                    if (prevRotationKeyFramePosition == 0 && nextRotationKeyFramePosition != 0) {
                        final Quaternion currentQuat = new Quaternion();
                        currentQuat.slerp(
                            parts.get(boxName)
                                .getDefaultRotationAsQuaternion(),
                            nextRotationKeyFrame.modelRenderersRotations.get(boxName),
                            SLERPProgress);
                        box.getRotationMatrix()
                            .set(currentQuat)
                            .transpose();
                        anyRotationApplied = true;
                    } else if (prevRotationKeyFramePosition != 0 && nextRotationKeyFramePosition != 0) {
                        final Quaternion currentQuat = new Quaternion();
                        currentQuat.slerp(
                            prevRotationKeyFrame.modelRenderersRotations.get(boxName),
                            nextRotationKeyFrame.modelRenderersRotations.get(boxName),
                            SLERPProgress);
                        box.getRotationMatrix()
                            .set(currentQuat)
                            .transpose();
                        anyRotationApplied = true;
                    }
                    final KeyFrame prevTranslationKeyFrame = channel.getPreviousTranslationKeyFrameForBox(
                        boxName,
                        entity.getAnimationHandler().animCurrentFrame.get(channel.name));
                    final int prevTranslationsKeyFramePosition = (prevTranslationKeyFrame != null)
                        ? channel.getKeyFramePosition(prevTranslationKeyFrame)
                        : 0;
                    final KeyFrame nextTranslationKeyFrame = channel.getNextTranslationKeyFrameForBox(
                        boxName,
                        entity.getAnimationHandler().animCurrentFrame.get(channel.name));
                    final int nextTranslationsKeyFramePosition = (nextTranslationKeyFrame != null)
                        ? channel.getKeyFramePosition(nextTranslationKeyFrame)
                        : 0;
                    float LERPProgress = (currentFrame - prevTranslationsKeyFramePosition)
                        / (nextTranslationsKeyFramePosition - prevTranslationsKeyFramePosition);
                    if (LERPProgress > 1.0f) {
                        LERPProgress = 1.0f;
                    }
                    if (prevTranslationsKeyFramePosition == 0 && nextTranslationsKeyFramePosition != 0) {
                        final Vector3f startPosition = parts.get(boxName)
                            .getPositionAsVector();
                        final Vector3f endPosition = nextTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                        final Vector3f currentPosition = new Vector3f(startPosition);
                        currentPosition.interpolate(endPosition, LERPProgress);
                        box.setRotationPoint(currentPosition.x, currentPosition.y, currentPosition.z);
                        anyTranslationApplied = true;
                    } else {
                        if (prevTranslationsKeyFramePosition == 0 || nextTranslationsKeyFramePosition == 0) {
                            continue;
                        }
                        final Vector3f startPosition = prevTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                        final Vector3f endPosition = nextTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                        final Vector3f currentPosition = new Vector3f(startPosition);
                        currentPosition.interpolate(endPosition, LERPProgress);
                        box.setRotationPoint(currentPosition.x, currentPosition.y, currentPosition.z);
                        anyTranslationApplied = true;
                    }
                } else {
                    anyCustomAnimationRunning = true;
                    ((CustomChannel) channel).update(parts, entity);
                }
            }
            if (!anyRotationApplied && !anyCustomAnimationRunning) {
                box.resetRotationMatrix();
            }
            if (!anyTranslationApplied && !anyCustomAnimationRunning) {
                box.resetRotationPoint();
            }
        }
    }

    public static boolean isWorldRemote(final IMCAnimatedEntity animatedEntity) {
        return ((Entity) animatedEntity).worldObj.isRemote;
    }
}
