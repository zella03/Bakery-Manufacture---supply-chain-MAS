import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class PackageStatus implements JadescriptPredicate {
  private PackageOfGoods package_;

  public PackageOfGoods getPackage_() {
    return this.package_;
  }

  public void setPackage_(final PackageOfGoods package_) {
    this.package_ = package_;
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
    _sb.append("PackageStatus");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getPackage_()));
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getStatus()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackageStatus) {
    	PackageStatus o = (PackageStatus) obj;
    	return true && java.util.Objects.equals(this.getPackage_(), o.getPackage_()) && java.util.Objects.equals(this.getStatus(), o.getStatus());
    } else {
    	return super.equals(obj);
    }
  }

  public PackageStatus() {
    {
    	this.setPackage_(new PackageOfGoods());
    	
    	this.setStatus("");
    }
  }

  public PackageStatus(final PackageOfGoods package_, final String status) {
    super();
    
    this.setPackage_(package_);
    this.setStatus(status);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackageStatus(final PackageOfGoods package_, final String status) {
    return null;
  }
}
