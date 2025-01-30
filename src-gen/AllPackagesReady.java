import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class AllPackagesReady implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("AllPackagesReady");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof AllPackagesReady) {
    	AllPackagesReady o = (AllPackagesReady) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public AllPackagesReady() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_AllPackagesReady() {
    return null;
  }
}
