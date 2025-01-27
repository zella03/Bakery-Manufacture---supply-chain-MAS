import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class OrderStatus implements JadescriptPredicate {
  private String orderId;

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(final String orderId) {
    this.orderId = orderId;
  }

  private String status;

  public String getStatus() {
    return this.status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("OrderStatus");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getOrderId()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getStatus()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof OrderStatus) {
    	OrderStatus o = (OrderStatus) obj;
    	return true && java.util.Objects.equals(this.getOrderId(), o.getOrderId()) && java.util.Objects.equals(this.getStatus(), o.getStatus());
    } else {
    	return super.equals(obj);
    }
  }

  public OrderStatus() {
    {
    	this.setOrderId("");
    	
    	this.setStatus("");
    }
  }

  public OrderStatus(final String orderId, final String status) {
    super();
    
    this.setOrderId(orderId);
    this.setStatus(status);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_OrderStatus(final String orderId, final String status) {
    return null;
  }
}
