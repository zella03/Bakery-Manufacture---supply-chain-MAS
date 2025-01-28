import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptAction;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class NeedRestock implements JadescriptAction {
  private AID agentId;

  public AID getAgentId() {
    return this.agentId;
  }

  public void setAgentId(final AID agentId) {
    this.agentId = agentId;
  }

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
    _sb.append("NeedRestock");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getAgentId()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getWhileProparing()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof NeedRestock) {
    	NeedRestock o = (NeedRestock) obj;
    	return true && java.util.Objects.equals(this.getAgentId(), o.getAgentId()) && java.util.Objects.equals(this.getIngredients(), o.getIngredients()) && java.util.Objects.equals(this.getWhileProparing(), o.getWhileProparing());
    } else {
    	return super.equals(obj);
    }
  }

  public NeedRestock() {
    {
    	this.setAgentId(new jade.core.AID());
    	
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    	
    	this.setWhileProparing(false);
    }
  }

  public NeedRestock(final AID agentId, final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    super();
    
    this.setAgentId(agentId);
    this.setIngredients(ingredients);
    this.setWhileProparing(whileProparing);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_NeedRestock(final AID agentId, final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    return null;
  }
}
