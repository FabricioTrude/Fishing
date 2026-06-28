package com.fabricio.fishing.lwjgl3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// ./gradlew lwjgl3:AtlasGenerator
public class AtlasGenerator {
    public static void main(String[] args) {
        String rootInput = "generated/features";
        String outputDir = "atlas";

        System.out.println("CWD: " + new File(".").getAbsolutePath());

        File root = new File(rootInput);
        if(!root.exists() || !root.isDirectory()){
            System.out.println("Input invlido: " + rootInput);
            return;
        }
        packFolders(root, root, outputDir);
        System.out.println("Atlas generation complete.");
    }
    private static void packFolders(File root, File current, String outputDir){
        File[] files = current.listFiles();
        if(files == null) return;

        List<File> subFolders = new ArrayList<>();
        boolean hasFiles = false;

        for (File file: files){
            if (file.isDirectory()) subFolders.add(file);
            else hasFiles = true;
        }

        if (hasFiles && subFolders.isEmpty()){
            String atlasName = buildAtlasName(root, current);
            System.out.println("Packing: " + atlasName);

            TexturePacker.Settings settings = new TexturePacker.Settings();
            settings.useIndexes = true;
            settings.filterMin = Texture.TextureFilter.Nearest;
            settings.filterMag = Texture.TextureFilter.Nearest;
            settings.duplicatePadding = false;
            settings.paddingX = 1;
            settings.paddingY = 1;

            TexturePacker.process(settings,current.getAbsolutePath(), outputDir, atlasName);
            return;
        }
        for (File folder : subFolders) packFolders(root, folder, outputDir);
    }
    private static String buildAtlasName(File root, File folder){
        String relative = root.toPath()
            .relativize(folder.toPath())
            .toString();
        return relative
            .replace("\\", "_")
            .replace("/", "_");
    }
}
