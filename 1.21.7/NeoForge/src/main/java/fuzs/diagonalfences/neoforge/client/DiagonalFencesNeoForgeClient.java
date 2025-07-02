package fuzs.diagonalfences.neoforge.client;

import fuzs.diagonalfences.DiagonalFences;
import fuzs.diagonalfences.client.DiagonalFencesClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = DiagonalFences.MOD_ID, dist = Dist.CLIENT)
public class DiagonalFencesNeoForgeClient {

    public DiagonalFencesNeoForgeClient() {
        ClientModConstructor.construct(DiagonalFences.MOD_ID, DiagonalFencesClient::new);
    }
}
