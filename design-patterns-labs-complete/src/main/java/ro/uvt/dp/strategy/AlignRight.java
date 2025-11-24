
package ro.uvt.dp.strategy;

public class AlignRight implements AlignStrategy {
    @Override
    public String render(String text, int width) {
        if (text == null) return null;
        if (text.length() >= width) return text;
        int pad = width - text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pad; i++) sb.append(' ');
        sb.append(text);
        return sb.toString();
    }
}
