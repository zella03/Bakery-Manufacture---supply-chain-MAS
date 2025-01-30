import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class FinishRaports extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static FinishRaports __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new FinishRaports(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event1.run();
    __event2.run();
    __event3.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event1.__eventFired && !__event2.__eventFired && !__event3.__eventFired) __awaitForEvents();
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

  public FinishRaports(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 241
    	 * log "SUPERVISOR waiting for final reports"
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, FinishRaports.this.getClass().getName(), FinishRaports.this, "on create", java.lang.String.valueOf("SUPERVISOR waiting for final reports"));
    	
    	/* 
    	 * Compiled from source statement at line 242
    	 * allBakersReported = 0
    	 */
    	
    	FinishRaports.this._agentEnv.getAgent().setAllBakersReported(0);
    	
    	/* 
    	 * Compiled from source statement from line 243 to line 246
    	 * if length of supplierList ≠ 0 do #means that this is Supervisor2
    	 *             packerReported = false
    	 *         else do
    	 *             packerReported = true
    	 */
    	
    	if(!java.util.Objects.equals(FinishRaports.this._agentEnv.getAgent().getSupplierList().size(), 0)) {
    		/* 
    		 * Compiled from source statement at line 244
    		 * packerReported = false
    		 */
    		
    		FinishRaports.this._agentEnv.getAgent().setPackerReported(false);
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 246
    		 * packerReported = true
    		 */
    		
    		FinishRaports.this._agentEnv.getAgent().setPackerReported(true);
    	}
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event1 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 249 to line 251
      	 * if allBakersReported = numOfWorkers and packerReported do
      	 *             log "END OF WORK"
      	 *             destroy this
      	 */
      	
      	if(java.util.Objects.equals(FinishRaports.this._agentEnv.getAgent().getAllBakersReported(), FinishRaports.this._agentEnv.getAgent().getNumOfWorkers()) && FinishRaports.this._agentEnv.getAgent().getPackerReported()) {
      		/* 
      		 * Compiled from source statement at line 250
      		 * log "END OF WORK"
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, FinishRaports.this.getClass().getName(), FinishRaports.this, "on execute", java.lang.String.valueOf("END OF WORK"));
      		
      		/* 
      		 * Compiled from source statement at line 251
      		 * destroy this
      		 */
      		
      		FinishRaports.this.destroy();
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

  private FinishRaports.__Event1 __event1 =  new FinishRaports.__Event1();

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(FinishRaports.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1904067707 {
      	public jade.core.AID id;
      	
      	public java.lang.Integer succRestockByColl;
      	
      	public java.lang.Integer succRestockBySupp;
      	
      	public java.lang.Integer ordersToRedo;
      	
      	public java.lang.Integer ordersDone;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> stock;
      	
      	private final __PatternMatcher1904067707 __PatternMatcher1904067707_obj =  this;
      	
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
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		succRestockByColl = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm2(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		succRestockBySupp = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm3(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		ordersToRedo = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm4(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		ordersDone = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm5(java.lang.Object __objx) {
      		jadescript.util.JadescriptList<IngredientQuantity> __x;
      		
      		try {
      			if(__objx instanceof jadescript.util.JadescriptList) {
      				__x = (jadescript.util.JadescriptList<IngredientQuantity>) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		stock = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		BakerRaportInfo __x;
      		
      		try {
      			if(__objx instanceof BakerRaportInfo) {
      				__x = (BakerRaportInfo) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getId()) && headerMatch_structterm1(__x.getNumRestockFromColl()) && headerMatch_structterm2(__x.getNumRestockFromSupp()) && headerMatch_structterm3(__x.getNumOrdersToRedo()) && headerMatch_structterm4(__x.getOrdersDone()) && headerMatch_structterm5(__x.getRestStock());
      	}
      }
      __PatternMatcher1904067707 __PatternMatcher1904067707_obj = new __PatternMatcher1904067707();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1904067707_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	FinishRaports.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 255
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<BakerRaportInfo>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 256 to line 260
      			 * log "RAPORT OF: "+name of agent+" for BAKER: "+name of senderAgent
      			 *             + "\n Num of successful necessary assistance of colleagues: "+succRestockByColl
      			 *             + "\n Num of successful necessary restocks from suppliers: "+succRestockBySupp
      			 *             + "\n Orders done: "+ordersDone+" and orders needed to be redone: "+ordersToRedo
      			 *             + "\n Stock left: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, FinishRaports.this.getClass().getName(), FinishRaports.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("RAPORT OF: ") + java.lang.String.valueOf(FinishRaports.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" for BAKER: ")) + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf("\n Num of successful necessary assistance of colleagues: ")) + java.lang.String.valueOf(__PatternMatcher1904067707_obj.succRestockByColl)) + java.lang.String.valueOf("\n Num of successful necessary restocks from suppliers: ")) + java.lang.String.valueOf(__PatternMatcher1904067707_obj.succRestockBySupp)) + java.lang.String.valueOf("\n Orders done: ")) + java.lang.String.valueOf(__PatternMatcher1904067707_obj.ordersDone)) + java.lang.String.valueOf(" and orders needed to be redone: ")) + java.lang.String.valueOf(__PatternMatcher1904067707_obj.ordersToRedo)) + java.lang.String.valueOf("\n Stock left: ")) + java.lang.String.valueOf(__PatternMatcher1904067707_obj.stock)));
      			
      			/* 
      			 * Compiled from source statement at line 262
      			 * allBakersReported = allBakersReported + 1
      			 */
      			
      			FinishRaports.this._agentEnv.getAgent().setAllBakersReported(FinishRaports.this._agentEnv.getAgent().getAllBakersReported() + 1);
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

  private FinishRaports.__Event2 __event2 = null;

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(FinishRaports.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1349609425 {
      	public jadescript.util.JadescriptList<PackagePreparation> timeForPackage;
      	
      	private final __PatternMatcher1349609425 __PatternMatcher1349609425_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		jadescript.util.JadescriptList<PackagePreparation> __x;
      		
      		try {
      			if(__objx instanceof jadescript.util.JadescriptList) {
      				__x = (jadescript.util.JadescriptList<PackagePreparation>) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		timeForPackage = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		PackerRaport __x;
      		
      		try {
      			if(__objx instanceof PackerRaport) {
      				__x = (PackerRaport) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getPcgPrep());
      	}
      }
      __PatternMatcher1349609425 __PatternMatcher1349609425_obj = new __PatternMatcher1349609425();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1349609425_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	FinishRaports.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement from line 265 to line 266
      			 * log "RAPORT OF: "+name of agent+" for PACKER: "+ name of packer
      			 *             + "\n Packages with their prep time: "+PackerRaport(timeForPackage)
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, FinishRaports.this.getClass().getName(), FinishRaports.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("RAPORT OF: ") + java.lang.String.valueOf(FinishRaports.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" for PACKER: ")) + java.lang.String.valueOf(FinishRaports.this._agentEnv.getAgent().getPacker().getName())) + java.lang.String.valueOf("\n Packages with their prep time: ")) + java.lang.String.valueOf(BakeryOntology.PackerRaport(__PatternMatcher1349609425_obj.timeForPackage))));
      			
      			/* 
      			 * Compiled from source statement at line 268
      			 * packerReported = true
      			 */
      			
      			FinishRaports.this._agentEnv.getAgent().setPackerReported(true);
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

  private FinishRaports.__Event3 __event3 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(FinishRaports.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event2 = new FinishRaports.__Event2();
    	
    	__event3 = new FinishRaports.__Event3();
    }
  }
}
