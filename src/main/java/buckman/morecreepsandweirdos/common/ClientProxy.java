package buckman.morecreepsandweirdos.common;

import buckman.morecreepsandweirdos.MoreCreepsAndWeirdos;
import buckman.morecreepsandweirdos.library.Util;
import buckman.morecreepsandweirdos.library.client.Particles;
import buckman.morecreepsandweirdos.shared.client.ParticleConfetti;
import buckman.morecreepsandweirdos.shared.client.ParticleSmoke;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
    protected void registerItemModel(ItemStack item, String name)
    {
        if (item != null && !StringUtils.isNullOrEmpty(name))
        {
            ModelRegisterUtil.registerItemModel(item, Util.getResource(name));
        }
    }

    @Override
    public void preInit()
    {
        super.preInit();
    }

    @Override
    protected void registerModels()
    {
        MoreCreepsAndWeirdos.achievementsIcons.registerItemModels();
        MoreCreepsAndWeirdos.particles.registerItemModels();

        // Zebra Armour
        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.zebraHelmet), "zebra_armor_helmet");
        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.zebraChestplate), "zebra_armor_chestplate");
        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.zebraLeggings), "zebra_armor_leggings");
        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.zebraBoots), "zebra_armor_boots");

        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.armSword), "arm_sword");
        registerItemModel(new ItemStack(MoreCreepsAndWeirdos.rayGun), "arm_sword");
    }

    @Override
    public void spawnParticle(Particles particleType, World world, double x, double y, double z, int... data)
    {
        if (world == null)
        {
            world = Minecraft.getMinecraft().world;
        }

        Particle effect = createParticle(particleType, world, x, y, z, data);

        Minecraft.getMinecraft().effectRenderer.addEffect(effect);
    }

    public static Particle createParticle(Particles type, World world, double x, double y, double z, int... data)
    {
        switch (type)
        {
        case CONFETTI:
            int meta = data.length > 1 ? data[1] : 0;
            return new ParticleConfetti(world, x, y, z, Item.getItemById(data[0]), meta);
        case RAYGUN_SMOKE:
            return new ParticleSmoke(world, x, y, z, Item.getItemById(data[0]), data[1], 0.5F);
        }

        return null;
    }
}
