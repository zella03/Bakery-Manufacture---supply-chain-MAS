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
    	 * Compiled from source statement at line 75
    	 * otherGroupEnded = false
    	 */
    	
    	java.lang.Boolean otherGroupEnded = false;
    	
    	/* 
    	 * Compiled from source statement at line 76
    	 * allReported = false
    	 */
    	
    	ReportingWorkers.this.setAllReported(false);
    	
    	/* 
    	 * Compiled from source statement from line 77 to line 82
    	 * if type = "private" do
    	 *             packerReady = false
    	 *             supplierReady = false
    	 *         else do
    	 *             packerReady = true
    	 *             supplierReady = true
    	 */
    	
    	if(java.util.Objects.equals(ReportingWorkers.this._agentEnv.getAgent().getType(), "private")) {
    		/* 
    		 * Compiled from source statement at line 78
    		 * packerReady = false
    		 */
    		
    		ReportingWorkers.this.setPackerReady(false);
    		
    		/* 
    		 * Compiled from source statement at line 79
    		 * supplierReady = false
    		 */
    		
    		ReportingWorkers.this.setSupplierReady(false);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 81
    		 * packerReady = true
    		 */
    		
    		ReportingWorkers.this.setPackerReady(true);
    		
    		/* 
    		 * Compiled from source statement at line 82
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
      	 * Compiled from source statement from line 85 to line 89
      	 * if allReported and packerReady and supplierReady do
      	 * 	       for worker in listOfBakers do
      	 * 	           send message inform AgentsReported to workerId of worker
      	 * 	       activate SendOrder
      	 * 	       destroy this
      	 */
      	
      	if(ReportingWorkers.this.getAllReported() && ReportingWorkers.this.getPackerReady() && ReportingWorkers.this.getSupplierReady()) {
      		/* 
      		 * Compiled from source statement from line 86 to line 87
      		 * for worker in listOfBakers do
      		 * 	           send message inform AgentsReported to workerId of worker
      		 */
      		
      		for ( WorkerReady worker : ReportingWorkers.this._agentEnv.getAgent().getListOfBakers()) {
      			/* 
      			 * Compiled from source statement at line 87
      			 * send message inform AgentsReported to workerId of worker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1273438784 = BakeryOntology.AgentsReported();
      				
      				jadescript.core.message.Message _synthesizedMessage1273438784 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1273438784.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1273438784,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1273438784.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1273438784.addReceiver(worker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1273438784, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1273438784, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1273438784);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 88
      		 * 
      		 * 	       activate SendOrder
      		 */
      		
      		new SendOrder(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement at line 89
      		 * destroy this
      		 */
      		
      		ReportingWorkers.this.destroy();
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
       class __PatternMatcher285534969 {
      	public jade.core.AID id;
      	
      	public java.lang.String worker;
      	
      	public java.lang.String workerType;
      	
      	private final __PatternMatcher285534969 __PatternMatcher285534969_obj =  this;
      	
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
      __PatternMatcher285534969 __PatternMatcher285534969_obj = new __PatternMatcher285534969();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher285534969_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 92
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<WorkerReady>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 93 to line 100
      			 * if worker = "baker" do
      			 * 	       add WorkerReady(senderAgent,worker,workerType) to listOfBakers
      			 * 	    else if worker = "packer" do
      			 * 	       packer of agent = senderAgent
      			 * 	       packerReady = true
      			 * 	       send message request ProvidePackingList(privateOrders) to packer
      			 * 	    else if worker = "supplier" do
      			 * 	       add senderAgent to supplierList
      			 */
      			
      			if(java.util.Objects.equals(__PatternMatcher285534969_obj.worker, "baker")) {
      				/* 
      				 * Compiled from source statement at line 94
      				 * add WorkerReady(senderAgent,worker,workerType) to listOfBakers
      				 */
      				
      				ReportingWorkers.this._agentEnv.getAgent().getListOfBakers().add(BakeryOntology.WorkerReady(senderAgent ,__PatternMatcher285534969_obj.worker ,__PatternMatcher285534969_obj.workerType));
      			}
      			else if(java.util.Objects.equals(__PatternMatcher285534969_obj.worker, "packer")) {
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
      					
      					java.lang.Object _contentToBeSent148851638 = BakeryOntology.ProvidePackingList(ReportingWorkers.this._agentEnv.getAgent().getPrivateOrders());
      					
      					jadescript.core.message.Message _synthesizedMessage148851638 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage148851638.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent148851638,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage148851638.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage148851638.addReceiver(ReportingWorkers.this._agentEnv.getAgent().getPacker());
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage148851638, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent148851638, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage148851638);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else if(java.util.Objects.equals(__PatternMatcher285534969_obj.worker, "supplier")) {
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
