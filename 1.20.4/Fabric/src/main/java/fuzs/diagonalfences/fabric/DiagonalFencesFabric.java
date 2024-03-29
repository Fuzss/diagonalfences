package fuzs.diagonalfences.fabric;

import fuzs.diagonalfences.DiagonalFences;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class DiagonalFencesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(DiagonalFences.MOD_ID, DiagonalFences::new);
    }
}
