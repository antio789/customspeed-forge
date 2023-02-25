package antio789.customspeed.config;


import antio789.customspeed.Customspeed;
import antio789.customspeed.createrule;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;


import java.util.Map;

public class ModConfig {
    public ModConfig(){
    }


    private static final int villager_adult = 150;
    private static final int villager_baby = 600;
    private static final int animal_adult = 150;
    private static final int animal_baby = 600;
    private static final int spawnerspeed = 20;

    public static int getMinspawndelay() {
        return (getspeed(Spawnerspeed)/2)*20;
    }

    public static int getMaxspawndelay() {
        return (getspeed(Spawnerspeed)*2)*20;
    }

    public static int getVillager_adult() { return getspeed(Villager_breed)*20;
    }

    public static int getVillager_baby() {
        return -getspeed(Villager_baby)*20;
    }

    public static int getAnimal_adult() {
        return getspeed(Animal_breed)*20;
    }

    public static int getAnimal_baby() {
        return -getspeed(Animal_baby)*20;
    }

    public static final GameRules.Key<GameRules.IntegerValue> Villager_breed = createrule.createint(Customspeed.modid+".adultVillagerbreed_150", GameRules.Category.MOBS, villager_adult);
    public static final GameRules.Key<GameRules.IntegerValue> Villager_baby = createrule.createint(Customspeed.modid+".babyVillagergrowup_600", GameRules.Category.MOBS, villager_baby);
    public static final GameRules.Key<GameRules.IntegerValue> Animal_breed = createrule.createint(Customspeed.modid+".adultAnimalbreed_150", GameRules.Category.MOBS, animal_adult);
    public static final GameRules.Key<GameRules.IntegerValue> Animal_baby = createrule.createint(Customspeed.modid+".babyAnimalgrowup_600", GameRules.Category.MOBS, animal_baby);
    public static final GameRules.Key<GameRules.IntegerValue> Spawnerspeed = createrule.createint(Customspeed.modid+".Spawnerspeed_20", GameRules.Category.MOBS, spawnerspeed);

    public static GameRules getRule(){
        return Customspeed.world.getGameRules();
    }
    public static int getspeed(GameRules.Key<GameRules.IntegerValue> rule){
        if(Customspeed.world==null||getRule().getInt(rule)<1){
            System.out.println("world ,not loaded properly");

            return defaults.get(rule);
        }
        return getRule().getInt(rule);
    }




    private static final Map<GameRules.Key, Integer> defaults = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(Villager_breed,villager_adult);
        hashMap.put(Villager_baby, villager_baby);
        hashMap.put(Animal_breed,animal_adult);
        hashMap.put(Animal_baby,animal_baby);
        hashMap.put(Spawnerspeed,spawnerspeed);
    });


/** gamerules work only on int and bool unfortunately this would be for later
    private enum GameSpeed{
        VERY_FAST,
        FAST,
        NORMAL,
        SLOW,
        VERY_SLOW
    }

    private static final Map<GameSpeed, Double> CONFIGSPEED = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(GameSpeed.VERY_FAST,0.25);
        hashMap.put(GameSpeed.FAST, 0.5);
        hashMap.put(GameSpeed.NORMAL, 1.0);
        hashMap.put(GameSpeed.SLOW,2.0);
        hashMap.put(GameSpeed.VERY_SLOW,4.0);
    });
*/


    public static void init() {
    }


}
