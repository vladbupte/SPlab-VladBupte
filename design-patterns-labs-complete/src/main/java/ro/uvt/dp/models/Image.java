
package ro.uvt.dp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IMAGE")
public class Image extends BaseElement {
    private String name;
    public Image() { super(); }
    public Image(String name) { super("Image"); this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override
    public void print() {
        System.out.println("Image with name:" + name);
    }
}
