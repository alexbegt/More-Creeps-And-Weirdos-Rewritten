package buckman.morecreepsandweirdos.common;

import buckman.morecreepsandweirdos.library.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class Sounds
{
    //@formatter:off
    public static final SoundEvent RAYGUN_FIRE = registerSound("raygunfire");
    public static final SoundEvent ROCKET_EXPLODE = registerSound("rocketexplode");
    
    public static final SoundEvent ACHIEVEMENT = registerSound("achivement");
    
    public static final SoundEvent FLOOB = registerSound("floob");
    public static final SoundEvent FLOOB_HURT = registerSound("floobhurt");
    public static final SoundEvent FLOOB_DEATH = registerSound("floobdeath");
    
    public static final SoundEvent MUMMY = registerSound("mummy");
    public static final SoundEvent MUMMY_HURT = registerSound("mummyhurt");
    public static final SoundEvent MUMMY_DEATH = registerSound("mummydealth");
    //@formatter:on

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = Util.getResource(name);
        SoundEvent event = new SoundEvent(location);
        SoundEvent.REGISTRY.register(-1, location, event);
        return event;
    }
}
