package xyz.m06.cluelessbeacon.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.m06.cluelessbeacon.CluelessBeacon;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntityMixin {
    @Inject(method = "updateBase", at = @At("HEAD"), cancellable = true)
    private static void updateBase(Level world, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
        if (isClueless(world, x, y, z) && !world.isClientSide()) {
            world.explode(null, x, y, z, 20, Explosion.BlockInteraction.BREAK);
            cir.setReturnValue(0);
        }
    }

    //copypaste some beacon updateLevel code here and "simplify" it
    @Unique
    private static boolean isClueless(Level world, int x, int y, int z) {
        int oneLmao = 1; //it's one
        int scanY = y - oneLmao;

        if (scanY < world.getMinBuildHeight()) return false;

        for (int scanX = x - oneLmao; scanX <= x + oneLmao; ++scanX) {
            for (int scanZ = z - oneLmao; scanZ <= z + oneLmao; ++scanZ) {
                if (!world.getBlockState(new BlockPos(scanX, scanY, scanZ)).is(CluelessBeacon.CLUELESSBEACON_BASE_BLOCKS)) return false;
            }
        }

        return true;
    }
}
