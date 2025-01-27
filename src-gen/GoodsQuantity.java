import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;

@SuppressWarnings("all")
public class GoodsQuantity implements JadescriptConcept {
  private Good good;

  public Good getGood() {
    return this.good;
  }

  public void setGood(final Good good) {
    this.good = good;
  }

  private Integer quantity;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(final Integer quantity) {
    this.quantity = quantity;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("GoodsQuantity");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getGood()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getQuantity()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof GoodsQuantity) {
    	GoodsQuantity o = (GoodsQuantity) obj;
    	return true && java.util.Objects.equals(this.getGood(), o.getGood()) && java.util.Objects.equals(this.getQuantity(), o.getQuantity());
    } else {
    	return super.equals(obj);
    }
  }

  public GoodsQuantity() {
    {
    	this.setGood(new Good());
    	
    	this.setQuantity(0);
    }
  }

  public GoodsQuantity(final Good good, final Integer quantity) {
    super();
    
    this.setGood(good);
    this.setQuantity(quantity);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_GoodsQuantity(final Good good, final Integer quantity) {
    return null;
  }
}
