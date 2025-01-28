import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import jadescript.content.JadescriptProposition;
import jadescript.core.Agent;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.JadescriptAgentController;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class Supplier extends Agent {
  private Supplier __theAgent = (Supplier)/*Used as metadata*/null;

  private AgentEnv<Supplier, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected IngredientQuantity flour = null;

  public void setFlour(final IngredientQuantity flour) {
    this.flour = flour;
  }

  public IngredientQuantity getFlour() {
    return this.flour;
  }

  protected IngredientQuantity sugar = null;

  public void setSugar(final IngredientQuantity sugar) {
    this.sugar = sugar;
  }

  public IngredientQuantity getSugar() {
    return this.sugar;
  }

  protected IngredientQuantity eggs = null;

  public void setEggs(final IngredientQuantity eggs) {
    this.eggs = eggs;
  }

  public IngredientQuantity getEggs() {
    return this.eggs;
  }

  protected IngredientQuantity yeast = null;

  public void setYeast(final IngredientQuantity yeast) {
    this.yeast = yeast;
  }

  public IngredientQuantity getYeast() {
    return this.yeast;
  }

  protected IngredientQuantity water = null;

  public void setWater(final IngredientQuantity water) {
    this.water = water;
  }

  public IngredientQuantity getWater() {
    return this.water;
  }

  protected JadescriptList<IngredientQuantity> supplies1 = null;

  public void setSupplies1(final JadescriptList<IngredientQuantity> supplies1) {
    this.supplies1 = supplies1;
  }

  public JadescriptList<IngredientQuantity> getSupplies1() {
    return this.supplies1;
  }

  protected JadescriptList<IngredientQuantity> supplies2 = null;

  public void setSupplies2(final JadescriptList<IngredientQuantity> supplies2) {
    this.supplies2 = supplies2;
  }

  public JadescriptList<IngredientQuantity> getSupplies2() {
    return this.supplies2;
  }

  protected JadescriptList<IngredientQuantity> listOfAvSupplies = null;

  public void setListOfAvSupplies(final JadescriptList<IngredientQuantity> listOfAvSupplies) {
    this.listOfAvSupplies = listOfAvSupplies;
  }

  public JadescriptList<IngredientQuantity> getListOfAvSupplies() {
    return this.listOfAvSupplies;
  }

  protected String supplierType = null;

  public void setSupplierType(final String supplierType) {
    this.supplierType = supplierType;
  }

  public String getSupplierType() {
    return this.supplierType;
  }

  protected Boolean runOutSupply = null;

  public void setRunOutSupply(final Boolean runOutSupply) {
    this.runOutSupply = runOutSupply;
  }

  public Boolean getRunOutSupply() {
    return this.runOutSupply;
  }

  private void __onCreate() {
    java.lang.String type = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[0], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    try {
    	/* 
    	 * Compiled from source statement at line 15
    	 * supplierType of agent = type
    	 */
    	
    	_agentEnv.getAgent().setSupplierType(type);
    	
    	/* 
    	 * Compiled from source statement at line 16
    	 * runOutSupply = false
    	 */
    	
    	Supplier.this.setRunOutSupply(false);
    	
    	/* 
    	 * Compiled from source statement at line 18
    	 * log "SUPPLIER created with arguments: "+supplierType
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supplier.this.getClass().getName(), Supplier.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER created with arguments: ") + java.lang.String.valueOf(Supplier.this.getSupplierType())));
    	
    	/* 
    	 * Compiled from source statement from line 20 to line 23
    	 * if supplierType = "supplierType1" do
    	 *              listOfAvSupplies = supplies1
    	 *         else do
    	 *             listOfAvSupplies = supplies2
    	 */
    	
    	if(java.util.Objects.equals(Supplier.this.getSupplierType(), "supplierType1")) {
    		/* 
    		 * Compiled from source statement at line 21
    		 * listOfAvSupplies = supplies1
    		 */
    		
    		Supplier.this.setListOfAvSupplies(Supplier.this.getSupplies1());
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 23
    		 * listOfAvSupplies = supplies2
    		 */
    		
    		Supplier.this.setListOfAvSupplies(Supplier.this.getSupplies2());
    	}
    	
    	/* 
    	 * Compiled from source statement at line 25
    	 * 
    	 *         
    	 *         log "SUPPLIER'S list of supplies: "+listOfAvSupplies
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supplier.this.getClass().getName(), Supplier.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER'S list of supplies: ") + java.lang.String.valueOf(Supplier.this.getListOfAvSupplies())));
    	
    	/* 
    	 * Compiled from source statement at line 26
    	 * activate ProvidingRestock
    	 */
    	
    	new ProvidingRestock(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(Supplier.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  public void __handleBehaviourFailure(final jadescript.core.behaviours.Behaviour<?> __behaviour, final JadescriptProposition __reason) {
    boolean __handled = false;
    if(!__handled) {
    	jadescript.core.Agent.doLog(java.util.logging.Level.INFO, this.getClass().getName(), this, "<behaviour failure dispatcher>", "Behaviour " + __behaviour + " failed with reason: " + __reason);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	Supplier.this.flour = BakeryOntology.IngredientQuantity("flour" ,10);
    	
    	Supplier.this.sugar = BakeryOntology.IngredientQuantity("sugar" ,10);
    	
    	Supplier.this.eggs = BakeryOntology.IngredientQuantity("eggs" ,10);
    	
    	Supplier.this.yeast = BakeryOntology.IngredientQuantity("yeast" ,10);
    	
    	Supplier.this.water = BakeryOntology.IngredientQuantity("water" ,10);
    	
    	Supplier.this.supplies1 = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supplier.this.getFlour(), Supplier.this.getEggs()));
    	
    	Supplier.this.supplies2 = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supplier.this.getSugar(), Supplier.this.getYeast(), Supplier.this.getWater()));
    	
    	Supplier.this.listOfAvSupplies = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	Supplier.this.supplierType = "";
    	
    	Supplier.this.runOutSupply = false;
    }
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public Supplier __theAgent() {
    return this;
  }

  protected void setup() {
    super.setup();
    __initializeAgentEnv();
    __initializeProperties();
    this.__onCreate();
  }

  protected void __registerCodecs(final ContentManager cm) {
    super.__registerCodecs(cm);
    cm.registerLanguage(__codec);
  }

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName, final String type) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, Supplier.class, type);
  }
}
