package buckman.morecreepsandweirdos.common;

import java.util.Locale;

import buckman.morecreepsandweirdos.library.Util;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

public abstract class MoreCreepsHelper
{
    /**
     * Sets the correct unlocalized name and registers the item.
     */
    protected static <T extends Item> T registerItem(T item, String name)
    {
        if (!name.equals(name.toLowerCase(Locale.US)))
        {
            throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", name));
        }

        item.setUnlocalizedName(Util.prefix(name));
        item.setRegistryName(Util.getResource(name));
        GameRegistry.register(item);
        return item;
    }

    protected static <T extends IForgeRegistryEntry<?>> T register(T thing, String name)
    {
        thing.setRegistryName(Util.getResource(name));
        GameRegistry.register(thing);
        return thing;
    }
}
