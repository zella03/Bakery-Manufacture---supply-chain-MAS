import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class OrderRedoRequired implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("OrderRedoRequired");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof OrderRedoRequired) {
    	OrderRedoRequired o = (OrderRedoRequired) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public OrderRedoRequired() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_OrderRedoRequired() {
    return null;
  }
}
