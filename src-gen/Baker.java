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
public class Baker extends Agent {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected Good bread = null;

  public void setBread(final Good bread) {
    this.bread = bread;
  }

  public Good getBread() {
    return this.bread;
  }

  protected Good bun = null;

  public void setBun(final Good bun) {
    this.bun = bun;
  }

  public Good getBun() {
    return this.bun;
  }

  protected Good cookies = null;

  public void setCookies(final Good cookies) {
    this.cookies = cookies;
  }

  public Good getCookies() {
    return this.cookies;
  }

  protected Good cake = null;

  public void setCake(final Good cake) {
    this.cake = cake;
  }

  public Good getCake() {
    return this.cake;
  }

  protected Good cupcakes = null;

  public void setCupcakes(final Good cupcakes) {
    this.cupcakes = cupcakes;
  }

  public Good getCupcakes() {
    return this.cupcakes;
  }

  protected JadescriptList<Good> recipeBook = null;

  public void setRecipeBook(final JadescriptList<Good> recipeBook) {
    this.recipeBook = recipeBook;
  }

  public JadescriptList<Good> getRecipeBook() {
    return this.recipeBook;
  }

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

  protected JadescriptList<IngredientQuantity> stock = null;

  public void setStock(final JadescriptList<IngredientQuantity> stock) {
    this.stock = stock;
  }

  public JadescriptList<IngredientQuantity> getStock() {
    return this.stock;
  }

  protected String typeBaker = null;

  public void setTypeBaker(final String typeBaker) {
    this.typeBaker = typeBaker;
  }

  public String getTypeBaker() {
    return this.typeBaker;
  }

  protected String supervisorName = null;

  public void setSupervisorName(final String supervisorName) {
    this.supervisorName = supervisorName;
  }

  public String getSupervisorName() {
    return this.supervisorName;
  }

  protected JadescriptList<String> listOfSuppliers = null;

  public void setListOfSuppliers(final JadescriptList<String> listOfSuppliers) {
    this.listOfSuppliers = listOfSuppliers;
  }

  public JadescriptList<String> getListOfSuppliers() {
    return this.listOfSuppliers;
  }

  protected JadescriptList<String> listOfCoworkers = null;

  public void setListOfCoworkers(final JadescriptList<String> listOfCoworkers) {
    this.listOfCoworkers = listOfCoworkers;
  }

  public JadescriptList<String> getListOfCoworkers() {
    return this.listOfCoworkers;
  }

  protected JadescriptList<OrderStatus> ordersList = null;

  public void setOrdersList(final JadescriptList<OrderStatus> ordersList) {
    this.ordersList = ordersList;
  }

  public JadescriptList<OrderStatus> getOrdersList() {
    return this.ordersList;
  }

  protected JadescriptList<Order> fullOrderList = null;

  public void setFullOrderList(final JadescriptList<Order> fullOrderList) {
    this.fullOrderList = fullOrderList;
  }

  public JadescriptList<Order> getFullOrderList() {
    return this.fullOrderList;
  }

  protected Boolean currentlyAskingForOrder = null;

  public void setCurrentlyAskingForOrder(final Boolean currentlyAskingForOrder) {
    this.currentlyAskingForOrder = currentlyAskingForOrder;
  }

  public Boolean getCurrentlyAskingForOrder() {
    return this.currentlyAskingForOrder;
  }

  public void changeToNormal(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement at line 70
    	 * typeBaker of this = "normal"
    	 */
    	
    	Baker.this.setTypeBaker("normal");
    	
    	/* 
    	 * Compiled from source statement at line 71
    	 * recipeBook = [bread, bun, cookies]
    	 */
    	
    	Baker.this.setRecipeBook(jadescript.util.JadescriptCollections.createList(java.util.List.of(Baker.this.getBread(), Baker.this.getBun(), Baker.this.getCookies())));
    }
  }

  public void chnageStatus(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final String id, final String newStatus) {
    {
    	/* 
    	 * Compiled from source statement from line 74 to line 77
    	 * for i in ordersList do
    	 * 	       if orderId of i = id do
    	 * 	           status of i = newStatus
    	 * 	           break
    	 */
    	
    	for ( OrderStatus i : Baker.this.getOrdersList()) {
    		/* 
    		 * Compiled from source statement from line 75 to line 77
    		 * if orderId of i = id do
    		 * 	           status of i = newStatus
    		 * 	           break
    		 */
    		
    		if(java.util.Objects.equals(i.getOrderId(), id)) {
    			/* 
    			 * Compiled from source statement at line 76
    			 * status of i = newStatus
    			 */
    			
    			i.setStatus(newStatus);
    			
    			/* 
    			 * Compiled from source statement at line 77
    			 * break
    			 */
    			
    			break;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement from line 78 to line 81
    	 * 
    	 * 	   for i in fullOrderList do
    	 * 	       if id of i = id do
    	 * 	           status of i = newStatus
    	 * 	           break
    	 */
    	
    	for ( Order i : Baker.this.getFullOrderList()) {
    		/* 
    		 * Compiled from source statement from line 79 to line 81
    		 * if id of i = id do
    		 * 	           status of i = newStatus
    		 * 	           break
    		 */
    		
    		if(java.util.Objects.equals(i.getId(), id)) {
    			/* 
    			 * Compiled from source statement at line 80
    			 * status of i = newStatus
    			 */
    			
    			i.setStatus(newStatus);
    			
    			/* 
    			 * Compiled from source statement at line 81
    			 * break
    			 */
    			
    			break;
    		}
    	}
    }
  }

  private void __onCreate() {
    java.lang.String type = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[0], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.String supervisor = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[1], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.String coworker1 = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[2], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.String supplier1 = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[3], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.String supplier2 = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[4], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    try {
    	/* 
    	 * Compiled from source statement at line 84
    	 * typeBaker of this = type
    	 */
    	
    	Baker.this.setTypeBaker(type);
    	
    	/* 
    	 * Compiled from source statement at line 85
    	 * supervisorName of this = supervisor
    	 */
    	
    	Baker.this.setSupervisorName(supervisor);
    	
    	/* 
    	 * Compiled from source statement at line 86
    	 * add coworker1 to listOfCoworkers
    	 */
    	
    	Baker.this.getListOfCoworkers().add(coworker1);
    	
    	/* 
    	 * Compiled from source statement at line 87
    	 * add supplier1 to listOfSuppliers
    	 */
    	
    	Baker.this.getListOfSuppliers().add(supplier1);
    	
    	/* 
    	 * Compiled from source statement at line 88
    	 * add supplier2 to listOfSuppliers
    	 */
    	
    	Baker.this.getListOfSuppliers().add(supplier2);
    	
    	/* 
    	 * Compiled from source statement at line 89
    	 * log "BAKER created with arguments: " + typeBaker + ", " + supervisor
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Baker.this.getClass().getName(), Baker.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER created with arguments: ") + java.lang.String.valueOf(Baker.this.getTypeBaker())) + java.lang.String.valueOf(", ")) + java.lang.String.valueOf(supervisor)));
    	
    	/* 
    	 * Compiled from source statement at line 91
    	 * activate DelayedWorkerReady after "PT2S" as duration
    	 */
    	
    	new DelayedWorkerReady(_agentEnv.getAgent().toEnv()).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT2S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
    	
    	/* 
    	 * Compiled from source statement from line 94 to line 97
    	 * if type = "normal" do
    	 *             recipeBook of this = [bread, bun, cookies]
    	 *         else do
    	 *             recipeBook of this= [cake, cupcakes]
    	 */
    	
    	if(java.util.Objects.equals(type, "normal")) {
    		/* 
    		 * Compiled from source statement at line 95
    		 * recipeBook of this = [bread, bun, cookies]
    		 */
    		
    		Baker.this.setRecipeBook(jadescript.util.JadescriptCollections.createList(java.util.List.of(Baker.this.getBread(), Baker.this.getBun(), Baker.this.getCookies())));
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 97
    		 * recipeBook of this= [cake, cupcakes]
    		 */
    		
    		Baker.this.setRecipeBook(jadescript.util.JadescriptCollections.createList(java.util.List.of(Baker.this.getCake(), Baker.this.getCupcakes())));
    	}
    	
    	/* 
    	 * Compiled from source statement at line 98
    	 * 
    	 *         log "BAKER knowledge RECIPE_BOOK: "+recipeBook
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Baker.this.getClass().getName(), Baker.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("BAKER knowledge RECIPE_BOOK: ") + java.lang.String.valueOf(Baker.this.getRecipeBook())));
    	
    	/* 
    	 * Compiled from source statement at line 100
    	 * activate ManageOrders
    	 */
    	
    	new ManageOrders(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
    	
    	/* 
    	 * Compiled from source statement at line 101
    	 * activate ListenCoworkers
    	 */
    	
    	new ListenCoworkers(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(Baker.this);
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
    	Baker.this.bread = BakeryOntology.Good("bread" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(BakeryOntology.IngredientQuantity("flour" ,2), BakeryOntology.IngredientQuantity("water" ,2), BakeryOntology.IngredientQuantity("yeast" ,1))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT20S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT10S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,6);
    	
    	Baker.this.bun = BakeryOntology.Good("bun" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(BakeryOntology.IngredientQuantity("flour" ,2), BakeryOntology.IngredientQuantity("water" ,2), BakeryOntology.IngredientQuantity("yeast" ,1))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT25S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT15S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,8);
    	
    	Baker.this.cookies = BakeryOntology.Good("cookies" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(BakeryOntology.IngredientQuantity("flour" ,2), BakeryOntology.IngredientQuantity("water" ,1), BakeryOntology.IngredientQuantity("eggs" ,2), BakeryOntology.IngredientQuantity("sugar" ,2))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT15S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT20S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,14);
    	
    	Baker.this.cake = BakeryOntology.Good("cake" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(BakeryOntology.IngredientQuantity("flour" ,4), BakeryOntology.IngredientQuantity("water" ,2), BakeryOntology.IngredientQuantity("eggs" ,3), BakeryOntology.IngredientQuantity("sugar" ,2))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT30S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT20S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,1);
    	
    	Baker.this.cupcakes = BakeryOntology.Good("cupcakes" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(BakeryOntology.IngredientQuantity("flour" ,4), BakeryOntology.IngredientQuantity("sugar" ,2), BakeryOntology.IngredientQuantity("eggs" ,3))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT10S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT15S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))) ,6);
    	
    	Baker.this.recipeBook = new jadescript.util.JadescriptList<Good>();
    	
    	Baker.this.flour = BakeryOntology.IngredientQuantity("flour" ,15);
    	
    	Baker.this.sugar = BakeryOntology.IngredientQuantity("sugar" ,20);
    	
    	Baker.this.eggs = BakeryOntology.IngredientQuantity("eggs" ,20);
    	
    	Baker.this.yeast = BakeryOntology.IngredientQuantity("yeast" ,20);
    	
    	Baker.this.water = BakeryOntology.IngredientQuantity("water" ,20);
    	
    	Baker.this.stock = jadescript.util.JadescriptCollections.createList(java.util.List.of(Baker.this.getFlour(), Baker.this.getSugar(), Baker.this.getEggs(), Baker.this.getYeast(), Baker.this.getWater()));
    	
    	Baker.this.typeBaker = "";
    	
    	Baker.this.supervisorName = "";
    	
    	Baker.this.listOfSuppliers = new jadescript.util.JadescriptList<java.lang.String>();
    	
    	Baker.this.listOfCoworkers = new jadescript.util.JadescriptList<java.lang.String>();
    	
    	Baker.this.ordersList = new jadescript.util.JadescriptList<OrderStatus>();
    	
    	Baker.this.fullOrderList = new jadescript.util.JadescriptList<Order>();
    	
    	Baker.this.currentlyAskingForOrder = false;
    }
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public Baker __theAgent() {
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

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName, final String type, final String supervisor, final String coworker1, final String supplier1, final String supplier2) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, Baker.class, type, supervisor, coworker1, supplier1, supplier2);
  }
}
