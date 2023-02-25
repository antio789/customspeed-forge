package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.world.entity.animal.Fox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Fox.FoxBreedGoal.class)
public abstract class foxtimer {

    @ModifyArg(method="breed",at= @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/animal/Animal;setAge(I)V"),index = 0)
    private int init(int par1){
        if(par1==6000) return ModConfig.getAnimal_adult();
        else {
            System.out.println("animal baby got through "+ModConfig.getAnimal_baby());
            return ModConfig.getAnimal_baby();
        }
    }
    @ModifyArg(method="breed",at= @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/animal/Fox;setAge(I)V"),index = 0)
    private int init2(int par1){
        if(par1==-24000){
            return ModConfig.getAnimal_baby();
        }
         return par1;
    }
}
