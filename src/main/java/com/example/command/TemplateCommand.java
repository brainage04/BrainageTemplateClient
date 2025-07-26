package com.example.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class TemplateCommand {
    public static int execute(FabricClientCommandSource source) {
        source.sendFeedback(Text.literal("This is a test command."));

        return 1;
    }

    public static void initialize(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("template")
                .executes(context ->
                        execute(
                                context.getSource()
                        )
                )
        );
    }
}
