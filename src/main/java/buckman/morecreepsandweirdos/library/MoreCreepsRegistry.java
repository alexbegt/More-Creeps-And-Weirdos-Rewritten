package buckman.morecreepsandweirdos.library;

import buckman.morecreepsandweirdos.common.client.CreativeTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class MoreCreepsRegistry
{
    private MoreCreepsRegistry()
    {
    }

    /*---------------------------------------------------------------------------
    | CREATIVE TABS                                                             |
    ---------------------------------------------------------------------------*/

    public static CreativeTab tabGeneral = new CreativeTab("CreepsGeneral", new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));
}
