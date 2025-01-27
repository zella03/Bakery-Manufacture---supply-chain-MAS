import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;

@SuppressWarnings("all")
public class Order implements JadescriptConcept {
  private String id;

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  private String good;

  public String getGood() {
    return this.good;
  }

  public void setGood(final String good) {
    this.good = good;
  }

  private String status;

  public String getStatus() {
    return this.status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  private String type;

  public String getType() {
    return this.type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("Order");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getId()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getGood()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getStatus()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getType()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof Order) {
    	Order o = (Order) obj;
    	return true && java.util.Objects.equals(this.getId(), o.getId()) && java.util.Objects.equals(this.getGood(), o.getGood()) && java.util.Objects.equals(this.getStatus(), o.getStatus()) && java.util.Objects.equals(this.getType(), o.getType());
    } else {
    	return super.equals(obj);
    }
  }

  public Order() {
    {
    	this.setId("");
    	
    	this.setGood("");
    	
    	this.setStatus("");
    	
    	this.setType("");
    }
  }

  public Order(final String id, final String good, final String status, final String type) {
    super();
    
    this.setId(id);
    this.setGood(good);
    this.setStatus(status);
    this.setType(type);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_Order(final String id, final String good, final String status, final String type) {
    return null;
  }
}
