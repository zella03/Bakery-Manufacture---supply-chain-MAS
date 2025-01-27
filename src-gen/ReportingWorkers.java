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
    __event3.run();
    __event4.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event3.__eventFired && !__event4.__eventFired) __awaitForEvents();
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

  public ReportingWorkers(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 53
    	 * count = 0
    	 */
    	
    	ReportingWorkers.this.setCount(0);
    	
    	/* 
    	 * Compiled from source statement at line 54
    	 * allReported = false
    	 */
    	
    	ReportingWorkers.this.setAllReported(false);
    	
    	/* 
    	 * Compiled from source statement at line 55
    	 * log count
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, ReportingWorkers.this.getClass().getName(), ReportingWorkers.this, "on create", java.lang.String.valueOf(ReportingWorkers.this.getCount()));
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event3 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 58 to line 63
      	 * if allReported do
      	 * 	        for worker in listOfWorkers do
      	 * 	            log "problem here"
      	 * 	            send message inform AgentsReported to workerId of worker
      	 * 	        activate SendOrder
      	 * 	        deactivate this
      	 */
      	
      	if(ReportingWorkers.this.getAllReported()) {
      		/* 
      		 * Compiled from source statement from line 59 to line 61
      		 * for worker in listOfWorkers do
      		 * 	            log "problem here"
      		 * 	            send message inform AgentsReported to workerId of worker
      		 */
      		
      		for ( WorkerReady worker : ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers()) {
      			/* 
      			 * Compiled from source statement at line 60
      			 * log "problem here"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ReportingWorkers.this.getClass().getName(), ReportingWorkers.this, "on execute", java.lang.String.valueOf("problem here"));
      			
      			/* 
      			 * Compiled from source statement at line 61
      			 * send message inform AgentsReported to workerId of worker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1372370486 = BakeryOntology.AgentsReported();
      				
      				jadescript.core.message.Message _synthesizedMessage1372370486 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1372370486.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1372370486,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1372370486.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1372370486.addReceiver(worker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1372370486, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1372370486, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1372370486);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 62
      		 * 
      		 * 	        activate SendOrder
      		 */
      		
      		new SendOrder(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement at line 63
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

  private ReportingWorkers.__Event3 __event3 =  new ReportingWorkers.__Event3();

  private class __Event4 {
    Boolean __eventFired = false;

    public void run() {
      if(ReportingWorkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1119321795 {
      	public jade.core.AID id;
      	
      	public java.lang.String workerType;
      	
      	private final __PatternMatcher1119321795 __PatternMatcher1119321795_obj =  this;
      	
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
      __PatternMatcher1119321795 __PatternMatcher1119321795_obj = new __PatternMatcher1119321795();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1119321795_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 67
      			 * log "problem here"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ReportingWorkers.this.getClass().getName(), ReportingWorkers.this, "on inform", java.lang.String.valueOf("problem here"));
      			
      			/* 
      			 * Compiled from source statement at line 68
      			 * add WorkerReady(id,workerType) to listOfWorkers
      			 */
      			
      			ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers().add(BakeryOntology.WorkerReady(__PatternMatcher1119321795_obj.id ,__PatternMatcher1119321795_obj.workerType));
      			
      			/* 
      			 * Compiled from source statement at line 69
      			 * log "workers which reported: "+listOfWorkers
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ReportingWorkers.this.getClass().getName(), ReportingWorkers.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("workers which reported: ") + java.lang.String.valueOf(ReportingWorkers.this._agentEnv.getAgent().getListOfWorkers())));
      			
      			/* 
      			 * Compiled from source statement at line 70
      			 * count = count + 1
      			 */
      			
      			ReportingWorkers.this.setCount(ReportingWorkers.this.getCount() + 1);
      			
      			/* 
      			 * Compiled from source statement from line 72 to line 73
      			 * if count = 2 do
      			 *            allReported = true
      			 */
      			
      			if(java.util.Objects.equals(ReportingWorkers.this.getCount(), 2)) {
      				/* 
      				 * Compiled from source statement at line 73
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

  private ReportingWorkers.__Event4 __event4 = null;

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
    	
    	__event4 = new ReportingWorkers.__Event4();
    }
  }
}
