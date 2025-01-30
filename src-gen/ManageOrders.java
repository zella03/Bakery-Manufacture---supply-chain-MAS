import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class ManageOrders extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static ManageOrders __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new ManageOrders(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event4.run();
    __event5.run();
    __event6.run();
    __event7.run();
    __event8.run();
    __event9.run();
    __event10.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event4.__eventFired && !__event5.__eventFired && !__event6.__eventFired && !__event7.__eventFired && !__event8.__eventFired && !__event9.__eventFired && !__event10.__eventFired) __awaitForEvents();
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

  protected Boolean endOfOrders = null;

  public void setEndOfOrders(final Boolean endOfOrders) {
    this.endOfOrders = endOfOrders;
  }

  public Boolean getEndOfOrders() {
    return this.endOfOrders;
  }

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  public void LookOrderUp(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final String orderId) {
    {
    	/* 
    	 * Compiled from source statement from line 126 to line 129
    	 * for i in fullOrderList do
    	 *             if orderId = id of i do
    	 *                 order = i
    	 *                 break
    	 */
    	
    	for ( Order i : ManageOrders.this._agentEnv.getAgent().getFullOrderList()) {
    		/* 
    		 * Compiled from source statement from line 127 to line 129
    		 * if orderId = id of i do
    		 *                 order = i
    		 *                 break
    		 */
    		
    		if(java.util.Objects.equals(orderId, i.getId())) {
    			/* 
    			 * Compiled from source statement at line 128
    			 * order = i
    			 */
    			
    			ManageOrders.this.setOrder(i);
    			
    			/* 
    			 * Compiled from source statement at line 129
    			 * break
    			 */
    			
    			break;
    		}
    	}
    }
  }

  public ManageOrders(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 132
    	 * endOfOrders = false
    	 */
    	
    	ManageOrders.this.setEndOfOrders(false);
    	
    	/* 
    	 * Compiled from source statement at line 133
    	 * currentlyAskingForOrder = false
    	 */
    	
    	ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(false);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event4 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement at line 135
      	 * count = 0
      	 */
      	
      	java.lang.Integer count = 0;
      	
      	/* 
      	 * Compiled from source statement from line 136 to line 145
      	 * if length of ordersList ≠ 0 do
      	 *             for i in ordersList do
      	 *                 if status of i ≠ "baking" do
      	 *                     break
      	 *                 else do 
      	 *                     count = count + 1 #we cannot ask for new order if we are preparing another one or when we lack of ingredients
      	 *             if count = length of ordersList and not endOfOrders and not currentlyAskingForOrder do #if everything is ONLY baking we can ask for another order to make
      	 *                 log "BAKER: "+name of agent+" __ count of ord baking: "+count+" orderList: "+ ordersList+" end orders: "+ endOfOrders
      	 *                 activate SendRequest
      	 *                 currentlyAskingForOrder = true
      	 */
      	
      	if(!java.util.Objects.equals(ManageOrders.this._agentEnv.getAgent().getOrdersList().size(), 0)) {
      		/* 
      		 * Compiled from source statement from line 137 to line 141
      		 * for i in ordersList do
      		 *                 if status of i ≠ "baking" do
      		 *                     break
      		 *                 else do 
      		 *                     count = count + 1
      		 */
      		
      		for ( OrderStatus i : ManageOrders.this._agentEnv.getAgent().getOrdersList()) {
      			/* 
      			 * Compiled from source statement from line 138 to line 141
      			 * if status of i ≠ "baking" do
      			 *                     break
      			 *                 else do 
      			 *                     count = count + 1
      			 */
      			
      			if(!java.util.Objects.equals(i.getStatus(), "baking")) {
      				/* 
      				 * Compiled from source statement at line 139
      				 * break
      				 */
      				
      				break;
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 141
      				 * count = count + 1
      				 */
      				
      				count = count + 1;
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement from line 142 to line 145
      		 *  #we cannot ask for new order if we are preparing another one or when we lack of ingredients
      		 *             if count = length of ordersList and not endOfOrders and not currentlyAskingForOrder do #if everything is ONLY baking we can ask for another order to make
      		 *                 log "BAKER: "+name of agent+" __ count of ord baking: "+count+" orderList: "+ ordersList+" end orders: "+ endOfOrders
      		 *                 activate SendRequest
      		 *                 currentlyAskingForOrder = true
      		 */
      		
      		if(java.util.Objects.equals(count, ManageOrders.this._agentEnv.getAgent().getOrdersList().size()) &&  ! ManageOrders.this.getEndOfOrders() &&  ! ManageOrders.this._agentEnv.getAgent().getCurrentlyAskingForOrder()) {
      			/* 
      			 * Compiled from source statement at line 143
      			 * log "BAKER: "+name of agent+" __ count of ord baking: "+count+" orderList: "+ ordersList+" end orders: "+ endOfOrders
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" __ count of ord baking: ")) + java.lang.String.valueOf(count)) + java.lang.String.valueOf(" orderList: ")) + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersList())) + java.lang.String.valueOf(" end orders: ")) + java.lang.String.valueOf(ManageOrders.this.getEndOfOrders())));
      			
      			/* 
      			 * Compiled from source statement at line 144
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 145
      			 * currentlyAskingForOrder = true
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(true);
      		}
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

  private ManageOrders.__Event4 __event4 =  new ManageOrders.__Event4();

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher564138380 {
      	private final __PatternMatcher564138380 __PatternMatcher564138380_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		AgentsReported __x;
      		
      		try {
      			if(__objx instanceof AgentsReported) {
      				__x = (AgentsReported) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.AgentsReported());
      	}
      }
      __PatternMatcher564138380 __PatternMatcher564138380_obj = new __PatternMatcher564138380();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher564138380_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 148
      			 * currentlyAskingForOrder = true
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(true);
      			
      			/* 
      			 * Compiled from source statement at line 149
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 150
      			 * activate WaitForNewOrder
      			 */
      			
      			new WaitForNewOrder(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private ManageOrders.__Event5 __event5 = null;

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1579666958 {
      	public java.lang.String id;
      	
      	public java.lang.String status;
      	
      	private final __PatternMatcher1579666958 __PatternMatcher1579666958_obj =  this;
      	
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
      		
      		id = __x;
      		
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
      		
      		status = __x;
      		
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
      __PatternMatcher1579666958 __PatternMatcher1579666958_obj = new __PatternMatcher1579666958();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1579666958_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 153
      			 * log "BAKER: "+name of agent+" is finished."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is finished.")));
      			
      			/* 
      			 * Compiled from source statement at line 154
      			 * send message inform OrderStatus(id,status) to supervisorName@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1337503858 = BakeryOntology.OrderStatus(__PatternMatcher1579666958_obj.id ,__PatternMatcher1579666958_obj.status);
      				
      				jadescript.core.message.Message _synthesizedMessage1337503858 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1337503858.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1337503858,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1337503858.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1337503858.addReceiver(new jade.core.AID(java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getSupervisorName()), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1337503858, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1337503858, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1337503858);
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

  private ManageOrders.__Event6 __event6 = null;

  private class __Event7 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher157442001 {
      	public java.lang.String orderId;
      	
      	public java.lang.String decision;
      	
      	private final __PatternMatcher157442001 __PatternMatcher157442001_obj =  this;
      	
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
      		
      		decision = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		RedoOrder __x;
      		
      		try {
      			if(__objx instanceof RedoOrder) {
      				__x = (RedoOrder) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getOrderId()) && headerMatch_structterm1(__x.getDecision());
      	}
      }
      __PatternMatcher157442001 __PatternMatcher157442001_obj = new __PatternMatcher157442001();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher157442001_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 157
      			 * do LookOrderUp with orderId
      			 */
      			
      			ManageOrders.this.LookOrderUp(_agentEnv.getAgent().toEnv() ,__PatternMatcher157442001_obj.orderId);
      			
      			/* 
      			 * Compiled from source statement from line 159 to line 170
      			 * if decision = "No need" do
      			 *             log "Order: "+orderId+" ACCEPTED"
      			 *             remove OrderStatus(orderId,"finished") from ordersList #this if zaakceptuje!!!
      			 *             ordersDone = ordersDone + 1
      			 *             if type of order = "private" do
      			 *                 #order was accepted and now its send to packer to pack the order
      			 *                 send message request GoodToPack(order) to packer@
      			 *         else do
      			 *             ordersToRedo = ordersToRedo + 1
      			 *             log "Order: "+orderId+" need to be REDONE. Decision: "+decision
      			 *             do chnageStatus with id of order, "toPrepare"
      			 *             activate PrepareOrder(order)
      			 */
      			
      			if(java.util.Objects.equals(__PatternMatcher157442001_obj.decision, "No need")) {
      				/* 
      				 * Compiled from source statement at line 160
      				 * log "Order: "+orderId+" ACCEPTED"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Order: ") + java.lang.String.valueOf(__PatternMatcher157442001_obj.orderId)) + java.lang.String.valueOf(" ACCEPTED")));
      				
      				/* 
      				 * Compiled from source statement at line 161
      				 * remove OrderStatus(orderId,"finished") from ordersList
      				 */
      				
      				ManageOrders.this._agentEnv.getAgent().getOrdersList().remove(BakeryOntology.OrderStatus(__PatternMatcher157442001_obj.orderId ,"finished"));
      				
      				/* 
      				 * Compiled from source statement at line 162
      				 * ordersDone = ordersDone + 1
      				 */
      				
      				ManageOrders.this._agentEnv.getAgent().setOrdersDone(ManageOrders.this._agentEnv.getAgent().getOrdersDone() + 1);
      				
      				/* 
      				 * Compiled from source statement from line 163 to line 165
      				 * if type of order = "private" do
      				 *                 #order was accepted and now its send to packer to pack the order
      				 *                 send message request GoodToPack(order) to packer@
      				 */
      				
      				if(java.util.Objects.equals(ManageOrders.this.getOrder().getType(), "private")) {
      					/* 
      					 * Compiled from source statement at line 165
      					 * send message request GoodToPack(order) to packer@
      					 */
      					
      					try {
      						jadescript.util.SendMessageUtils.validatePerformative("request");
      						
      						java.lang.Object _contentToBeSent902653061 = BakeryOntology.GoodToPack(ManageOrders.this.getOrder());
      						
      						jadescript.core.message.Message _synthesizedMessage902653061 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      						
      						_synthesizedMessage902653061.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent902653061,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      						
      						_synthesizedMessage902653061.setLanguage(__codec.getName());;
      						
      						_synthesizedMessage902653061.addReceiver(new jade.core.AID(java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getPacker()), false));
      						
      						_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage902653061, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent902653061, "request"));
      						
      						_agentEnv.getAgent().send(_synthesizedMessage902653061);
      					}
      					catch(java.lang.Throwable _t) {
      						throw jadescript.core.exception.JadescriptException.wrap(_t);
      					}
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 167
      				 * ordersToRedo = ordersToRedo + 1
      				 */
      				
      				ManageOrders.this._agentEnv.getAgent().setOrdersToRedo(ManageOrders.this._agentEnv.getAgent().getOrdersToRedo() + 1);
      				
      				/* 
      				 * Compiled from source statement at line 168
      				 * log "Order: "+orderId+" need to be REDONE. Decision: "+decision
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Order: ") + java.lang.String.valueOf(__PatternMatcher157442001_obj.orderId)) + java.lang.String.valueOf(" need to be REDONE. Decision: ")) + java.lang.String.valueOf(__PatternMatcher157442001_obj.decision)));
      				
      				/* 
      				 * Compiled from source statement at line 169
      				 * do chnageStatus with id of order, "toPrepare"
      				 */
      				
      				ManageOrders.this._agentEnv.getAgent().chnageStatus(_agentEnv.getAgent().toEnv() ,ManageOrders.this.getOrder().getId() ,"toPrepare");
      				
      				/* 
      				 * Compiled from source statement at line 170
      				 * activate PrepareOrder(order)
      				 */
      				
      				new PrepareOrder(_agentEnv.getAgent().toEnv() ,ManageOrders.this.getOrder()).activate(_agentEnv.getAgent());
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

  private ManageOrders.__Event7 __event7 = null;

  private class __Event8 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher908159867 {
      	private final __PatternMatcher908159867 __PatternMatcher908159867_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		EndOfPrivateOrders __x;
      		
      		try {
      			if(__objx instanceof EndOfPrivateOrders) {
      				__x = (EndOfPrivateOrders) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.EndOfPrivateOrders());
      	}
      }
      __PatternMatcher908159867 __PatternMatcher908159867_obj = new __PatternMatcher908159867();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher908159867_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 173
      			 * do changeToNormal
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().changeToNormal(_agentEnv.getAgent().toEnv());
      			
      			/* 
      			 * Compiled from source statement at line 174
      			 * log "BAKER: "+name of agent+" is changed into normal: "+typeBaker of agent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is changed into normal: ")) + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getTypeBaker())));
      			
      			/* 
      			 * Compiled from source statement at line 175
      			 * currentlyAskingForOrder = true
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(true);
      			
      			/* 
      			 * Compiled from source statement at line 176
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private ManageOrders.__Event8 __event8 = null;

  private class __Event9 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1355131866 {
      	private final __PatternMatcher1355131866 __PatternMatcher1355131866_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		EndOfOrders __x;
      		
      		try {
      			if(__objx instanceof EndOfOrders) {
      				__x = (EndOfOrders) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.EndOfOrders());
      	}
      }
      __PatternMatcher1355131866 __PatternMatcher1355131866_obj = new __PatternMatcher1355131866();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1355131866_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 179
      			 * log "BAKER HAS STILL TO DO: "+ordersList+" but finished"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER HAS STILL TO DO: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersList())) + java.lang.String.valueOf(" but finished")));
      			
      			/* 
      			 * Compiled from source statement at line 180
      			 * log "Times of help of coll: "+succRestockByColl
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Times of help of coll: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getSuccRestockByColl())));
      			
      			/* 
      			 * Compiled from source statement at line 181
      			 * log "Times of help of supp: "+succRestockBySupp
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Times of help of supp: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getSuccRestockBySupp())));
      			
      			/* 
      			 * Compiled from source statement at line 182
      			 * log "Orders needed redo: "+ ordersToRedo
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Orders needed redo: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersToRedo())));
      			
      			/* 
      			 * Compiled from source statement at line 183
      			 * log "Orders done: "+ordersDone
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Orders done: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersDone())));
      			
      			/* 
      			 * Compiled from source statement at line 184
      			 * deactivate WaitForNewOrder
      			 */
      			
      			new WaitForNewOrder(_agentEnv.getAgent().toEnv()).deactivate();
      			
      			/* 
      			 * Compiled from source statement at line 185
      			 * endOfOrders = true
      			 */
      			
      			ManageOrders.this.setEndOfOrders(true);
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

  private ManageOrders.__Event9 __event9 = null;

  private class __Event10 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher645886434 {
      	private final __PatternMatcher645886434 __PatternMatcher645886434_obj =  this;
      	
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
      __PatternMatcher645886434 __PatternMatcher645886434_obj = new __PatternMatcher645886434();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher645886434_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ManageOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 192
      			 * log "I will send here report"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf("I will send here report"));
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

  private ManageOrders.__Event10 __event10 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ManageOrders.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ManageOrders.this.endOfOrders = false;
    	
    	ManageOrders.this.order = new Order();
    	
    	__event5 = new ManageOrders.__Event5();
    	
    	__event6 = new ManageOrders.__Event6();
    	
    	__event7 = new ManageOrders.__Event7();
    	
    	__event8 = new ManageOrders.__Event8();
    	
    	__event9 = new ManageOrders.__Event9();
    	
    	__event10 = new ManageOrders.__Event10();
    }
  }
}
