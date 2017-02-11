package buckman.morecreepsandweirdos.common;

import buckman.morecreepsandweirdos.library.client.Particles;
import net.minecraft.world.World;

public class CommonProxy
{
    public void preInit()
    {
        this.registerModels();
    }

    public void init()
    {

    }

    public void postInit()
    {
    }

    protected void registerModels()
    {
    }

    public void spawnParticle(Particles particleType, World world, double x, double y, double z, int... data)
    {
    }
}
