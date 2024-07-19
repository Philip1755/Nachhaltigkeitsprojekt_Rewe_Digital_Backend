package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tags {
    Tag1, Tag2, Tag3, Tag4, Tag5, Tag6, Tag7, Tag8, Tag9;

    public static Tags fromId(int id) {
        return switch (id) {
            case 0 -> Tag1;
            case 1 -> Tag2;
            case 2 -> Tag3;
            case 3 -> Tag4;
            case 4 -> Tag5;
            case 5 -> Tag6;
            case 6 -> Tag7;
            case 7 -> Tag8;
            case 8 -> Tag9;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
