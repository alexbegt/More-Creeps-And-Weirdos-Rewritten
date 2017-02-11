package buckman.morecreepsandweirdos.shared.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleConfetti extends Particle
{
    public ParticleConfetti(World worldIn, double posXIn, double posYIn, double posZIn, Item itemIn, int meta)
    {
        super(worldIn, posXIn, posYIn, posZIn, 0.0D, 0.0D, 0.0D);

        this.setSize(0.5F, 0.5F);

        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(itemIn, meta));

        this.particleRed = 1.0F;
        this.particleBlue = 1.0F;
        this.particleGreen = 1.0F;
        this.particleGravity = 1.0F;
        this.particleScale = 2.0F;
        this.particleMaxAge = 55;
    }

    @Override
    public int getFXLayer()
    {
        return 2;
    }

    @Override
    public void renderParticle(VertexBuffer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        float f6 = this.particleTextureIndexX / 16.0F;
        float f7 = f6 + 0.01560938F;
        float f8 = this.particleTextureIndexY / 16.0F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * this.particleScale;

        if (this.particleTexture != null)
        {
            f6 = this.particleTexture.getMinU();
            f7 = this.particleTexture.getMaxU();
            f8 = this.particleTexture.getMinV();
            f9 = this.particleTexture.getMaxV();
        }

        float f11 = (float) (this.prevPosX + (this.posX - this.prevPosX) * partialTicks - interpPosX);
        float f12 = (float) (this.prevPosY + (this.posY - this.prevPosY) * partialTicks - interpPosY);
        float f13 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - interpPosZ);

        worldRendererIn.pos((f11 - rotationX * f10 - rotationXY * f10), (f12 - rotationZ * f10), (f13 - rotationYZ * f10 - rotationXZ * f10)).tex(f7, f9).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        worldRendererIn.pos((f11 - rotationX * f10 + rotationXY * f10), (f12 + rotationZ * f10), (f13 - rotationYZ * f10 + rotationXZ * f10)).tex(f7, f8).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        worldRendererIn.pos((f11 + rotationX * f10 + rotationXY * f10), (f12 + rotationZ * f10), (f13 + rotationYZ * f10 + rotationXZ * f10)).tex(f6, f8).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        worldRendererIn.pos((f11 + rotationX * f10 - rotationXY * f10), (f12 - rotationZ * f10), (f13 + rotationYZ * f10 - rotationXZ * f10)).tex(f6, f9).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
    }
}
