package app;

public enum ContextType {

    NATIVE("NATIVE_APP"), WEBVIEW("WEBVIEW_org.wikipedia");

    private final String contextTypeValue;

    ContextType(String contextTypeValue) {
        this.contextTypeValue = contextTypeValue;
    }

    public String getContextTypeValue() {
        return contextTypeValue;
    }
}
