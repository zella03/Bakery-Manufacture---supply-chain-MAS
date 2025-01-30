import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class ReportingWorkers extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static ReportingWorkers __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new ReportingWorkers(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event4.run();
    __event5.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event4.__eventFired && !__event5.__eventFired) __awaitForEvents();
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

  protected Boolean allReported = null;

  public void setAllReported(final Boolean allReported) {
    this.allReported = allReported;
  }

  public Boolean getAllReported() {
    return this.allReported;
  }

  protected Boolean packerReady = null;

  public void setPackerReady(final Boolean packerReady) {
    this.packerReady = packerReady;
  }

  public Boolean getPackerReady() {
    return this.packerReady;
  }

  protected Boolean supplierReady = null;

  public void setSupplierReady(final Boolean supplierReady) {
    this.supplierReady = supplierReady;
  }

  public Boolean getSupplierReady() {
    return this.supplierReady;
  }

  public ReportingWorkers(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 73
    	 * otherGroupEnded = false
    	 */
    	
    	java.lang.Boolean otherGroupEnded = false;
    	
    	/* 
    	 * Compiled from source statement at line 74
    	 * allReported = false
    	 */
    	
    	ReportingWorkers.this.setAllReported(false);
    	
    	/* 
    	 * Compiled from source statement from line 75 to line 80
    	 * if type = "private" do
    	 *             packerReady = false
    	 *             supplierReady = false
    	 *         else do
    	 *             packerReady = true
    	 *             supplierReady = true
    	 */
    	
    	if(java.util.Objects.equals(ReportingWorkers.this._agentEnv.getAgent().getType(), "private")) {
    		/* 
    		 * Compiled from source statement at line 76
    		 * packerReady = false
    		 */
    		
    		ReportingWorkers.this.setPackerReady(false);
    		
    		/* 
    		 * Compiled from source statement at line 77
    		 * supplierReady = false
    		 */
    		
    		ReportingWorkers.this.setSupplierReady(false);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 79
    		 * packerReady = true
    		 */
    		
    		ReportingWorkers.this.setPackerReady(true);
    		
    		/* 
    		 * Compiled from source statement at line 80
    		 * supplierReady = true
    		 */
    		
    		ReportingWorkers.this.setSupplierReady(true);
    	}
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
      	 * Compiled from source statement from line 83 to line 87
      	 * if allReported and packerReady and supplierReady do
      	 * 	       for worker in listOfBakers do
      	 * 	           send message inform AgentsReported to workerId of worker
      	 * 	       activate SendOrder
      	 * 	       deactivate this
      	 */
      	
      	if(ReportingWorkers.this.getAllReported() && ReportingWorkers.this.getPackerReady() && ReportingWorkers.this.getSupplierReady()) {
      		/* 
      		 * Compiled from source statement from line 84 to line 85
      		 * for worker in listOfBakers do
      		 * 	           send message inform AgentsReported to workerId of worker
      		 */
      		
      		for ( WorkerReady worker : ReportingWorkers.this._agentEnv.getAgent().getListOfBakers()) {
      			/* 
      			 * Compiled from source statement at line 85
      			 * send message inform AgentsReported to workerId of worker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent2080010213 = BakeryOntology.AgentsReported();
      				
      				jadescript.core.message.Message _synthesizedMessage2080010213 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage2080010213.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent2080010213,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage2080010213.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage2080010213.addReceiver(worker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage2080010213, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent2080010213, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage2080010213);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 86
      		 * 
      		 * 	       activate SendOrder
      		 */
      		
      		new SendOrder(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement at line 87
      		 * deactivate this
      		 */
      		
      		ReportingWorkers.this.deactivate();
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

  private ReportingWorkers.__Event4 __event4 =  new ReportingWorkers.__Event4();

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(ReportingWorkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1410293899 {
      	public jade.core.AID id;
      	
      	public java.lang.String worker;
      	
      	public java.lang.String workerType;
      	
      	private final __PatternMatcher1410293899 __PatternMatcher1410293899_obj =  this;
      	
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
      		
      		worker = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm2(java.lang.Object __objx) {
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
      		
      		workerType = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		WorkerReady __x;
      		
      		try {
      			if(__objx instanceof WorkerReady) {
      				__x = (WorkerReady) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getWorkerId()) && headerMatch_structterm1(__x.getWorker()) && headerMatch_structterm2(__x.getType());
      	}
      }
      __PatternMatcher1410293899 __PatternMatcher1410293899_obj = new __PatternMatcher1410293899();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1410293899_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ReportingWorkers.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 90
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<WorkerReady>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 91 to line 100
      			 * if worker = "baker" do
      			 * 	       add WorkerReady(senderAgent,worker,workerType) to listOfBakers
      			 * 	       #log "BAKERS which reported - ready to work: "+listOfBakers
      			 * 	       #count = count + 1
      			 * 	    else if worker = "packer" do
      			 * 	       packer of agent = senderAgent
      			 * 	       packerReady = true
      			 * 	       send message request ProvidePackingList(privateOrders) to packer
      			 * 	    else if worker = "supplier" do
      			 * 	       add senderAgent to supplierList
      			 */
      			
      			if(java.util.Objects.equals(__PatternMatcher1410293899_obj.worker, "baker")) {
      				/* 
      				 * Compiled from source statement at line 92
      				 * add WorkerReady(senderAgent,worker,workerType) to listOfBakers
      				 */
      				
      				ReportingWorkers.this._agentEnv.getAgent().getListOfBakers().add(BakeryOntology.WorkerReady(senderAgent ,__PatternMatcher1410293899_obj.worker ,__PatternMatcher1410293899_obj.workerType));
      			}
      			else if(java.util.Objects.equals(__PatternMatcher1410293899_obj.worker, "packer")) {
      				/* 
      				 * Compiled from source statement at line 96
      				 * packer of agent = senderAgent
      				 */
      				
      				ReportingWorkers.this.getJadescriptAgent().setPacker(senderAgent);
      				
      				/* 
      				 * Compiled from source statement at line 97
      				 * packerReady = true
      				 */
      				
      				ReportingWorkers.this.setPackerReady(true);
      				
      				/* 
      				 * Compiled from source statement at line 98
      				 * send message request ProvidePackingList(privateOrders) to packer
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent837662447 = BakeryOntology.ProvidePackingList(ReportingWorkers.this._agentEnv.getAgent().getPrivateOrders());
      					
      					jadescript.core.message.Message _synthesizedMessage837662447 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage837662447.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent837662447,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage837662447.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage837662447.addReceiver(ReportingWorkers.this._agentEnv.getAgent().getPacker());
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage837662447, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent837662447, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage837662447);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else if(java.util.Objects.equals(__PatternMatcher1410293899_obj.worker, "supplier")) {
      				/* 
      				 * Compiled from source statement at line 100
      				 * add senderAgent to supplierList
      				 */
      				
      				ReportingWorkers.this._agentEnv.getAgent().getSupplierList().add(senderAgent);
      			}
      			
      			/* 
      			 * Compiled from source statement from line 102 to line 103
      			 * 
      			 *         
      			 *         if length of listOfBakers = numOfWorkers do
      			 *            allReported = true
      			 */
      			
      			if(java.util.Objects.equals(ReportingWorkers.this._agentEnv.getAgent().getListOfBakers().size(), ReportingWorkers.this._agentEnv.getAgent().getNumOfWorkers())) {
      				/* 
      				 * Compiled from source statement at line 103
      				 * allReported = true
      				 */
      				
      				ReportingWorkers.this.setAllReported(true);
      			}
      			
      			/* 
      			 * Compiled from source statement from line 105 to line 106
      			 * 
      			 *         
      			 *         if length of supplierList = 2 do
      			 *            supplierReady = true
      			 */
      			
      			if(java.util.Objects.equals(ReportingWorkers.this._agentEnv.getAgent().getSupplierList().size(), 2)) {
      				/* 
      				 * Compiled from source statement at line 106
      				 * supplierReady = true
      				 */
      				
      				ReportingWorkers.this.setSupplierReady(true);
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

  private ReportingWorkers.__Event5 __event5 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ReportingWorkers.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ReportingWorkers.this.allReported = false;
    	
    	ReportingWorkers.this.packerReady = false;
    	
    	ReportingWorkers.this.supplierReady = false;
    	
    	__event5 = new ReportingWorkers.__Event5();
    }
  }
}
