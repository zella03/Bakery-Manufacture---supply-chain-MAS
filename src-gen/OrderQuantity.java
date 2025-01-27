import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;

@SuppressWarnings("all")
public class OrderQuantity implements JadescriptConcept {
  private String good;

  public String getGood() {
    return this.good;
  }

  public void setGood(final String good) {
    this.good = good;
  }

  private String type;

  public String getType() {
    return this.type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(final Integer quantity) {
    this.quantity = quantity;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("OrderQuantity");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getGood()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getType()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getQuantity()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof OrderQuantity) {
    	OrderQuantity o = (OrderQuantity) obj;
    	return true && java.util.Objects.equals(this.getGood(), o.getGood()) && java.util.Objects.equals(this.getType(), o.getType()) && java.util.Objects.equals(this.getQuantity(), o.getQuantity());
    } else {
    	return super.equals(obj);
    }
  }

  public OrderQuantity() {
    {
    	this.setGood("");
    	
    	this.setType("");
    	
    	this.setQuantity(0);
    }
  }

  public OrderQuantity(final String good, final String type, final Integer quantity) {
    super();
    
    this.setGood(good);
    this.setType(type);
    this.setQuantity(quantity);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_OrderQuantity(final String good, final String type, final Integer quantity) {
    return null;
  }
}
