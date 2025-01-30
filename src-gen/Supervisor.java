import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.core.AID;
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

  protected OrderQuantity orderCake1 = null;

  public void setOrderCake1(final OrderQuantity orderCake1) {
    this.orderCake1 = orderCake1;
  }

  public OrderQuantity getOrderCake1() {
    return this.orderCake1;
  }

  protected OrderQuantity orderCupcake1 = null;

  public void setOrderCupcake1(final OrderQuantity orderCupcake1) {
    this.orderCupcake1 = orderCupcake1;
  }

  public OrderQuantity getOrderCupcake1() {
    return this.orderCupcake1;
  }

  protected OrderQuantity orderCake2 = null;

  public void setOrderCake2(final OrderQuantity orderCake2) {
    this.orderCake2 = orderCake2;
  }

  public OrderQuantity getOrderCake2() {
    return this.orderCake2;
  }

  protected OrderQuantity orderCupcake2 = null;

  public void setOrderCupcake2(final OrderQuantity orderCupcake2) {
    this.orderCupcake2 = orderCupcake2;
  }

  public OrderQuantity getOrderCupcake2() {
    return this.orderCupcake2;
  }

  protected PackageOfGoods package1 = null;

  public void setPackage1(final PackageOfGoods package1) {
    this.package1 = package1;
  }

  public PackageOfGoods getPackage1() {
    return this.package1;
  }

  protected PackageOfGoods package2 = null;

  public void setPackage2(final PackageOfGoods package2) {
    this.package2 = package2;
  }

  public PackageOfGoods getPackage2() {
    return this.package2;
  }

  protected JadescriptList<PackageOfGoods> privateOrders = null;

  public void setPrivateOrders(final JadescriptList<PackageOfGoods> privateOrders) {
    this.privateOrders = privateOrders;
  }

  public JadescriptList<PackageOfGoods> getPrivateOrders() {
    return this.privateOrders;
  }

  protected JadescriptList<PackageOfGoods> finishedPackages = null;

  public void setFinishedPackages(final JadescriptList<PackageOfGoods> finishedPackages) {
    this.finishedPackages = finishedPackages;
  }

  public JadescriptList<PackageOfGoods> getFinishedPackages() {
    return this.finishedPackages;
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

  protected String coSupplier = null;

  public void setCoSupplier(final String coSupplier) {
    this.coSupplier = coSupplier;
  }

  public String getCoSupplier() {
    return this.coSupplier;
  }

  protected Integer orderCount = null;

  public void setOrderCount(final Integer orderCount) {
    this.orderCount = orderCount;
  }

  public Integer getOrderCount() {
    return this.orderCount;
  }

  protected JadescriptList<WorkerReady> listOfBakers = null;

  public void setListOfBakers(final JadescriptList<WorkerReady> listOfBakers) {
    this.listOfBakers = listOfBakers;
  }

  public JadescriptList<WorkerReady> getListOfBakers() {
    return this.listOfBakers;
  }

  protected AID packer = null;

  public void setPacker(final AID packer) {
    this.packer = packer;
  }

  public AID getPacker() {
    return this.packer;
  }

  protected JadescriptList<AID> supplierList = null;

  public void setSupplierList(final JadescriptList<AID> supplierList) {
    this.supplierList = supplierList;
  }

  public JadescriptList<AID> getSupplierList() {
    return this.supplierList;
  }

  public void SplitIntoOrdersNormal(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final JadescriptList<OrderQuantity> listOfOrders, final Integer ratio) {
    {
    	/* 
    	 * Compiled from source statement from line 34 to line 39
    	 * for i in listOfOrders do
    	 *             if quantity of i ≠ 0 do
    	 * 	            for j in 0 to ((quantity of i/ratio)-1) do
    	 * 	                id = (name of agent + "_" + orderCount) as text
    	 * 	                add Order(id,good of i,"pending",type of i) to orderList
    	 * 	                orderCount = orderCount + 1
    	 */
    	
    	for ( OrderQuantity i : listOfOrders) {
    		/* 
    		 * Compiled from source statement from line 35 to line 39
    		 * if quantity of i ≠ 0 do
    		 * 	            for j in 0 to ((quantity of i/ratio)-1) do
    		 * 	                id = (name of agent + "_" + orderCount) as text
    		 * 	                add Order(id,good of i,"pending",type of i) to orderList
    		 * 	                orderCount = orderCount + 1
    		 */
    		
    		if(!java.util.Objects.equals(i.getQuantity(), 0)) {
    			/* 
    			 * Compiled from source statement from line 36 to line 39
    			 * for j in 0 to ((quantity of i/ratio)-1) do
    			 * 	                id = (name of agent + "_" + orderCount) as text
    			 * 	                add Order(id,good of i,"pending",type of i) to orderList
    			 * 	                orderCount = orderCount + 1
    			 */
    			
    			for ( java.lang.Integer j : new jadescript.util.IntegerRange(0, ((i.getQuantity() / ratio) - 1), true, true)) {
    				/* 
    				 * Compiled from source statement at line 37
    				 * id = (name of agent + "_" + orderCount) as text
    				 */
    				
    				java.lang.String id = ((java.lang.String) jadescript.util.types.Converter.convert((java.lang.String.valueOf(java.lang.String.valueOf(_agentEnv.getAgent().getName()) + java.lang.String.valueOf("_")) + java.lang.String.valueOf(Supervisor.this.getOrderCount())), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT)));
    				
    				/* 
    				 * Compiled from source statement at line 38
    				 * add Order(id,good of i,"pending",type of i) to orderList
    				 */
    				
    				Supervisor.this.getOrderList().add(BakeryOntology.Order(id ,i.getGood() ,"pending" ,i.getType()));
    				
    				/* 
    				 * Compiled from source statement at line 39
    				 * orderCount = orderCount + 1
    				 */
    				
    				Supervisor.this.setOrderCount(Supervisor.this.getOrderCount() + 1);
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 40
    	 * 
    	 *         log "Splitted orders of SUPERVISOR: "+orderList
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supervisor.this.getClass().getName(), Supervisor.this, "SplitIntoOrdersNormal", java.lang.String.valueOf(java.lang.String.valueOf("Splitted orders of SUPERVISOR: ") + java.lang.String.valueOf(Supervisor.this.getOrderList())));
    }
  }

  public void SplitIntoOrdersPrivate(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final JadescriptList<PackageOfGoods> listOfPackages) {
    {
    	/* 
    	 * Compiled from source statement from line 43 to line 49
    	 * for pcg in listOfPackages do
    	 *             for order in ordersInPackage of pcg do 
    	 * 	            if quantity of order ≠ 0 do
    	 * 	                for j in 0 to (quantity of order-1) do
    	 * 	                    id = (name of agent + "_" + orderCount) as text
    	 * 	                    add Order(id,good of order,"pending",type of order) to orderList
    	 * 	                    orderCount = orderCount + 1
    	 */
    	
    	for ( PackageOfGoods pcg : listOfPackages) {
    		/* 
    		 * Compiled from source statement from line 44 to line 49
    		 * for order in ordersInPackage of pcg do 
    		 * 	            if quantity of order ≠ 0 do
    		 * 	                for j in 0 to (quantity of order-1) do
    		 * 	                    id = (name of agent + "_" + orderCount) as text
    		 * 	                    add Order(id,good of order,"pending",type of order) to orderList
    		 * 	                    orderCount = orderCount + 1
    		 */
    		
    		for ( OrderQuantity order : pcg.getOrdersInPackage()) {
    			/* 
    			 * Compiled from source statement from line 45 to line 49
    			 * if quantity of order ≠ 0 do
    			 * 	                for j in 0 to (quantity of order-1) do
    			 * 	                    id = (name of agent + "_" + orderCount) as text
    			 * 	                    add Order(id,good of order,"pending",type of order) to orderList
    			 * 	                    orderCount = orderCount + 1
    			 */
    			
    			if(!java.util.Objects.equals(order.getQuantity(), 0)) {
    				/* 
    				 * Compiled from source statement from line 46 to line 49
    				 * for j in 0 to (quantity of order-1) do
    				 * 	                    id = (name of agent + "_" + orderCount) as text
    				 * 	                    add Order(id,good of order,"pending",type of order) to orderList
    				 * 	                    orderCount = orderCount + 1
    				 */
    				
    				for ( java.lang.Integer j : new jadescript.util.IntegerRange(0, (order.getQuantity() - 1), true, true)) {
    					/* 
    					 * Compiled from source statement at line 47
    					 * id = (name of agent + "_" + orderCount) as text
    					 */
    					
    					java.lang.String id = ((java.lang.String) jadescript.util.types.Converter.convert((java.lang.String.valueOf(java.lang.String.valueOf(_agentEnv.getAgent().getName()) + java.lang.String.valueOf("_")) + java.lang.String.valueOf(Supervisor.this.getOrderCount())), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT)));
    					
    					/* 
    					 * Compiled from source statement at line 48
    					 * add Order(id,good of order,"pending",type of order) to orderList
    					 */
    					
    					Supervisor.this.getOrderList().add(BakeryOntology.Order(id ,order.getGood() ,"pending" ,order.getType()));
    					
    					/* 
    					 * Compiled from source statement at line 49
    					 * orderCount = orderCount + 1
    					 */
    					
    					Supervisor.this.setOrderCount(Supervisor.this.getOrderCount() + 1);
    				}
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 50
    	 * 
    	 *         log "Splitted orders of SUPERVISOR: "+orderList
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supervisor.this.getClass().getName(), Supervisor.this, "SplitIntoOrdersPrivate", java.lang.String.valueOf(java.lang.String.valueOf("Splitted orders of SUPERVISOR: ") + java.lang.String.valueOf(Supervisor.this.getOrderList())));
    }
  }

  private void __onCreate() {
    java.lang.String type = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[0], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    java.lang.Integer numOfWorkers = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[1], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER));
    java.lang.String coSupplier = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[2], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    try {
    	/* 
    	 * Compiled from source statement at line 54
    	 * type of agent = type
    	 */
    	
    	_agentEnv.getAgent().setType(type);
    	
    	/* 
    	 * Compiled from source statement at line 55
    	 * numOfWorkers of agent = numOfWorkers
    	 */
    	
    	_agentEnv.getAgent().setNumOfWorkers(numOfWorkers);
    	
    	/* 
    	 * Compiled from source statement at line 56
    	 * orderCount of agent = 0
    	 */
    	
    	_agentEnv.getAgent().setOrderCount(0);
    	
    	/* 
    	 * Compiled from source statement at line 57
    	 * coSupplier of agent = coSupplier
    	 */
    	
    	_agentEnv.getAgent().setCoSupplier(coSupplier);
    	
    	/* 
    	 * Compiled from source statement at line 58
    	 * log "SUPERVISOR created with arguments: "+type
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Supervisor.this.getClass().getName(), Supervisor.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("SUPERVISOR created with arguments: ") + java.lang.String.valueOf(type)));
    	
    	/* 
    	 * Compiled from source statement from line 60 to line 63
    	 * if type of agent = "normal" do
    	 *             do SplitIntoOrdersNormal with normalOrders,1
    	 *         else do
    	 *             do SplitIntoOrdersPrivate with privateOrders
    	 */
    	
    	if(java.util.Objects.equals(_agentEnv.getAgent().getType(), "normal")) {
    		/* 
    		 * Compiled from source statement at line 61
    		 * do SplitIntoOrdersNormal with normalOrders,1
    		 */
    		
    		Supervisor.this.SplitIntoOrdersNormal(_agentEnv.getAgent().toEnv() ,Supervisor.this.getNormalOrders() ,1);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 63
    		 * do SplitIntoOrdersPrivate with privateOrders
    		 */
    		
    		Supervisor.this.SplitIntoOrdersPrivate(_agentEnv.getAgent().toEnv() ,Supervisor.this.getPrivateOrders());
    	}
    	
    	/* 
    	 * Compiled from source statement at line 64
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
    	
    	Supervisor.this.orderBun = BakeryOntology.OrderQuantity("bun" ,"normal" ,3);
    	
    	Supervisor.this.orderCookies = BakeryOntology.OrderQuantity("cookies" ,"normal" ,3);
    	
    	Supervisor.this.orderCake1 = BakeryOntology.OrderQuantity("cake" ,"private" ,1);
    	
    	Supervisor.this.orderCupcake1 = BakeryOntology.OrderQuantity("cupcakes" ,"private" ,1);
    	
    	Supervisor.this.orderCake2 = BakeryOntology.OrderQuantity("cake" ,"private" ,1);
    	
    	Supervisor.this.orderCupcake2 = BakeryOntology.OrderQuantity("cupcakes" ,"private" ,1);
    	
    	Supervisor.this.package1 = BakeryOntology.PackageOfGoods("Pcg1" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getOrderCake1(), Supervisor.this.getOrderCupcake1())) ,"pending");
    	
    	Supervisor.this.package2 = BakeryOntology.PackageOfGoods("Pcg2" ,jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getOrderCake2(), Supervisor.this.getOrderCupcake2())) ,"pending");
    	
    	Supervisor.this.privateOrders = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getPackage1(), Supervisor.this.getPackage2()));
    	
    	Supervisor.this.finishedPackages = new jadescript.util.JadescriptList<PackageOfGoods>();
    	
    	Supervisor.this.normalOrders = jadescript.util.JadescriptCollections.createList(java.util.List.of(Supervisor.this.getOrderBread(), Supervisor.this.getOrderBun(), Supervisor.this.getOrderCookies()));
    	
    	Supervisor.this.orderList = new jadescript.util.JadescriptList<Order>();
    	
    	Supervisor.this.pendingOrders = new jadescript.util.JadescriptList<OrderStatus>();
    	
    	Supervisor.this.type = "";
    	
    	Supervisor.this.numOfWorkers = 0;
    	
    	Supervisor.this.coSupplier = "";
    	
    	Supervisor.this.orderCount = 0;
    	
    	Supervisor.this.listOfBakers = new jadescript.util.JadescriptList<WorkerReady>();
    	
    	Supervisor.this.packer = new jade.core.AID();
    	
    	Supervisor.this.supplierList = new jadescript.util.JadescriptList<jade.core.AID>();
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

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName, final String type, final Integer numOfWorkers, final String coSupplier) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, Supervisor.class, type, numOfWorkers, coSupplier);
  }
}
