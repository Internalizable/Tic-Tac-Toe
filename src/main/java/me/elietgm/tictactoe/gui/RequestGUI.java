package me.elietgm.tictactoe.gui;

import me.elietgm.tictactoe.TicTacToe;
import me.elietgm.tictactoe.chest.ChestGUI;
import me.elietgm.tictactoe.chest.GUICallback;
import me.elietgm.tictactoe.utils.XMaterial;
import me.elietgm.tictactoe.utils.messages.PredefinedMessages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RequestGUI {

    public void open(Player player, String playerSent) {

        new ChestGUI(player, 27, PredefinedMessages.GUI_REQUEST_TITLE.build(), false, new GUICallback() {

            @Override
            public void callback(ChestGUI gui, CallbackType callback, ItemStack item) {

                switch(callback) {
                    case INIT:

                        //todo display stats in lore

                        gui.i.setItem(4, TicTacToe.getSkullCreator().createSkull(playerSent, 1, PredefinedMessages.GUI_REQUEST_HEAD_TITLE.build()));

                        gui.i.setItem(12, TicTacToe.getItemCreator().createItem(XMaterial.LIME_TERRACOTTA.parseMaterial(),
                                1, 5, PredefinedMessages.GUI_REQUEST_ACCEPT.build()));

                        gui.i.setItem(14, TicTacToe.getItemCreator().createItem(XMaterial.RED_TERRACOTTA.parseMaterial(),
                                1, 14, PredefinedMessages.GUI_REQUEST_DENY.build()));
                        break;

                    case CLICK:

                        String displayName = item.getItemMeta().getDisplayName();

                        if(displayName.equalsIgnoreCase(PredefinedMessages.GUI_REQUEST_ACCEPT.build())) {
                            //todo open the game inventory
                            player.closeInventory();
                        }

                        if(displayName.equalsIgnoreCase(PredefinedMessages.GUI_REQUEST_DENY.build())) {
                            //todo deny the game
                            player.closeInventory();
                        }

                        break;
                }

            }

            @Override
            public void onSecond(ChestGUI gui) {}

        });

    }

}
