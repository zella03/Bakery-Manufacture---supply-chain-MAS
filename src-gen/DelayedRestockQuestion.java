import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class DelayedRestockQuestion extends OneShotBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static DelayedRestockQuestion __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new DelayedRestockQuestion(_agentEnv, "", new Order(), false);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event4.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event4.__eventFired) __awaitForEvents();
  }

  public Boolean __hasStaleMessageHandler() {
    return false;
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected String supplier = null;

  public void setSupplier(final String supplier) {
    this.supplier = supplier;
  }

  public String getSupplier() {
    return this.supplier;
  }

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  protected Boolean bakerWhileProparing = null;

  public void setBakerWhileProparing(final Boolean bakerWhileProparing) {
    this.bakerWhileProparing = bakerWhileProparing;
  }

  public Boolean getBakerWhileProparing() {
    return this.bakerWhileProparing;
  }

  public DelayedRestockQuestion(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final String supplier, final Order order, final Boolean bakerWhileProparing) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 405
    	 * supplier of this = supplier
    	 */
    	
    	DelayedRestockQuestion.this.setSupplier(supplier);
    	
    	/* 
    	 * Compiled from source statement at line 406
    	 * order of this = order
    	 */
    	
    	DelayedRestockQuestion.this.setOrder(order);
    	
    	/* 
    	 * Compiled from source statement at line 407
    	 * bakerWhileProparing of this = bakerWhileProparing
    	 */
    	
    	DelayedRestockQuestion.this.setBakerWhileProparing(bakerWhileProparing);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event4 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement at line 409
      	 * log "BAKER need RESTOCK. ask "+supplier+" having stock: "+stock
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, DelayedRestockQuestion.this.getClass().getName(), DelayedRestockQuestion.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER need RESTOCK. ask ") + java.lang.String.valueOf(DelayedRestockQuestion.this.getSupplier())) + java.lang.String.valueOf(" having stock: ")) + java.lang.String.valueOf(DelayedRestockQuestion.this._agentEnv.getAgent().getStock())));
      	
      	/* 
      	 * Compiled from source statement at line 410
      	 * send message request NeedRestock(aid of agent, stock, bakerWhileProparing) to supplier@
      	 */
      	
      	try {
      		jadescript.util.SendMessageUtils.validatePerformative("request");
      		
      		java.lang.Object _contentToBeSent1489557916 = BakeryOntology.NeedRestock(DelayedRestockQuestion.this.getJadescriptAgent().getAID() ,DelayedRestockQuestion.this._agentEnv.getAgent().getStock() ,DelayedRestockQuestion.this.getBakerWhileProparing());
      		
      		jadescript.core.message.Message _synthesizedMessage1489557916 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      		
      		_synthesizedMessage1489557916.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1489557916,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      		
      		_synthesizedMessage1489557916.setLanguage(__codec.getName());;
      		
      		_synthesizedMessage1489557916.addReceiver(new jade.core.AID(java.lang.String.valueOf(DelayedRestockQuestion.this.getSupplier()), false));
      		
      		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1489557916, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1489557916, "request"));
      		
      		_agentEnv.getAgent().send(_synthesizedMessage1489557916);
      	}
      	catch(java.lang.Throwable _t) {
      		throw jadescript.core.exception.JadescriptException.wrap(_t);
      	}
      	
      	/* 
      	 * Compiled from source statement at line 411
      	 * activate HandleIngredientsShortage(stock,order)
      	 */
      	
      	new HandleIngredientsShortage(_agentEnv.getAgent().toEnv() ,DelayedRestockQuestion.this._agentEnv.getAgent().getStock() ,DelayedRestockQuestion.this.getOrder()).activate(_agentEnv.getAgent());
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private DelayedRestockQuestion.__Event4 __event4 =  new DelayedRestockQuestion.__Event4();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(DelayedRestockQuestion.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	DelayedRestockQuestion.this.supplier = "";
    	
    	DelayedRestockQuestion.this.order = new Order();
    	
    	DelayedRestockQuestion.this.bakerWhileProparing = false;
    }
  }
}
