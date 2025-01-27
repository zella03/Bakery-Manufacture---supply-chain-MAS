import jade.content.onto.Ontology;
import jadescript.content.JadescriptConcept;
import jadescript.lang.Duration;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class Good implements JadescriptConcept {
  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private JadescriptList<IngredientQuantity> ingredients;

  public JadescriptList<IngredientQuantity> getIngredients() {
    return this.ingredients;
  }

  public void setIngredients(final JadescriptList<IngredientQuantity> ingredients) {
    this.ingredients = ingredients;
  }

  private Duration bakingTime;

  public Duration getBakingTime() {
    return this.bakingTime;
  }

  public void setBakingTime(final Duration bakingTime) {
    this.bakingTime = bakingTime;
  }

  private Duration preparationTime;

  public Duration getPreparationTime() {
    return this.preparationTime;
  }

  public void setPreparationTime(final Duration preparationTime) {
    this.preparationTime = preparationTime;
  }

  private Integer batchSize;

  public Integer getBatchSize() {
    return this.batchSize;
  }

  public void setBatchSize(final Integer batchSize) {
    this.batchSize = batchSize;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("Good");
    _sb.append("(");
    _sb.append("\"" + java.lang.String.valueOf(getName()) + "\"");
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getIngredients()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getBakingTime()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getPreparationTime()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getBatchSize()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof Good) {
    	Good o = (Good) obj;
    	return true && java.util.Objects.equals(this.getName(), o.getName()) && java.util.Objects.equals(this.getIngredients(), o.getIngredients()) && java.util.Objects.equals(this.getBakingTime(), o.getBakingTime()) && java.util.Objects.equals(this.getPreparationTime(), o.getPreparationTime()) && java.util.Objects.equals(this.getBatchSize(), o.getBatchSize());
    } else {
    	return super.equals(obj);
    }
  }

  public Good() {
    {
    	this.setName("");
    	
    	this.setIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
    	
    	this.setBakingTime(new jadescript.lang.Duration());
    	
    	this.setPreparationTime(new jadescript.lang.Duration());
    	
    	this.setBatchSize(0);
    }
  }

  public Good(final String name, final JadescriptList<IngredientQuantity> ingredients, final Duration bakingTime, final Duration preparationTime, final Integer batchSize) {
    super();
    
    this.setName(name);
    this.setIngredients(ingredients);
    this.setBakingTime(bakingTime);
    this.setPreparationTime(preparationTime);
    this.setBatchSize(batchSize);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_Good(final String name, final JadescriptList<IngredientQuantity> ingredients, final Duration bakingTime, final Duration preparationTime, final Integer batchSize) {
    return null;
  }
}
