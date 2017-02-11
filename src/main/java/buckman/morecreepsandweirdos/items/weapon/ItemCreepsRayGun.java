package buckman.morecreepsandweirdos.items.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCreepsRayGun extends Item
{
    public ItemCreepsRayGun()
    {
        super();

        this.setMaxStackSize(1);
        this.setMaxDamage(64);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
    }
}
