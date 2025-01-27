import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class RepackedPackage implements JadescriptAction {
  private String packageId;

  public String getPackageId() {
    return this.packageId;
  }

  public void setPackageId(final String packageId) {
    this.packageId = packageId;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RepackedPackage");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getPackageId()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RepackedPackage) {
    	RepackedPackage o = (RepackedPackage) obj;
    	return true && java.util.Objects.equals(this.getPackageId(), o.getPackageId());
    } else {
    	return super.equals(obj);
    }
  }

  public RepackedPackage() {
    {
    	this.setPackageId("");
    }
  }

  public RepackedPackage(final String packageId) {
    super();
    
    this.setPackageId(packageId);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RepackedPackage(final String packageId) {
    return null;
  }
}
