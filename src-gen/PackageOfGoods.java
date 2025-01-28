import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class PackageOfGoods implements JadescriptConcept {
  private String packageId;

  public String getPackageId() {
    return this.packageId;
  }

  public void setPackageId(final String packageId) {
    this.packageId = packageId;
  }

  private JadescriptList<OrderQuantity> ordersInPackage;

  public JadescriptList<OrderQuantity> getOrdersInPackage() {
    return this.ordersInPackage;
  }

  public void setOrdersInPackage(final JadescriptList<OrderQuantity> ordersInPackage) {
    this.ordersInPackage = ordersInPackage;
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
    _sb.append("PackageOfGoods");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getPackageId()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getOrdersInPackage()));
    _sb.append(", ");
    _sb.append("\"" + java.lang.String.valueOf(getStatus()) + "\"");
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackageOfGoods) {
    	PackageOfGoods o = (PackageOfGoods) obj;
    	return true && java.util.Objects.equals(this.getPackageId(), o.getPackageId()) && java.util.Objects.equals(this.getOrdersInPackage(), o.getOrdersInPackage()) && java.util.Objects.equals(this.getStatus(), o.getStatus());
    } else {
    	return super.equals(obj);
    }
  }

  public PackageOfGoods() {
    {
    	this.setPackageId("");
    	
    	this.setOrdersInPackage(new jadescript.util.JadescriptList<OrderQuantity>());
    	
    	this.setStatus("");
    }
  }

  public PackageOfGoods(final String packageId, final JadescriptList<OrderQuantity> ordersInPackage, final String status) {
    super();
    
    this.setPackageId(packageId);
    this.setOrdersInPackage(ordersInPackage);
    this.setStatus(status);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackageOfGoods(final String packageId, final JadescriptList<OrderQuantity> ordersInPackage, final String status) {
    return null;
  }
}
