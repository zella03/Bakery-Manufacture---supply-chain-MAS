import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class GoodToPack implements JadescriptAction {
  private Order order;

  public Order getOrder() {
    return this.order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("GoodToPack");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getOrder()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof GoodToPack) {
    	GoodToPack o = (GoodToPack) obj;
    	return true && java.util.Objects.equals(this.getOrder(), o.getOrder());
    } else {
    	return super.equals(obj);
    }
  }

  public GoodToPack() {
    {
    	this.setOrder(new Order());
    }
  }

  public GoodToPack(final Order order) {
    super();
    
    this.setOrder(order);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_GoodToPack(final Order order) {
    return null;
  }
}
