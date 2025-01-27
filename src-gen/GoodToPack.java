import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class GoodToPack implements JadescriptAction {
  private Good good;

  public Good getGood() {
    return this.good;
  }

  public void setGood(final Good good) {
    this.good = good;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("GoodToPack");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getGood()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof GoodToPack) {
    	GoodToPack o = (GoodToPack) obj;
    	return true && java.util.Objects.equals(this.getGood(), o.getGood());
    } else {
    	return super.equals(obj);
    }
  }

  public GoodToPack() {
    {
    	this.setGood(new Good());
    }
  }

  public GoodToPack(final Good good) {
    super();
    
    this.setGood(good);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_GoodToPack(final Good good) {
    return null;
  }
}
