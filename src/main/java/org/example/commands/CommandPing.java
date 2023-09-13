package org.example.commands;

import org.example.Main;
import org.example.utils.commands.Command;
import org.example.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.interaction.SlashCommand;

import java.util.List;

public class CommandPing implements CommandExecutor {

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getChannel().sendMessage("Je suis la oui");
    }

}
