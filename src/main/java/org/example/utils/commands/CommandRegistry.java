package org.example.utils.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CommandRegistry {

    private ArrayList<Command> lstCommand;

    public CommandRegistry() {
        this.lstCommand = new ArrayList<Command>();
    }

    public void addCommand(Command cmd)
    {
        lstCommand.add(cmd);
    }

    public void removeCommand(String id){
        lstCommand.removeIf((cmd) -> cmd.getId().equalsIgnoreCase(id));
    }

    public Optional<Command> getByAlias(String alias)
    {
        for( Command cmd : lstCommand  )
        {
            if(Arrays.asList(cmd.getAliases()).contains(alias)) {
                return Optional.of(cmd);
            }
        }
        return Optional.empty();
    }

}
