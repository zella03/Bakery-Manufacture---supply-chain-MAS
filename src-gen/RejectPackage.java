import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class RejectPackage implements JadescriptAction {
  private String packageId;

  public String getPackageId() {
    return this.packageId;
  }

  public void setPackageId(final String packageId) {
    this.packageId = packageId;
  }

  private String reason;

  public String getReason() {
    return this.reason;
  }

  public void setReason(final String reason) {
    this.reason = reason;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RejectPackage");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getPackageId()) + "\"");
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getReason()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RejectPackage) {
    	RejectPackage o = (RejectPackage) obj;
    	return true && java.util.Objects.equals(this.getPackageId(), o.getPackageId()) && java.util.Objects.equals(this.getReason(), o.getReason());
    } else {
    	return super.equals(obj);
    }
  }

  public RejectPackage() {
    {
    	this.setPackageId("");
    	
    	this.setReason("");
    }
  }

  public RejectPackage(final String packageId, final String reason) {
    super();
    
    this.setPackageId(packageId);
    this.setReason(reason);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RejectPackage(final String packageId, final String reason) {
    return null;
  }
}
