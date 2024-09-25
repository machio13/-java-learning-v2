package SummerText;

public enum Market {
    PRIME("P", "Prime"),
    STANDARD("S", "Standard"),
    GROWTH("G", "Growth"),
    UNKNOWN("", "Unknown");

    private final String code;
    private final String displayName;

    Market(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public static Market fromCode(String code) {
        return switch (code) {
            case "P" -> PRIME;
            case "S" -> STANDARD;
            case "G" -> GROWTH;
            default -> UNKNOWN;
        };
    }

    public String getDisplayName() {
        return displayName;
    }
}
