package fuzs.diagonalfences.neoforge;

import fuzs.diagonalfences.DiagonalFences;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.neoforged.fml.common.Mod;

@Mod(DiagonalFences.MOD_ID)
public class DiagonalFencesNeoForge {

    public DiagonalFencesNeoForge() {
        ModConstructor.construct(DiagonalFences.MOD_ID, DiagonalFences::new);
    }
}
