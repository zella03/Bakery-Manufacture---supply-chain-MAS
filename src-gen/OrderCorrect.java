import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class OrderCorrect implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("OrderCorrect");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof OrderCorrect) {
    	OrderCorrect o = (OrderCorrect) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public OrderCorrect() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_OrderCorrect() {
    return null;
  }
}
