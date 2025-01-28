import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class HandleIngredientsShortage extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static HandleIngredientsShortage __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new HandleIngredientsShortage(_agentEnv, new jadescript.util.JadescriptList<IngredientQuantity>(), new Order());
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event5.run();
    __event6.run();
    __event7.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event5.__eventFired && !__event6.__eventFired && !__event7.__eventFired) __awaitForEvents();
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

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  protected JadescriptList<IngredientAvaliable> responds = null;

  public void setResponds(final JadescriptList<IngredientAvaliable> responds) {
    this.responds = responds;
  }

  public JadescriptList<IngredientAvaliable> getResponds() {
    return this.responds;
  }

  protected Boolean noHelpFromCo = null;

  public void setNoHelpFromCo(final Boolean noHelpFromCo) {
    this.noHelpFromCo = noHelpFromCo;
  }

  public Boolean getNoHelpFromCo() {
    return this.noHelpFromCo;
  }

  public void LookOrderUp(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 245 to line 248
    	 * for i in fullOrderList do
    	 *             if status of i ≠ "baking" and status of i ≠ "finished" do
    	 *                 order = i
    	 *                 break
    	 */
    	
    	for ( Order i : HandleIngredientsShortage.this._agentEnv.getAgent().getFullOrderList()) {
    		/* 
    		 * Compiled from source statement from line 246 to line 248
    		 * if status of i ≠ "baking" and status of i ≠ "finished" do
    		 *                 order = i
    		 *                 break
    		 */
    		
    		if(!java.util.Objects.equals(i.getStatus(), "baking") && !java.util.Objects.equals(i.getStatus(), "finished")) {
    			/* 
    			 * Compiled from source statement at line 247
    			 * order = i
    			 */
    			
    			HandleIngredientsShortage.this.setOrder(i);
    			
    			/* 
    			 * Compiled from source statement at line 248
    			 * break
    			 */
    			
    			break;
    		}
    	}
    }
  }

  public HandleIngredientsShortage(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final JadescriptList<IngredientQuantity> listIngredientsNeeded, final Order order) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 254
    	 * noHelpFromCo = true
    	 */
    	
    	HandleIngredientsShortage.this.setNoHelpFromCo(true);
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
      if(HandleIngredientsShortage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1878558256 {
      	public jade.core.AID id;
      	
      	public java.lang.Boolean avaliable;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> ingredients;
      	
      	private final __PatternMatcher1878558256 __PatternMatcher1878558256_obj =  this;
      	
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
      		java.lang.Boolean __x;
      		
      		try {
      			if(__objx instanceof java.lang.Boolean) {
      				__x = (java.lang.Boolean) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		avaliable = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm2(java.lang.Object __objx) {
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
      		
      		ingredients = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		IngredientAvaliable __x;
      		
      		try {
      			if(__objx instanceof IngredientAvaliable) {
      				__x = (IngredientAvaliable) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getId()) && headerMatch_structterm1(__x.getAvaliable()) && headerMatch_structterm2(__x.getIngredients());
      	}
      }
      __PatternMatcher1878558256 __PatternMatcher1878558256_obj = new __PatternMatcher1878558256();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1878558256_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	HandleIngredientsShortage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 257
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<IngredientAvaliable>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 258
      			 * respond = IngredientAvaliable(id,avaliable,ingredients)
      			 */
      			
      			IngredientAvaliable respond = BakeryOntology.IngredientAvaliable(__PatternMatcher1878558256_obj.id ,__PatternMatcher1878558256_obj.avaliable ,__PatternMatcher1878558256_obj.ingredients);
      			
      			/* 
      			 * Compiled from source statement from line 259 to line 262
      			 * if avaliable do
      			 *             log "Agent: "+ name of senderAgent + "has avaliable ingredients for :"+name of agent
      			 *         else do
      			 *             log "Agent: "+ name of senderAgent + "does NOT have avaliable ingredients for :"+name of agent
      			 */
      			
      			if(__PatternMatcher1878558256_obj.avaliable) {
      				/* 
      				 * Compiled from source statement at line 260
      				 * log "Agent: "+ name of senderAgent + "has avaliable ingredients for :"+name of agent
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf("has avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())));
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 262
      				 * log "Agent: "+ name of senderAgent + "does NOT have avaliable ingredients for :"+name of agent
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf("does NOT have avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())));
      			}
      			
      			/* 
      			 * Compiled from source statement at line 264
      			 * 
      			 *         
      			 *         add respond to responds
      			 */
      			
      			HandleIngredientsShortage.this.getResponds().add(respond);
      			
      			/* 
      			 * Compiled from source statement from line 265 to line 279
      			 * if length of responds = length of listOfCoworkers do
      			 *             for i in responds do
      			 * 		        if avaliable of i do
      			 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent +" asked list: "+ingredients
      			 * 		            send message request RequestIngredientsColleague(aid, ingredients) to id of i
      			 * 		            noHelpFromCo = false
      			 * 		            break
      			 * 		
      			 * 	        if noHelpFromCo do
      			 * 	            log "NOBODY can help baker: "+name of agent+" call for supplier"
      			 * 	            for supplier in listOfSuppliers do
      			 * 		           #send message request RequestIngredients(aid,listIngredientsNeeded) to supplier@ #idk czy potrzebne delay
      			 * 		            do LookOrderUp
      			 * 		            activate DelayedRestockQuestion(supplier,order,true) after "PT2S" as duration
      			 * 		    responds = [] of IngredientAvaliable
      			 */
      			
      			if(java.util.Objects.equals(HandleIngredientsShortage.this.getResponds().size(), HandleIngredientsShortage.this._agentEnv.getAgent().getListOfCoworkers().size())) {
      				/* 
      				 * Compiled from source statement from line 266 to line 271
      				 * for i in responds do
      				 * 		        if avaliable of i do
      				 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent +" asked list: "+ingredients
      				 * 		            send message request RequestIngredientsColleague(aid, ingredients) to id of i
      				 * 		            noHelpFromCo = false
      				 * 		            break
      				 */
      				
      				for ( IngredientAvaliable i : HandleIngredientsShortage.this.getResponds()) {
      					/* 
      					 * Compiled from source statement from line 267 to line 271
      					 * if avaliable of i do
      					 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent +" asked list: "+ingredients
      					 * 		            send message request RequestIngredientsColleague(aid, ingredients) to id of i
      					 * 		            noHelpFromCo = false
      					 * 		            break
      					 */
      					
      					if(i.getAvaliable()) {
      						/* 
      						 * Compiled from source statement at line 268
      						 * log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent +" asked list: "+ingredients
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Asking agent: ") + java.lang.String.valueOf(i.getId().getName())) + java.lang.String.valueOf("for his avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" asked list: ")) + java.lang.String.valueOf(__PatternMatcher1878558256_obj.ingredients)));
      						
      						/* 
      						 * Compiled from source statement at line 269
      						 * send message request RequestIngredientsColleague(aid, ingredients) to id of i
      						 */
      						
      						try {
      							jadescript.util.SendMessageUtils.validatePerformative("request");
      							
      							java.lang.Object _contentToBeSent1473755253 = BakeryOntology.RequestIngredientsColleague(HandleIngredientsShortage.this._agentEnv.getAgent().getAID() ,__PatternMatcher1878558256_obj.ingredients);
      							
      							jadescript.core.message.Message _synthesizedMessage1473755253 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      							
      							_synthesizedMessage1473755253.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1473755253,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      							
      							_synthesizedMessage1473755253.setLanguage(__codec.getName());;
      							
      							_synthesizedMessage1473755253.addReceiver(i.getId());
      							
      							_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1473755253, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1473755253, "request"));
      							
      							_agentEnv.getAgent().send(_synthesizedMessage1473755253);
      						}
      						catch(java.lang.Throwable _t) {
      							throw jadescript.core.exception.JadescriptException.wrap(_t);
      						}
      						
      						/* 
      						 * Compiled from source statement at line 270
      						 * noHelpFromCo = false
      						 */
      						
      						HandleIngredientsShortage.this.setNoHelpFromCo(false);
      						
      						/* 
      						 * Compiled from source statement at line 271
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement from line 273 to line 278
      				 * 
      				 * 		
      				 * 	        if noHelpFromCo do
      				 * 	            log "NOBODY can help baker: "+name of agent+" call for supplier"
      				 * 	            for supplier in listOfSuppliers do
      				 * 		           #send message request RequestIngredients(aid,listIngredientsNeeded) to supplier@ #idk czy potrzebne delay
      				 * 		            do LookOrderUp
      				 * 		            activate DelayedRestockQuestion(supplier,order,true) after "PT2S" as duration
      				 */
      				
      				if(HandleIngredientsShortage.this.getNoHelpFromCo()) {
      					/* 
      					 * Compiled from source statement at line 274
      					 * log "NOBODY can help baker: "+name of agent+" call for supplier"
      					 */
      					
      					jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("NOBODY can help baker: ") + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" call for supplier")));
      					
      					/* 
      					 * Compiled from source statement from line 275 to line 278
      					 * for supplier in listOfSuppliers do
      					 * 		           #send message request RequestIngredients(aid,listIngredientsNeeded) to supplier@ #idk czy potrzebne delay
      					 * 		            do LookOrderUp
      					 * 		            activate DelayedRestockQuestion(supplier,order,true) after "PT2S" as duration
      					 */
      					
      					for ( java.lang.String supplier : HandleIngredientsShortage.this._agentEnv.getAgent().getListOfSuppliers()) {
      						/* 
      						 * Compiled from source statement at line 277
      						 * do LookOrderUp
      						 */
      						
      						HandleIngredientsShortage.this.LookOrderUp(_agentEnv.getAgent().toEnv());
      						
      						/* 
      						 * Compiled from source statement at line 278
      						 * activate DelayedRestockQuestion(supplier,order,true) after "PT2S" as duration
      						 */
      						
      						new DelayedRestockQuestion(_agentEnv.getAgent().toEnv() ,supplier ,HandleIngredientsShortage.this.getOrder() ,true).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT2S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement at line 279
      				 * 
      				 * 		    responds = [] of IngredientAvaliable
      				 */
      				
      				HandleIngredientsShortage.this.setResponds(new jadescript.util.JadescriptList<IngredientAvaliable>());
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

  private HandleIngredientsShortage.__Event5 __event5 = null;

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(HandleIngredientsShortage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher296931311 {
      	public java.lang.Boolean bakerWhileProparing;
      	
      	private final __PatternMatcher296931311 __PatternMatcher296931311_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		java.lang.Boolean __x;
      		
      		try {
      			if(__objx instanceof java.lang.Boolean) {
      				__x = (java.lang.Boolean) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		bakerWhileProparing = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		SupplierRunOutSupply __x;
      		
      		try {
      			if(__objx instanceof SupplierRunOutSupply) {
      				__x = (SupplierRunOutSupply) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getBakerWhileProparing());
      	}
      }
      __PatternMatcher296931311 __PatternMatcher296931311_obj = new __PatternMatcher296931311();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher296931311_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	HandleIngredientsShortage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement from line 286 to line 289
      			 * if bakerWhileProparing do
      			 *             do LookOrderUp
      			 *             log "Good turn to check for preparing: "+order
      			 *             activate PrepareOrder(order)
      			 */
      			
      			if(__PatternMatcher296931311_obj.bakerWhileProparing) {
      				/* 
      				 * Compiled from source statement at line 287
      				 * do LookOrderUp
      				 */
      				
      				HandleIngredientsShortage.this.LookOrderUp(_agentEnv.getAgent().toEnv());
      				
      				/* 
      				 * Compiled from source statement at line 288
      				 * log "Good turn to check for preparing: "+order
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Good turn to check for preparing: ") + java.lang.String.valueOf(HandleIngredientsShortage.this.getOrder())));
      				
      				/* 
      				 * Compiled from source statement at line 289
      				 * activate PrepareOrder(order)
      				 */
      				
      				new PrepareOrder(_agentEnv.getAgent().toEnv() ,HandleIngredientsShortage.this.getOrder()).activate(_agentEnv.getAgent());
      			}
      			
      			/* 
      			 * Compiled from source statement at line 290
      			 * 
      			 *         deactivate this
      			 */
      			
      			HandleIngredientsShortage.this.deactivate();
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

  private HandleIngredientsShortage.__Event6 __event6 = null;

  private class __Event7 {
    Boolean __eventFired = false;

    public void run() {
      if(HandleIngredientsShortage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1329852047 {
      	public jadescript.util.JadescriptList<IngredientQuantity> handedIngredients;
      	
      	public java.lang.Boolean whileProparing;
      	
      	private final __PatternMatcher1329852047 __PatternMatcher1329852047_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
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
      		
      		handedIngredients = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		java.lang.Boolean __x;
      		
      		try {
      			if(__objx instanceof java.lang.Boolean) {
      				__x = (java.lang.Boolean) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		whileProparing = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		ProvideIngredients __x;
      		
      		try {
      			if(__objx instanceof ProvideIngredients) {
      				__x = (ProvideIngredients) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getIngredients()) && headerMatch_structterm1(__x.getWhileProparing());
      	}
      }
      __PatternMatcher1329852047 __PatternMatcher1329852047_obj = new __PatternMatcher1329852047();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1329852047_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	HandleIngredientsShortage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 293
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<ProvideIngredients>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 294
      			 * log "Just got ingredients from: "+senderAgent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Just got ingredients from: ") + java.lang.String.valueOf(senderAgent)));
      			
      			/* 
      			 * Compiled from source statement from line 296 to line 299
      			 * for ingredient in handedIngredients do
      			 *             for item in stock do
      			 *                 if ingredientName of ingredient = ingredientName of item do
      			 *                    quantity of item = quantity of item + quantity of ingredient
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher1329852047_obj.handedIngredients) {
      				/* 
      				 * Compiled from source statement from line 297 to line 299
      				 * for item in stock do
      				 *                 if ingredientName of ingredient = ingredientName of item do
      				 *                    quantity of item = quantity of item + quantity of ingredient
      				 */
      				
      				for ( IngredientQuantity item : HandleIngredientsShortage.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 298 to line 299
      					 * if ingredientName of ingredient = ingredientName of item do
      					 *                    quantity of item = quantity of item + quantity of ingredient
      					 */
      					
      					if(java.util.Objects.equals(ingredient.getIngredientName(), item.getIngredientName())) {
      						/* 
      						 * Compiled from source statement at line 299
      						 * quantity of item = quantity of item + quantity of ingredient
      						 */
      						
      						item.setQuantity(item.getQuantity() + ingredient.getQuantity());
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 301
      			 * 
      			 *         
      			 *         log "Fixed stock: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Fixed stock: ") + java.lang.String.valueOf(HandleIngredientsShortage.this._agentEnv.getAgent().getStock())));
      			
      			/* 
      			 * Compiled from source statement from line 302 to line 305
      			 * if whileProparing do
      			 *             do LookOrderUp
      			 *             log "Good turn to check for preparing: "+order
      			 *             activate PrepareOrder(order)
      			 */
      			
      			if(__PatternMatcher1329852047_obj.whileProparing) {
      				/* 
      				 * Compiled from source statement at line 303
      				 * do LookOrderUp
      				 */
      				
      				HandleIngredientsShortage.this.LookOrderUp(_agentEnv.getAgent().toEnv());
      				
      				/* 
      				 * Compiled from source statement at line 304
      				 * log "Good turn to check for preparing: "+order
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Good turn to check for preparing: ") + java.lang.String.valueOf(HandleIngredientsShortage.this.getOrder())));
      				
      				/* 
      				 * Compiled from source statement at line 305
      				 * activate PrepareOrder(order)
      				 */
      				
      				new PrepareOrder(_agentEnv.getAgent().toEnv() ,HandleIngredientsShortage.this.getOrder()).activate(_agentEnv.getAgent());
      			}
      			
      			/* 
      			 * Compiled from source statement at line 306
      			 * 
      			 *         deactivate this
      			 */
      			
      			HandleIngredientsShortage.this.deactivate();
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

  private HandleIngredientsShortage.__Event7 __event7 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(HandleIngredientsShortage.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	HandleIngredientsShortage.this.order = new Order();
    	
    	HandleIngredientsShortage.this.responds = new jadescript.util.JadescriptList<IngredientAvaliable>();
    	
    	HandleIngredientsShortage.this.noHelpFromCo = false;
    	
    	__event5 = new HandleIngredientsShortage.__Event5();
    	
    	__event6 = new HandleIngredientsShortage.__Event6();
    	
    	__event7 = new HandleIngredientsShortage.__Event7();
    }
  }
}
