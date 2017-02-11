package buckman.morecreepsandweirdos.common;

import java.util.HashMap;

import buckman.morecreepsandweirdos.MoreCreepsAndWeirdos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class MoreCreepsAchievements
{
    public HashMap<String, Achievement> achievementList;

    public MoreCreepsAchievements()
    {
        this.achievementList = new HashMap<String, Achievement>();

        registerAchievement("zebra", 8, 2, MoreCreepsAndWeirdos.achievementZebra, AchievementList.OPEN_INVENTORY, false);

        AchievementPage.registerAchievementPage(new AchievementPage("More Creeps And Weirdos Rebooted", this.achievementList.values().toArray(new Achievement[this.achievementList.size()])));

        /*
        achievementFrisbee = new Achievement("frisbee", "frisbee", aX, aY, frisbee, null).registerStat();
        achievementchugcola = new Achievement("chugcola", "chugcola", aX + 2, aY, blorpcola, null).registerStat();
        achievementRadio = new Achievement("guineapigradio", "guineapigradio", aX + 4, aY, guineapigradio, null).registerStat();
        achievementpyramid = new Achievement("pyramid", "pyramid", aX + 6, aY, MoreCreepsAndWeirdos.achievementPyramid, null).registerStat();
        achievementlolliman = new Achievement("lolliman", "lolliman", aX + 8, aY, lolly, null).registerStat();
        achievementsnowdevil = new Achievement("snowdevil", "snowdevil", aX + 2, aY + 2, Blocks.ICE, null).registerStat();
        achievementhunchback = new Achievement("hunchback", "hunchback", aX + 4, aY + 2, Items.CAKE, null).registerStat();
        achievementcamel = new Achievement("camel", "camel", aX + 6, aY + 2, MoreCreepsAndWeirdos.achievementCamel, achievementcamel).registerStat();
        achievementzebra = new Achievement("zebra", "zebra", aX + 8, aY + 2, MoreCreepsAndWeirdos.achievementZebra, achievementzebra).registerStat();
        achievementrockmonster = new Achievement("rockmonster", "rockmonster", aX, aY + 2, MoreCreepsAndWeirdos.achievementRockMonster, null).registerStat();
        achievementschlump = new Achievement("schlump", "schlump", aX, aY + 4, babyjarfull, achievementschlump).registerStat();
        achievementnonswimmer = new Achievement("nonswimmer", "nonswimmer", aX + 2, aY + 4, MoreCreepsAndWeirdos.achievementNonswimmer, achievementnonswimmer).registerStat();
        achievementpigtaming = new Achievement("pigtaming", "pigtaming", aX, aY + 6, MoreCreepsAndWeirdos.achievementPig, null).registerStat();
        achievementpiglevel5 = new Achievement("level5", "level5", aX + 2, aY + 6, MoreCreepsAndWeirdos.achievementPig, achievementpigtaming).registerStat();
        achievementpiglevel10 = new Achievement("level10", "level10", aX + 4, aY + 6, MoreCreepsAndWeirdos.achievementPig, achievementpiglevel5).registerStat();
        achievementpiglevel20 = new Achievement("level20", "level20", aX + 6, aY + 6, MoreCreepsAndWeirdos.achievementPig, achievementpiglevel10).registerStat();
        achievementpighotel = new Achievement("pighotel", "pighotel", aX + 8, aY + 6, MoreCreepsAndWeirdos.achievementPig, achievementpiglevel20).registerStat();
        achievementrocketgiraffe = new Achievement("rocketgiraffe", "rocketgiraffe", aX, aY + 8, rocket, null).registerStat();
        achievementrocket = new Achievement("rocket", "rocket", aX + 2, aY + 8, rocket, achievementrocketgiraffe).registerStat();
        achievementrocketrampage = new Achievement("rocketrampage", "rocketrampage", aX + 4, aY + 8, rocket, achievementrocket).registerStat();
        achievementfloobkill = new Achievement("floobkill", "floobkill", aX, aY + 10, MoreCreepsAndWeirdos.achievementFloob, null).registerStat();
        achievementfloobicide = new Achievement("floobicide", "floobicide", aX + 2, aY + 10, MoreCreepsAndWeirdos.achievementFloob, achievementfloobkill).registerStat();
        achievementgookill = new Achievement("gookill", "gookill", aX, aY + 12, goodonut, null).registerStat();
        achievementgookill10 = new Achievement("gookill10", "gookill10", aX + 2, aY + 12, goodonut, achievementgookill).registerStat();
        achievementgookill25 = new Achievement("gookill25", "gookill25", aX + 4, aY + 12, goodonut, achievementgookill10).registerStat();
        achievementbumflower = new Achievement("bumflower", "bumflower", aX, aY + 14, Blocks.YELLOW_FLOWER, null).registerStat();
        achievementbumpot = new Achievement("bumpot", "bumpot", aX + 2, aY + 14, Items.BUCKET, achievementbumflower).registerStat();
        achievementbumlava = new Achievement("bumlava", "bumlava", aX + 4, aY + 14, Items.LAVA_BUCKET, achievementbumpot).registerStat();
        achievement100bucks = new Achievement("achievement100bucks", "achievement100bucks", aX, aY + 16, money, null).registerStat();
        achievement500bucks = new Achievement("achievement500bucks", "achievement500bucks", aX + 2, aY + 16, money, achievement100bucks).registerStat();
        achievement1000bucks = new Achievement("achievement1000bucks", "achievement1000bucks", aX + 4, aY + 16, money, achievement500bucks).registerStat();
        achievement10bubble = new Achievement("achievement10bubble", "achievement10bubble", aX, aY + 18, MoreCreepsAndWeirdos.achievementBubble, null).registerStat();
        achievement25bubble = new Achievement("achievement25bubble", "achievement25bubble", aX + 2, aY + 18, MoreCreepsAndWeirdos.achievementBubble, achievement10bubble).registerStat();
        achievement50bubble = new Achievement("achievement50bubble", "achievement50bubble", aX + 4, aY + 18, MoreCreepsAndWeirdos.achievementBubble, achievement25bubble).registerStat();
        achievement100bubble = new Achievement("achievement100bubble", "achievement100bubble", aX + 6, aY + 18, MoreCreepsAndWeirdos.achievementBubble, achievement50bubble).registerStat();
        achievementsnow = new Achievement("achievementsnow", "achievementsnow", aX, aY + 20, Items.SNOWBALL, null).registerStat();
        achievementsnowtiny = new Achievement("achievementsnowtiny", "achievementsnowtiny", aX + 2, aY + 20, Items.SNOWBALL, null).registerStat();
        achievementsnowtall = new Achievement("achievementsnowtall", "achievementsnowtall", aX + 4, aY + 20, Items.SNOWBALL, null).registerStat();
        achievementhotdogtaming = new Achievement("hotdogtaming", "hotdogtaming", aX, aY + 22, MoreCreepsAndWeirdos.achievementHotdog, null).registerStat();
        achievementhotdoglevel5 = new Achievement("hotdoglevel5", "level5", aX + 2, aY + 22, MoreCreepsAndWeirdos.achievementHotdog, achievementhotdogtaming).registerStat();
        achievementhotdoglevel10 = new Achievement("hotdoglevel10", "level10", aX + 4, aY + 22, MoreCreepsAndWeirdos.achievementHotdog, achievementhotdoglevel5).registerStat();
        achievementhotdoglevel25 = new Achievement("hotdoglevel25", "level25", aX + 6, aY + 22, MoreCreepsAndWeirdos.achievementHotdog, achievementhotdoglevel10).registerStat();
        achievementhotdogheaven = new Achievement("hotdogheaven", "hotdogheaven", aX + 8, aY + 22, MoreCreepsAndWeirdos.achievementHotdog, achievementhotdoglevel25).registerStat();
        achievementram128 = new Achievement("ram128", "ram128", aX, aY + 24, ram16k, null).registerStat();
        achievementram512 = new Achievement("ram512", "ram512", aX + 2, aY + 24, ram16k, achievementram128).registerStat();
        achievementram1024 = new Achievement("ram1024", "ram1024", aX + 4, aY + 24, ram16k, achievementram512).registerStat();
        achievementGotohell = new Achievement("gotohell", "gotohell", aX, aY + 26, a_hell, null).registerStat();
        achievementfalseidol = new Achievement("falseidol", "falseidol", aX + 2, aY + 26, a_hell, achievementGotohell).registerStat();
        achievementprisoner = new Achievement("achievementprisoner", "achievementprisoner", aX, aY + 28, Blocks.IRON_BARS, null).registerStat();
        achievement5prisoner = new Achievement("achievement5prisoner", "achievement5prisoner", aX + 2, aY + 28, Blocks.IRON_BARS, achievementprisoner).registerStat();
        achievement10prisoner = new Achievement("achievement10prisoner", "achievement10prisoner", aX + 4, aY + 28, Blocks.IRON_BARS, achievement5prisoner).registerStat();
        achievement1caveman = new Achievement("achievement1caveman", "achievement1caveman", aX, aY + 30, MoreCreepsAndWeirdos.achievementCaveman, null).registerStat();
        achievement10caveman = new Achievement("achievement10caveman", "achievement10caveman", aX + 2, aY + 30, MoreCreepsAndWeirdos.achievementCaveman, achievement1caveman).registerStat();
        achievement50caveman = new Achievement("achievement50caveman", "achievement50caveman", aX + 4, aY + 30, MoreCreepsAndWeirdos.achievementCaveman, achievement10caveman).registerStat();*/
    }

    public Achievement registerAchievement(String textId, int x, int y, ItemStack icon, Achievement requirement, boolean special)
    {
        Achievement achievement = new Achievement("mcawrb." + textId, textId, -2 + x, -2 + y, icon, requirement);
        if (special)
        {
            achievement.setSpecial();
        }
        achievement.registerStat();

        this.achievementList.put(textId, achievement);
        return achievement;
    }

    public Achievement registerAchievement(String textId, int x, int y, ItemStack icon, String requirement, boolean special)
    {
        Achievement achievement = new Achievement("mcawrb." + textId, textId, -2 + x, -2 + y, icon, getAchievement(requirement));
        if (special)
        {
            achievement.setSpecial();
        }
        achievement.registerStat();
        this.achievementList.put(textId, achievement);
        return achievement;
    }

    public void issueAchievement(EntityPlayer entityplayer, String textId)
    {
        if (this.achievementList.containsKey(textId))
        {
            entityplayer.addStat(this.achievementList.get(textId));
        }
    }

    public Achievement getAchievement(String textId)
    {
        if (this.achievementList.containsKey(textId))
        {
            return this.achievementList.get(textId);
        }

        return null;
    }
}
