import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitEndDay extends CyclicBehaviour<Packer> {
  private Packer __theAgent = (Packer)/*Used as metadata*/null;

  private AgentEnv<Packer, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public WaitEndDay(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static WaitEndDay __createEmpty(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitEndDay(_agentEnv);
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
    Boolean __eventFired = false;

    public void run() {
      if(WaitEndDay.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher2859542 {
      	private final __PatternMatcher2859542 __PatternMatcher2859542_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		EndOfDay __x;
      		
      		try {
      			if(__objx instanceof EndOfDay) {
      				__x = (EndOfDay) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.EndOfDay());
      	}
      }
      __PatternMatcher2859542 __PatternMatcher2859542_obj = new __PatternMatcher2859542();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher2859542_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	WaitEndDay.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 103
      			 * send message inform PackerRaport(timeForPackage) to supervisorName@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1538310574 = BakeryOntology.PackerRaport(WaitEndDay.this._agentEnv.getAgent().getTimeForPackage());
      				
      				jadescript.core.message.Message _synthesizedMessage1538310574 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1538310574.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1538310574,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1538310574.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1538310574.addReceiver(new jade.core.AID(java.lang.String.valueOf(WaitEndDay.this._agentEnv.getAgent().getSupervisorName()), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1538310574, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1538310574, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1538310574);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 104
      			 * destroy this
      			 */
      			
      			WaitEndDay.this.destroy();
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private WaitEndDay.__Event0 __event0 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitEndDay.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event0 = new WaitEndDay.__Event0();
    }
  }
}
