import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class DelayedWorkerReady extends OneShotBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public DelayedWorkerReady(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static DelayedWorkerReady __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new DelayedWorkerReady(_agentEnv);
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
      	 * Compiled from source statement at line 109
      	 * send message inform WorkerReady(aid of agent, typeBaker of agent) to supervisorName@
      	 */
      	
      	try {
      		jadescript.util.SendMessageUtils.validatePerformative("inform");
      		
      		java.lang.Object _contentToBeSent32022206 = BakeryOntology.WorkerReady(DelayedWorkerReady.this.getJadescriptAgent().getAID() ,DelayedWorkerReady.this.getJadescriptAgent().getTypeBaker());
      		
      		jadescript.core.message.Message _synthesizedMessage32022206 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      		
      		_synthesizedMessage32022206.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent32022206,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      		
      		_synthesizedMessage32022206.setLanguage(__codec.getName());;
      		
      		_synthesizedMessage32022206.addReceiver(new jade.core.AID(java.lang.String.valueOf(DelayedWorkerReady.this._agentEnv.getAgent().getSupervisorName()), false));
      		
      		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage32022206, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent32022206, "inform"));
      		
      		_agentEnv.getAgent().send(_synthesizedMessage32022206);
      	}
      	catch(java.lang.Throwable _t) {
      		throw jadescript.core.exception.JadescriptException.wrap(_t);
      	}
      	
      	/* 
      	 * Compiled from source statement at line 110
      	 * log "WorkerReady message sent."
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, DelayedWorkerReady.this.getClass().getName(), DelayedWorkerReady.this, "on execute", java.lang.String.valueOf("WorkerReady message sent."));
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private DelayedWorkerReady.__Event0 __event0 =  new DelayedWorkerReady.__Event0();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(DelayedWorkerReady.this);
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
