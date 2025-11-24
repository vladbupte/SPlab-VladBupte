
package ro.uvt.dp.strategy;

public class AlignCenter implements AlignStrategy {
    @Override
    public String render(String text, int width) {
        if (text == null) return null;
        if (text.length() >= width) return text;
        int totalPad = width - text.length();
        int left = totalPad / 2;
        int right = totalPad - left;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < left; i++) sb.append(' ');
        sb.append(text);
        for (int i = 0; i < right; i++) sb.append(' ');
        return sb.toString();
    }
}
