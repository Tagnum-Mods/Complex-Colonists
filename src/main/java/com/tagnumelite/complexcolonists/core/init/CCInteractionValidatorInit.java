package com.tagnumelite.complexcolonists.core.init;

import com.tagnumelite.complexcolonists.api.entity.ai.EntityAIModMissing;
import net.minecraft.network.chat.Component;

import com.minecolonies.api.colony.interactionhandling.InteractionValidatorRegistry;

import static com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants.WORKER_MISSING_MOD;

public class CCInteractionValidatorInit {
    public static void init() {
        InteractionValidatorRegistry.registerStandardPredicate(Component.translatable(WORKER_MISSING_MOD),
                                                               citizen -> citizen.getJob() != null && ((EntityAIModMissing<?, ?>) citizen.getJob()
                                                                                                                                         .getWorkerAI()).isModMissing());
    }
}
