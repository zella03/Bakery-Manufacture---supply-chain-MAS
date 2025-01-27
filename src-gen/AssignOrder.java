import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class AssignOrder implements JadescriptAction {
  private AID agentId;

  public AID getAgentId() {
    return this.agentId;
  }

  public void setAgentId(final AID agentId) {
    this.agentId = agentId;
  }

  private Order order;

  public Order getOrder() {
    return this.order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("AssignOrder");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getAgentId()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getOrder()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof AssignOrder) {
    	AssignOrder o = (AssignOrder) obj;
    	return true && java.util.Objects.equals(this.getAgentId(), o.getAgentId()) && java.util.Objects.equals(this.getOrder(), o.getOrder());
    } else {
    	return super.equals(obj);
    }
  }

  public AssignOrder() {
    {
    	this.setAgentId(new jade.core.AID());
    	
    	this.setOrder(new Order());
    }
  }

  public AssignOrder(final AID agentId, final Order order) {
    super();
    
    this.setAgentId(agentId);
    this.setOrder(order);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_AssignOrder(final AID agentId, final Order order) {
    return null;
  }
}
