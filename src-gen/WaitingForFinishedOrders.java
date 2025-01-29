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

  public static WaitingForFinishedOrders __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitingForFinishedOrders(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event2.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event2.__eventFired) __awaitForEvents();
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

  protected Integer count = null;

  public void setCount(final Integer count) {
    this.count = count;
  }

  public Integer getCount() {
    return this.count;
  }

  public WaitingForFinishedOrders(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 156
    	 * count = 0
    	 */
    	
    	WaitingForFinishedOrders.this.setCount(0);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitingForFinishedOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1214340500 {
      	public java.lang.String orderId;
      	
      	public java.lang.String orderStatus;
      	
      	private final __PatternMatcher1214340500 __PatternMatcher1214340500_obj =  this;
      	
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
      __PatternMatcher1214340500 __PatternMatcher1214340500_obj = new __PatternMatcher1214340500();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1214340500_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 159
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<OrderStatus>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 161 to line 173
      			 * if count % 5 ≠ 0 do #each 10th should be send to redo
      			 * 	        for i in pendingOrders do
      			 * 	            if orderId of i = orderId do
      			 * 	                status of i = orderStatus
      			 * 	                break
      			 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      			 * 	        log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      			 * 	        
      			 * 	        #send message request_when (RedoOrder(orderId,"No need"),OrderCorrect) to senderAgent
      			 * 	        send message request RedoOrder(orderId,"No need") to senderAgent
      			 *         else do
      			 *             #send message request_when (RedoOrder(orderId,"Order not done correctly"),OrderRedoRequired) to senderAgent
      			 *             send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      			 */
      			
      			if(!java.util.Objects.equals(WaitingForFinishedOrders.this.getCount() % 5, 0)) {
      				/* 
      				 * Compiled from source statement from line 162 to line 165
      				 * for i in pendingOrders do
      				 * 	            if orderId of i = orderId do
      				 * 	                status of i = orderStatus
      				 * 	                break
      				 */
      				
      				for ( OrderStatus i : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
      					/* 
      					 * Compiled from source statement from line 163 to line 165
      					 * if orderId of i = orderId do
      					 * 	                status of i = orderStatus
      					 * 	                break
      					 */
      					
      					if(java.util.Objects.equals(i.getOrderId(), __PatternMatcher1214340500_obj.orderId)) {
      						/* 
      						 * Compiled from source statement at line 164
      						 * status of i = orderStatus
      						 */
      						
      						i.setStatus(__PatternMatcher1214340500_obj.orderStatus);
      						
      						/* 
      						 * Compiled from source statement at line 165
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement at line 166
      				 * 
      				 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders to make under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList())));
      				
      				/* 
      				 * Compiled from source statement at line 167
      				 * log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders PENDING under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders())));
      				
      				/* 
      				 * Compiled from source statement at line 170
      				 * send message request RedoOrder(orderId,"No need") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent599599886 = BakeryOntology.RedoOrder(__PatternMatcher1214340500_obj.orderId ,"No need");
      					
      					jadescript.core.message.Message _synthesizedMessage599599886 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage599599886.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent599599886,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage599599886.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage599599886.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage599599886, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent599599886, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage599599886);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 173
      				 * send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent577912466 = BakeryOntology.RedoOrder(__PatternMatcher1214340500_obj.orderId ,"Order not done correctly");
      					
      					jadescript.core.message.Message _synthesizedMessage577912466 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage577912466.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent577912466,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage577912466.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage577912466.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage577912466, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent577912466, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage577912466);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 174
      			 * 
      			 *         count = count + 1
      			 */
      			
      			WaitingForFinishedOrders.this.setCount(WaitingForFinishedOrders.this.getCount() + 1);
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

  private WaitingForFinishedOrders.__Event2 __event2 = null;

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
    	WaitingForFinishedOrders.this.count = 0;
    	
    	__event2 = new WaitingForFinishedOrders.__Event2();
    }
  }
}
