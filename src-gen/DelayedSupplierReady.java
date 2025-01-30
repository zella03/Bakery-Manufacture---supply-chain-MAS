import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class DelayedSupplierReady extends OneShotBehaviour<Supplier> {
  private Supplier __theAgent = (Supplier)/*Used as metadata*/null;

  private AgentEnv<Supplier, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public DelayedSupplierReady(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static DelayedSupplierReady __createEmpty(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new DelayedSupplierReady(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event0.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event0.__eventFired) __awaitForEvents();
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

  private class __Event0 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement at line 33
      	 * send message inform WorkerReady(aid of agent,"supplier","none") to supervisorName@
      	 */
      	
      	try {
      		jadescript.util.SendMessageUtils.validatePerformative("inform");
      		
      		java.lang.Object _contentToBeSent787379926 = BakeryOntology.WorkerReady(DelayedSupplierReady.this.getJadescriptAgent().getAID() ,"supplier" ,"none");
      		
      		jadescript.core.message.Message _synthesizedMessage787379926 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      		
      		_synthesizedMessage787379926.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent787379926,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      		
      		_synthesizedMessage787379926.setLanguage(__codec.getName());;
      		
      		_synthesizedMessage787379926.addReceiver(new jade.core.AID(java.lang.String.valueOf(DelayedSupplierReady.this._agentEnv.getAgent().getSupervisorName()), false));
      		
      		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage787379926, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent787379926, "inform"));
      		
      		_agentEnv.getAgent().send(_synthesizedMessage787379926);
      	}
      	catch(java.lang.Throwable _t) {
      		throw jadescript.core.exception.JadescriptException.wrap(_t);
      	}
      	
      	/* 
      	 * Compiled from source statement at line 34
      	 * log "SUPPLIER: "+name of agent+" READY TO WORK"
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, DelayedSupplierReady.this.getClass().getName(), DelayedSupplierReady.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER: ") + java.lang.String.valueOf(DelayedSupplierReady.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" READY TO WORK")));
      	
      	/* 
      	 * Compiled from source statement at line 35
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
  }

  private DelayedSupplierReady.__Event0 __event0 =  new DelayedSupplierReady.__Event0();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(DelayedSupplierReady.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    }
  }
}
