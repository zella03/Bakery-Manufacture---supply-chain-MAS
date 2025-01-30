import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class EndOfDay implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("EndOfDay");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof EndOfDay) {
    	EndOfDay o = (EndOfDay) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public EndOfDay() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_EndOfDay() {
    return null;
  }
}
