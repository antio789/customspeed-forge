package antio789.customspeed;


import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.IntegerValue;
import net.minecraft.world.level.GameRules.Key;
import net.minecraft.world.level.GameRules.Type;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Method;

public class createrule {
    public static Key<IntegerValue> createint(String id, Category cat, int defaultVal) {
        try {
            Method m = ObfuscationReflectionHelper.findMethod(IntegerValue.class, "m_46312_", int.class);

            Type<IntegerValue> ruleTypeint = (Type<IntegerValue>) m.invoke(null, defaultVal);
            Key<IntegerValue> rule = GameRules.register(id, cat, ruleTypeint);
            return rule;
        }
        catch (Exception e) {
            Customspeed.LOGGER.error("Create gamerule error", e);
        }
        return null;
    }
}
