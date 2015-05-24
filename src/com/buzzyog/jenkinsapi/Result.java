

package com.buzzyog.jenkinsapi;

import org.pircbotx.Colors;

public enum Result {

    SUCCESS("blue", Colors.GREEN, Colors.UNDERLINE),
    FAILURE("red", Colors.RED, Colors.UNDERLINE),
    NOT_BUILT("notbuilt", Colors.LIGHT_GRAY, Colors.UNDERLINE),;

    private String ident;
    private String[] colours;

    Result(String ident, String... colours) {
        this.ident = ident;
        this.colours = colours;
    }

    public String format(String toFormat) {
        StringBuilder builder = new StringBuilder();
        for (String s : getColours()) {
            builder.append(s);
        }
        return builder.append(toFormat).toString();
    }

    public String[] getColours() {
        return colours;
    }

    public String getIdent() {
        return ident;
    }

    public static Result getByIdent(String ident) {
        for (Result r : Result.values()) {
            if (r.getIdent().equals(ident)) {
                return r;
            }
        }
        return null;
    }
}