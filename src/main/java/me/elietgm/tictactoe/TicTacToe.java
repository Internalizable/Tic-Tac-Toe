package me.elietgm.tictactoe;

import lombok.Getter;
import me.elietgm.tictactoe.chest.ItemCreator;
import me.elietgm.tictactoe.chest.SkullCreator;
import org.bukkit.plugin.java.JavaPlugin;

public final class TicTacToe extends JavaPlugin {

    @Getter private static TicTacToe instance;
    @Getter private static ItemCreator itemCreator = new ItemCreator();
    @Getter private static SkullCreator skullCreator = new SkullCreator();

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
