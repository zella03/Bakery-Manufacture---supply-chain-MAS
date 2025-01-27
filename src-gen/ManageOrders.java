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

  public ManageOrders(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

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
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event2.__eventFired && !__event3.__eventFired && !__event4.__eventFired) __awaitForEvents();
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

  /**
   * ManageOrders doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 104
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
  }

  private class __Event2 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 107 to line 114
      	 * if length of ordersList !=0 do
      	 *             for i in ordersList do
      	 *                 if status of i ≠ "baking" do
      	 *                     break
      	 *                 else do 
      	 *                     count = count + 1 #we can't ask for new order if we are preparing another one or when we lack of ingredients
      	 *             if count = length of ordersList do #if everything is ONLY baking we can ask for another order to make
      	 *                 activate SendRequest
      	 */
      	
      	if(!java.util.Objects.equals(ManageOrders.this._agentEnv.getAgent().getOrdersList().size(), 0)) {
      		/* 
      		 * Compiled from source statement from line 108 to line 112
      		 * for i in ordersList do
      		 *                 if status of i ≠ "baking" do
      		 *                     break
      		 *                 else do 
      		 *                     count = count + 1
      		 */
      		
      		for ( OrderStatus i : ManageOrders.this._agentEnv.getAgent().getOrdersList()) {
      			/* 
      			 * Compiled from source statement from line 109 to line 112
      			 * if status of i ≠ "baking" do
      			 *                     break
      			 *                 else do 
      			 *                     count = count + 1
      			 */
      			
      			if(!java.util.Objects.equals(i.getStatus(), "baking")) {
      				/* 
      				 * Compiled from source statement at line 110
      				 * break
      				 */
      				
      				break;
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 112
      				 * count = count + 1
      				 */
      				
      				ManageOrders.this.setCount(ManageOrders.this.getCount() + 1);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement from line 113 to line 114
      		 *  #we can't ask for new order if we are preparing another one or when we lack of ingredients
      		 *             if count = length of ordersList do #if everything is ONLY baking we can ask for another order to make
      		 *                 activate SendRequest
      		 */
      		
      		if(java.util.Objects.equals(ManageOrders.this.getCount(), ManageOrders.this._agentEnv.getAgent().getOrdersList().size())) {
      			/* 
      			 * Compiled from source statement at line 114
      			 * activate SendRequest
      			 */
      			
      			new SendRequest(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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
       class __PatternMatcher2095266631 {
      	public java.lang.String id;
      	
      	public java.lang.String status;
      	
      	private final __PatternMatcher2095266631 __PatternMatcher2095266631_obj =  this;
      	
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
      __PatternMatcher2095266631 __PatternMatcher2095266631_obj = new __PatternMatcher2095266631();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher2095266631_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 117
      			 * log "Agent: "+name of agent+" is finished."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(ManageOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" is finished.")));
      			
      			/* 
      			 * Compiled from source statement at line 118
      			 * send message inform OrderStatus(id,status) to supervisorName@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1796877897 = BakeryOntology.OrderStatus(__PatternMatcher2095266631_obj.id ,__PatternMatcher2095266631_obj.status);
      				
      				jadescript.core.message.Message _synthesizedMessage1796877897 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1796877897.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1796877897,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1796877897.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1796877897.addReceiver(new jade.core.AID(java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getSupervisorName()), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1796877897, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1796877897, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1796877897);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 119
      			 * remove OrderStatus(id,status) from ordersList
      			 */
      			
      			ManageOrders.this._agentEnv.getAgent().getOrdersList().remove(BakeryOntology.OrderStatus(__PatternMatcher2095266631_obj.id ,__PatternMatcher2095266631_obj.status));
      			
      			/* 
      			 * Compiled from source statement at line 120
      			 * log ordersList
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ManageOrders.this.getClass().getName(), ManageOrders.this, "on inform", java.lang.String.valueOf(ManageOrders.this._agentEnv.getAgent().getOrdersList()));
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
       class __PatternMatcher957418642 {
      	private final __PatternMatcher957418642 __PatternMatcher957418642_obj =  this;
      	
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
      __PatternMatcher957418642 __PatternMatcher957418642_obj = new __PatternMatcher957418642();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher957418642_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement from line 123 to line 126
      			 * if typeBaker of agent = "private" do
      			 *             do changeToNormal
      			 *             for i in listOfCoworkers do
      			 *                 send message inform EndOfPrivateOrders to i@
      			 */
      			
      			if(java.util.Objects.equals(ManageOrders.this.getJadescriptAgent().getTypeBaker(), "private")) {
      				/* 
      				 * Compiled from source statement at line 124
      				 * do changeToNormal
      				 */
      				
      				ManageOrders.this._agentEnv.getAgent().changeToNormal(_agentEnv.getAgent().toEnv());
      				
      				/* 
      				 * Compiled from source statement from line 125 to line 126
      				 * for i in listOfCoworkers do
      				 *                 send message inform EndOfPrivateOrders to i@
      				 */
      				
      				for ( java.lang.String i : ManageOrders.this._agentEnv.getAgent().getListOfCoworkers()) {
      					/* 
      					 * Compiled from source statement at line 126
      					 * send message inform EndOfPrivateOrders to i@
      					 */
      					
      					try {
      						jadescript.util.SendMessageUtils.validatePerformative("inform");
      						
      						java.lang.Object _contentToBeSent626807321 = BakeryOntology.EndOfPrivateOrders();
      						
      						jadescript.core.message.Message _synthesizedMessage626807321 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      						
      						_synthesizedMessage626807321.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent626807321,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      						
      						_synthesizedMessage626807321.setLanguage(__codec.getName());;
      						
      						_synthesizedMessage626807321.addReceiver(new jade.core.AID(java.lang.String.valueOf(i), false));
      						
      						_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage626807321, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent626807321, "inform"));
      						
      						_agentEnv.getAgent().send(_synthesizedMessage626807321);
      					}
      					catch(java.lang.Throwable _t) {
      						throw jadescript.core.exception.JadescriptException.wrap(_t);
      					}
      				}
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

  private ManageOrders.__Event4 __event4 = null;

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
    	ManageOrders.this.count = 0;
    	
    	__event3 = new ManageOrders.__Event3();
    	
    	__event4 = new ManageOrders.__Event4();
    }
  }
}
