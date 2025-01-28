import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptPredicate;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class IngredientAvaliable implements JadescriptPredicate {
  private AID id;

  public AID getId() {
    return this.id;
  }

  public void setId(final AID id) {
    this.id = id;
  }

  private Boolean avaliable;

  public Boolean getAvaliable() {
    return this.avaliable;
  }

  public void setAvaliable(final Boolean avaliable) {
    this.avaliable = avaliable;
  }

  private JadescriptList<IngredientQuantity> ingredients;

  public JadescriptList<IngredientQuantity> getIngredients() {
    return this.ingredients;
  }

  public void setIngredients(final JadescriptList<IngredientQuantity> ingredients) {
    this.ingredients = ingredients;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("IngredientAvaliable");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getId()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getAvaliable()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof IngredientAvaliable) {
    	IngredientAvaliable o = (IngredientAvaliable) obj;
    	return true && java.util.Objects.equals(this.getId(), o.getId()) && java.util.Objects.equals(this.getAvaliable(), o.getAvaliable()) && java.util.Objects.equals(this.getIngredients(), o.getIngredients());
    } else {
    	return super.equals(obj);
    }
  }

  public IngredientAvaliable() {
    {
    	this.setId(new jade.core.AID());
    	
    	this.setAvaliable(false);
    	
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    }
  }

  public IngredientAvaliable(final AID id, final Boolean avaliable, final JadescriptList<IngredientQuantity> ingredients) {
    super();
    
    this.setId(id);
    this.setAvaliable(avaliable);
    this.setIngredients(ingredients);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_IngredientAvaliable(final AID id, final Boolean avaliable, final JadescriptList<IngredientQuantity> ingredients) {
    return null;
  }
}
