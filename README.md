# MinecraftFabricModTemplate

This mod template demonstrates:

* Adding an Item (File `ModItems` called from `onInitialize` method in `MinecraftFabricModTemplate`)
* Adding a CreativeTab (File `ModCreativeTab` used when creating items and blocks)

Things to notice:
* The `assets` folder under `resources` that's where textures, models, lang files and more are. Can be added by hand or generated via code (Not demonstrated yet)
* The `data` folder contains recipes and advancements (This is the popup that show when a recipe is unlocked)


## Datagen · [LINK](https://fabricmc.net/wiki/tutorial:datagen_setup)

Notice this addition to build.gradle
```
loom {
    runs {
        // This adds a new gradle task that runs the datagen API: "gradlew runDatagenClient"
        datagenClient {
            inherit client
            name "Data Generation"
            vmArg "-Dfabric-api.datagen"
            vmArg "-Dfabric-api.datagen.output-dir=${file("src/main/generated")}"
            vmArg "-Dfabric-api.datagen.modid=${modid}"
 
            runDir "build/datagen"
        }
    }
}

// Add the datagenned files into the jar.
sourceSets {
    main {
        resources {
            srcDirs += [
                    'src/main/generated'
            ]
        }
    }
}
```
Also add `modid = mfmt` to your gradle.properties file (With your mod id)
Add this to `fabric.mod.json` (With your route to that class) to the `entrypoints`
```
"fabric-datagen": [
    "com.mramericanmike.mfmt.datagen.ModDatagen"
]
```
Make sure to Load Gradle Changes after adding this
Check the `datagen` package

### Details

This repo has the GitHub Actions disabled, if you want to enable them rename the `github` folder to `.github`

> **TODO:**
> * Have more comments on the classes itself.
> * Describe in this document the step by step needed changes to get started: changing package name, mod name, etc.
