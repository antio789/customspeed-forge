package antio789.customspeed;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

public class clientevent {
    public static final String Key_help="key.customspeed.help";
    public static final String Key_category="category.customspeed.help";
    public static KeyMapping help;
    @Mod.EventBusSubscriber(modid=Customspeed.modid,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class fmlevents {
        @SubscribeEvent
        public static void registerkey(FMLClientSetupEvent event) {
            help = new KeyMapping(Key_help, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, Key_category);

        }
    }
    @Mod.EventBusSubscriber(modid=Customspeed.modid,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class forgeevents {
        @SubscribeEvent
        public static void input(InputEvent event) {
            if (help.consumeClick()) {
                assert Minecraft.getInstance().player != null;
                Minecraft.getInstance().player.displayClientMessage(Component.translatable(Customspeed.modid + ".config.use"), false);
            }
        }
    }


}
