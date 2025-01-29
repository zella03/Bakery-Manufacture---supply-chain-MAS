import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class SendRequest extends OneShotBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public SendRequest(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static SendRequest __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new SendRequest(_agentEnv);
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
      	 * Compiled from source statement at line 181
      	 * log "BAKER: "+name of agent + " sending request for an order from: " + supervisorName of agent
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendRequest.this.getClass().getName(), SendRequest.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(SendRequest.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" sending request for an order from: ")) + java.lang.String.valueOf(SendRequest.this.getJadescriptAgent().getSupervisorName())));
      	
      	/* 
      	 * Compiled from source statement at line 182
      	 * send message request RequestOrder(aid of agent) to supervisorName@
      	 */
      	
      	try {
      		jadescript.util.SendMessageUtils.validatePerformative("request");
      		
      		java.lang.Object _contentToBeSent2101245394 = BakeryOntology.RequestOrder(SendRequest.this.getJadescriptAgent().getAID());
      		
      		jadescript.core.message.Message _synthesizedMessage2101245394 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      		
      		_synthesizedMessage2101245394.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent2101245394,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      		
      		_synthesizedMessage2101245394.setLanguage(__codec.getName());;
      		
      		_synthesizedMessage2101245394.addReceiver(new jade.core.AID(java.lang.String.valueOf(SendRequest.this._agentEnv.getAgent().getSupervisorName()), false));
      		
      		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage2101245394, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent2101245394, "request"));
      		
      		_agentEnv.getAgent().send(_synthesizedMessage2101245394);
      	}
      	catch(java.lang.Throwable _t) {
      		throw jadescript.core.exception.JadescriptException.wrap(_t);
      	}
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private SendRequest.__Event0 __event0 =  new SendRequest.__Event0();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(SendRequest.this);
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
