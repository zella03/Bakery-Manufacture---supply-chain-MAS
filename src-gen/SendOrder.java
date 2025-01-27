import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.content.onto.Ontology;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class SendOrder extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public SendOrder(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static SendOrder __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new SendOrder(_agentEnv);
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

  public Ontology __ontology__jadescript_content_onto_Ontology = (jadescript.content.onto.Ontology) jadescript.content.onto.Ontology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(jadescript.content.onto.Ontology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  /**
   * SendOrder doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 60
    	 * activate WaitingForFinishedOrders
    	 */
    	
    	new WaitingForFinishedOrders(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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
      if(SendOrder.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1671445159 {
      	public jade.core.AID id;
      	
      	private final __PatternMatcher1671445159 __PatternMatcher1671445159_obj =  this;
      	
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
      		
      		id = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		RequestOrder __x;
      		
      		try {
      			if(__objx instanceof RequestOrder) {
      				__x = (RequestOrder) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId());
      	}
      }
      __PatternMatcher1671445159 __PatternMatcher1671445159_obj = new __PatternMatcher1671445159();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1671445159_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	SendOrder.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 64
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<RequestOrder>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 66 to line 84
      			 * if length of orderList ≠ 0 do
      			 * 	       order = orderList[0]
      			 * 	       orderStatus = OrderStatus(id of order, status of order)
      			 *            remove order from orderList
      			 *            add orderStatus to pendingOrders
      			 *             
      			 *            log orderList
      			 *            log pendingOrders
      			 *         
      			 * 	       log "Agent: "+name of agent+" received request for order from agent: " + name of sender
      			 * 	       send message request AssignOrder(id,order) to senderAgent
      			 * 	    else if type of agent = "private" do
      			 * 	       type of agent = "normal"
      			 * 	       log "End of private orders. Lets do some normal orders."
      			 * 	       do SplitIntoOrders with normalOrders,1 #private have to do 2 time less that normal had to do normal orders (plan 3x less)
      			 * 	       send message inform EndOfPrivateOrders to senderAgent
      			 * 	    else do
      			 * 	       log "No more orders"
      			 * 	       deactivate this
      			 */
      			
      			if(!java.util.Objects.equals(SendOrder.this._agentEnv.getAgent().getOrderList().size(), 0)) {
      				/* 
      				 * Compiled from source statement at line 67
      				 * order = orderList[0]
      				 */
      				
      				Order order = SendOrder.this._agentEnv.getAgent().getOrderList().get(0);
      				
      				/* 
      				 * Compiled from source statement at line 68
      				 * orderStatus = OrderStatus(id of order, status of order)
      				 */
      				
      				OrderStatus orderStatus = BakeryOntology.OrderStatus(order.getId() ,order.getStatus());
      				
      				/* 
      				 * Compiled from source statement at line 69
      				 * remove order from orderList
      				 */
      				
      				SendOrder.this._agentEnv.getAgent().getOrderList().remove(order);
      				
      				/* 
      				 * Compiled from source statement at line 70
      				 * add orderStatus to pendingOrders
      				 */
      				
      				SendOrder.this._agentEnv.getAgent().getPendingOrders().add(orderStatus);
      				
      				/* 
      				 * Compiled from source statement at line 72
      				 * log orderList
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(SendOrder.this._agentEnv.getAgent().getOrderList()));
      				
      				/* 
      				 * Compiled from source statement at line 73
      				 * log pendingOrders
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(SendOrder.this._agentEnv.getAgent().getPendingOrders()));
      				
      				/* 
      				 * Compiled from source statement at line 75
      				 * log "Agent: "+name of agent+" received request for order from agent: " + name of sender
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(SendOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received request for order from agent: ")) + java.lang.String.valueOf(__receivedMessage.getSender().getName())));
      				
      				/* 
      				 * Compiled from source statement at line 76
      				 * send message request AssignOrder(id,order) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent184845430 = BakeryOntology.AssignOrder(__PatternMatcher1671445159_obj.id ,order);
      					
      					jadescript.core.message.Message _synthesizedMessage184845430 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage184845430.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent184845430,BakeryOntology.getInstance(),jadescript.content.onto.Ontology.getInstance()).getName());;
      					
      					_synthesizedMessage184845430.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage184845430.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage184845430, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent184845430, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage184845430);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else if(java.util.Objects.equals(SendOrder.this.getJadescriptAgent().getType(), "private")) {
      				/* 
      				 * Compiled from source statement at line 78
      				 * type of agent = "normal"
      				 */
      				
      				SendOrder.this.getJadescriptAgent().setType("normal");
      				
      				/* 
      				 * Compiled from source statement at line 79
      				 * log "End of private orders. Lets do some normal orders."
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf("End of private orders. Lets do some normal orders."));
      				
      				/* 
      				 * Compiled from source statement at line 80
      				 * do SplitIntoOrders with normalOrders,1
      				 */
      				
      				SendOrder.this._agentEnv.getAgent().SplitIntoOrders(_agentEnv.getAgent().toEnv() ,SendOrder.this._agentEnv.getAgent().getNormalOrders() ,1);
      				
      				/* 
      				 * Compiled from source statement at line 81
      				 * send message inform EndOfPrivateOrders to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1875661422 = BakeryOntology.EndOfPrivateOrders();
      					
      					jadescript.core.message.Message _synthesizedMessage1875661422 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1875661422.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1875661422,BakeryOntology.getInstance(),jadescript.content.onto.Ontology.getInstance()).getName());;
      					
      					_synthesizedMessage1875661422.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1875661422.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1875661422, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1875661422, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1875661422);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 83
      				 * log "No more orders"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf("No more orders"));
      				
      				/* 
      				 * Compiled from source statement at line 84
      				 * deactivate this
      				 */
      				
      				SendOrder.this.deactivate();
      			}
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

  private SendOrder.__Event1 __event1 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(SendOrder.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event1 = new SendOrder.__Event1();
    }
  }
}
