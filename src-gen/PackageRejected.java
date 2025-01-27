import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class PackageRejected implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackageRejected");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackageRejected) {
    	PackageRejected o = (PackageRejected) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public PackageRejected() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackageRejected() {
    return null;
  }
}
