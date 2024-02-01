package fuzs.diagonalfences;

import fuzs.diagonalblocks.api.v2.DiagonalBlockType;
import fuzs.diagonalblocks.api.v2.DiagonalBlockTypes;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiagonalFences implements ModConstructor {
    public static final String MOD_ID = "diagonalfences";
    public static final String MOD_NAME = "Diagonal Fences";
    public static final Logger LOGGER = LogManager.getLogger(DiagonalFences.MOD_NAME);

    @Override
    public void onConstructMod() {
        DiagonalBlockType.register(DiagonalBlockTypes.FENCE);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
