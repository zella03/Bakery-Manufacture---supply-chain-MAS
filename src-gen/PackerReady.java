import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class PackerReady implements JadescriptPredicate {
  private AID workerId;

  public AID getWorkerId() {
    return this.workerId;
  }

  public void setWorkerId(final AID workerId) {
    this.workerId = workerId;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackerReady");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getWorkerId()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackerReady) {
    	PackerReady o = (PackerReady) obj;
    	return true && java.util.Objects.equals(this.getWorkerId(), o.getWorkerId());
    } else {
    	return super.equals(obj);
    }
  }

  public PackerReady() {
    {
    	this.setWorkerId(new jade.core.AID());
    }
  }

  public PackerReady(final AID workerId) {
    super();
    
    this.setWorkerId(workerId);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackerReady(final AID workerId) {
    return null;
  }
}
