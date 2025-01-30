import jade.content.onto.Ontology;
import jade.core.AID;
import jadescript.content.JadescriptPredicate;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class BakerRaportInfo implements JadescriptPredicate {
  private AID id;

  public AID getId() {
    return this.id;
  }

  public void setId(final AID id) {
    this.id = id;
  }

  private Integer numRestockFromColl;

  public Integer getNumRestockFromColl() {
    return this.numRestockFromColl;
  }

  public void setNumRestockFromColl(final Integer numRestockFromColl) {
    this.numRestockFromColl = numRestockFromColl;
  }

  private Integer numRestockFromSupp;

  public Integer getNumRestockFromSupp() {
    return this.numRestockFromSupp;
  }

  public void setNumRestockFromSupp(final Integer numRestockFromSupp) {
    this.numRestockFromSupp = numRestockFromSupp;
  }

  private Integer numOrdersToRedo;

  public Integer getNumOrdersToRedo() {
    return this.numOrdersToRedo;
  }

  public void setNumOrdersToRedo(final Integer numOrdersToRedo) {
    this.numOrdersToRedo = numOrdersToRedo;
  }

  private Integer ordersDone;

  public Integer getOrdersDone() {
    return this.ordersDone;
  }

  public void setOrdersDone(final Integer ordersDone) {
    this.ordersDone = ordersDone;
  }

  private JadescriptList<IngredientQuantity> restStock;

  public JadescriptList<IngredientQuantity> getRestStock() {
    return this.restStock;
  }

  public void setRestStock(final JadescriptList<IngredientQuantity> restStock) {
    this.restStock = restStock;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("BakerRaportInfo");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getId()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getNumRestockFromColl()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getNumRestockFromSupp()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getNumOrdersToRedo()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getOrdersDone()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getRestStock()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof BakerRaportInfo) {
    	BakerRaportInfo o = (BakerRaportInfo) obj;
    	return true && java.util.Objects.equals(this.getId(), o.getId()) && java.util.Objects.equals(this.getNumRestockFromColl(), o.getNumRestockFromColl()) && java.util.Objects.equals(this.getNumRestockFromSupp(), o.getNumRestockFromSupp()) && java.util.Objects.equals(this.getNumOrdersToRedo(), o.getNumOrdersToRedo()) && java.util.Objects.equals(this.getOrdersDone(), o.getOrdersDone()) && java.util.Objects.equals(this.getRestStock(), o.getRestStock());
    } else {
    	return super.equals(obj);
    }
  }

  public BakerRaportInfo() {
    {
    	this.setId(new jade.core.AID());
    	
    	this.setNumRestockFromColl(0);
    	
    	this.setNumRestockFromSupp(0);
    	
    	this.setNumOrdersToRedo(0);
    	
    	this.setOrdersDone(0);
    	
    	this.setRestStock(new jadescript.util.JadescriptList<IngredientQuantity>());
    }
  }

  public BakerRaportInfo(final AID id, final Integer numRestockFromColl, final Integer numRestockFromSupp, final Integer numOrdersToRedo, final Integer ordersDone, final JadescriptList<IngredientQuantity> restStock) {
    super();
    
    this.setId(id);
    this.setNumRestockFromColl(numRestockFromColl);
    this.setNumRestockFromSupp(numRestockFromSupp);
    this.setNumOrdersToRedo(numOrdersToRedo);
    this.setOrdersDone(ordersDone);
    this.setRestStock(restStock);
  }

  public Ontology __getDeclaringOntology() {
    return BakeryOntology.getInstance();
  }

  private BakeryOntology __metadata_BakerRaportInfo(final AID id, final Integer numRestockFromColl, final Integer numRestockFromSupp, final Integer numOrdersToRedo, final Integer ordersDone, final JadescriptList<IngredientQuantity> restStock) {
    return null;
  }
}
