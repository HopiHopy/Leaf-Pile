package com.movtery.leafpile;

import com.movtery.leafpile.block.BlockMatching;
import com.movtery.leafpile.block.ModBlocks;
import com.movtery.leafpile.config.Config;
import com.movtery.leafpile.item.ModItemGroups;
import com.movtery.leafpile.item.ModItems;
import com.movtery.leafpile.sound.ModSoundEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LeafPile implements ModInitializer {
    public static String MODID = "leafpile";
    public static String MODNAME = "Leaf Pile";
    public static Logger LOGGER = LoggerFactory.getLogger(MODNAME);
    private static Config config = null;

    public static Config getConfig() {
        if (config == null) loadConfig();
        return config;
    }

    private static void loadConfig() {
        String fileName = (MODID + ".json");
        Path configPath = FabricLoader.getInstance().getConfigDir();
        File configFile = new File(configPath + "\\" + fileName);
        if (!configFile.exists()) {
            boolean t;
            try {
                t = configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (t) LOGGER.info("Created a new configuration file: " + configFile.getPath());
        }
        config = new Config(configFile);
        config.load();
    }

    private static void modRegistry() {
        ModBlocks.registry();
        ModItems.registry();
        ModItemGroups.registry();
        ModSoundEvent.registry();
        BlockMatching.registry();
    }

    @Override
    public void onInitialize() {
        modRegistry();
        loadConfig();
    }
}
