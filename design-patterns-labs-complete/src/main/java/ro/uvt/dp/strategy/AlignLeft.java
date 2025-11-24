
package ro.uvt.dp.strategy;

public class AlignLeft implements AlignStrategy {
    @Override
    public String render(String text, int width) {
        // simple left alignment: just return text
        return text;
    }
}
