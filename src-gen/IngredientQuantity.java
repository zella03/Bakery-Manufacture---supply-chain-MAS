import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;

@SuppressWarnings("all")
public class IngredientQuantity implements JadescriptConcept {
  private String ingredientName;

  public String getIngredientName() {
    return this.ingredientName;
  }

  public void setIngredientName(final String ingredientName) {
    this.ingredientName = ingredientName;
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
    _sb.append("\"" + java.lang.String.valueOf(getIngredientName()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getQuantity()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof IngredientQuantity) {
    	IngredientQuantity o = (IngredientQuantity) obj;
    	return true && java.util.Objects.equals(this.getIngredientName(), o.getIngredientName()) && java.util.Objects.equals(this.getQuantity(), o.getQuantity());
    } else {
    	return super.equals(obj);
    }
  }

  public IngredientQuantity() {
    {
    	this.setIngredientName("");
    	
    	this.setQuantity(0);
    }
  }

  public IngredientQuantity(final String ingredientName, final Integer quantity) {
    super();
    
    this.setIngredientName(ingredientName);
    this.setQuantity(quantity);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_IngredientQuantity(final String ingredientName, final Integer quantity) {
    return null;
  }
}
