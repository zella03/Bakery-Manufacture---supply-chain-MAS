import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class RequestOrder implements JadescriptAction {
  private AID agentId;

  public AID getAgentId() {
    return this.agentId;
  }

  public void setAgentId(final AID agentId) {
    this.agentId = agentId;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RequestOrder");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getAgentId()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RequestOrder) {
    	RequestOrder o = (RequestOrder) obj;
    	return true && java.util.Objects.equals(this.getAgentId(), o.getAgentId());
    } else {
    	return super.equals(obj);
    }
  }

  public RequestOrder() {
    {
    	this.setAgentId(new jade.core.AID());
    }
  }

  public RequestOrder(final AID agentId) {
    super();
    
    this.setAgentId(agentId);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RequestOrder(final AID agentId) {
    return null;
  }
}
