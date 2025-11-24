
package ro.uvt.dp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import ro.uvt.dp.strategy.AlignStrategy;
import ro.uvt.dp.strategy.AlignLeft;

@Entity
@DiscriminatorValue("PARAGRAPH")
public class Paragraph extends BaseElement {

    private String text;

    @Transient
    private AlignStrategy alignStrategy = new AlignLeft();

    public Paragraph() { super(); }

    public Paragraph(String text) { super("Paragraph"); this.text = text; }

    public String getText() { return text; }
    public void setText(String t) { this.text = t; }

    public void setAlignStrategy(AlignStrategy s) { this.alignStrategy = s; }

    @Override
    public void print() {
        String out = text;
        if (alignStrategy != null) out = alignStrategy.render(text, 60);
        System.out.println("Paragraph: " + out);
    }
}
