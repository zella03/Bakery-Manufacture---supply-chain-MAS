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
    __event6.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event4.__eventFired && !__event5.__eventFired && !__event6.__eventFired) __awaitForEvents();
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

  public ReportingWorkers(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 68
    	 * count = 0
    	 */
    	
    	ReportingWorkers.this.setCount(0);
    	
    	/* 
    	 * Compiled from source statement at line 69
    	 * allReported = false
    	 */
    	
    	ReportingWorkers.this.setAllReported(false);
    	
    	/* 
    	 * Compiled from source statement from line 70 to line 73
    	 * if type = "private" do
    	 *             packerReady = false
    	 *         else do
    	 *             packerReady = true
    	 */
    	
    	if(java.util.Objects.equals(ReportingWorkers.this._agentEnv.getAgent().getType(), "private")) {
    		/* 
    		 * Compiled from source statement at line 71
    		 * packerReady = false
    		 */
    		
    		ReportingWorkers.this.setPackerReady(false);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 73
    		 * packerReady = true
    		 */
    		
    		ReportingWorkers.this.setPackerReady(true);
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
      	 * Compiled from source statement from line 76 to line 80
      	 * if allReported and packerReady do
      	 * 	        for worker in listOfWorkers do
      	 * 	            send message inform AgentsReported to workerId of worker
      	 * 	        activate SendOrder
      	 * 	        deactivate this
      	 */
      	
      	if(ReportingWorkers.this.getAllReported() && ReportingWorkers.this.getPackerReady()) {
      		/* 
      		 * Compiled from source statement from line 77 to line 78
      		 * for worker in listOfWorkers do
      		 * 	            send message inform AgentsReported to workerId of worker
      		 */
      		
      		for ( WorkerReady worker : ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers()) {
      			/* 
      			 * Compiled from source statement at line 78
      			 * send message inform AgentsReported to workerId of worker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent356266990 = BakeryOntology.AgentsReported();
      				
      				jadescript.core.message.Message _synthesizedMessage356266990 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage356266990.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent356266990,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage356266990.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage356266990.addReceiver(worker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage356266990, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent356266990, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage356266990);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 79
      		 * 
      		 * 	        activate SendOrder
      		 */
      		
      		new SendOrder(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement at line 80
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
       class __PatternMatcher959532505 {
      	public jade.core.AID id;
      	
      	private final __PatternMatcher959532505 __PatternMatcher959532505_obj =  this;
      	
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
      		PackerReady __x;
      		
      		try {
      			if(__objx instanceof PackerReady) {
      				__x = (PackerReady) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getWorkerId());
      	}
      }
      __PatternMatcher959532505 __PatternMatcher959532505_obj = new __PatternMatcher959532505();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher959532505_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 83
      			 * packer of agent = id
      			 */
      			
      			ReportingWorkers.this.getJadescriptAgent().setPacker(__PatternMatcher959532505_obj.id);
      			
      			/* 
      			 * Compiled from source statement at line 84
      			 * packerReady = true
      			 */
      			
      			ReportingWorkers.this.setPackerReady(true);
      			
      			/* 
      			 * Compiled from source statement at line 85
      			 * send message request ProvidePackingList(privateOrders) to packer
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1144311081 = BakeryOntology.ProvidePackingList(ReportingWorkers.this._agentEnv.getAgent().getPrivateOrders());
      				
      				jadescript.core.message.Message _synthesizedMessage1144311081 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1144311081.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1144311081,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1144311081.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1144311081.addReceiver(ReportingWorkers.this._agentEnv.getAgent().getPacker());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1144311081, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1144311081, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1144311081);
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

  private ReportingWorkers.__Event5 __event5 = null;

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(ReportingWorkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher42377038 {
      	public jade.core.AID id;
      	
      	public java.lang.String workerType;
      	
      	private final __PatternMatcher42377038 __PatternMatcher42377038_obj =  this;
      	
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
      		
      		return true && headerMatch_structterm0(__x.getWorkerId()) && headerMatch_structterm1(__x.getType());
      	}
      }
      __PatternMatcher42377038 __PatternMatcher42377038_obj = new __PatternMatcher42377038();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher42377038_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 88
      			 * add WorkerReady(id,workerType) to listOfWorkers
      			 */
      			
      			ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers().add(BakeryOntology.WorkerReady(__PatternMatcher42377038_obj.id ,__PatternMatcher42377038_obj.workerType));
      			
      			/* 
      			 * Compiled from source statement at line 89
      			 * log "BAKERS which reported - ready to work: "+listOfWorkers
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ReportingWorkers.this.getClass().getName(), ReportingWorkers.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("BAKERS which reported - ready to work: ") + java.lang.String.valueOf(ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers())));
      			
      			/* 
      			 * Compiled from source statement at line 90
      			 * count = count + 1
      			 */
      			
      			ReportingWorkers.this.setCount(ReportingWorkers.this.getCount() + 1);
      			
      			/* 
      			 * Compiled from source statement from line 92 to line 93
      			 * if count = numOfWorkers do
      			 *            allReported = true
      			 */
      			
      			if(java.util.Objects.equals(ReportingWorkers.this.getCount(), ReportingWorkers.this._agentEnv.getAgent().getNumOfWorkers())) {
      				/* 
      				 * Compiled from source statement at line 93
      				 * allReported = true
      				 */
      				
      				ReportingWorkers.this.setAllReported(true);
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

  private ReportingWorkers.__Event6 __event6 = null;

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
    	ReportingWorkers.this.count = 0;
    	
    	ReportingWorkers.this.allReported = false;
    	
    	ReportingWorkers.this.packerReady = false;
    	
    	__event5 = new ReportingWorkers.__Event5();
    	
    	__event6 = new ReportingWorkers.__Event6();
    }
  }
}
