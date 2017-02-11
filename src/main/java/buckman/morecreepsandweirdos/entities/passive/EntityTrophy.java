package buckman.morecreepsandweirdos.entities.passive;

import buckman.morecreepsandweirdos.MoreCreepsAndWeirdos;
import buckman.morecreepsandweirdos.common.Sounds;
import buckman.morecreepsandweirdos.library.client.Particles;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTrophy extends EntityCreature
{
    public int partytime;

    public int trophylifespan;

    public float spin;

    public String texture;

    public EntityTrophy(World world)
    {
        super(world);
        texture = "morecreeps:textures/entity/trophy.png";
        partytime = rand.nextInt(30) + 40;
        trophylifespan = 80;
        setSize(1.0F, 2.5F);
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        if (partytime-- > 1)
        {
            if (world.isRemote)
            {
                for (int i = 1; i < 10; i++)
                {
                    for (int j = 0; j < 10; j++)
                    {
                        double x = this.posX + (world.rand.nextFloat() * 8F - world.rand.nextFloat() * 8F);
                        double y = this.posY + world.rand.nextInt(4) + 4D;
                        double z = this.posZ + (world.rand.nextFloat() * 8F - world.rand.nextFloat() * 8F);

                        MoreCreepsAndWeirdos.proxy.spawnParticle(Particles.CONFETTI, world, x, y, z, world.rand.nextInt(99));
                    }
                }
            }
        }

        if (trophylifespan-- < 0)
        {
            setDead();
        }

        super.onUpdate();
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    @Override
    public boolean isEntityInsideOpaqueBlock()
    {
        return false;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.MUMMY;
    }

    @Override
    protected SoundEvent getHurtSound()
    {
        return Sounds.MUMMY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.MUMMY_DEATH;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource damagesource)
    {
        for (int i = 0; i < rand.nextInt(25) + 10; i++)
        {
            dropItem(MoreCreepsAndWeirdos.money, 1);
        }

        super.setDead();
    }
}
