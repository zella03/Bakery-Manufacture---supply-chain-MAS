import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitingForFinishedOrders extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public WaitingForFinishedOrders(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static WaitingForFinishedOrders __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitingForFinishedOrders(_agentEnv);
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
      if(WaitingForFinishedOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1373522286 {
      	public java.lang.String orderId;
      	
      	public java.lang.String orderStatus;
      	
      	private final __PatternMatcher1373522286 __PatternMatcher1373522286_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		java.lang.String __x;
      		
      		try {
      			if(__objx instanceof java.lang.String) {
      				__x = (java.lang.String) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		orderId = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		java.lang.String __x;
      		
      		try {
      			if(__objx instanceof java.lang.String) {
      				__x = (java.lang.String) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		orderStatus = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		OrderStatus __x;
      		
      		try {
      			if(__objx instanceof OrderStatus) {
      				__x = (OrderStatus) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getOrderId()) && headerMatch_structterm1(__x.getStatus());
      	}
      }
      __PatternMatcher1373522286 __PatternMatcher1373522286_obj = new __PatternMatcher1373522286();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1373522286_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	WaitingForFinishedOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement from line 140 to line 143
      			 * for i in pendingOrders do
      			 *             if orderId of i = orderId do
      			 *                 status of i = orderStatus
      			 *                 break
      			 */
      			
      			for ( OrderStatus i : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
      				/* 
      				 * Compiled from source statement from line 141 to line 143
      				 * if orderId of i = orderId do
      				 *                 status of i = orderStatus
      				 *                 break
      				 */
      				
      				if(java.util.Objects.equals(i.getOrderId(), __PatternMatcher1373522286_obj.orderId)) {
      					/* 
      					 * Compiled from source statement at line 142
      					 * status of i = orderStatus
      					 */
      					
      					i.setStatus(__PatternMatcher1373522286_obj.orderStatus);
      					
      					/* 
      					 * Compiled from source statement at line 143
      					 * break
      					 */
      					
      					break;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 144
      			 * 
      			 *         log orderList
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList()));
      			
      			/* 
      			 * Compiled from source statement at line 145
      			 * log pendingOrders
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()));
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

  private WaitingForFinishedOrders.__Event0 __event0 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitingForFinishedOrders.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event0 = new WaitingForFinishedOrders.__Event0();
    }
  }
}
