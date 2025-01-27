import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class EndOfPrivateOrders implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("EndOfPrivateOrders");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof EndOfPrivateOrders) {
    	EndOfPrivateOrders o = (EndOfPrivateOrders) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public EndOfPrivateOrders() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_EndOfPrivateOrders() {
    return null;
  }
}
