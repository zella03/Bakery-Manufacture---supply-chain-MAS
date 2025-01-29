import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitAndPackOrders extends CyclicBehaviour<Packer> {
  private Packer __theAgent = (Packer)/*Used as metadata*/null;

  private AgentEnv<Packer, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public WaitAndPackOrders(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static WaitAndPackOrders __createEmpty(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitAndPackOrders(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event1.run();
    __event2.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event1.__eventFired && !__event2.__eventFired) __awaitForEvents();
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

  public void ifPackageFinished(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement at line 29
    	 * packed = false
    	 */
    	
    	java.lang.Boolean packed = false;
    	
    	/* 
    	 * Compiled from source statement from line 31 to line 41
    	 * if length of packageList ≠ 0 do
    	 *             for packageToPack in packageList do
    	 *                 for order in ordersInPackage of packageToPack do
    	 *                     if quantity of order ≠ 0 do
    	 *                         packed = false
    	 *                         break
    	 *                     else do
    	 *                         packed = true
    	 *                 if packed do
    	 *                     status of packageToPack = "finished"
    	 *                     add packageToPack to finishedPackages
    	 */
    	
    	if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getPackageList().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 32 to line 41
    		 * for packageToPack in packageList do
    		 *                 for order in ordersInPackage of packageToPack do
    		 *                     if quantity of order ≠ 0 do
    		 *                         packed = false
    		 *                         break
    		 *                     else do
    		 *                         packed = true
    		 *                 if packed do
    		 *                     status of packageToPack = "finished"
    		 *                     add packageToPack to finishedPackages
    		 */
    		
    		for ( PackageOfGoods packageToPack : WaitAndPackOrders.this._agentEnv.getAgent().getPackageList()) {
    			/* 
    			 * Compiled from source statement from line 33 to line 38
    			 * for order in ordersInPackage of packageToPack do
    			 *                     if quantity of order ≠ 0 do
    			 *                         packed = false
    			 *                         break
    			 *                     else do
    			 *                         packed = true
    			 */
    			
    			for ( OrderQuantity order : packageToPack.getOrdersInPackage()) {
    				/* 
    				 * Compiled from source statement from line 34 to line 38
    				 * if quantity of order ≠ 0 do
    				 *                         packed = false
    				 *                         break
    				 *                     else do
    				 *                         packed = true
    				 */
    				
    				if(!java.util.Objects.equals(order.getQuantity(), 0)) {
    					/* 
    					 * Compiled from source statement at line 35
    					 * packed = false
    					 */
    					
    					packed = false;
    					
    					/* 
    					 * Compiled from source statement at line 36
    					 * break
    					 */
    					
    					break;
    				}
    				else {
    					/* 
    					 * Compiled from source statement at line 38
    					 * packed = true
    					 */
    					
    					packed = true;
    				}
    			}
    			
    			/* 
    			 * Compiled from source statement from line 39 to line 41
    			 * 
    			 *                 if packed do
    			 *                     status of packageToPack = "finished"
    			 *                     add packageToPack to finishedPackages
    			 */
    			
    			if(packed) {
    				/* 
    				 * Compiled from source statement at line 40
    				 * status of packageToPack = "finished"
    				 */
    				
    				packageToPack.setStatus("finished");
    				
    				/* 
    				 * Compiled from source statement at line 41
    				 * add packageToPack to finishedPackages
    				 */
    				
    				WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages().add(packageToPack);
    			}
    		}
    	}
    }
  }

  private class __Event1 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 44 to line 45
      	 * if length of packageList = 0 do
      	 *             deactivate this
      	 */
      	
      	if(java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getPackageList().size(), 0)) {
      		/* 
      		 * Compiled from source statement at line 45
      		 * deactivate this
      		 */
      		
      		WaitAndPackOrders.this.deactivate();
      	}
      	
      	/* 
      	 * Compiled from source statement from line 49 to line 71
      	 * 
      	 *             
      	 *         #jeżeli lista z paczkami się powiększyła to czek zamówienia i dodawaj do zamówień
      	 *         # bo co jeżeli dwóch bakerów da w tym samym czasie..
      	 *         if length of ordersReadyToPack ≠ 0 do
      	 *             for packageToPack in packageList do
      	 *                 for order in ordersInPackage of packageToPack do
      	 *                     for readyToPack in ordersReadyToPack do
      	 *                         if good of readyToPack = good of order do
      	 *                             quantity of order = quantity of order - 1
      	 *                             remove readyToPack from ordersReadyToPack
      	 *                             status of packageToPack = "preparing"
      	 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      	 *                             break
      	 *                     if length of ordersReadyToPack = 0 do
      	 *                         break
      	 *                 if length of ordersReadyToPack = 0 do
      	 *                         break
      	 *             
      	 *             do ifPackageFinished
      	 *             
      	 *             if length of finishedPackages ≠ 0 do
      	 *                 for pcg in finishedPackages do
      	 *                     log "PACKER send FINISHED package: "+ packageId of pcg
      	 *                     send message inform PackageStatus(pcg) to supervisorName@
      	 *                     remove pcg from packageList
      	 *                 finishedPackages = [] of PackageOfGoods
      	 */
      	
      	if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      		/* 
      		 * Compiled from source statement from line 50 to line 62
      		 * for packageToPack in packageList do
      		 *                 for order in ordersInPackage of packageToPack do
      		 *                     for readyToPack in ordersReadyToPack do
      		 *                         if good of readyToPack = good of order do
      		 *                             quantity of order = quantity of order - 1
      		 *                             remove readyToPack from ordersReadyToPack
      		 *                             status of packageToPack = "preparing"
      		 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      		 *                             break
      		 *                     if length of ordersReadyToPack = 0 do
      		 *                         break
      		 *                 if length of ordersReadyToPack = 0 do
      		 *                         break
      		 */
      		
      		for ( PackageOfGoods packageToPack : WaitAndPackOrders.this._agentEnv.getAgent().getPackageList()) {
      			/* 
      			 * Compiled from source statement from line 51 to line 60
      			 * for order in ordersInPackage of packageToPack do
      			 *                     for readyToPack in ordersReadyToPack do
      			 *                         if good of readyToPack = good of order do
      			 *                             quantity of order = quantity of order - 1
      			 *                             remove readyToPack from ordersReadyToPack
      			 *                             status of packageToPack = "preparing"
      			 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      			 *                             break
      			 *                     if length of ordersReadyToPack = 0 do
      			 *                         break
      			 */
      			
      			for ( OrderQuantity order : packageToPack.getOrdersInPackage()) {
      				/* 
      				 * Compiled from source statement from line 52 to line 58
      				 * for readyToPack in ordersReadyToPack do
      				 *                         if good of readyToPack = good of order do
      				 *                             quantity of order = quantity of order - 1
      				 *                             remove readyToPack from ordersReadyToPack
      				 *                             status of packageToPack = "preparing"
      				 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      				 *                             break
      				 */
      				
      				for ( Order readyToPack : WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack()) {
      					/* 
      					 * Compiled from source statement from line 53 to line 58
      					 * if good of readyToPack = good of order do
      					 *                             quantity of order = quantity of order - 1
      					 *                             remove readyToPack from ordersReadyToPack
      					 *                             status of packageToPack = "preparing"
      					 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      					 *                             break
      					 */
      					
      					if(java.util.Objects.equals(readyToPack.getGood(), order.getGood())) {
      						/* 
      						 * Compiled from source statement at line 54
      						 * quantity of order = quantity of order - 1
      						 */
      						
      						order.setQuantity(order.getQuantity() - 1);
      						
      						/* 
      						 * Compiled from source statement at line 55
      						 * remove readyToPack from ordersReadyToPack
      						 */
      						
      						WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().remove(readyToPack);
      						
      						/* 
      						 * Compiled from source statement at line 56
      						 * status of packageToPack = "preparing"
      						 */
      						
      						packageToPack.setStatus("preparing");
      						
      						/* 
      						 * Compiled from source statement at line 57
      						 * log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("PACKER packed order: ") + java.lang.String.valueOf(order)) + java.lang.String.valueOf(" to package: ")) + java.lang.String.valueOf(packageToPack.getPackageId())));
      						
      						/* 
      						 * Compiled from source statement at line 58
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement from line 59 to line 60
      				 * 
      				 *                     if length of ordersReadyToPack = 0 do
      				 *                         break
      				 */
      				
      				if(java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      					/* 
      					 * Compiled from source statement at line 60
      					 * break
      					 */
      					
      					break;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 61 to line 62
      			 * 
      			 *                 if length of ordersReadyToPack = 0 do
      			 *                         break
      			 */
      			
      			if(java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      				/* 
      				 * Compiled from source statement at line 62
      				 * break
      				 */
      				
      				break;
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 64
      		 * 
      		 *             
      		 *             do ifPackageFinished
      		 */
      		
      		WaitAndPackOrders.this.ifPackageFinished(_agentEnv.getAgent().toEnv());
      		
      		/* 
      		 * Compiled from source statement from line 66 to line 71
      		 * if length of finishedPackages ≠ 0 do
      		 *                 for pcg in finishedPackages do
      		 *                     log "PACKER send FINISHED package: "+ packageId of pcg
      		 *                     send message inform PackageStatus(pcg) to supervisorName@
      		 *                     remove pcg from packageList
      		 *                 finishedPackages = [] of PackageOfGoods
      		 */
      		
      		if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages().size(), 0)) {
      			/* 
      			 * Compiled from source statement from line 67 to line 70
      			 * for pcg in finishedPackages do
      			 *                     log "PACKER send FINISHED package: "+ packageId of pcg
      			 *                     send message inform PackageStatus(pcg) to supervisorName@
      			 *                     remove pcg from packageList
      			 */
      			
      			for ( PackageOfGoods pcg : WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages()) {
      				/* 
      				 * Compiled from source statement at line 68
      				 * log "PACKER send FINISHED package: "+ packageId of pcg
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf("PACKER send FINISHED package: ") + java.lang.String.valueOf(pcg.getPackageId())));
      				
      				/* 
      				 * Compiled from source statement at line 69
      				 * send message inform PackageStatus(pcg) to supervisorName@
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1853049133 = BakeryOntology.PackageStatus(pcg);
      					
      					jadescript.core.message.Message _synthesizedMessage1853049133 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1853049133.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1853049133,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1853049133.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1853049133.addReceiver(new jade.core.AID(java.lang.String.valueOf(WaitAndPackOrders.this._agentEnv.getAgent().getSupervisorName()), false));
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1853049133, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1853049133, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1853049133);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 70
      				 * remove pcg from packageList
      				 */
      				
      				WaitAndPackOrders.this._agentEnv.getAgent().getPackageList().remove(pcg);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 71
      			 * 
      			 *                 finishedPackages = [] of PackageOfGoods
      			 */
      			
      			WaitAndPackOrders.this._agentEnv.getAgent().setFinishedPackages(new jadescript.util.JadescriptList<PackageOfGoods>());
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

  private WaitAndPackOrders.__Event1 __event1 =  new WaitAndPackOrders.__Event1();

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitAndPackOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher911372325 {
      	public Order order;
      	
      	private final __PatternMatcher911372325 __PatternMatcher911372325_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
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
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		GoodToPack __x;
      		
      		try {
      			if(__objx instanceof GoodToPack) {
      				__x = (GoodToPack) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getOrder());
      	}
      }
      __PatternMatcher911372325 __PatternMatcher911372325_obj = new __PatternMatcher911372325();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher911372325_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	WaitAndPackOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 75
      			 * log "PACKER got an order to pack"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on request", java.lang.String.valueOf("PACKER got an order to pack"));
      			
      			/* 
      			 * Compiled from source statement at line 76
      			 * add order to ordersReadyToPack
      			 */
      			
      			WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().add(__PatternMatcher911372325_obj.order);
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

  private WaitAndPackOrders.__Event2 __event2 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitAndPackOrders.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event2 = new WaitAndPackOrders.__Event2();
    }
  }
}
