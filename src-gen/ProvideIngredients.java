import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class ProvideIngredients implements JadescriptAction {
  private JadescriptList<IngredientQuantity> ingredients;

  public JadescriptList<IngredientQuantity> getIngredients() {
    return this.ingredients;
  }

  public void setIngredients(final JadescriptList<IngredientQuantity> ingredients) {
    this.ingredients = ingredients;
  }

  private Boolean whileProparing;

  public Boolean getWhileProparing() {
    return this.whileProparing;
  }

  public void setWhileProparing(final Boolean whileProparing) {
    this.whileProparing = whileProparing;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("ProvideIngredients");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getWhileProparing()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof ProvideIngredients) {
    	ProvideIngredients o = (ProvideIngredients) obj;
    	return true && java.util.Objects.equals(this.getIngredients(), o.getIngredients()) && java.util.Objects.equals(this.getWhileProparing(), o.getWhileProparing());
    } else {
    	return super.equals(obj);
    }
  }

  public ProvideIngredients() {
    {
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    	
    	this.setWhileProparing(false);
    }
  }

  public ProvideIngredients(final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    super();
    
    this.setIngredients(ingredients);
    this.setWhileProparing(whileProparing);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_ProvideIngredients(final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    return null;
  }
}
