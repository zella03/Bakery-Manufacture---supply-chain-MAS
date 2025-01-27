import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class PackageReady implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("PackageReady");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PackageReady) {
    	PackageReady o = (PackageReady) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public PackageReady() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_PackageReady() {
    return null;
  }
}
