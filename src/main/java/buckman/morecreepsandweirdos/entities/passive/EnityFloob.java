package buckman.morecreepsandweirdos.entities.passive;

import buckman.morecreepsandweirdos.MoreCreepsAndWeirdos;
import buckman.morecreepsandweirdos.common.EntityStats;
import buckman.morecreepsandweirdos.common.Sounds;
import buckman.morecreepsandweirdos.entities.projectile.EntityRayGun;
import buckman.morecreepsandweirdos.entities.projectile.EntityRocket;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EnityFloob extends EntityMob
{
    protected Entity playerToAttack;

    /**
     * returns true if a creature has attacked recently only used for creepers and skeletons
     */
    protected boolean hasAttacked;

    protected ItemStack heldObj;

    public int itemnumber;

    public int stolenamount;

    public int rayTime;

    private Entity targetedEntity;

    public float modelsize;

    public String texture;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public EnityFloob(World world)
    {
        super(world);
        texture = "morecreeps:textures/entity/floob.png";
        hasAttacked = false;
        heldObj = new ItemStack(MoreCreepsAndWeirdos.rayGun, 1);
        rayTime = rand.nextInt(50) + 50;
        isImmuneToFire = true;
        modelsize = 1.0F;
        ((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.5D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setFloat("ModelSize", modelsize);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        modelsize = nbttagcompound.getFloat("ModelSize");
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate()
    {
        if (this.getAttackTarget() instanceof EnityFloob)
        {
            this.setAttackTarget(null);
        }

        targetedEntity = world.getClosestPlayerToEntity(this, 3D);

        if (targetedEntity != null && (targetedEntity instanceof EntityPlayer) && canEntityBeSeen(targetedEntity))
        {
            for (int i = 0; i < 360; i++)
            {
                rotationYaw = i;
            }

            if (rand.nextInt(4) == 0)
            {
                setAttackTarget((EntityLivingBase) targetedEntity);
            }
        }

        if (rayTime-- < 1)
        {
            rayTime = rand.nextInt(50) + 25;
            double d = 64D;
            targetedEntity = world.getClosestPlayerToEntity(this, 30D);

            if (targetedEntity != null && canEntityBeSeen(targetedEntity) && targetedEntity == getAttackTarget() && (targetedEntity instanceof EntityPlayer) && !isDead)
            {
                double d1 = targetedEntity.getDistanceSqToEntity(this);

                if (d1 < d * d && d1 > 3D)
                {
                    double d2 = targetedEntity.posX - posX;
                    double d4 = targetedEntity.posZ - posZ;
                    renderYawOffset = rotationYaw = (-(float) Math.atan2(d2, d4) * 180F) / (float) Math.PI;
                    this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, Sounds.RAYGUN_FIRE, SoundCategory.AMBIENT, getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                    EntityRayGun creepsentityray = new EntityRayGun(world, this);

                    if (creepsentityray != null && getHealth() > 0)
                    {
                        if (!world.isRemote)
                            world.spawnEntityInWorld(creepsentityray);
                    }
                }
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = world.getClosestPlayerToEntity(this, 20D);

        if (entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        }
        else
        {
            return null;
        }
    }

    /**
     * Plays living's sound at its position
     */
    @Override
    public void playLivingSound()
    {
        SoundEvent sound = getAmbientSound();

        if (sound != null)
        {
            world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, sound, this.getSoundCategory(), getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F + (1.0F - modelsize) * 2.0F);
        }
    }

    @Override
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.HOSTILE;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.FLOOB;
    }

    @Override
    protected SoundEvent getHurtSound()
    {
        return Sounds.FLOOB_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.FLOOB_DEATH;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(posX);
        int j = MathHelper.floor(getCollisionBoundingBox().minY);
        int k = MathHelper.floor(posZ);
        Block block = world.getBlockState(new BlockPos(i, j - 1, k)).getBlock();
        return block != Blocks.COBBLESTONE && block != Blocks.LOG && block != Blocks.STONE_SLAB && block != Blocks.DOUBLE_STONE_SLAB && block != Blocks.PLANKS && block != Blocks.WOOL && world.getCollisionBoxes(this, getCollisionBoundingBox()).size() == 0 && world.canSeeSky(new BlockPos(i, j, k)) && rand.nextInt(5) == 0;// && l > 10;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    @Override
    public ItemStack getHeldItemMainhand()
    {
        return heldObj;
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        Object obj = damagesource.getEntity();

        EntityPlayer player = (EntityPlayer) damagesource.getEntity();

        if ((obj instanceof EntityRocket) && ((EntityRocket) obj).owner != null)
        {
            obj = ((EntityRocket) obj).owner;
        }

        if (obj instanceof EntityPlayer)
        {
            EntityStats.floobcount++;

            if (!((EntityPlayerMP) player).getStatFile().hasAchievementUnlocked(MoreCreepsAndWeirdos.achievements.getAchievement("floobkill")))
            {
                this.world.playSound(null, this.posX, this.posY, this.posZ, Sounds.ACHIEVEMENT, SoundCategory.AMBIENT, 1.0F, 1.0F);

                MoreCreepsAndWeirdos.achievements.issueAchievement(player, "floobkill");

                if (!world.isRemote)
                {
                    double d = -MathHelper.sin((player.rotationYaw * (float) Math.PI) / 180F);
                    double d1 = MathHelper.cos((player.rotationYaw * (float) Math.PI) / 180F);
                    EntityTrophy entityTrophy = new EntityTrophy(world);
                    entityTrophy.setLocationAndAngles(player.posX + d * 3D, player.posY - 2D, player.posZ + d1 * 3D, player.rotationYaw, 0.0F);
                    world.spawnEntityInWorld(entityTrophy);
                }
            }

            if (!((EntityPlayerMP) player).getStatFile().hasAchievementUnlocked(MoreCreepsAndWeirdos.achievements.getAchievement("floobicide")) && EntityStats.floobcount >= 20)
            {
                this.world.playSound(null, this.posX, this.posY, this.posZ, Sounds.ACHIEVEMENT, SoundCategory.AMBIENT, 1.0F, 1.0F);

                MoreCreepsAndWeirdos.achievements.issueAchievement(player, "floobicide");

                if (!world.isRemote)
                {
                    double d = -MathHelper.sin((player.rotationYaw * (float) Math.PI) / 180F);
                    double d1 = MathHelper.cos((player.rotationYaw * (float) Math.PI) / 180F);
                    EntityTrophy entityTrophy = new EntityTrophy(world);
                    entityTrophy.setLocationAndAngles(player.posX + d * 3D, player.posY - 2D, player.posZ + d1 * 3D, player.rotationYaw, 0.0F);
                    world.spawnEntityInWorld(entityTrophy);
                }
            }
        }

        if (rand.nextInt(6) == 0)
        {
            dropItem(MoreCreepsAndWeirdos.rayGun, 1);
        }

        super.onDeath(damagesource);
    }
}
