import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class DelayedBakerReady extends OneShotBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public DelayedBakerReady(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static DelayedBakerReady __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new DelayedBakerReady(_agentEnv);
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
      	 * Compiled from source statement at line 119
      	 * send message inform WorkerReady(aid of agent,"baker",typeBaker of agent) to supervisorName@
      	 */
      	
      	try {
      		jadescript.util.SendMessageUtils.validatePerformative("inform");
      		
      		java.lang.Object _contentToBeSent418937540 = BakeryOntology.WorkerReady(DelayedBakerReady.this.getJadescriptAgent().getAID() ,"baker" ,DelayedBakerReady.this.getJadescriptAgent().getTypeBaker());
      		
      		jadescript.core.message.Message _synthesizedMessage418937540 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      		
      		_synthesizedMessage418937540.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent418937540,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      		
      		_synthesizedMessage418937540.setLanguage(__codec.getName());;
      		
      		_synthesizedMessage418937540.addReceiver(new jade.core.AID(java.lang.String.valueOf(DelayedBakerReady.this._agentEnv.getAgent().getSupervisorName()), false));
      		
      		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage418937540, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent418937540, "inform"));
      		
      		_agentEnv.getAgent().send(_synthesizedMessage418937540);
      	}
      	catch(java.lang.Throwable _t) {
      		throw jadescript.core.exception.JadescriptException.wrap(_t);
      	}
      	
      	/* 
      	 * Compiled from source statement at line 120
      	 * log "BAKER: "+name of agent+" READY TO WORK"
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, DelayedBakerReady.this.getClass().getName(), DelayedBakerReady.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(DelayedBakerReady.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" READY TO WORK")));
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private DelayedBakerReady.__Event0 __event0 =  new DelayedBakerReady.__Event0();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(DelayedBakerReady.this);
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
