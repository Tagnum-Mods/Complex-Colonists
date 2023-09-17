package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.minecolonies.api.sounds.EventType;
import com.minecolonies.api.sounds.ModSoundEvents;
import com.minecolonies.api.util.Tuple;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CCSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, ComplexColonists.MOD_ID);

    /**
     * Map of sound events.
     */
    public static Map<String, Map<EventType, Tuple<SoundEvent, SoundEvent>>> CITIZEN_SOUND_EVENTS = new HashMap<>();

    static
    {
        for (final ResourceLocation job : CCJobs.getJobs())
        {
            final Map<EventType, Tuple<SoundEvent, SoundEvent>> map = new HashMap<>();
            for (final EventType soundEvents : EventType.values())
            {
                final SoundEvent maleSoundEvent = ModSoundEvents.getSoundID("mob." + job.getPath() + ".male." + soundEvents.name().toLowerCase(Locale.US));
                final SoundEvent femaleSoundEvent =
                        ModSoundEvents.getSoundID("mob." + job.getPath() + ".female." + soundEvents.name().toLowerCase(Locale.US));

                SOUND_EVENTS.register(maleSoundEvent.getLocation().getPath(), () -> maleSoundEvent);
                SOUND_EVENTS.register(femaleSoundEvent.getLocation().getPath(),  () -> femaleSoundEvent);
                map.put(soundEvents, new Tuple<>(maleSoundEvent, femaleSoundEvent));
            }
            CITIZEN_SOUND_EVENTS.put(job.getPath(), map);
        }
    }
}
