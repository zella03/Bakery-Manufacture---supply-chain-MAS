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
    __event2.run();
    __event3.run();
    __event4.run();
    __event5.run();
    __event6.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event2.__eventFired && !__event3.__eventFired && !__event4.__eventFired && !__event5.__eventFired && !__event6.__eventFired) __awaitForEvents();
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

  public ManageOrders(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 113
    	 * endOfOrders = false
    	 */
    	
    	ManageOrders.this.setEndOfOrders(false);
    	
    	/* 
    	 * Compiled from source statement at line 114
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

  private class __Event2 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement at line 116
      	 * count = 0
      	 */
      	
      	java.lang.Integer count = 0;
      	
      	/* 
      	 * Compiled from source statement from line 117 to line 126
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
      		 * Compiled from source statement from line 118 to line 122
      		 * for i in ordersList do
      		 *                 if status of i ≠ "baking" do
      		 *                     break
      		 *                 else do 
      		 *                     count = count + 1
      		 */
      		
      		for ( OrderStatus i : ManageOrders.this._agentEnv.getAgent().getOrdersList()) {
      			/* 
      			 * Compiled from source statement from line 119 to line 122
      			 * if status of i ≠ "baking" do
      			 *                     break
      			 *                 else do 
      			 *                     count = count + 1
      			 */
      			
      			if(!java.util.Objects.equals(i.getStatus(), "baking")) {
      				/* 
      				 * Compiled from source statement at line 120
      				 * break
      				 */
      				
      				break;
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 122
      				 * count = count + 1
      				 */
      				
      				count = count + 1;
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement from line 123 to line 126
      		 *  #we cannot ask for new order if we are preparing another one or when we lack of ingredients
      		 *             if count = length of ordersList and not endOfOrders and not currentlyAskingForOrder do #if everything is ONLY baking we can ask for another order to make
      		 *                 log "BAKER: "+name of agent+" __ count of ord baking: "+count+" orderList: "+ ordersList+" end orders: "+ endOfOrders
      		 *                 activate SendRequest
      		 *                 currentlyAskingForOrder = true
      		 */
      		
      		if(java.util.Objects.equals(count, ManageOrders.this._agentEnv.getAgent().getOrdersList().size()) &&  ! ManageOrders.this.getEndOfOrders() &&  ! ManageOrders.this._agentEnv.getAgent().getCurrentlyAskingForOrder()) {
      			/* 
      			 * Compiled from source statement at line 124
      			 * log "BAKER: "+name of agent+" __ count of ord baking: "+count+" orderList: "+ ordersList+" end orders: "+ endOfOrders
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" __ count of ord baking: ")) + java.lang.String.valueOf(count)) + java.lang.String.valueOf(" orderList: ")) + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersList())) + java.lang.String.valueOf(" end orders: ")) + java.lang.String.valueOf(ManageOrders.this.getEndOfOrders())));
      			
      			/* 
      			 * Compiled from source statement at line 125
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 126
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

  private ManageOrders.__Event2 __event2 =  new ManageOrders.__Event2();

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher95579104 {
      	private final __PatternMatcher95579104 __PatternMatcher95579104_obj =  this;
      	
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
      __PatternMatcher95579104 __PatternMatcher95579104_obj = new __PatternMatcher95579104();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher95579104_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 129
      			 * currentlyAskingForOrder = true
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(true);
      			
      			/* 
      			 * Compiled from source statement at line 130
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 131
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

  private ManageOrders.__Event3 __event3 = null;

  private class __Event4 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher867775356 {
      	public java.lang.String id;
      	
      	public java.lang.String status;
      	
      	private final __PatternMatcher867775356 __PatternMatcher867775356_obj =  this;
      	
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
      __PatternMatcher867775356 __PatternMatcher867775356_obj = new __PatternMatcher867775356();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher867775356_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 134
      			 * log "BAKER: "+name of agent+" is finished."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is finished.")));
      			
      			/* 
      			 * Compiled from source statement at line 135
      			 * send message inform OrderStatus(id,status) to supervisorName@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent156188091 = BakeryOntology.OrderStatus(__PatternMatcher867775356_obj.id ,__PatternMatcher867775356_obj.status);
      				
      				jadescript.core.message.Message _synthesizedMessage156188091 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage156188091.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent156188091,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage156188091.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage156188091.addReceiver(new jade.core.AID(java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getSupervisorName()), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage156188091, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent156188091, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage156188091);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 136
      			 * remove OrderStatus(id,status) from ordersList
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().getOrdersList().remove(BakeryOntology.OrderStatus(__PatternMatcher867775356_obj.id ,__PatternMatcher867775356_obj.status));
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

  private ManageOrders.__Event4 __event4 = null;

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1299810377 {
      	private final __PatternMatcher1299810377 __PatternMatcher1299810377_obj =  this;
      	
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
      __PatternMatcher1299810377 __PatternMatcher1299810377_obj = new __PatternMatcher1299810377();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1299810377_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 139
      			 * do changeToNormal
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().changeToNormal(_agentEnv.getAgent().toEnv());
      			
      			/* 
      			 * Compiled from source statement at line 140
      			 * log "BAKER: "+name of agent+" is changed into normal: "+typeBaker of agent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is changed into normal: ")) + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getTypeBaker())));
      			
      			/* 
      			 * Compiled from source statement at line 141
      			 * currentlyAskingForOrder = true
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().setCurrentlyAskingForOrder(true);
      			
      			/* 
      			 * Compiled from source statement at line 142
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

  private ManageOrders.__Event5 __event5 = null;

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(ManageOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1615467811 {
      	private final __PatternMatcher1615467811 __PatternMatcher1615467811_obj =  this;
      	
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
      __PatternMatcher1615467811 __PatternMatcher1615467811_obj = new __PatternMatcher1615467811();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1615467811_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 145
      			 * log "BAKER HAS STILL TO DO: "+ordersList+" but finished"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER HAS STILL TO DO: ") + java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersList())) + java.lang.String.valueOf(" but finished")));
      			
      			/* 
      			 * Compiled from source statement at line 146
      			 * deactivate WaitForNewOrder
      			 */
      			
      			new WaitForNewOrder(_agentEnv.getAgent().toEnv()).deactivate();
      			
      			/* 
      			 * Compiled from source statement at line 147
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

  private ManageOrders.__Event6 __event6 = null;

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
    	
    	__event3 = new ManageOrders.__Event3();
    	
    	__event4 = new ManageOrders.__Event4();
    	
    	__event5 = new ManageOrders.__Event5();
    	
    	__event6 = new ManageOrders.__Event6();
    }
  }
}
