package com.github.johnclark96.listener;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.species.abilities.Abilities;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PixelmonCaptureListener {

    @SubscribeEvent
    public void onCapturePokemon(CaptureEvent.SuccessfulCapture event) {
        PixelmonEntity pixelmon = event.getPokemon();
        Pokemon pokemon = pixelmon.getPokemon();
        ServerPlayerEntity player = event.getPlayer();

        if(pokemon.hasHiddenAbility()) {
            player.sendMessage(new StringTextComponent("You caught a " + pokemon.getDisplayName() + " with its hidden ability" + pokemon.getAbilityName() + "!"), player.getUUID());
        } else {
            player.sendMessage(new StringTextComponent("You caught a " + pokemon.getDisplayName() + "!"), player.getUUID());
        }
    }
}
