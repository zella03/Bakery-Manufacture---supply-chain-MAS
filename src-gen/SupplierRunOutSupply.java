import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class SupplierRunOutSupply implements JadescriptPredicate {
  private Boolean bakerWhileProparing;

  public Boolean getBakerWhileProparing() {
    return this.bakerWhileProparing;
  }

  public void setBakerWhileProparing(final Boolean bakerWhileProparing) {
    this.bakerWhileProparing = bakerWhileProparing;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("SupplierRunOutSupply");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getBakerWhileProparing()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof SupplierRunOutSupply) {
    	SupplierRunOutSupply o = (SupplierRunOutSupply) obj;
    	return true && java.util.Objects.equals(this.getBakerWhileProparing(), o.getBakerWhileProparing());
    } else {
    	return super.equals(obj);
    }
  }

  public SupplierRunOutSupply() {
    {
    	this.setBakerWhileProparing(false);
    }
  }

  public SupplierRunOutSupply(final Boolean bakerWhileProparing) {
    super();
    
    this.setBakerWhileProparing(bakerWhileProparing);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_SupplierRunOutSupply(final Boolean bakerWhileProparing) {
    return null;
  }
}
