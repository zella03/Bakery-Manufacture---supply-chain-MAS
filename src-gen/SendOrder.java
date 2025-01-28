import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.core.AID;
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
    __event5.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event5.__eventFired) __awaitForEvents();
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

  protected String currentWorkerType = null;

  public void setCurrentWorkerType(final String currentWorkerType) {
    this.currentWorkerType = currentWorkerType;
  }

  public String getCurrentWorkerType() {
    return this.currentWorkerType;
  }

  protected Boolean eandOfPrivateOrders = null;

  public void setEandOfPrivateOrders(final Boolean eandOfPrivateOrders) {
    this.eandOfPrivateOrders = eandOfPrivateOrders;
  }

  public Boolean getEandOfPrivateOrders() {
    return this.eandOfPrivateOrders;
  }

  public Boolean checkIfWorkerReported(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final AID id) {
    {
    	/* 
    	 * Compiled from source statement from line 99 to line 103
    	 * if length of listOfWorkers ≠ 0 do
    	 * 	        for worker in listOfWorkers do
    	 * 	            if workerId of worker = id do
    	 * 	                currentWorkerType = type of worker
    	 * 	                return true
    	 */
    	
    	if(!java.util.Objects.equals(SendOrder.this._agentEnv.getAgent().getListOfWorkers().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 100 to line 103
    		 * for worker in listOfWorkers do
    		 * 	            if workerId of worker = id do
    		 * 	                currentWorkerType = type of worker
    		 * 	                return true
    		 */
    		
    		for ( WorkerReady worker : SendOrder.this._agentEnv.getAgent().getListOfWorkers()) {
    			/* 
    			 * Compiled from source statement from line 101 to line 103
    			 * if workerId of worker = id do
    			 * 	                currentWorkerType = type of worker
    			 * 	                return true
    			 */
    			
    			if(java.util.Objects.equals(worker.getWorkerId(), id)) {
    				/* 
    				 * Compiled from source statement at line 102
    				 * currentWorkerType = type of worker
    				 */
    				
    				SendOrder.this.setCurrentWorkerType(worker.getType());
    				
    				/* 
    				 * Compiled from source statement at line 103
    				 * return true
    				 */
    				
    				return true;
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 104
    	 * 
    	 *         return false
    	 */
    	
    	return false;
    }
  }

  public void ChangeTypeOfAgent(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final AID id) {
    {
    	/* 
    	 * Compiled from source statement from line 107 to line 112
    	 * if length of listOfWorkers ≠ 0 do
    	 * 	        for worker in listOfWorkers do
    	 * 	            if workerId of worker = id do
    	 * 	                type of worker = "normal"
    	 * 	                log "BAKER: "+worker+" changed into type 'normal'"
    	 * 	                break
    	 */
    	
    	if(!java.util.Objects.equals(SendOrder.this._agentEnv.getAgent().getListOfWorkers().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 108 to line 112
    		 * for worker in listOfWorkers do
    		 * 	            if workerId of worker = id do
    		 * 	                type of worker = "normal"
    		 * 	                log "BAKER: "+worker+" changed into type 'normal'"
    		 * 	                break
    		 */
    		
    		for ( WorkerReady worker : SendOrder.this._agentEnv.getAgent().getListOfWorkers()) {
    			/* 
    			 * Compiled from source statement from line 109 to line 112
    			 * if workerId of worker = id do
    			 * 	                type of worker = "normal"
    			 * 	                log "BAKER: "+worker+" changed into type 'normal'"
    			 * 	                break
    			 */
    			
    			if(java.util.Objects.equals(worker.getWorkerId(), id)) {
    				/* 
    				 * Compiled from source statement at line 110
    				 * type of worker = "normal"
    				 */
    				
    				worker.setType("normal");
    				
    				/* 
    				 * Compiled from source statement at line 111
    				 * log "BAKER: "+worker+" changed into type 'normal'"
    				 */
    				
    				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "ChangeTypeOfAgent", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(worker)) + java.lang.String.valueOf(" changed into type 'normal'")));
    				
    				/* 
    				 * Compiled from source statement at line 112
    				 * break
    				 */
    				
    				break;
    			}
    		}
    	}
    }
  }

  /**
   * SendOrder doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 115
    	 * eandOfPrivateOrders = false
    	 */
    	
    	SendOrder.this.setEandOfPrivateOrders(false);
    	
    	/* 
    	 * Compiled from source statement at line 116
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

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(SendOrder.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher2139726086 {
      	public jade.core.AID id;
      	
      	private final __PatternMatcher2139726086 __PatternMatcher2139726086_obj =  this;
      	
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
      __PatternMatcher2139726086 __PatternMatcher2139726086_obj = new __PatternMatcher2139726086();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher2139726086_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 119
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<RequestOrder>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 120
      			 * momentOfChangeType = false
      			 */
      			
      			java.lang.Boolean momentOfChangeType = false;
      			
      			/* 
      			 * Compiled from source statement from line 122 to line 151
      			 * if checkIfWorkerReported(id) do #should check if agent is on the list of working bakers
      			 *             if currentWorkerType = "private" and (length of orderList = 0) do #first time asking if sent of private
      			 *                log "END OF PRIVATE ORDERS. Lets do some normal orders."
      			 *                do SplitIntoOrdersNormal with normalOrders,1
      			 *                eandOfPrivateOrders = true
      			 *                
      			 *             if currentWorkerType = "private" and eandOfPrivateOrders do
      			 *                 send message inform EndOfPrivateOrders to senderAgent
      			 *                 do ChangeTypeOfAgent with id
      			 *                 momentOfChangeType = true
      			 *             
      			 *             if not momentOfChangeType do
      			 * 		        if length of orderList ≠ 0 do
      			 * 			       order = orderList[0]
      			 * 			       orderStatus = OrderStatus(id of order, status of order)
      			 * 		           remove order from orderList
      			 * 		           add orderStatus to pendingOrders
      			 * 		            
      			 * 		           log "REQUEST - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      			 * 		           log "REQUEST - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      			 * 		        
      			 * 			       log "SUPERVISOR: "+name of agent+" received request for order from agent: " + name of sender
      			 * 			       send message request AssignOrder(id,order) to senderAgent
      			 * 			    else do
      			 * 			       log "NO MORE ORDERS under SUPERVISOR: "+ name of agent
      			 * 			       send message inform EndOfOrders to senderAgent
      			 * 			       # info że koniec i nie ma się więcej pytać -> ale trzeba sprawdzić dla każdego
      			 * 			       #deactivate this
      			 * 		else do
      			 * 		  log "not yet reported"
      			 */
      			
      			if(SendOrder.this.checkIfWorkerReported(_agentEnv.getAgent().toEnv() ,__PatternMatcher2139726086_obj.id)) {
      				/* 
      				 * Compiled from source statement from line 123 to line 126
      				 * if currentWorkerType = "private" and (length of orderList = 0) do #first time asking if sent of private
      				 *                log "END OF PRIVATE ORDERS. Lets do some normal orders."
      				 *                do SplitIntoOrdersNormal with normalOrders,1
      				 *                eandOfPrivateOrders = true
      				 */
      				
      				if(java.util.Objects.equals(SendOrder.this.getCurrentWorkerType(), "private") && (java.util.Objects.equals(SendOrder.this._agentEnv.getAgent().getOrderList().size(), 0))) {
      					/* 
      					 * Compiled from source statement at line 124
      					 * log "END OF PRIVATE ORDERS. Lets do some normal orders."
      					 */
      					
      					jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf("END OF PRIVATE ORDERS. Lets do some normal orders."));
      					
      					/* 
      					 * Compiled from source statement at line 125
      					 * do SplitIntoOrdersNormal with normalOrders,1
      					 */
      					
      					SendOrder.this._agentEnv.getAgent().SplitIntoOrdersNormal(_agentEnv.getAgent().toEnv() ,SendOrder.this._agentEnv.getAgent().getNormalOrders() ,1);
      					
      					/* 
      					 * Compiled from source statement at line 126
      					 * eandOfPrivateOrders = true
      					 */
      					
      					SendOrder.this.setEandOfPrivateOrders(true);
      				}
      				
      				/* 
      				 * Compiled from source statement from line 128 to line 131
      				 * 
      				 *                
      				 *             if currentWorkerType = "private" and eandOfPrivateOrders do
      				 *                 send message inform EndOfPrivateOrders to senderAgent
      				 *                 do ChangeTypeOfAgent with id
      				 *                 momentOfChangeType = true
      				 */
      				
      				if(java.util.Objects.equals(SendOrder.this.getCurrentWorkerType(), "private") && SendOrder.this.getEandOfPrivateOrders()) {
      					/* 
      					 * Compiled from source statement at line 129
      					 * send message inform EndOfPrivateOrders to senderAgent
      					 */
      					
      					try {
      						jadescript.util.SendMessageUtils.validatePerformative("inform");
      						
      						java.lang.Object _contentToBeSent1239114761 = BakeryOntology.EndOfPrivateOrders();
      						
      						jadescript.core.message.Message _synthesizedMessage1239114761 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      						
      						_synthesizedMessage1239114761.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1239114761,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      						
      						_synthesizedMessage1239114761.setLanguage(__codec.getName());;
      						
      						_synthesizedMessage1239114761.addReceiver(senderAgent);
      						
      						_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1239114761, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1239114761, "inform"));
      						
      						_agentEnv.getAgent().send(_synthesizedMessage1239114761);
      					}
      					catch(java.lang.Throwable _t) {
      						throw jadescript.core.exception.JadescriptException.wrap(_t);
      					}
      					
      					/* 
      					 * Compiled from source statement at line 130
      					 * do ChangeTypeOfAgent with id
      					 */
      					
      					SendOrder.this.ChangeTypeOfAgent(_agentEnv.getAgent().toEnv() ,__PatternMatcher2139726086_obj.id);
      					
      					/* 
      					 * Compiled from source statement at line 131
      					 * momentOfChangeType = true
      					 */
      					
      					momentOfChangeType = true;
      				}
      				
      				/* 
      				 * Compiled from source statement from line 133 to line 147
      				 * 
      				 *             
      				 *             if not momentOfChangeType do
      				 * 		        if length of orderList ≠ 0 do
      				 * 			       order = orderList[0]
      				 * 			       orderStatus = OrderStatus(id of order, status of order)
      				 * 		           remove order from orderList
      				 * 		           add orderStatus to pendingOrders
      				 * 		            
      				 * 		           log "REQUEST - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      				 * 		           log "REQUEST - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      				 * 		        
      				 * 			       log "SUPERVISOR: "+name of agent+" received request for order from agent: " + name of sender
      				 * 			       send message request AssignOrder(id,order) to senderAgent
      				 * 			    else do
      				 * 			       log "NO MORE ORDERS under SUPERVISOR: "+ name of agent
      				 * 			       send message inform EndOfOrders to senderAgent
      				 */
      				
      				if( ! momentOfChangeType) {
      					/* 
      					 * Compiled from source statement from line 134 to line 147
      					 * if length of orderList ≠ 0 do
      					 * 			       order = orderList[0]
      					 * 			       orderStatus = OrderStatus(id of order, status of order)
      					 * 		           remove order from orderList
      					 * 		           add orderStatus to pendingOrders
      					 * 		            
      					 * 		           log "REQUEST - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      					 * 		           log "REQUEST - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      					 * 		        
      					 * 			       log "SUPERVISOR: "+name of agent+" received request for order from agent: " + name of sender
      					 * 			       send message request AssignOrder(id,order) to senderAgent
      					 * 			    else do
      					 * 			       log "NO MORE ORDERS under SUPERVISOR: "+ name of agent
      					 * 			       send message inform EndOfOrders to senderAgent
      					 */
      					
      					if(!java.util.Objects.equals(SendOrder.this._agentEnv.getAgent().getOrderList().size(), 0)) {
      						/* 
      						 * Compiled from source statement at line 135
      						 * order = orderList[0]
      						 */
      						
      						Order order = SendOrder.this._agentEnv.getAgent().getOrderList().get(0);
      						
      						/* 
      						 * Compiled from source statement at line 136
      						 * orderStatus = OrderStatus(id of order, status of order)
      						 */
      						
      						OrderStatus orderStatus = BakeryOntology.OrderStatus(order.getId() ,order.getStatus());
      						
      						/* 
      						 * Compiled from source statement at line 137
      						 * remove order from orderList
      						 */
      						
      						SendOrder.this._agentEnv.getAgent().getOrderList().remove(order);
      						
      						/* 
      						 * Compiled from source statement at line 138
      						 * add orderStatus to pendingOrders
      						 */
      						
      						SendOrder.this._agentEnv.getAgent().getPendingOrders().add(orderStatus);
      						
      						/* 
      						 * Compiled from source statement at line 140
      						 * log "REQUEST - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("REQUEST - Orders to make under SUPERVISOR") + java.lang.String.valueOf(SendOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(SendOrder.this._agentEnv.getAgent().getOrderList())));
      						
      						/* 
      						 * Compiled from source statement at line 141
      						 * log "REQUEST - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("REQUEST - Orders PENDING under SUPERVISOR") + java.lang.String.valueOf(SendOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(SendOrder.this._agentEnv.getAgent().getPendingOrders())));
      						
      						/* 
      						 * Compiled from source statement at line 143
      						 * log "SUPERVISOR: "+name of agent+" received request for order from agent: " + name of sender
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("SUPERVISOR: ") + java.lang.String.valueOf(SendOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received request for order from agent: ")) + java.lang.String.valueOf(__receivedMessage.getSender().getName())));
      						
      						/* 
      						 * Compiled from source statement at line 144
      						 * send message request AssignOrder(id,order) to senderAgent
      						 */
      						
      						try {
      							jadescript.util.SendMessageUtils.validatePerformative("request");
      							
      							java.lang.Object _contentToBeSent1268657487 = BakeryOntology.AssignOrder(__PatternMatcher2139726086_obj.id ,order);
      							
      							jadescript.core.message.Message _synthesizedMessage1268657487 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      							
      							_synthesizedMessage1268657487.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1268657487,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      							
      							_synthesizedMessage1268657487.setLanguage(__codec.getName());;
      							
      							_synthesizedMessage1268657487.addReceiver(senderAgent);
      							
      							_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1268657487, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1268657487, "request"));
      							
      							_agentEnv.getAgent().send(_synthesizedMessage1268657487);
      						}
      						catch(java.lang.Throwable _t) {
      							throw jadescript.core.exception.JadescriptException.wrap(_t);
      						}
      					}
      					else {
      						/* 
      						 * Compiled from source statement at line 146
      						 * log "NO MORE ORDERS under SUPERVISOR: "+ name of agent
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("NO MORE ORDERS under SUPERVISOR: ") + java.lang.String.valueOf(SendOrder.this.getJadescriptAgent().getName())));
      						
      						/* 
      						 * Compiled from source statement at line 147
      						 * send message inform EndOfOrders to senderAgent
      						 */
      						
      						try {
      							jadescript.util.SendMessageUtils.validatePerformative("inform");
      							
      							java.lang.Object _contentToBeSent402779768 = BakeryOntology.EndOfOrders();
      							
      							jadescript.core.message.Message _synthesizedMessage402779768 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      							
      							_synthesizedMessage402779768.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent402779768,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      							
      							_synthesizedMessage402779768.setLanguage(__codec.getName());;
      							
      							_synthesizedMessage402779768.addReceiver(senderAgent);
      							
      							_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage402779768, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent402779768, "inform"));
      							
      							_agentEnv.getAgent().send(_synthesizedMessage402779768);
      						}
      						catch(java.lang.Throwable _t) {
      							throw jadescript.core.exception.JadescriptException.wrap(_t);
      						}
      					}
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 151
      				 * log "not yet reported"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, SendOrder.this.getClass().getName(), SendOrder.this, "on request", java.lang.String.valueOf("not yet reported"));
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

  private SendOrder.__Event5 __event5 = null;

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
    	SendOrder.this.currentWorkerType = "";
    	
    	SendOrder.this.eandOfPrivateOrders = false;
    	
    	__event5 = new SendOrder.__Event5();
    }
  }
}
