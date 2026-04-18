package edu.coolschool.utilities;

public enum CountriesEnum {
    US("US", "United States of America"),
    GB("GB", "United Kingdom");

    private final String code;
    private final String displayName;

    CountriesEnum(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CountriesEnum fromCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException(ErrorStrings.UNKNOWN_COUNTRY.getMessage());
        }

        for (CountriesEnum country : values()) {
            if (country.code.equalsIgnoreCase(code.trim())) {
                return country;
            }
        }

        throw new IllegalArgumentException(ErrorStrings.UNKNOWN_COUNTRY.getMessage());
    }

    @Override
    public String toString() {
        return displayName;
    }
}