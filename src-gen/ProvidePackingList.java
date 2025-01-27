import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class ProvidePackingList implements JadescriptAction {
  private JadescriptList<PackageOfGoods> packageList;

  public JadescriptList<PackageOfGoods> getPackageList() {
    return this.packageList;
  }

  public void setPackageList(final JadescriptList<PackageOfGoods> packageList) {
    this.packageList = packageList;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("ProvidePackingList");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getPackageList()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof ProvidePackingList) {
    	ProvidePackingList o = (ProvidePackingList) obj;
    	return true && java.util.Objects.equals(this.getPackageList(), o.getPackageList());
    } else {
    	return super.equals(obj);
    }
  }

  public ProvidePackingList() {
    {
    	this.setPackageList(new jadescript.util.JadescriptList<PackageOfGoods>());
    }
  }

  public ProvidePackingList(final JadescriptList<PackageOfGoods> packageList) {
    super();
    
    this.setPackageList(packageList);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_ProvidePackingList(final JadescriptList<PackageOfGoods> packageList) {
    return null;
  }
}
