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

  public Boolean checkIfKnow(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final String good) {
    {
    	/* 
    	 * Compiled from source statement from line 180 to line 182
    	 * for item in recipeBook do 
    	 *             if name of item = good do
    	 *                 return true
    	 */
    	
    	for ( Good item : WaitForNewOrder.this._agentEnv.getAgent().getRecipeBook()) {
    		/* 
    		 * Compiled from source statement from line 181 to line 182
    		 * if name of item = good do
    		 *                 return true
    		 */
    		
    		if(java.util.Objects.equals(item.getName(), good)) {
    			/* 
    			 * Compiled from source statement at line 182
    			 * return true
    			 */
    			
    			return true;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 183
    	 * 
    	 *         return false
    	 */
    	
    	return false;
    }
  }

  /**
   * WaitForNewOrder doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 186
    	 * log "BAKER: "+name of agent + " is waiting for new order from supervisor: " + supervisorName of agent
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on activate", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is waiting for new order from supervisor: ")) + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getSupervisorName())));
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
      if(WaitForNewOrder.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1749412786 {
      	public jade.core.AID agentId;
      	
      	public Order order;
      	
      	private final __PatternMatcher1749412786 __PatternMatcher1749412786_obj =  this;
      	
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
      __PatternMatcher1749412786 __PatternMatcher1749412786_obj = new __PatternMatcher1749412786();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1749412786_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 189
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<AssignOrder>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 191 to line 201
      			 * if checkIfKnow(good of order) do
      			 *             currentlyAskingForOrder = false
      			 * 	        log "BAKER: "+name of agent +" received an order for: "+good of order +" from: " + name of senderAgent+" and knows the recipe"
      			 * 	        status of order = "toPrepare"
      			 * 	        orderWithStatus = OrderStatus(id of order,"toPrepare")
      			 * 	        add orderWithStatus to ordersList
      			 * 	        add order to fullOrderList
      			 * 	        log "OrderList: "+ ordersList+" of BAKER: "+name of agent
      			 * 	        activate PrepareOrder(order)
      			 * 	    else do
      			 * 	       log "BAKER: "+name of agent+" received an order for: "+good of order +" but does not know the recipe!!"
      			 */
      			
      			if(WaitForNewOrder.this.checkIfKnow(_agentEnv.getAgent().toEnv() ,__PatternMatcher1749412786_obj.order.getGood())) {
      				/* 
      				 * Compiled from source statement at line 192
      				 * currentlyAskingForOrder = false
      				 */
      				
      				WaitForNewOrder.this._agentEnv.getAgent().setCurrentlyAskingForOrder(false);
      				
      				/* 
      				 * Compiled from source statement at line 193
      				 * log "BAKER: "+name of agent +" received an order for: "+good of order +" from: " + name of senderAgent+" and knows the recipe"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received an order for: ")) + java.lang.String.valueOf(__PatternMatcher1749412786_obj.order.getGood())) + java.lang.String.valueOf(" from: ")) + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf(" and knows the recipe")));
      				
      				/* 
      				 * Compiled from source statement at line 194
      				 * status of order = "toPrepare"
      				 */
      				
      				__PatternMatcher1749412786_obj.order.setStatus("toPrepare");
      				
      				/* 
      				 * Compiled from source statement at line 195
      				 * orderWithStatus = OrderStatus(id of order,"toPrepare")
      				 */
      				
      				OrderStatus orderWithStatus = BakeryOntology.OrderStatus(__PatternMatcher1749412786_obj.order.getId() ,"toPrepare");
      				
      				/* 
      				 * Compiled from source statement at line 196
      				 * add orderWithStatus to ordersList
      				 */
      				
      				WaitForNewOrder.this._agentEnv.getAgent().getOrdersList().add(orderWithStatus);
      				
      				/* 
      				 * Compiled from source statement at line 197
      				 * add order to fullOrderList
      				 */
      				
      				WaitForNewOrder.this._agentEnv.getAgent().getFullOrderList().add(__PatternMatcher1749412786_obj.order);
      				
      				/* 
      				 * Compiled from source statement at line 198
      				 * log "OrderList: "+ ordersList+" of BAKER: "+name of agent
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("OrderList: ") + java.lang.String.valueOf(WaitForNewOrder.this._agentEnv.getAgent().getOrdersList())) + java.lang.String.valueOf(" of BAKER: ")) + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())));
      				
      				/* 
      				 * Compiled from source statement at line 199
      				 * activate PrepareOrder(order)
      				 */
      				
      				new PrepareOrder(_agentEnv.getAgent().toEnv() ,__PatternMatcher1749412786_obj.order).activate(_agentEnv.getAgent());
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 201
      				 * log "BAKER: "+name of agent+" received an order for: "+good of order +" but does not know the recipe!!"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForNewOrder.this.getClass().getName(), WaitForNewOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(WaitForNewOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received an order for: ")) + java.lang.String.valueOf(__PatternMatcher1749412786_obj.order.getGood())) + java.lang.String.valueOf(" but does not know the recipe!!")));
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

  private WaitForNewOrder.__Event2 __event2 = null;

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
    	__event2 = new WaitForNewOrder.__Event2();
    }
  }
}
