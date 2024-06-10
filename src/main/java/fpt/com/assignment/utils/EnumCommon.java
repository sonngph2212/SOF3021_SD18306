package fpt.com.assignment.utils;

public class EnumCommon {

    public static enum AppParam {
        TRANG_THAI("TRANG_THAI");

        private final String name;

        AppParam(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
