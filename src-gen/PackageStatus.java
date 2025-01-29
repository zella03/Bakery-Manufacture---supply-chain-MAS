import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class PackageStatus implements JadescriptPredicate {
  private PackageOfGoods pcg;

  public PackageOfGoods getPcg() {
    return this.pcg;
  }

  public void setPcg(final PackageOfGoods pcg) {
    this.pcg = pcg;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackageStatus");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getPcg()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackageStatus) {
    	PackageStatus o = (PackageStatus) obj;
    	return true && java.util.Objects.equals(this.getPcg(), o.getPcg());
    } else {
    	return super.equals(obj);
    }
  }

  public PackageStatus() {
    {
    	this.setPcg(new PackageOfGoods());
    }
  }

  public PackageStatus(final PackageOfGoods pcg) {
    super();
    
    this.setPcg(pcg);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackageStatus(final PackageOfGoods pcg) {
    return null;
  }
}
