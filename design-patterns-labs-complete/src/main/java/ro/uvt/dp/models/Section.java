
package ro.uvt.dp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SECTION")
public class Section extends BaseElement {

    @OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<BaseElement> children = new ArrayList<>();

    public Section() { super(); }
    public Section(String title) { super(title); }

    public void add(BaseElement e) { children.add(e); }

    @Override
    public void print() {
        System.out.println(getTitle());
        for (BaseElement e : children) {
            e.print();
        }
    }
}
