package buckman.morecreepsandweirdos.entities.projectile;

import buckman.morecreepsandweirdos.MoreCreepsAndWeirdos;
import buckman.morecreepsandweirdos.common.Sounds;
import buckman.morecreepsandweirdos.entities.passive.EnityFloob;
import buckman.morecreepsandweirdos.library.client.Particles;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityRayGun extends EntityThrowable
{
    protected boolean playerFire;

    public EntityRayGun(World world)
    {
        super(world);
        playerFire = false;
    }

    public EntityRayGun(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityRayGun(World world, EntityLivingBase entityliving)
    {
        super(world, entityliving);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {

    }

    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 4;

            if (result.entityHit instanceof EntityPlayer)
            {
                if (world.getDifficulty() == EnumDifficulty.PEACEFUL)
                {
                    i = 0;
                }

                if (world.getDifficulty() == EnumDifficulty.EASY)
                {
                    i = i / 3 + 1;
                }

                if (world.getDifficulty() == EnumDifficulty.HARD)
                {
                    i = (i * 3) / 2;
                }

                if ((result.entityHit instanceof EntityLivingBase) && playerFire || !(result.entityHit instanceof EnityFloob) || playerFire)
                {
                    result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4);
                }
            }
        }
        if (this.world.isRemote)
        {
            for (int i = 0; i < 8; i++)
            {
                byte scale = 7;

                if (rand.nextInt(4) == 0)
                {
                    scale = 11;
                }
                MoreCreepsAndWeirdos.proxy.spawnParticle(Particles.RAYGUN_SMOKE, world, this.posX, this.posY, this.posZ, Item.getIdFromItem(Items.EGG), scale);
            }
        }

        this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, Sounds.RAYGUN_FIRE, SoundCategory.AMBIENT, 0.2F, 1.0F / (rand.nextFloat() * 0.1F + 0.95F));

        for (int j = 0; j < 8; ++j)
        {
            this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.world.isRemote)
        {
            this.setDead();
        }
    }
}
