package buckman.morecreepsandweirdos.items.armor;

import buckman.morecreepsandweirdos.library.MoreCreepsRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCreepsZebraArmor extends ItemArmor
{
    public ItemCreepsZebraArmor(ArmorMaterial armorMaterialIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(armorMaterialIn, 5, equipmentSlotIn);
        this.setCreativeTab(MoreCreepsRegistry.tabGeneral);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        return "mcawrb:textures/armor/zebra_armor" + (slot == EntityEquipmentSlot.LEGS ? "_leggings" : "") + ".png";
    }
}
