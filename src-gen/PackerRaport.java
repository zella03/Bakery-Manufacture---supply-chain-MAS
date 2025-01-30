import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class PackerRaport implements JadescriptPredicate {
  private JadescriptList<PackagePreparation> pcgPrep;

  public JadescriptList<PackagePreparation> getPcgPrep() {
    return this.pcgPrep;
  }

  public void setPcgPrep(final JadescriptList<PackagePreparation> pcgPrep) {
    this.pcgPrep = pcgPrep;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackerRaport");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getPcgPrep()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackerRaport) {
    	PackerRaport o = (PackerRaport) obj;
    	return true && java.util.Objects.equals(this.getPcgPrep(), o.getPcgPrep());
    } else {
    	return super.equals(obj);
    }
  }

  public PackerRaport() {
    {
    	this.setPcgPrep(new jadescript.util.JadescriptList<PackagePreparation>());
    }
  }

  public PackerRaport(final JadescriptList<PackagePreparation> pcgPrep) {
    super();
    
    this.setPcgPrep(pcgPrep);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackerRaport(final JadescriptList<PackagePreparation> pcgPrep) {
    return null;
  }
}
