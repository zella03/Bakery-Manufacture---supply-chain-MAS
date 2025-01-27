import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class AgentsReported implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("AgentsReported");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof AgentsReported) {
    	AgentsReported o = (AgentsReported) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public AgentsReported() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_AgentsReported() {
    return null;
  }
}
