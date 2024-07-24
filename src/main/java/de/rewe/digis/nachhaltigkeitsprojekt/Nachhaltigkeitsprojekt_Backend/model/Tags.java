package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public enum Tags {
    Tag1(1),
    Tag2(2),
    Tag3(3),
    Tag4(4),
    Tag5(5),
    Tag6(6),
    Tag7(7),
    Tag8(8),
    Tag9(9);

    private final int value;

    Tags(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    public static Tags fromValue(int value) {
        for (Tags tag : Tags.values()) {
            if (tag.getValue() == value) {
                return tag;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static List<Tags> convertIntegersToTags(List<Integer> integerList) {
        return integerList.stream()
                .map(Tags::fromValue)
                .toList();
    }
}
