import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class ListenCoworkers extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public ListenCoworkers(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static ListenCoworkers __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new ListenCoworkers(_agentEnv);
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

  protected Boolean avaliable = null;

  public void setAvaliable(final Boolean avaliable) {
    this.avaliable = avaliable;
  }

  public Boolean getAvaliable() {
    return this.avaliable;
  }

  protected JadescriptList<IngredientQuantity> providedIngredients = null;

  public void setProvidedIngredients(final JadescriptList<IngredientQuantity> providedIngredients) {
    this.providedIngredients = providedIngredients;
  }

  public JadescriptList<IngredientQuantity> getProvidedIngredients() {
    return this.providedIngredients;
  }

  public void clearProvidedIngredients(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 190 to line 192
    	 * if length of providedIngredients ≠ 0 do
    	 *             for i in providedIngredients do
    	 *                 remove i from providedIngredients
    	 */
    	
    	if(!java.util.Objects.equals(ListenCoworkers.this.getProvidedIngredients().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 191 to line 192
    		 * for i in providedIngredients do
    		 *                 remove i from providedIngredients
    		 */
    		
    		for ( IngredientQuantity i : ListenCoworkers.this.getProvidedIngredients()) {
    			/* 
    			 * Compiled from source statement at line 192
    			 * remove i from providedIngredients
    			 */
    			
    			ListenCoworkers.this.getProvidedIngredients().remove(i);
    		}
    	}
    }
  }

  public Boolean duringPreparation(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 195 to line 197
    	 * for order in ordersList do
    	 *             if status of order = "preparing" do
    	 *                 return true
    	 */
    	
    	for ( OrderStatus order : ListenCoworkers.this._agentEnv.getAgent().getOrdersList()) {
    		/* 
    		 * Compiled from source statement from line 196 to line 197
    		 * if status of order = "preparing" do
    		 *                 return true
    		 */
    		
    		if(java.util.Objects.equals(order.getStatus(), "preparing")) {
    			/* 
    			 * Compiled from source statement at line 197
    			 * return true
    			 */
    			
    			return true;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 198
    	 * 
    	 *         return false
    	 */
    	
    	return false;
    }
  }

  private class __Event4 {
    Boolean __eventFired = false;

    public void run() {
      if(ListenCoworkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1307941616 {
      	public jade.core.AID agentId;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> ingredients;
      	
      	private final __PatternMatcher1307941616 __PatternMatcher1307941616_obj =  this;
      	
      	public boolean headerMatch_structterm0_typecast0(java.lang.Object __objx) {
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
      		
      		agentId = __x;
      		
      		return true;
      	}
      	
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
      		
      		return true && headerMatch_structterm0_typecast0(__x);
      	}
      	
      	public boolean headerMatch_structterm1_typecast0(java.lang.Object __objx) {
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
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
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
      		
      		return true && headerMatch_structterm1_typecast0(__x);
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		AskForHelpColleague __x;
      		
      		try {
      			if(__objx instanceof AskForHelpColleague) {
      				__x = (AskForHelpColleague) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getIngredients());
      	}
      }
      __PatternMatcher1307941616 __PatternMatcher1307941616_obj = new __PatternMatcher1307941616();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1307941616_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ListenCoworkers.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 201
      			 * avaliable = true
      			 */
      			
      			ListenCoworkers.this.setAvaliable(true);
      			
      			/* 
      			 * Compiled from source statement at line 202
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<AskForHelpColleague>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 203
      			 * log "BAKER: "+name of agent +" received a request for help from "+ name of senderAgent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received a request for help from ")) + java.lang.String.valueOf(senderAgent.getName())));
      			
      			/* 
      			 * Compiled from source statement at line 204
      			 * log "Needed ingredients: "+ingredients
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Needed ingredients: ") + java.lang.String.valueOf(__PatternMatcher1307941616_obj.ingredients)));
      			
      			/* 
      			 * Compiled from source statement at line 206
      			 * log "during prep: "+duringPreparation
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("during prep: ") + java.lang.String.valueOf(ListenCoworkers.this.duringPreparation(_agentEnv.getAgent().toEnv()))));
      			
      			/* 
      			 * Compiled from source statement from line 208 to line 222
      			 * if not duringPreparation do
      			 *             log "not in prep"
      			 * 	        for ingredient in ingredients do
      			 * 	            for item in stock do
      			 * 	                if quantity of ingredient > quantity of item do
      			 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      			 * 	                   send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      			 * 	                   avaliable = false
      			 * 	                   break
      			 * 	            if not avaliable do
      			 * 	                break
      			 * 	    else do
      			 * 	       log "BAKER: "+name of agent+"won't help with ingredients. PREPARING good"
      			 *            send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      			 *            avaliable = false
      			 */
      			
      			if( ! ListenCoworkers.this.duringPreparation(_agentEnv.getAgent().toEnv())) {
      				/* 
      				 * Compiled from source statement at line 209
      				 * log "not in prep"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf("not in prep"));
      				
      				/* 
      				 * Compiled from source statement from line 210 to line 218
      				 * for ingredient in ingredients do
      				 * 	            for item in stock do
      				 * 	                if quantity of ingredient > quantity of item do
      				 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      				 * 	                   send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      				 * 	                   avaliable = false
      				 * 	                   break
      				 * 	            if not avaliable do
      				 * 	                break
      				 */
      				
      				for ( IngredientQuantity ingredient : __PatternMatcher1307941616_obj.ingredients) {
      					/* 
      					 * Compiled from source statement from line 211 to line 216
      					 * for item in stock do
      					 * 	                if quantity of ingredient > quantity of item do
      					 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      					 * 	                   send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      					 * 	                   avaliable = false
      					 * 	                   break
      					 */
      					
      					for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      						/* 
      						 * Compiled from source statement from line 212 to line 216
      						 * if quantity of ingredient > quantity of item do
      						 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      						 * 	                   send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      						 * 	                   avaliable = false
      						 * 	                   break
      						 */
      						
      						if(ingredient.getQuantity() > item.getQuantity()) {
      							/* 
      							 * Compiled from source statement at line 213
      							 * log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      							 */
      							
      							jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent wants too much: ") + java.lang.String.valueOf(ingredient.getQuantity())) + java.lang.String.valueOf(" when i have ")) + java.lang.String.valueOf(item.getQuantity())));
      							
      							/* 
      							 * Compiled from source statement at line 214
      							 * send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      							 */
      							
      							try {
      								jadescript.util.SendMessageUtils.validatePerformative("inform");
      								
      								java.lang.Object _contentToBeSent1608209550 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,false ,__PatternMatcher1307941616_obj.ingredients);
      								
      								jadescript.core.message.Message _synthesizedMessage1608209550 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      								
      								_synthesizedMessage1608209550.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1608209550,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      								
      								_synthesizedMessage1608209550.setLanguage(__codec.getName());;
      								
      								_synthesizedMessage1608209550.addReceiver(senderAgent);
      								
      								_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1608209550, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1608209550, "inform"));
      								
      								_agentEnv.getAgent().send(_synthesizedMessage1608209550);
      							}
      							catch(java.lang.Throwable _t) {
      								throw jadescript.core.exception.JadescriptException.wrap(_t);
      							}
      							
      							/* 
      							 * Compiled from source statement at line 215
      							 * avaliable = false
      							 */
      							
      							ListenCoworkers.this.setAvaliable(false);
      							
      							/* 
      							 * Compiled from source statement at line 216
      							 * break
      							 */
      							
      							break;
      						}
      					}
      					
      					/* 
      					 * Compiled from source statement from line 217 to line 218
      					 * 
      					 * 	            if not avaliable do
      					 * 	                break
      					 */
      					
      					if( ! ListenCoworkers.this.getAvaliable()) {
      						/* 
      						 * Compiled from source statement at line 218
      						 * break
      						 */
      						
      						break;
      					}
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 220
      				 * log "BAKER: "+name of agent+"won't help with ingredients. PREPARING good"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())) + java.lang.String.valueOf("won't help with ingredients. PREPARING good")));
      				
      				/* 
      				 * Compiled from source statement at line 221
      				 * send message inform IngredientAvaliable(aid, false,ingredients) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent606709961 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,false ,__PatternMatcher1307941616_obj.ingredients);
      					
      					jadescript.core.message.Message _synthesizedMessage606709961 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage606709961.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent606709961,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage606709961.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage606709961.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage606709961, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent606709961, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage606709961);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 222
      				 * avaliable = false
      				 */
      				
      				ListenCoworkers.this.setAvaliable(false);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 224
      			 * 
      			 *         
      			 *         log "hello im here"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf("hello im here"));
      			
      			/* 
      			 * Compiled from source statement from line 225 to line 227
      			 * if avaliable do
      			 *             log "entered here"
      			 *             send message inform IngredientAvaliable(aid, true,ingredients) to senderAgent
      			 */
      			
      			if(ListenCoworkers.this.getAvaliable()) {
      				/* 
      				 * Compiled from source statement at line 226
      				 * log "entered here"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf("entered here"));
      				
      				/* 
      				 * Compiled from source statement at line 227
      				 * send message inform IngredientAvaliable(aid, true,ingredients) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent545341028 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,true ,__PatternMatcher1307941616_obj.ingredients);
      					
      					jadescript.core.message.Message _synthesizedMessage545341028 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage545341028.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent545341028,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage545341028.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage545341028.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage545341028, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent545341028, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage545341028);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
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

  private ListenCoworkers.__Event4 __event4 = null;

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(ListenCoworkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher139593854 {
      	public jade.core.AID id;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> listIngredientsNeeded;
      	
      	private final __PatternMatcher139593854 __PatternMatcher139593854_obj =  this;
      	
      	public boolean headerMatch_structterm0_typecast0(java.lang.Object __objx) {
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
      		
      		return true && headerMatch_structterm0_typecast0(__x);
      	}
      	
      	public boolean headerMatch_structterm1_typecast0(java.lang.Object __objx) {
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
      		
      		listIngredientsNeeded = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
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
      		
      		return true && headerMatch_structterm1_typecast0(__x);
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		RequestIngredientsColleague __x;
      		
      		try {
      			if(__objx instanceof RequestIngredientsColleague) {
      				__x = (RequestIngredientsColleague) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getIngredients());
      	}
      }
      __PatternMatcher139593854 __PatternMatcher139593854_obj = new __PatternMatcher139593854();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher139593854_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ListenCoworkers.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 231
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<RequestIngredientsColleague>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 232 to line 236
      			 * for ingredient in listIngredientsNeeded do
      			 *             for item in stock do
      			 *                 if ingredientName of ingredient = ingredientName of item do
      			 *                    quantity of item = quantity of item - quantity of ingredient
      			 *                    add IngredientQuantity(ingredientName of ingredient, quantity of ingredient) to providedIngredients
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher139593854_obj.listIngredientsNeeded) {
      				/* 
      				 * Compiled from source statement from line 233 to line 236
      				 * for item in stock do
      				 *                 if ingredientName of ingredient = ingredientName of item do
      				 *                    quantity of item = quantity of item - quantity of ingredient
      				 *                    add IngredientQuantity(ingredientName of ingredient, quantity of ingredient) to providedIngredients
      				 */
      				
      				for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 234 to line 236
      					 * if ingredientName of ingredient = ingredientName of item do
      					 *                    quantity of item = quantity of item - quantity of ingredient
      					 *                    add IngredientQuantity(ingredientName of ingredient, quantity of ingredient) to providedIngredients
      					 */
      					
      					if(java.util.Objects.equals(ingredient.getIngredientName(), item.getIngredientName())) {
      						/* 
      						 * Compiled from source statement at line 235
      						 * quantity of item = quantity of item - quantity of ingredient
      						 */
      						
      						item.setQuantity(item.getQuantity() - ingredient.getQuantity());
      						
      						/* 
      						 * Compiled from source statement at line 236
      						 * add IngredientQuantity(ingredientName of ingredient, quantity of ingredient) to providedIngredients
      						 */
      						
      						ListenCoworkers.this.getProvidedIngredients().add(BakeryOntology.IngredientQuantity(ingredient.getIngredientName() ,ingredient.getQuantity()));
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 238
      			 * 
      			 *         
      			 *         log "Items that are beeing send: "+providedIngredients +" by: "+name of agent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Items that are beeing send: ") + java.lang.String.valueOf(ListenCoworkers.this.getProvidedIngredients())) + java.lang.String.valueOf(" by: ")) + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())));
      			
      			/* 
      			 * Compiled from source statement at line 239
      			 * log "My current stock after helping: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("My current stock after helping: ") + java.lang.String.valueOf(ListenCoworkers.this._agentEnv.getAgent().getStock())));
      			
      			/* 
      			 * Compiled from source statement at line 241
      			 * send message request ProvideIngredients(providedIngredients,true) to senderAgent
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent153723497 = BakeryOntology.ProvideIngredients(ListenCoworkers.this.getProvidedIngredients() ,true);
      				
      				jadescript.core.message.Message _synthesizedMessage153723497 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage153723497.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent153723497,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage153723497.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage153723497.addReceiver(senderAgent);
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage153723497, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent153723497, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage153723497);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 242
      			 * providedIngredients = [] of IngredientQuantity
      			 */
      			
      			ListenCoworkers.this.setProvidedIngredients(new jadescript.util.JadescriptList<IngredientQuantity>());
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

  private ListenCoworkers.__Event5 __event5 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ListenCoworkers.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ListenCoworkers.this.avaliable = false;
    	
    	ListenCoworkers.this.providedIngredients = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	__event4 = new ListenCoworkers.__Event4();
    	
    	__event5 = new ListenCoworkers.__Event5();
    }
  }
}
