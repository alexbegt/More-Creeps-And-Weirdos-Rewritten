package buckman.morecreepsandweirdos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.Subscribe;

import buckman.morecreepsandweirdos.common.CommonProxy;
import buckman.morecreepsandweirdos.common.MoreCreepsAchievements;
import buckman.morecreepsandweirdos.common.MoreCreepsHelper;
import buckman.morecreepsandweirdos.common.config.Config;
import buckman.morecreepsandweirdos.items.ItemMetaDynamic;
import buckman.morecreepsandweirdos.items.armor.ItemCreepsZebraArmor;
import buckman.morecreepsandweirdos.items.weapon.ItemCreepsArmSword;
import buckman.morecreepsandweirdos.library.MoreCreepsRegistry;
import buckman.morecreepsandweirdos.library.Util;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoreCreepsAndWeirdos.modID, name = MoreCreepsAndWeirdos.modName, version = MoreCreepsAndWeirdos.modVersion, dependencies = "required-after:Forge@[12.18.0.1993,)", acceptedMinecraftVersions = "[1.8, 1.11)")
public class MoreCreepsAndWeirdos extends MoreCreepsHelper
{
    public static final String modID = Util.MODID;

    public static final String modVersion = "${version}";

    public static final String modName = "More Creeps And Weirdos REWRITTEN";

    public static final Logger log = LogManager.getLogger(modID);

    /* Instance of this mod, used for grabbing prototype fields */
    @Instance(modID)
    public static MoreCreepsAndWeirdos instance;

    @SidedProxy(clientSide = "buckman.morecreepsandweirdos.common.ClientProxy", serverSide = "buckman.morecreepsandweirdos.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Config.load(event);

        particles = registerItem(new ItemMetaDynamic(), "particles");
        achievementsIcons = registerItem(new ItemMetaDynamic(), "achievements");

        particles.setCreativeTab(MoreCreepsRegistry.tabGeneral);
        achievementsIcons.setCreativeTab(MoreCreepsRegistry.tabGeneral);

        particleBubble = particles.addMeta(0, "particle_bubble");
        particleSmoke = particles.addMeta(1, "particle_smoke");
        particleRed = particles.addMeta(2, "particle_red");
        particleBlack = particles.addMeta(3, "particle_black");
        particleYellow = particles.addMeta(4, "particle_yellow");
        particleBlue = particles.addMeta(5, "particle_blue");
        particleShrink = particles.addMeta(6, "particle_shrink");
        particleBarf = particles.addMeta(7, "particle_barf");

        achievementPig = achievementsIcons.addMeta(0, "achievement_pig");
        achievementPyramid = achievementsIcons.addMeta(1, "achievement_pyramid");
        achievementFloob = achievementsIcons.addMeta(2, "achievement_floob");
        achievementRockMonster = achievementsIcons.addMeta(3, "achievement_rockmonster");
        achievementBubble = achievementsIcons.addMeta(4, "achievement_bubble");
        achievementHotdog = achievementsIcons.addMeta(5, "achievement_hotdog");
        achievementCamel = achievementsIcons.addMeta(6, "achievement_camel");
        achievementZebra = achievementsIcons.addMeta(7, "achievement_zebra");
        achievementNonswimmer = achievementsIcons.addMeta(8, "achievement_nonswimmer");
        achievementCaveman = achievementsIcons.addMeta(9, "achievement_caveman");

        ArmorMaterial zebraMaterial = EnumHelper.addArmorMaterial("Zebra", "mcawrb:zebraArmor", 25, new int[] { 2, 6, 4, 2 }, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);

        zebraHelmet = registerItem(new ItemCreepsZebraArmor(zebraMaterial, EntityEquipmentSlot.HEAD), "zebra_armor_helmet");
        zebraChestplate = registerItem(new ItemCreepsZebraArmor(zebraMaterial, EntityEquipmentSlot.CHEST), "zebra_armor_chestplate");
        zebraLeggings = registerItem(new ItemCreepsZebraArmor(zebraMaterial, EntityEquipmentSlot.LEGS), "zebra_armor_leggings");
        zebraBoots = registerItem(new ItemCreepsZebraArmor(zebraMaterial, EntityEquipmentSlot.FEET), "zebra_armor_boots");

        armSword = registerItem(new ItemCreepsArmSword(), "arm_sword");

        proxy.preInit();

        achievements = new MoreCreepsAchievements();

        MoreCreepsRegistry.tabGeneral.setDisplayIcon(achievementFloob);
    }

    @Subscribe
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    //@formatter:off
    public static MoreCreepsAchievements achievements;
    // Items
    public static ItemMetaDynamic particles;
    public static ItemStack particleBubble;
    public static ItemStack particleSmoke;
    public static ItemStack particleRed;
    public static ItemStack particleBlack;
    public static ItemStack particleYellow;
    public static ItemStack particleBlue;
    public static ItemStack particleShrink;
    public static ItemStack particleBarf;
    
    public static ItemMetaDynamic achievementsIcons;
    public static ItemStack achievementPig;
    public static ItemStack achievementPyramid;
    public static ItemStack achievementFloob;
    public static ItemStack achievementRockMonster;
    public static ItemStack achievementBubble;
    public static ItemStack achievementHotdog;
    public static ItemStack achievementCamel;
    public static ItemStack achievementZebra;
    public static ItemStack achievementNonswimmer;
    public static ItemStack achievementCaveman;
    
    public static Item zebraHelmet;
    public static Item zebraChestplate;
    public static Item zebraLeggings;
    public static Item zebraBoots;
    
    public static Item armSword;
    public static Item rayGun;
    //@formatter:on

}
