package fuzs.diagonalfences.client;

import com.google.common.collect.Sets;
import fuzs.diagonalfences.DiagonalFences;
import fuzs.diagonalfences.api.world.level.block.DiagonalBlock;
import fuzs.diagonalfences.client.model.MultipartAppender;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.MultiPartBakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.Set;

public class DiagonalFencesClient {

    public static void onBakingCompleted(ModelManager modelManager, Map<ResourceLocation, BakedModel> models, ModelBakery modelBakery) {
        Set<Block> erroredBlocks = Sets.newHashSet();
        Registry.BLOCK.stream()
                .filter(block -> block instanceof FenceBlock)
                .filter(block -> block instanceof DiagonalBlock diagonalBlock && diagonalBlock.hasProperties())
                .flatMap(block -> block.getStateDefinition().getPossibleStates().stream())
                .forEach(state -> {
                    ResourceLocation fenceLocation = BlockModelShaper.stateToModelLocation(state);
                    BakedModel model = models.get(fenceLocation);
                    if (model instanceof MultiPartBakedModel fenceModel) {
                        MultiPartBakedModel newModel = appendDiagonalFenceSelectors(state.getBlock(), fenceModel);
                        models.put(fenceLocation, newModel);
                    } else if (!erroredBlocks.contains(state.getBlock())){
                        erroredBlocks.add(state.getBlock());
                        DiagonalFences.LOGGER.info("Fence block '{}' is not using multipart models, diagonal fence connections may not be visible!", state.getBlock());
                    }
                });
    }

    private static MultiPartBakedModel appendDiagonalFenceSelectors(Block block, MultiPartBakedModel model) {
        Map<BlockState, Direction> oneArmStates = Map.of(
                block.defaultBlockState().setValue(FenceBlock.NORTH, true), Direction.NORTH,
                block.defaultBlockState().setValue(FenceBlock.EAST, true), Direction.EAST,
                block.defaultBlockState().setValue(FenceBlock.SOUTH, true), Direction.SOUTH,
                block.defaultBlockState().setValue(FenceBlock.WEST, true), Direction.WEST
        );
        return MultipartAppender.appendDiagonalSelectors(block, oneArmStates, model);
    }
}
