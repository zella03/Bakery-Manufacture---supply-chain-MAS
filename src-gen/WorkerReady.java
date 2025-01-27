import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class WorkerReady implements JadescriptPredicate {
  private AID workerId;

  public AID getWorkerId() {
    return this.workerId;
  }

  public void setWorkerId(final AID workerId) {
    this.workerId = workerId;
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
    _sb.append("WorkerReady");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getWorkerId()));
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getType()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof WorkerReady) {
    	WorkerReady o = (WorkerReady) obj;
    	return true && java.util.Objects.equals(this.getWorkerId(), o.getWorkerId()) && java.util.Objects.equals(this.getType(), o.getType());
    } else {
    	return super.equals(obj);
    }
  }

  public WorkerReady() {
    {
    	this.setWorkerId(new jade.core.AID());
    	
    	this.setType("");
    }
  }

  public WorkerReady(final AID workerId, final String type) {
    super();
    
    this.setWorkerId(workerId);
    this.setType(type);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_WorkerReady(final AID workerId, final String type) {
    return null;
  }
}
