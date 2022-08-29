package com.tagnumelite.complexcolonists.api.entity.ai;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.colony.jobs.AModdedJob;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.api.colony.interactionhandling.ChatPriority;
import com.minecolonies.api.entity.ai.statemachine.AIEventTarget;
import com.minecolonies.api.entity.ai.statemachine.AITarget;
import com.minecolonies.api.entity.ai.statemachine.states.AIBlockingEventType;
import com.minecolonies.api.entity.ai.statemachine.states.IAIState;
import com.minecolonies.coremod.colony.interactionhandling.StandardInteraction;
import com.minecolonies.coremod.entity.ai.basic.AbstractAISkeleton;

import static com.minecolonies.api.entity.ai.statemachine.states.AIWorkerState.IDLE;
import static com.minecolonies.api.entity.ai.statemachine.states.AIWorkerState.INIT;
import static com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants.WORKER_MISSING_MOD;

public class EntityAIModMissing<AI extends AbstractAISkeleton<J>, J extends AModdedJob<AI, J>>
        extends AbstractAISkeleton<J> {
    private final String modId;

    /**
     * Creates an EntityAI for jobs whose required modid is missing.
     *
     * @param job   The job because the parent needs this
     * @param modId The modid of the mod that is mossing
     */
    public EntityAIModMissing(@NotNull AModdedJob<AI, J> job, String modId) {
        super((J) job);
        this.modId = modId;
        super.registerTargets(new AIEventTarget<>(AIBlockingEventType.AI_BLOCKING, () -> INIT, 2000),
                              new AITarget(INIT, () -> IDLE, 1), new AITarget(IDLE, this::missingMod, 200));
        ComplexColonists.LOGGER.warn("Created EntityAI for worker missing mod: {}", modId);
    }

    private IAIState missingMod() {
        worker.getCitizenData().triggerInteraction(
                // TODO: Fix this, the MODID is not getting passed through to the interaction
                new StandardInteraction(Component.translatable(WORKER_MISSING_MOD, Component.literal(modId)),
                                        ChatPriority.BLOCKING));
        return IDLE;
    }


    public boolean isModMissing() {
        return !ModList.get().isLoaded(modId);
    }
}
