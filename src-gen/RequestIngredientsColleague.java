import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptAction;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class RequestIngredientsColleague implements JadescriptAction {
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

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("RequestIngredientsColleague");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getAgentId()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof RequestIngredientsColleague) {
    	RequestIngredientsColleague o = (RequestIngredientsColleague) obj;
    	return true && java.util.Objects.equals(this.getAgentId(), o.getAgentId()) && java.util.Objects.equals(this.getIngredients(), o.getIngredients());
    } else {
    	return super.equals(obj);
    }
  }

  public RequestIngredientsColleague() {
    {
    	this.setAgentId(new jade.core.AID());
    	
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    }
  }

  public RequestIngredientsColleague(final AID agentId, final JadescriptList<IngredientQuantity> ingredients) {
    super();
    
    this.setAgentId(agentId);
    this.setIngredients(ingredients);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_RequestIngredientsColleague(final AID agentId, final JadescriptList<IngredientQuantity> ingredients) {
    return null;
  }
}
