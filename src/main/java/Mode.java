public enum Mode {
    COPY,
    MOVE;

    public static Mode fromString(String mode) {
        try {
            return Mode.valueOf(mode.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e){
            return null;
        }
    }

}
