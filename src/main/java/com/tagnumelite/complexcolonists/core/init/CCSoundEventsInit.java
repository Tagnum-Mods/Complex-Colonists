package com.tagnumelite.complexcolonists.core.init;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import com.minecolonies.api.colony.jobs.registry.IJobRegistry;
import com.minecolonies.api.colony.jobs.registry.JobEntry;
import com.minecolonies.api.sounds.EventType;
import com.minecolonies.api.sounds.ModSoundEvents;
import com.minecolonies.api.util.Tuple;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.minecolonies.api.sounds.ModSoundEvents.CITIZEN_SOUND_EVENTS;

@Mod.EventBusSubscriber(modid = ComplexColonists.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCSoundEventsInit {
    @SubscribeEvent
    public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> registry = event.getRegistry();

        for (final JobEntry job : IJobRegistry.getInstance().getValues()) {
            if (job.getRegistryName().getNamespace().equals(ComplexColonists.MOD_ID) && !job.getRegistryName()
                                                                                            .getPath()
                                                                                            .equals("placeholder")) {
                final Map<EventType, Tuple<SoundEvent, SoundEvent>> map = new HashMap<>();
                for (final EventType soundEvents : EventType.values()) {
                    final SoundEvent maleSoundEvent = ModSoundEvents.getSoundID(
                            "mob." + job.getRegistryName().getPath() + ".male." + soundEvents.name()
                                                                                             .toLowerCase(Locale.US));
                    final SoundEvent femaleSoundEvent = ModSoundEvents.getSoundID(
                            "mob." + job.getRegistryName().getPath() + ".female." + soundEvents.name()
                                                                                               .toLowerCase(Locale.US));

                    registry.register(maleSoundEvent);
                    registry.register(femaleSoundEvent);
                    map.put(soundEvents, new Tuple<>(maleSoundEvent, femaleSoundEvent));
                }
                CITIZEN_SOUND_EVENTS.put(job.getRegistryName().getPath(), map);
            }
        }
    }
}
