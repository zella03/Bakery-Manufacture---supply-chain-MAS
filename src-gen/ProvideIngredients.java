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

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("ProvideIngredients");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof ProvideIngredients) {
    	ProvideIngredients o = (ProvideIngredients) obj;
    	return true && java.util.Objects.equals(this.getIngredients(), o.getIngredients());
    } else {
    	return super.equals(obj);
    }
  }

  public ProvideIngredients() {
    {
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    }
  }

  public ProvideIngredients(final JadescriptList<IngredientQuantity> ingredients) {
    super();
    
    this.setIngredients(ingredients);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_ProvideIngredients(final JadescriptList<IngredientQuantity> ingredients) {
    return null;
  }
}
