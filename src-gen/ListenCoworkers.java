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
    	 * Compiled from source statement from line 191 to line 193
    	 * if length of providedIngredients ≠ 0 do
    	 *             for i in providedIngredients do
    	 *                 remove i from providedIngredients
    	 */
    	
    	if(!java.util.Objects.equals(ListenCoworkers.this.getProvidedIngredients().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 192 to line 193
    		 * for i in providedIngredients do
    		 *                 remove i from providedIngredients
    		 */
    		
    		for ( IngredientQuantity i : ListenCoworkers.this.getProvidedIngredients()) {
    			/* 
    			 * Compiled from source statement at line 193
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
    	 * Compiled from source statement from line 196 to line 198
    	 * for order in ordersList do
    	 *             if status of order = "preparing" do
    	 *                 return true
    	 */
    	
    	for ( OrderStatus order : ListenCoworkers.this._agentEnv.getAgent().getOrdersList()) {
    		/* 
    		 * Compiled from source statement from line 197 to line 198
    		 * if status of order = "preparing" do
    		 *                 return true
    		 */
    		
    		if(java.util.Objects.equals(order.getStatus(), "preparing")) {
    			/* 
    			 * Compiled from source statement at line 198
    			 * return true
    			 */
    			
    			return true;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 199
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
       class __PatternMatcher1058577754 {
      	public jade.core.AID agentId;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> ingredients;
      	
      	private final __PatternMatcher1058577754 __PatternMatcher1058577754_obj =  this;
      	
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
      __PatternMatcher1058577754 __PatternMatcher1058577754_obj = new __PatternMatcher1058577754();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1058577754_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Needed ingredients: ") + java.lang.String.valueOf(__PatternMatcher1058577754_obj.ingredients)));
      			
      			/* 
      			 * Compiled from source statement from line 206 to line 219
      			 * if not duringPreparation do
      			 * 	        for ingredient in ingredients do
      			 * 	            for item in stock do
      			 * 	                if quantity of ingredient > quantity of item do
      			 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      			 * 	                   send message inform IngredientAvaliable(aid, false) to senderAgent
      			 * 	                   avaliable = false
      			 * 	                   break
      			 * 	            if not avaliable do
      			 * 	                break
      			 * 	    else do
      			 * 	       log "BAKER: "+name of agent+"won't help with ingredients. PREPARING good"
      			 *            send message inform IngredientAvaliable(aid, false) to senderAgent
      			 *            avaliable = false
      			 */
      			
      			if( ! ListenCoworkers.this.duringPreparation(_agentEnv.getAgent().toEnv())) {
      				/* 
      				 * Compiled from source statement from line 207 to line 215
      				 * for ingredient in ingredients do
      				 * 	            for item in stock do
      				 * 	                if quantity of ingredient > quantity of item do
      				 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      				 * 	                   send message inform IngredientAvaliable(aid, false) to senderAgent
      				 * 	                   avaliable = false
      				 * 	                   break
      				 * 	            if not avaliable do
      				 * 	                break
      				 */
      				
      				for ( IngredientQuantity ingredient : __PatternMatcher1058577754_obj.ingredients) {
      					/* 
      					 * Compiled from source statement from line 208 to line 213
      					 * for item in stock do
      					 * 	                if quantity of ingredient > quantity of item do
      					 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      					 * 	                   send message inform IngredientAvaliable(aid, false) to senderAgent
      					 * 	                   avaliable = false
      					 * 	                   break
      					 */
      					
      					for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      						/* 
      						 * Compiled from source statement from line 209 to line 213
      						 * if quantity of ingredient > quantity of item do
      						 * 	                   log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      						 * 	                   send message inform IngredientAvaliable(aid, false) to senderAgent
      						 * 	                   avaliable = false
      						 * 	                   break
      						 */
      						
      						if(ingredient.getQuantity() > item.getQuantity()) {
      							/* 
      							 * Compiled from source statement at line 210
      							 * log "Agent wants too much: "+ quantity of ingredient + " when i have "+ quantity of item
      							 */
      							
      							jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent wants too much: ") + java.lang.String.valueOf(ingredient.getQuantity())) + java.lang.String.valueOf(" when i have ")) + java.lang.String.valueOf(item.getQuantity())));
      							
      							/* 
      							 * Compiled from source statement at line 211
      							 * send message inform IngredientAvaliable(aid, false) to senderAgent
      							 */
      							
      							try {
      								jadescript.util.SendMessageUtils.validatePerformative("inform");
      								
      								java.lang.Object _contentToBeSent1812075081 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,false);
      								
      								jadescript.core.message.Message _synthesizedMessage1812075081 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      								
      								_synthesizedMessage1812075081.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1812075081,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      								
      								_synthesizedMessage1812075081.setLanguage(__codec.getName());;
      								
      								_synthesizedMessage1812075081.addReceiver(senderAgent);
      								
      								_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1812075081, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1812075081, "inform"));
      								
      								_agentEnv.getAgent().send(_synthesizedMessage1812075081);
      							}
      							catch(java.lang.Throwable _t) {
      								throw jadescript.core.exception.JadescriptException.wrap(_t);
      							}
      							
      							/* 
      							 * Compiled from source statement at line 212
      							 * avaliable = false
      							 */
      							
      							ListenCoworkers.this.setAvaliable(false);
      							
      							/* 
      							 * Compiled from source statement at line 213
      							 * break
      							 */
      							
      							break;
      						}
      					}
      					
      					/* 
      					 * Compiled from source statement from line 214 to line 215
      					 * 
      					 * 	            if not avaliable do
      					 * 	                break
      					 */
      					
      					if( ! ListenCoworkers.this.getAvaliable()) {
      						/* 
      						 * Compiled from source statement at line 215
      						 * break
      						 */
      						
      						break;
      					}
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 217
      				 * log "BAKER: "+name of agent+"won't help with ingredients. PREPARING good"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("BAKER: ") + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())) + java.lang.String.valueOf("won't help with ingredients. PREPARING good")));
      				
      				/* 
      				 * Compiled from source statement at line 218
      				 * send message inform IngredientAvaliable(aid, false) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent122776497 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,false);
      					
      					jadescript.core.message.Message _synthesizedMessage122776497 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage122776497.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent122776497,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage122776497.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage122776497.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage122776497, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent122776497, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage122776497);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 219
      				 * avaliable = false
      				 */
      				
      				ListenCoworkers.this.setAvaliable(false);
      			}
      			
      			/* 
      			 * Compiled from source statement from line 221 to line 222
      			 * 
      			 *         
      			 *         if avaliable do
      			 *             send message inform IngredientAvaliable(aid, true) to senderAgent
      			 */
      			
      			if(ListenCoworkers.this.getAvaliable()) {
      				/* 
      				 * Compiled from source statement at line 222
      				 * send message inform IngredientAvaliable(aid, true) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1990303237 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,true);
      					
      					jadescript.core.message.Message _synthesizedMessage1990303237 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1990303237.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1990303237,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1990303237.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1990303237.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1990303237, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1990303237, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1990303237);
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
       class __PatternMatcher924516918 {
      	public jade.core.AID id;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> listIngredientsNeeded;
      	
      	private final __PatternMatcher924516918 __PatternMatcher924516918_obj =  this;
      	
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
      __PatternMatcher924516918 __PatternMatcher924516918_obj = new __PatternMatcher924516918();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher924516918_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 225
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<RequestIngredientsColleague>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 226 to line 230
      			 * for ingredient in listIngredientsNeeded do
      			 *             for item in stock do
      			 *                 if name of ingredient = name of item do
      			 *                    quantity of item = quantity of item - quantity of ingredient
      			 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher924516918_obj.listIngredientsNeeded) {
      				/* 
      				 * Compiled from source statement from line 227 to line 230
      				 * for item in stock do
      				 *                 if name of ingredient = name of item do
      				 *                    quantity of item = quantity of item - quantity of ingredient
      				 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      				 */
      				
      				for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 228 to line 230
      					 * if name of ingredient = name of item do
      					 *                    quantity of item = quantity of item - quantity of ingredient
      					 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      					 */
      					
      					if(java.util.Objects.equals(ingredient.getName(), item.getName())) {
      						/* 
      						 * Compiled from source statement at line 229
      						 * quantity of item = quantity of item - quantity of ingredient
      						 */
      						
      						item.setQuantity(item.getQuantity() - ingredient.getQuantity());
      						
      						/* 
      						 * Compiled from source statement at line 230
      						 * add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      						 */
      						
      						ListenCoworkers.this.getProvidedIngredients().add(BakeryOntology.IngredientQuantity(ingredient.getName() ,ingredient.getQuantity()));
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 232
      			 * 
      			 *         
      			 *         log "Items that are beeing send: "+providedIngredients +" by: "+name of agent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Items that are beeing send: ") + java.lang.String.valueOf(ListenCoworkers.this.getProvidedIngredients())) + java.lang.String.valueOf(" by: ")) + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())));
      			
      			/* 
      			 * Compiled from source statement at line 233
      			 * log "My current stock after helping: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("My current stock after helping: ") + java.lang.String.valueOf(ListenCoworkers.this._agentEnv.getAgent().getStock())));
      			
      			/* 
      			 * Compiled from source statement at line 235
      			 * send message request ProvideIngredients(providedIngredients) to senderAgent
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent900214321 = BakeryOntology.ProvideIngredients(ListenCoworkers.this.getProvidedIngredients());
      				
      				jadescript.core.message.Message _synthesizedMessage900214321 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage900214321.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent900214321,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage900214321.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage900214321.addReceiver(senderAgent);
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage900214321, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent900214321, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage900214321);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 236
      			 * do clearProvidedIngredients
      			 */
      			
      			ListenCoworkers.this.clearProvidedIngredients(_agentEnv.getAgent().toEnv());
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
    	ListenCoworkers.this.avaliable = true;
    	
    	ListenCoworkers.this.providedIngredients = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	__event4 = new ListenCoworkers.__Event4();
    	
    	__event5 = new ListenCoworkers.__Event5();
    }
  }
}
