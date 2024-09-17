package fuzs.diagonalfences.fabric.client;

import fuzs.diagonalfences.DiagonalFences;
import fuzs.diagonalfences.client.DiagonalFencesClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class DiagonalFencesFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(DiagonalFences.MOD_ID, DiagonalFencesClient::new);
    }
}
