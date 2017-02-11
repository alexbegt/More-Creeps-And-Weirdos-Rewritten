package buckman.morecreepsandweirdos.common.config;

import org.apache.logging.log4j.Logger;

import buckman.morecreepsandweirdos.library.Util;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Config
{
    public static Config instance = new Config();

    public static Logger log = Util.getLogger("Config");

    private static final String ENABLE_DISABLE = "ENABLE-DISABLE";

    private static final String WORLDGEN = "Worldgen";

    private static final String MOB_CHANGES = "Mob-Changes";

    private Config()
    {
    }

    public static void load(FMLPreInitializationEvent event)
    {
        configFile = new Configuration(event.getSuggestedConfigurationFile(), "0.2", false);
        configFile.load();

        syncConfig();
        applySpawnLimit();
    }

    public static boolean syncConfig()
    {
        unlimitedSpawn = configFile.get(ENABLE_DISABLE, "Unlimited spawning values for mobs", unlimitedSpawn).getBoolean(unlimitedSpawn);

        spawnNumberArmyGuy = configFile.get(MOB_CHANGES, "Number of Army Guys that can spawn", spawnNumberArmyGuy).getInt(spawnNumberArmyGuy);
        spawnNumberBabyMummy = configFile.get(MOB_CHANGES, "Number of Baby Mummys that can spawn", spawnNumberBabyMummy).getInt(spawnNumberBabyMummy);
        spawnNumberBigBaby = configFile.get(MOB_CHANGES, "Number of Big Babies that can spawn", spawnNumberBigBaby).getInt(spawnNumberBigBaby);
        spawnNumberBlackSoul = configFile.get(MOB_CHANGES, "Number of Black Souls that can spawn", spawnNumberBlackSoul).getInt(spawnNumberBlackSoul);
        spawnNumberBlorp = configFile.get(MOB_CHANGES, "Number of Blorps that can spawn", spawnNumberBlorp).getInt(spawnNumberBlorp);
        spawnNumberBubbleScum = configFile.get(MOB_CHANGES, "Number of Bubble Scums that can spawn", spawnNumberBubbleScum).getInt(spawnNumberBubbleScum);
        spawnNumberBum = configFile.get(MOB_CHANGES, "Number of Bums that can Spawn (NickNamed George)", spawnNumberBum).getInt(spawnNumberBum);
        spawnNumberCamel = configFile.get(MOB_CHANGES, "Number of Camels that can spawn", spawnNumberCamel).getInt(spawnNumberCamel);
        spawnNumberCamelJockey = configFile.get(MOB_CHANGES, "Number of Camel Jockies that can spawn", spawnNumberCamelJockey).getInt(spawnNumberCamelJockey);
        spawnNumberCaveman = configFile.get(MOB_CHANGES, "Number of Cavemen that can spawn", spawnNumberCaveman).getInt(spawnNumberCaveman);
        spawnNumbeDesertLizard = configFile.get(MOB_CHANGES, "Number of Desert Lizards that can spawn", spawnNumbeDesertLizard).getInt(spawnNumbeDesertLizard);
        spawnNumberDigBug = configFile.get(MOB_CHANGES, "Number of Dig Bugs that can spawn", spawnNumberDigBug).getInt(spawnNumberDigBug);
        spawnNumberEvilScientist = configFile.get(MOB_CHANGES, "Number of Evil Scientists that can spawn", spawnNumberEvilScientist).getInt(spawnNumberEvilScientist);
        spawnNumberFloob = configFile.get(MOB_CHANGES, "Number of Floobs that can spawn", spawnNumberFloob).getInt(spawnNumberFloob);
        spawnNumberFloobShip = configFile.get(MOB_CHANGES, "Number of Floob Shipss that can spawn", spawnNumberFloobShip).getInt(spawnNumberFloobShip);
        spawnNumberLetterG = configFile.get(MOB_CHANGES, "Number of Letter Gs that can spawn", spawnNumberLetterG).getInt(spawnNumberLetterG);
        spawnNumberGooGoats = configFile.get(MOB_CHANGES, "Number of Goo Goats that can spawn", spawnNumberGooGoats).getInt(spawnNumberGooGoats);
        spawnNumberGuineaPig = configFile.get(MOB_CHANGES, "Number of Guinea Pigs that can spawn", spawnNumberGuineaPig).getInt(spawnNumberGuineaPig);
        spawnNumberHippo = configFile.get(MOB_CHANGES, "Number of Hippos that can spawn", spawnNumberHippo).getInt(spawnNumberHippo);
        spawnNumberHorseHead = configFile.get(MOB_CHANGES, "Number of Horese Heads that can spawn", spawnNumberHorseHead).getInt(spawnNumberHorseHead);
        spawnNumberHotDog = configFile.get(MOB_CHANGES, "Number of Hot Dogs that can spawn", spawnNumberHotDog).getInt(spawnNumberHotDog);
        spawnNumberHunchback = configFile.get(MOB_CHANGES, "Number of Hunchbacks that can spawn", spawnNumberHunchback).getInt(spawnNumberHunchback);
        spawnNumberInvisibleMan = configFile.get(MOB_CHANGES, "Number of Invisible Man that can spawn", spawnNumberInvisibleMan).getInt(spawnNumberInvisibleMan);
        spawnNumberKid = configFile.get(MOB_CHANGES, "Number of Kids that can spawn", spawnNumberKid).getInt(spawnNumberKid);
        spawnNumberLawyerFromHell = configFile.get(MOB_CHANGES, "Number of Lawyers that can spawn", spawnNumberLawyerFromHell).getInt(spawnNumberLawyerFromHell);
        spawnNumberLoliMan = configFile.get(MOB_CHANGES, "Number of LoliMans that can spawn", spawnNumberLoliMan).getInt(spawnNumberLoliMan);
        spawnNumberManDog = configFile.get(MOB_CHANGES, "Number of Man Dogs that can spawn", spawnNumberManDog).getInt(spawnNumberManDog);
        spawnNumberMummy = configFile.get(MOB_CHANGES, "Number of Mummys that can spawn", spawnNumberMummy).getInt(spawnNumberMummy);
        spawnNumberNonSwimmer = configFile.get(MOB_CHANGES, "Number of NonSwimmers that can spawn", spawnNumberNonSwimmer).getInt(spawnNumberNonSwimmer);
        spawnNumberPreacher = configFile.get(MOB_CHANGES, "Number of Preachers that can spawn", spawnNumberPreacher).getInt(spawnNumberPreacher);
        spawnNumberRobotTed = configFile.get(MOB_CHANGES, "Number of Robot Teds that can spawn", spawnNumberRobotTed).getInt(spawnNumberRobotTed);
        spawnNumberRobotTodd = configFile.get(MOB_CHANGES, "Number of Robot Todds that can spawn", spawnNumberRobotTodd).getInt(spawnNumberRobotTodd);
        spawnNumberRockMonster = configFile.get(MOB_CHANGES, "Number of Rock Monsters that can spawn", spawnNumberRockMonster).getInt(spawnNumberRockMonster);
        spawnNumberRocketGiraffe = configFile.get(MOB_CHANGES, "Number of Rocket Giraffes that can spawn", spawnNumberRocketGiraffe).getInt(spawnNumberRocketGiraffe);
        spawnNumberSneakySal = configFile.get(MOB_CHANGES, "Number of Sneak Sals that can spawn", spawnNumberSneakySal).getInt(spawnNumberSneakySal);
        spawnNumberSnowDevil = configFile.get(MOB_CHANGES, "Number of Snow Devils that can spawn", spawnNumberSnowDevil).getInt(spawnNumberSnowDevil);
        spawnNumberThief = configFile.get(MOB_CHANGES, "Number of Thiefs that can spawn", spawnNumberThief).getInt(spawnNumberThief);
        spawnNumberZebra = configFile.get(MOB_CHANGES, "Number of Zebras that can spawn", spawnNumberZebra).getInt(spawnNumberZebra);

        generatePyramid = configFile.get(ENABLE_DISABLE, "Generate Pyramids", generatePyramid).getBoolean(generatePyramid);
        generateCastle = configFile.get(ENABLE_DISABLE, "Generate Castles", generateCastle).getBoolean(generateCastle);
        generateJail = configFile.get(ENABLE_DISABLE, "Generate Jails", generateJail).getBoolean(generateJail);

        pyramidSpawnRarity = configFile.get(WORLDGEN, "Pyramid Spawn Rarity", pyramidSpawnRarity).getInt(pyramidSpawnRarity);
        castleSpawnRange = configFile.get(WORLDGEN, "Castle Spawn Rarity", castleSpawnRange).getInt(castleSpawnRange);

        rayGunFire = configFile.get(ENABLE_DISABLE, "Enable Ray Gun replacing blocks with fire/lava", rayGunFire).getBoolean(rayGunFire);
        rayGunMelt = configFile.get(ENABLE_DISABLE, "Enable Ray Gun melting blocks Like ice", rayGunMelt).getBoolean(rayGunMelt);
        enableFloobshipExplosion = configFile.get(ENABLE_DISABLE, "Allow Floob ship Explosions", enableFloobshipExplosion).getBoolean(enableFloobshipExplosion);
        enableBumPublicUrination = configFile.get(ENABLE_DISABLE, "Allow Bum Public Urination ", enableBumPublicUrination).getBoolean(enableBumPublicUrination);
        enableBlood = configFile.get(ENABLE_DISABLE, "Enable Blood Particles", enableBlood).getBoolean(enableBlood);

        blorpMaxSize = configFile.get(MOB_CHANGES, "Max Size of Blorp", blorpMaxSize).getInt(blorpMaxSize);

        // save changes if any
        boolean changed = false;
        if (configFile.hasChanged())
        {
            configFile.save();
            changed = true;
        }
        return changed;
    }

    public static void applySpawnLimit()
    {
        if (!unlimitedSpawn)
        {
            if (spawnNumberArmyGuy < 0 || spawnNumberArmyGuy > 12)
            {
                spawnNumberArmyGuy = 5;
            }

            if (spawnNumberBabyMummy < 0 || spawnNumberBabyMummy > 12)
            {
                spawnNumberBabyMummy = 8;
            }

            if (spawnNumberBigBaby < 0 || spawnNumberBigBaby > 12)
            {
                spawnNumberBigBaby = 6;
            }

            if (spawnNumberBlackSoul < 0 || spawnNumberBlackSoul > 12)
            {
                spawnNumberBlackSoul = 5;
            }

            if (spawnNumberBlorp < 0 || spawnNumberBlorp > 12)
            {
                spawnNumberBlorp = 8;
            }

            if (spawnNumberBubbleScum < 0 || spawnNumberBubbleScum > 12)
            {
                spawnNumberBubbleScum = 8;
            }

            if (spawnNumberBum < 0 || spawnNumberBum > 12)
            {
                spawnNumberBum = 8;
            }

            if (spawnNumberCamel < 0 || spawnNumberCamel > 12)
            {
                spawnNumberCamel = 8;
            }

            if (spawnNumberCamelJockey < 0 || spawnNumberCamelJockey > 12)
            {
                spawnNumberCamelJockey = 6;
            }

            if (spawnNumberCaveman < 0 || spawnNumberCaveman > 12)
            {
                spawnNumberCaveman = 5;
            }

            if (spawnNumbeDesertLizard < 0 || spawnNumbeDesertLizard > 12)
            {
                spawnNumbeDesertLizard = 8;
            }

            if (spawnNumberDigBug < 0 || spawnNumberDigBug > 12)
            {
                spawnNumberDigBug = 7;
            }

            if (spawnNumberEvilScientist < 0 || spawnNumberEvilScientist > 12)
            {
                spawnNumberEvilScientist = 8;
            }

            if (spawnNumberFloob < 0 || spawnNumberFloob > 12)
            {
                spawnNumberFloob = 7;
            }

            if (spawnNumberFloobShip < 0 || spawnNumberFloobShip > 12)
            {
                spawnNumberFloobShip = 2;
            }

            if (spawnNumberLetterG < 0 || spawnNumberLetterG > 12)
            {
                spawnNumberLetterG = 8;
            }

            if (spawnNumberGooGoats < 0 || spawnNumberGooGoats > 12)
            {
                spawnNumberGooGoats = 8;
            }

            if (spawnNumberGuineaPig < 0 || spawnNumberGuineaPig > 12)
            {
                spawnNumberGuineaPig = 8;
            }

            if (spawnNumberHippo < 0 || spawnNumberHippo > 12)
            {
                spawnNumberHippo = 8;
            }

            if (spawnNumberHorseHead < 0 || spawnNumberHorseHead > 12)
            {
                spawnNumberHorseHead = 8;
            }

            if (spawnNumberHotDog < 0 || spawnNumberHotDog > 12)
            {
                spawnNumberHotDog = 8;
            }

            if (spawnNumberHunchback < 0 || spawnNumberHunchback > 12)
            {
                spawnNumberHunchback = 8;
            }

            if (spawnNumberInvisibleMan < 0 || spawnNumberInvisibleMan > 12)
            {
                spawnNumberInvisibleMan = 8;
            }

            if (spawnNumberKid < 0 || spawnNumberKid > 12)
            {
                spawnNumberKid = 5;
            }

            if (spawnNumberLawyerFromHell < 0 || spawnNumberLawyerFromHell > 12)
            {
                spawnNumberLawyerFromHell = 8;
            }

            if (spawnNumberLoliMan < 0 || spawnNumberLoliMan > 12)
            {
                spawnNumberLoliMan = 3;
            }

            if (spawnNumberManDog < 0 || spawnNumberManDog > 12)
            {
                spawnNumberManDog = 8;
            }

            if (spawnNumberMummy < 0 || spawnNumberMummy > 12)
            {
                spawnNumberMummy = 5;
            }

            if (spawnNumberNonSwimmer < 0 || spawnNumberNonSwimmer > 12)
            {
                spawnNumberNonSwimmer = 6;
            }

            if (spawnNumberPreacher < 0 || spawnNumberPreacher > 12)
            {
                spawnNumberPreacher = 7;
            }

            if (spawnNumberRobotTed < 0 || spawnNumberRobotTed > 12)
            {
                spawnNumberRobotTed = 8;
            }

            if (spawnNumberRobotTodd < 0 || spawnNumberRobotTodd > 12)
            {
                spawnNumberRobotTodd = 8;
            }

            if (spawnNumberRockMonster < 0 || spawnNumberRockMonster > 12)
            {
                spawnNumberRockMonster = 8;
            }

            if (spawnNumberRocketGiraffe < 0 || spawnNumberRocketGiraffe > 12)
            {
                spawnNumberRocketGiraffe = 7;
            }

            if (spawnNumberSneakySal < 0 || spawnNumberSneakySal > 12)
            {
                spawnNumberSneakySal = 6;
            }

            if (spawnNumberSnowDevil < 0 || spawnNumberSnowDevil > 12)
            {
                spawnNumberSnowDevil = 8;
            }

            if (spawnNumberThief < 0 || spawnNumberThief > 12)
            {
                spawnNumberThief = 8;
            }

            if (spawnNumberZebra < 0 || spawnNumberZebra > 12)
            {
                spawnNumberZebra = 8;
            }
            if (pyramidSpawnRarity < 1 || pyramidSpawnRarity > 10)
            {
                pyramidSpawnRarity = 5;
            }
            if (castleSpawnRange < 1 || castleSpawnRange > 10)
            {
                castleSpawnRange = 5;
            }
            if (blorpMaxSize < 6 || blorpMaxSize > 99)
            {
                blorpMaxSize = 6;
            }
        }
    }

    //@formatter:off
    public static int spawnNumberArmyGuy = 5;
    public static int spawnNumberBabyMummy = 8;
    public static int spawnNumberBigBaby = 6;
    public static int spawnNumberBlackSoul = 5;

    public static int spawnNumberBlorp = 8;
    public static int spawnNumberBubbleScum = 8;
    public static int spawnNumberBum = 8;
    public static int spawnNumberCamel = 8;

    public static int spawnNumberCamelJockey = 6;
    public static int spawnNumberCaveman = 5;
    public static int spawnNumbeDesertLizard = 8;
    public static int spawnNumberDigBug = 7;

    public static int spawnNumberEvilScientist = 8;
    public static int spawnNumberFloob = 7;
    public static int spawnNumberFloobShip = 2;
    public static int spawnNumberLetterG = 8;

    public static int spawnNumberGooGoats = 8;
    public static int spawnNumberGuineaPig = 8;
    public static int spawnNumberHippo = 8;
    public static int spawnNumberHorseHead = 8;

    public static int spawnNumberHotDog = 8;
    public static int spawnNumberHunchback = 8;
    public static int spawnNumberInvisibleMan = 8;
    public static int spawnNumberKid = 5;

    public static int spawnNumberLawyerFromHell = 8;
    public static int spawnNumberLoliMan = 3;
    public static int spawnNumberManDog = 8;
    public static int spawnNumberMummy = 5;

    public static int spawnNumberNonSwimmer = 6;
    public static int spawnNumberPreacher = 8;
    public static int spawnNumberRobotTed = 8;
    public static int spawnNumberRobotTodd = 8;

    public static int spawnNumberRockMonster = 8;
    public static int spawnNumberRocketGiraffe = 7;
    public static int spawnNumberSneakySal = 8;
    public static int spawnNumberSnowDevil = 8;

    public static int spawnNumberThief = 8;
    public static int spawnNumberZebra = 8;

    public static boolean generatePyramid = true;
    public static boolean generateCastle = true;
    public static boolean generateJail = true;

    public static int pyramidSpawnRarity = 5;
    public static int castleSpawnRange = 5;

    public static boolean rayGunFire = false;
    public static boolean rayGunMelt = false;
    public static boolean enableFloobshipExplosion = true;
    public static boolean enableBumPublicUrination = true;

    public static boolean enableBlood = true;

    public static int blorpMaxSize = 6;

    public static boolean unlimitedSpawn = true;
    
   //dood
    
    static Configuration configFile;
    //@formatter:on
}
