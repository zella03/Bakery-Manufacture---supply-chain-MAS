import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;
import jadescript.lang.Duration;

@SuppressWarnings("all")
public class PackagePreparation implements JadescriptConcept {
  private String packageId;

  public String getPackageId() {
    return this.packageId;
  }

  public void setPackageId(final String packageId) {
    this.packageId = packageId;
  }

  private Duration prepTime;

  public Duration getPrepTime() {
    return this.prepTime;
  }

  public void setPrepTime(final Duration prepTime) {
    this.prepTime = prepTime;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackagePreparation");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getPackageId()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getPrepTime()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackagePreparation) {
    	PackagePreparation o = (PackagePreparation) obj;
    	return true && java.util.Objects.equals(this.getPackageId(), o.getPackageId()) && java.util.Objects.equals(this.getPrepTime(), o.getPrepTime());
    } else {
    	return super.equals(obj);
    }
  }

  public PackagePreparation() {
    {
    	this.setPackageId("");
    	
    	this.setPrepTime(new jadescript.lang.Duration());
    }
  }

  public PackagePreparation(final String packageId, final Duration prepTime) {
    super();
    
    this.setPackageId(packageId);
    this.setPrepTime(prepTime);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackagePreparation(final String packageId, final Duration prepTime) {
    return null;
  }
}
