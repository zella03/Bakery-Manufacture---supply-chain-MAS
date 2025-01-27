import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class RejectOrAcceptOrder implements JadescriptAction {
  private String orderId;

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(final String orderId) {
    this.orderId = orderId;
  }

  private String decision;

  public String getDecision() {
    return this.decision;
  }

  public void setDecision(final String decision) {
    this.decision = decision;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RejectOrAcceptOrder");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getOrderId()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getDecision()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RejectOrAcceptOrder) {
    	RejectOrAcceptOrder o = (RejectOrAcceptOrder) obj;
    	return true && java.util.Objects.equals(this.getOrderId(), o.getOrderId()) && java.util.Objects.equals(this.getDecision(), o.getDecision());
    } else {
    	return super.equals(obj);
    }
  }

  public RejectOrAcceptOrder() {
    {
    	this.setOrderId("");
    	
    	this.setDecision("");
    }
  }

  public RejectOrAcceptOrder(final String orderId, final String decision) {
    super();
    
    this.setOrderId(orderId);
    this.setDecision(decision);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RejectOrAcceptOrder(final String orderId, final String decision) {
    return null;
  }
}
