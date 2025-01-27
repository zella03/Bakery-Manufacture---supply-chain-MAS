import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitForNewOrder extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public WaitForNewOrder(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static WaitForNewOrder __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitForNewOrder(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event1.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event1.__eventFired) __awaitForEvents();
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

  /**
   * WaitForNewOrder doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 221
    	 * log "Agent: "+name of agent + " is waiting for new order from supervisor: " + supervisorName of agent
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on activate", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is waiting for new order from supervisor: ")) + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getSupervisorName())));
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event1 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitForNewOrder.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1869990960 {
      	public jade.core.AID agentId;
      	
      	public Order order;
      	
      	private final __PatternMatcher1869990960 __PatternMatcher1869990960_obj =  this;
      	
      	public boolean headerMatch_structterm0_typecast0(java.lang.Object __objx) {
      		jade.core.AID __x;
      		
      		try {
      			if(__objx instanceof jade.core.AID) {
      				__x = (jade.core.AID) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		agentId = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		jade.core.AID __x;
      		
      		try {
      			if(__objx instanceof jade.core.AID) {
      				__x = (jade.core.AID) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0_typecast0(__x);
      	}
      	
      	public boolean headerMatch_structterm1_typecast0(java.lang.Object __objx) {
      		Order __x;
      		
      		try {
      			if(__objx instanceof Order) {
      				__x = (Order) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		order = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		Order __x;
      		
      		try {
      			if(__objx instanceof Order) {
      				__x = (Order) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm1_typecast0(__x);
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		AssignOrder __x;
      		
      		try {
      			if(__objx instanceof AssignOrder) {
      				__x = (AssignOrder) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getOrder());
      	}
      }
      __PatternMatcher1869990960 __PatternMatcher1869990960_obj = new __PatternMatcher1869990960();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1869990960_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	WaitForNewOrder.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 224
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<AssignOrder>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 225
      			 * log "Agent: "+name of agent +" received an order for: "+good of order +" from: " + name of senderAgent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received an order for: ")) + java.lang.String.valueOf(__PatternMatcher1869990960_obj.order.getGood())) + java.lang.String.valueOf(" from: ")) + java.lang.String.valueOf(senderAgent.getName())));
      			
      			/* 
      			 * Compiled from source statement at line 227
      			 * status of order = "toPrepare"
      			 */
      			
      			__PatternMatcher1869990960_obj.order.setStatus("toPrepare");
      			
      			/* 
      			 * Compiled from source statement at line 228
      			 * orderWithStatus = OrderStatus(id of order,"toPrepare")
      			 */
      			
      			OrderStatus orderWithStatus = BakeryOntology.OrderStatus(__PatternMatcher1869990960_obj.order.getId() ,"toPrepare");
      			
      			/* 
      			 * Compiled from source statement at line 229
      			 * add orderWithStatus to ordersList
      			 */
      			
      			WaitForNewOrder.this._agentEnv.getAgent().getOrdersList().add(orderWithStatus);
      			
      			/* 
      			 * Compiled from source statement at line 230
      			 * log "OrderList: "+ ordersList
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("OrderList: ") + java.lang.String.valueOf(WaitForNewOrder.this._agentEnv.getAgent().getOrdersList())));
      			
      			/* 
      			 * Compiled from source statement at line 233
      			 * activate PrepareOrder(order)
      			 */
      			
      			new PrepareOrder(_agentEnv.getAgent().toEnv() ,__PatternMatcher1869990960_obj.order).activate(_agentEnv.getAgent());
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

  private WaitForNewOrder.__Event1 __event1 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitForNewOrder.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event1 = new WaitForNewOrder.__Event1();
    }
  }
}
