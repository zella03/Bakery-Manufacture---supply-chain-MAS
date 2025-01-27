import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class SubmitPackage implements JadescriptAction {
  private PackageOfGoods packageOfGoods;

  public PackageOfGoods getPackageOfGoods() {
    return this.packageOfGoods;
  }

  public void setPackageOfGoods(final PackageOfGoods packageOfGoods) {
    this.packageOfGoods = packageOfGoods;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("SubmitPackage");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getPackageOfGoods()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof SubmitPackage) {
    	SubmitPackage o = (SubmitPackage) obj;
    	return true && java.util.Objects.equals(this.getPackageOfGoods(), o.getPackageOfGoods());
    } else {
    	return super.equals(obj);
    }
  }

  public SubmitPackage() {
    {
    	this.setPackageOfGoods(new PackageOfGoods());
    }
  }

  public SubmitPackage(final PackageOfGoods packageOfGoods) {
    super();
    
    this.setPackageOfGoods(packageOfGoods);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_SubmitPackage(final PackageOfGoods packageOfGoods) {
    return null;
  }
}
