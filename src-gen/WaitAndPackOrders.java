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

  public void ifPackageFinished(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement at line 31
    	 * packed = false
    	 */
    	
    	java.lang.Boolean packed = false;
    	
    	/* 
    	 * Compiled from source statement from line 33 to line 49
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
    	 *                     
    	 *                     for pcg in timeForPackage do
    	 *                         if packageId of pcg = packageId of packageToPack do
    	 *                             #log "start time: "+ prepTime of pcg+ " finish time: "+now as duration+" diff: "+ (now - prepTime of pcg) as duration
    	 *                             prepTime of pcg = (now - prepTime of pcg) as duration
    	 *                             break
    	 */
    	
    	if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getPackageList().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 34 to line 49
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
    		 *                     
    		 *                     for pcg in timeForPackage do
    		 *                         if packageId of pcg = packageId of packageToPack do
    		 *                             #log "start time: "+ prepTime of pcg+ " finish time: "+now as duration+" diff: "+ (now - prepTime of pcg) as duration
    		 *                             prepTime of pcg = (now - prepTime of pcg) as duration
    		 *                             break
    		 */
    		
    		for ( PackageOfGoods packageToPack : WaitAndPackOrders.this._agentEnv.getAgent().getPackageList()) {
    			/* 
    			 * Compiled from source statement from line 35 to line 40
    			 * for order in ordersInPackage of packageToPack do
    			 *                     if quantity of order ≠ 0 do
    			 *                         packed = false
    			 *                         break
    			 *                     else do
    			 *                         packed = true
    			 */
    			
    			for ( OrderQuantity order : packageToPack.getOrdersInPackage()) {
    				/* 
    				 * Compiled from source statement from line 36 to line 40
    				 * if quantity of order ≠ 0 do
    				 *                         packed = false
    				 *                         break
    				 *                     else do
    				 *                         packed = true
    				 */
    				
    				if(!java.util.Objects.equals(order.getQuantity(), 0)) {
    					/* 
    					 * Compiled from source statement at line 37
    					 * packed = false
    					 */
    					
    					packed = false;
    					
    					/* 
    					 * Compiled from source statement at line 38
    					 * break
    					 */
    					
    					break;
    				}
    				else {
    					/* 
    					 * Compiled from source statement at line 40
    					 * packed = true
    					 */
    					
    					packed = true;
    				}
    			}
    			
    			/* 
    			 * Compiled from source statement from line 41 to line 49
    			 * 
    			 *                 if packed do
    			 *                     status of packageToPack = "finished"
    			 *                     add packageToPack to finishedPackages
    			 *                     
    			 *                     for pcg in timeForPackage do
    			 *                         if packageId of pcg = packageId of packageToPack do
    			 *                             #log "start time: "+ prepTime of pcg+ " finish time: "+now as duration+" diff: "+ (now - prepTime of pcg) as duration
    			 *                             prepTime of pcg = (now - prepTime of pcg) as duration
    			 *                             break
    			 */
    			
    			if(packed) {
    				/* 
    				 * Compiled from source statement at line 42
    				 * status of packageToPack = "finished"
    				 */
    				
    				packageToPack.setStatus("finished");
    				
    				/* 
    				 * Compiled from source statement at line 43
    				 * add packageToPack to finishedPackages
    				 */
    				
    				WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages().add(packageToPack);
    				
    				/* 
    				 * Compiled from source statement from line 45 to line 49
    				 * for pcg in timeForPackage do
    				 *                         if packageId of pcg = packageId of packageToPack do
    				 *                             #log "start time: "+ prepTime of pcg+ " finish time: "+now as duration+" diff: "+ (now - prepTime of pcg) as duration
    				 *                             prepTime of pcg = (now - prepTime of pcg) as duration
    				 *                             break
    				 */
    				
    				for ( PackagePreparation pcg : WaitAndPackOrders.this._agentEnv.getAgent().getTimeForPackage()) {
    					/* 
    					 * Compiled from source statement from line 46 to line 49
    					 * if packageId of pcg = packageId of packageToPack do
    					 *                             #log "start time: "+ prepTime of pcg+ " finish time: "+now as duration+" diff: "+ (now - prepTime of pcg) as duration
    					 *                             prepTime of pcg = (now - prepTime of pcg) as duration
    					 *                             break
    					 */
    					
    					if(java.util.Objects.equals(pcg.getPackageId(), packageToPack.getPackageId())) {
    						/* 
    						 * Compiled from source statement at line 48
    						 * prepTime of pcg = (now - prepTime of pcg) as duration
    						 */
    						
    						pcg.setPrepTime(((jadescript.lang.Duration) jadescript.util.types.Converter.convert((jadescript.lang.Timestamp.minus(jadescript.lang.Timestamp.now(), pcg.getPrepTime())), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TIMESTAMP), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
    						
    						/* 
    						 * Compiled from source statement at line 49
    						 * break
    						 */
    						
    						break;
    					}
    				}
    			}
    		}
    	}
    }
  }

  public Boolean pckAlreadyPending(final AgentEnv<? extends Packer, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final String pcgId) {
    {
    	/* 
    	 * Compiled from source statement from line 53 to line 59
    	 * if length of timeForPackage ≠ 0 do
    	 *             for pcg in timeForPackage do
    	 *                 if packageId of pcg = pcgId do
    	 *                     return true
    	 *             return false
    	 *         else do
    	 *             return false
    	 */
    	
    	if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getTimeForPackage().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 54 to line 56
    		 * for pcg in timeForPackage do
    		 *                 if packageId of pcg = pcgId do
    		 *                     return true
    		 */
    		
    		for ( PackagePreparation pcg : WaitAndPackOrders.this._agentEnv.getAgent().getTimeForPackage()) {
    			/* 
    			 * Compiled from source statement from line 55 to line 56
    			 * if packageId of pcg = pcgId do
    			 *                     return true
    			 */
    			
    			if(java.util.Objects.equals(pcg.getPackageId(), pcgId)) {
    				/* 
    				 * Compiled from source statement at line 56
    				 * return true
    				 */
    				
    				return true;
    			}
    		}
    		
    		/* 
    		 * Compiled from source statement at line 57
    		 * 
    		 *             return false
    		 */
    		
    		return false;
    	}
    	else {
    		/* 
    		 * Compiled from source statement at line 59
    		 * return false
    		 */
    		
    		return false;
    	}
    }
  }

  private class __Event2 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 63 to line 90
      	 * if length of ordersReadyToPack ≠ 0 do
      	 *             for packageToPack in packageList do
      	 *                 for order in ordersInPackage of packageToPack do
      	 *                     for readyToPack in ordersReadyToPack do
      	 *                         if good of readyToPack = good of order do
      	 *                             
      	 *                             if not pckAlreadyPending(packageId of packageToPack) do
      	 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      	 *                             
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
      	 *                 
      	 *                 finishedPackages = [] of PackageOfGoods
      	 */
      	
      	if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      		/* 
      		 * Compiled from source statement from line 64 to line 80
      		 * for packageToPack in packageList do
      		 *                 for order in ordersInPackage of packageToPack do
      		 *                     for readyToPack in ordersReadyToPack do
      		 *                         if good of readyToPack = good of order do
      		 *                             
      		 *                             if not pckAlreadyPending(packageId of packageToPack) do
      		 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      		 *                             
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
      			 * Compiled from source statement from line 65 to line 78
      			 * for order in ordersInPackage of packageToPack do
      			 *                     for readyToPack in ordersReadyToPack do
      			 *                         if good of readyToPack = good of order do
      			 *                             
      			 *                             if not pckAlreadyPending(packageId of packageToPack) do
      			 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      			 *                             
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
      				 * Compiled from source statement from line 66 to line 76
      				 * for readyToPack in ordersReadyToPack do
      				 *                         if good of readyToPack = good of order do
      				 *                             
      				 *                             if not pckAlreadyPending(packageId of packageToPack) do
      				 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      				 *                             
      				 *                             quantity of order = quantity of order - 1
      				 *                             remove readyToPack from ordersReadyToPack
      				 *                             status of packageToPack = "preparing"
      				 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      				 *                             break
      				 */
      				
      				for ( Order readyToPack : WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack()) {
      					/* 
      					 * Compiled from source statement from line 67 to line 76
      					 * if good of readyToPack = good of order do
      					 *                             
      					 *                             if not pckAlreadyPending(packageId of packageToPack) do
      					 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      					 *                             
      					 *                             quantity of order = quantity of order - 1
      					 *                             remove readyToPack from ordersReadyToPack
      					 *                             status of packageToPack = "preparing"
      					 *                             log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      					 *                             break
      					 */
      					
      					if(java.util.Objects.equals(readyToPack.getGood(), order.getGood())) {
      						/* 
      						 * Compiled from source statement from line 69 to line 70
      						 * if not pckAlreadyPending(packageId of packageToPack) do
      						 *                                 add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      						 */
      						
      						if( ! WaitAndPackOrders.this.pckAlreadyPending(_agentEnv.getAgent().toEnv() ,packageToPack.getPackageId())) {
      							/* 
      							 * Compiled from source statement at line 70
      							 * add PackagePreparation(packageId of packageToPack,now as duration) to timeForPackage
      							 */
      							
      							WaitAndPackOrders.this._agentEnv.getAgent().getTimeForPackage().add(BakeryOntology.PackagePreparation(packageToPack.getPackageId() ,((jadescript.lang.Duration) jadescript.util.types.Converter.convert(jadescript.lang.Timestamp.now(), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TIMESTAMP), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION)))));
      						}
      						
      						/* 
      						 * Compiled from source statement at line 72
      						 * 
      						 *                             
      						 *                             quantity of order = quantity of order - 1
      						 */
      						
      						order.setQuantity(order.getQuantity() - 1);
      						
      						/* 
      						 * Compiled from source statement at line 73
      						 * remove readyToPack from ordersReadyToPack
      						 */
      						
      						WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().remove(readyToPack);
      						
      						/* 
      						 * Compiled from source statement at line 74
      						 * status of packageToPack = "preparing"
      						 */
      						
      						packageToPack.setStatus("preparing");
      						
      						/* 
      						 * Compiled from source statement at line 75
      						 * log "PACKER packed order: "+order+" to package: "+packageId of packageToPack
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("PACKER packed order: ") + java.lang.String.valueOf(order)) + java.lang.String.valueOf(" to package: ")) + java.lang.String.valueOf(packageToPack.getPackageId())));
      						
      						/* 
      						 * Compiled from source statement at line 76
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement from line 77 to line 78
      				 * 
      				 *                     if length of ordersReadyToPack = 0 do
      				 *                         break
      				 */
      				
      				if(java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      					/* 
      					 * Compiled from source statement at line 78
      					 * break
      					 */
      					
      					break;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 79 to line 80
      			 * 
      			 *                 if length of ordersReadyToPack = 0 do
      			 *                         break
      			 */
      			
      			if(java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().size(), 0)) {
      				/* 
      				 * Compiled from source statement at line 80
      				 * break
      				 */
      				
      				break;
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 82
      		 * 
      		 *             
      		 *             do ifPackageFinished
      		 */
      		
      		WaitAndPackOrders.this.ifPackageFinished(_agentEnv.getAgent().toEnv());
      		
      		/* 
      		 * Compiled from source statement from line 84 to line 90
      		 * if length of finishedPackages ≠ 0 do
      		 *                 for pcg in finishedPackages do
      		 *                     log "PACKER send FINISHED package: "+ packageId of pcg
      		 *                     send message inform PackageStatus(pcg) to supervisorName@
      		 *                     remove pcg from packageList
      		 *                 
      		 *                 finishedPackages = [] of PackageOfGoods
      		 */
      		
      		if(!java.util.Objects.equals(WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages().size(), 0)) {
      			/* 
      			 * Compiled from source statement from line 85 to line 88
      			 * for pcg in finishedPackages do
      			 *                     log "PACKER send FINISHED package: "+ packageId of pcg
      			 *                     send message inform PackageStatus(pcg) to supervisorName@
      			 *                     remove pcg from packageList
      			 */
      			
      			for ( PackageOfGoods pcg : WaitAndPackOrders.this._agentEnv.getAgent().getFinishedPackages()) {
      				/* 
      				 * Compiled from source statement at line 86
      				 * log "PACKER send FINISHED package: "+ packageId of pcg
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf("PACKER send FINISHED package: ") + java.lang.String.valueOf(pcg.getPackageId())));
      				
      				/* 
      				 * Compiled from source statement at line 87
      				 * send message inform PackageStatus(pcg) to supervisorName@
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1440795249 = BakeryOntology.PackageStatus(pcg);
      					
      					jadescript.core.message.Message _synthesizedMessage1440795249 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1440795249.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1440795249,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1440795249.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1440795249.addReceiver(new jade.core.AID(java.lang.String.valueOf(WaitAndPackOrders.this._agentEnv.getAgent().getSupervisorName()), false));
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1440795249, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1440795249, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1440795249);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 88
      				 * remove pcg from packageList
      				 */
      				
      				WaitAndPackOrders.this._agentEnv.getAgent().getPackageList().remove(pcg);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 90
      			 * 
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

  private WaitAndPackOrders.__Event2 __event2 =  new WaitAndPackOrders.__Event2();

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitAndPackOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1446479028 {
      	public Order order;
      	
      	private final __PatternMatcher1446479028 __PatternMatcher1446479028_obj =  this;
      	
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
      __PatternMatcher1446479028 __PatternMatcher1446479028_obj = new __PatternMatcher1446479028();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1446479028_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 93
      			 * log "PACKER got an order to pack"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitAndPackOrders.this.getClass().getName(), WaitAndPackOrders.this, "on request", java.lang.String.valueOf("PACKER got an order to pack"));
      			
      			/* 
      			 * Compiled from source statement at line 94
      			 * add order to ordersReadyToPack
      			 */
      			
      			WaitAndPackOrders.this._agentEnv.getAgent().getOrdersReadyToPack().add(__PatternMatcher1446479028_obj.order);
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

  private WaitAndPackOrders.__Event3 __event3 = null;

  private class __Event4 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitAndPackOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher502009776 {
      	private final __PatternMatcher502009776 __PatternMatcher502009776_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		AllPackagesReady __x;
      		
      		try {
      			if(__objx instanceof AllPackagesReady) {
      				__x = (AllPackagesReady) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.AllPackagesReady());
      	}
      }
      __PatternMatcher502009776 __PatternMatcher502009776_obj = new __PatternMatcher502009776();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher502009776_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 97
      			 * activate WaitEndDay
      			 */
      			
      			new WaitEndDay(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 98
      			 * destroy this
      			 */
      			
      			WaitAndPackOrders.this.destroy();
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

  private WaitAndPackOrders.__Event4 __event4 = null;

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
    	__event3 = new WaitAndPackOrders.__Event3();
    	
    	__event4 = new WaitAndPackOrders.__Event4();
    }
  }
}
