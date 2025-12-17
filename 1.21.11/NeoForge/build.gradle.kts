plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modCompileOnly(libs.puzzleslib.common)
    modApi(libs.puzzleslib.neoforge)
    modCompileOnly(libs.diagonalblocks.common)
    modApi(libs.diagonalblocks.neoforge)
    include(libs.diagonalblocks.neoforge)
}
