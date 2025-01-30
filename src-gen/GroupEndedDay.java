import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class GroupEndedDay implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("GroupEndedDay");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof GroupEndedDay) {
    	GroupEndedDay o = (GroupEndedDay) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public GroupEndedDay() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_GroupEndedDay() {
    return null;
  }
}
