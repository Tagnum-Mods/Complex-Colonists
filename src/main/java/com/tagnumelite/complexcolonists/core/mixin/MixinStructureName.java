package com.tagnumelite.complexcolonists.core.mixin;

import com.ldtteam.structurize.management.StructureName;
import com.ldtteam.structurize.management.Structures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;
import java.util.Objects;

@Mixin(value=StructureName.class, remap=false)
public class MixinStructureName {
    @Shadow private String section;
    @Shadow private String prefix;
    @Shadow private String schematic;
    @Shadow private String hut;

    @Inject(at=@At("RETURN"), method="init")
    private void onInit(String structureName, CallbackInfo ci) {
        if (!structureName.isEmpty() && Objects.equals(hut, "") && prefix.equals(Structures.SCHEMATICS_PREFIX)) {
            hut = schematic.split("\\d+")[0].toLowerCase(Locale.ROOT);
            section = Structures.SCHEMATICS_PREFIX;
            if (StructureName.HUTS.contains(hut)) {
                section = hut;
            } else {
                hut = "";
            }
        }
    }
}
