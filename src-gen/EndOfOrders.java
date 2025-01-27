import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class EndOfOrders implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("EndOfOrders");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof EndOfOrders) {
    	EndOfOrders o = (EndOfOrders) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public EndOfOrders() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_EndOfOrders() {
    return null;
  }
}
