import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;

@SuppressWarnings("all")
public class IngredientQuantity implements JadescriptConcept {
  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
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
    _sb.append("IngredientQuantity");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getName()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getQuantity()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof IngredientQuantity) {
    	IngredientQuantity o = (IngredientQuantity) obj;
    	return true && java.util.Objects.equals(this.getName(), o.getName()) && java.util.Objects.equals(this.getQuantity(), o.getQuantity());
    } else {
    	return super.equals(obj);
    }
  }

  public IngredientQuantity() {
    {
    	this.setName("");
    	
    	this.setQuantity(0);
    }
  }

  public IngredientQuantity(final String name, final Integer quantity) {
    super();
    
    this.setName(name);
    this.setQuantity(quantity);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_IngredientQuantity(final String name, final Integer quantity) {
    return null;
  }
}
