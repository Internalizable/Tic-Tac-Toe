package me.elietgm.tictactoe.command;

import me.elietgm.tictactoe.utils.messages.PredefinedMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TTTCmd extends AbstractCommand {

    public TTTCmd(String command, String usage, String description) {
        super(command, usage, description);
    }

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ttt.use")) {

            if(sender instanceof Player) {

                if(args.length != 2) {
                    //todo send help message
                    return true;
                }

                String secondArgument = args[0];
                String thirdArgument = args[1];

                if(secondArgument.equalsIgnoreCase("duel")) {
                    if(Bukkit.getPlayer(thirdArgument) == null) {
                        //todo player not online
                        return true;
                    }

                    //todo send duel request gui
                }

            }

        } else {
            sender.sendMessage(PredefinedMessages.NO_PERMISSION.build());
            return true;
        }

        return true;
    }

}
