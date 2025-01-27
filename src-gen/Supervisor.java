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
public class Supervisor extends Agent {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected OrderQuantity orderBread = null;

  public void setOrderBread(final OrderQuantity orderBread) {
    this.orderBread = orderBread;
  }

  public OrderQuantity getOrderBread() {
    return this.orderBread;
  }

  protected OrderQuantity orderBun = null;

  public void setOrderBun(final OrderQuantity orderBun) {
    this.orderBun = orderBun;
  }

  public OrderQuantity getOrderBun() {
    return this.orderBun;
  }

  protected OrderQuantity orderCookies = null;

  public void setOrderCookies(final OrderQuantity orderCookies) {
    this.orderCookies = orderCookies;
  }

  public OrderQuantity getOrderCookies() {
    return this.orderCookies;
  }

  protected OrderQuantity orderCake = null;

  public void setOrderCake(final OrderQuantity orderCake) {
    this.orderCake = orderCake;
  }

  public OrderQuantity getOrderCake() {
    return this.orderCake;
  }

  protected OrderQuantity orderCupcake = null;

  public void setOrderCupcake(final OrderQuantity orderCupcake) {
    this.orderCupcake = orderCupcake;
  }

  public OrderQuantity getOrderCupcake() {
    return this.orderCupcake;
  }

  protected JadescriptList<OrderQuantity> privateOrders = null;

  public void setPrivateOrders(final JadescriptList<OrderQuantity> privateOrders) {
    this.privateOrders = privateOrders;
  }

  public JadescriptList<OrderQuantity> getPrivateOrders() {
    return this.privateOrders;
  }

  protected JadescriptList<OrderQuantity> normalOrders = null;

  public void setNormalOrders(final JadescriptList<OrderQuantity> normalOrders) {
    this.normalOrders = normalOrders;
  }

  public JadescriptList<OrderQuantity> getNormalOrders() {
    return this.normalOrders;
  }

  protected JadescriptList<Order> orderList = null;

  public void setOrderList(final JadescriptList<Order> orderList) {
    this.orderList = orderList;
  }

  public JadescriptList<Order> getOrderList() {
    return this.orderList;
  }

  protected JadescriptList<OrderStatus> pendingOrders = null;

  public void setPendingOrders(final JadescriptList<OrderStatus> pendingOrders) {
    this.pendingOrders = pendingOrders;
  }

  public JadescriptList<OrderStatus> getPendingOrders() {
    return this.pendingOrders;
  }

  protected String type = null;

  public void setType(final String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  protected Integer numOfWorkers = null;

  public void setNumOfWorkers(final Integer numOfWorkers) {
    this.numOfWorkers = numOfWorkers;
  }

  public Integer getNumOfWorkers() {
    return this.numOfWorkers;
  }

  protected Integer orderCount = null;

  public void setOrderCount(final Integer orderCount) {
    this.orderCount = orderCount;
  }

  public Integer getOrderCount() {
    return this.orderCount;
  }

  protected JadescriptList<WorkerReady> listOfWorkers = null;

  public void setListOfWorkers(final JadescriptList<WorkerReady> listOfWorkers) {
    this.listOfWorkers = listOfWorkers;
  }

  public JadescriptList<WorkerReady> getListOfWorkers() {
    return this.listOfWorkers;
  }

  public void SplitIntoOrders(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final JadescriptList<OrderQuantity> listOfOrders, final Integer ratio) {
    {
    	/* 
    	 * Compiled from source statement from line 25 to line 31
    	 * for i in listOfOrders do
    	 *             if quantity of i ≠ 0 do
    	 * 	            for j in 0 to ((quantity of i/ratio)-1) do
    	 * 	                #log name of agent +"_"+j+ " got in here: "+(quantity of i/ratio)
    	 * 	                id = (name of agent + "_" + orderCount) as text
    	 * 	                add Order(id,good of i,"pending",type of i) to orderList
    	 * 	                orderCount = orderCount + 1
    	 */
    	
    	for ( OrderQuantity i : listOfOrders) {
    		/* 
    		 * Compiled from source statement from line 26 to line 31
    		 * if quantity of i ≠ 0 do
    		 * 	            for j in 0 to ((quantity of i/ratio)-1) do
    		 * 	                #log name of agent +"_"+j+ " got in here: "+(quantity of i/ratio)
    		 * 	                id = (name of agent + "_" + orderCount) as text
    		 * 	                add Order(id,good of i,"pending",type of i) to orderList
    		 * 	                orderCount = orderCount + 1
    		 */
    		
    		if(!java.util.Objects.equals(i.getQuantity(), 0)) {
    			/* 
    			 * Compiled from source statement from line 27 to line 31
    			 * for j in 0 to ((quantity of i/ratio)-1) do
    			 * 	                #log name of agent +"_"+j+ " got in here: "+(quantity of i/ratio)
    			 * 	                id = (name of agent + "_" + orderCount) as text
    			 * 	                add Order(id,good of i,"pending",type of i) to orderList
    			 * 	                orderCount = orderCount + 1
    			 */
    			
    			for ( java.lang.Integer j : new jadescript.util.IntegerRange(0, ((i.getQuantity() / ratio) - 1), true, true)) {
    				/* 
    				 * Compiled from source statement at line 29
    				 * id = (name of agent + "_" + orderCount) as text
    				 */
    				
    				java.lang.String id = ((java.lang.String) jadescript.util.types.Converter.convert((java.lang.String.valueOf(java.lang.String.valueOf(_agentEnv.getAgent().getName()) + java.lang.String.valueOf("_")) + java.lang.String.valueOf(Supervisor.this.getOrderCount())), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT)));
    				
    				/* 
    				 * Compiled from source statement at line 30
    				 * add Order(id,good of i,"pending",type of i) to orderList
    				 */
    				
    				Supervisor.this.getOrderList().add(BakeryOntology.Order(id ,i.getGood() ,"pending" ,i.getType()));
    				
    				/* 
    				 * Compiled from source statement at line 31
    				 * orderCount = orderCount + 1
    				 */
    				
    				Supervisor.this.setOrderCount(Supervisor.this.getOrderCount() + 1);
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 32
    	 * 
    	 *         log "Splitted orders of SUPERVISOR: "+orderList
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supervisor.this.getClass().getName(), Supervisor.this, "SplitIntoOrders", java.lang.String.valueOf(java.lang.String.valueOf("Splitted orders of SUPERVISOR: ") + java.lang.String.valueOf(Supervisor.this.getOrderList())));
    }
  }

  private void __onCreate() {
    java.lang.String type = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[0], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.Integer numOfWorkers = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[1], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER));
    try {
    	/* 
    	 * Compiled from source statement at line 36
    	 * type of agent = type
    	 */
    	
    	_agentEnv.getAgent().setType(type);
    	
    	/* 
    	 * Compiled from source statement at line 37
    	 * numOfWorkers of agent = numOfWorkers
    	 */
    	
    	_agentEnv.getAgent().setNumOfWorkers(numOfWorkers);
    	
    	/* 
    	 * Compiled from source statement at line 38
    	 * orderCount of agent = 0
    	 */
    	
    	_agentEnv.getAgent().setOrderCount(0);
    	
    	/* 
    	 * Compiled from source statement at line 39
    	 * log "SUPERVISOR created with arguments: "+type
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supervisor.this.getClass().getName(), Supervisor.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("SUPERVISOR created with arguments: ") + java.lang.String.valueOf(type)));
    	
    	/* 
    	 * Compiled from source statement from line 44 to line 47
    	 * if type of agent = "normal" do
    	 *             do SplitIntoOrders with normalOrders,1
    	 *         else do
    	 *             do SplitIntoOrders with privateOrders,1
    	 */
    	
    	if(java.util.Objects.equals(_agentEnv.getAgent().getType(), "normal")) {
    		/* 
    		 * Compiled from source statement at line 45
    		 * do SplitIntoOrders with normalOrders,1
    		 */
    		
    		Supervisor.this.SplitIntoOrders(_agentEnv.getAgent().toEnv() ,Supervisor.this.getNormalOrders() ,1);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 47
    		 * do SplitIntoOrders with privateOrders,1
    		 */
    		
    		Supervisor.this.SplitIntoOrders(_agentEnv.getAgent().toEnv() ,Supervisor.this.getPrivateOrders() ,1);
    	}
    	
    	/* 
    	 * Compiled from source statement at line 49
    	 * 
    	 *             
    	 *         activate ReportingWorkers
    	 */
    	
    	new ReportingWorkers(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(Supervisor.this);
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
    	Supervisor.this.orderBread = BakeryOntology.OrderQuantity("bread" ,"normal" ,3);
    	
    	Supervisor.this.orderBun = BakeryOntology.OrderQuantity("bun" ,"normal" ,1);
    	
    	Supervisor.this.orderCookies = BakeryOntology.OrderQuantity("cookies" ,"normal" ,1);
    	
    	Supervisor.this.orderCake = BakeryOntology.OrderQuantity("cake" ,"private" ,1);
    	
    	Supervisor.this.orderCupcake = BakeryOntology.OrderQuantity("cupcakes" ,"private" ,2);
    	
    	Supervisor.this.privateOrders = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getOrderCake(), Supervisor.this.getOrderCupcake()));
    	
    	Supervisor.this.normalOrders = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getOrderBread(), Supervisor.this.getOrderBun(), Supervisor.this.getOrderCookies()));
    	
    	Supervisor.this.orderList = new jadescript.util.JadescriptList<Order>();
    	
    	Supervisor.this.pendingOrders = new jadescript.util.JadescriptList<OrderStatus>();
    	
    	Supervisor.this.type = "";
    	
    	Supervisor.this.numOfWorkers = 0;
    	
    	Supervisor.this.orderCount = 0;
    	
    	Supervisor.this.listOfWorkers = new jadescript.util.JadescriptList<WorkerReady>();
    }
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public Supervisor __theAgent() {
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

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName, final String type, final Integer numOfWorkers) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, Supervisor.class, type, numOfWorkers);
  }
}
