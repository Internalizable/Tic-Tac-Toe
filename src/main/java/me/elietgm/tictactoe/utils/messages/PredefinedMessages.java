package me.elietgm.tictactoe.utils.messages;

import me.elietgm.tictactoe.TicTacToe;
import me.elietgm.tictactoe.utils.Colorizer;

import java.util.HashMap;
import java.util.Map;

public enum PredefinedMessages {

    PREFIX("messages.prefix"),
    NO_PERMISSION("messages.noperm"),
    GUI_REQUEST_TITLE("messages.gui.request.title"),
    GUI_REQUEST_HEAD_TITLE("messages.gui.request.head.title"),
    GUI_REQUEST_ACCEPT("messages.gui.request.accept"),
    GUI_REQUEST_DENY("messages.gui.request.deny");

    public String m;
    public Map<String, String> pH;

    private PredefinedMessages(String field) {
        this.m = TicTacToe.getInstance().getConfig().getString(field);
        this.pH = new HashMap<String, String>();
    }

    public void registerPlaceholder(String placeholder, String replaceWith) {
        pH.put(placeholder, replaceWith);
    }

    public String getMessage(boolean usePlaceholders) {
        if(usePlaceholders) {
            String replaced = "" + m;

            for(Map.Entry<String, String> replace : pH.entrySet()) {
                replaced = replaced.replace(replace.getKey(), replace.getValue());
            }

            return replaced;
        } else {
            return m;
        }
    }

    public String build() {
        return PREFIX.build() + Colorizer.color(getMessage(true));
    }

}
