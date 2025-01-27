import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class RequestPackingList implements JadescriptAction {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RequestPackingList");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RequestPackingList) {
    	RequestPackingList o = (RequestPackingList) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public RequestPackingList() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RequestPackingList() {
    return null;
  }
}
