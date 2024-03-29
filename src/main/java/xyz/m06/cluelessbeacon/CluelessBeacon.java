package xyz.m06.cluelessbeacon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.fabricmc.loader.impl.util.log.LogLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CluelessBeacon implements ModInitializer {
    public static String MOD_ID = "cluelessbeacon";
    public static final TagKey<Block> CLUELESSBEACON_BASE_BLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation("cluelessbeacon", "cluelessbeacon_base_blocks"));

    @Override
    public void onInitialize() {
        Log.log(LogLevel.INFO, LogCategory.create("m_06"), "hi");
    }
}
